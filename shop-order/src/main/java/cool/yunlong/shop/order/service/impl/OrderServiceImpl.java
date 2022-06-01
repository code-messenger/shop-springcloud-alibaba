package cool.yunlong.shop.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import cool.yunlong.shop.bean.Order;
import cool.yunlong.shop.bean.OrderItem;
import cool.yunlong.shop.bean.Product;
import cool.yunlong.shop.bean.User;
import cool.yunlong.shop.order.mapper.OrderItemMapper;
import cool.yunlong.shop.order.mapper.OrderMapper;
import cool.yunlong.shop.order.service.OrderService;
import cool.yunlong.shop.params.OrderParams;
import cool.yunlong.shop.utils.constants.HttpCode;
import cool.yunlong.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @author yunlong
 * @since 2022/4/22 11:31
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    private final static String userServer = "server-user";
    private final static String productServer = "server-product";

    /**
     * 保存订单
     *
     * @param orderParams 订单参数
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrder(OrderParams orderParams) {
        if (orderParams.isEmpty()) {
            throw new RuntimeException("参数异常: " + JSONObject.toJSONString(orderParams));
        }

        // 获取用户服务地址
        String userServerAddress = this.getServiceUrl(userServer);
        // 获取商品服务地址
        String productServerAddress = this.getServiceUrl(productServer);


        User user = restTemplate.getForObject(
                "http://" + userServerAddress + "/user/get/" + orderParams.getUserId(), User.class);
        if (user == null) {
            log.error("用户不存在，userId={}", orderParams.getUserId());
            throw new RuntimeException("用户不存在" + JSONObject.toJSONString(orderParams));
        }
        Product product = restTemplate.getForObject(
                "http://" + productServerAddress + "/product/get/" + orderParams.getProductId(), Product.class);
        if (product == null) {
            log.error("商品不存在，productId={}", orderParams.getProductId());
            throw new RuntimeException("未获取到商品信息: " + JSONObject.toJSONString(orderParams));
        }
        if (product.getProStock() < orderParams.getCount()) {
            throw new RuntimeException("商品库存不足: " + JSONObject.toJSONString(orderParams));
        }
        Order order = new Order();
        order.setAddress(user.getAddress());
        order.setPhone(user.getPhone());
        order.setUserId(user.getId());
        order.setUsername(user.getUsername());
        order.setTotalPrice(product.getProPrice().multiply(BigDecimal.valueOf(orderParams.getCount())));
        orderMapper.insert(order);

        OrderItem orderItem = new OrderItem();
        orderItem.setNumber(orderParams.getCount());
        orderItem.setOrderId(order.getId());
        orderItem.setProId(product.getId());
        orderItem.setProName(product.getProName());
        orderItem.setProPrice(product.getProPrice());
        orderItemMapper.insert(orderItem);

        Result<Integer> result = restTemplate.getForObject("http://" + productServerAddress + "/product/update_count/" + orderParams.getProductId() + "/" + orderParams.getCount(), Result.class);
        assert result != null;
        if (result.getCode() != HttpCode.SUCCESS) {
            throw new RuntimeException("库存扣减失败");
        }
        log.info("库存扣减成功");
    }

    /**
     * 从注册中心获取服务地址
     *
     * @param serviceName 服务名称
     * @return 服务地址
     */
    private String getServiceUrl(String serviceName) {
        ServiceInstance serviceInstance = discoveryClient.getInstances(serviceName).get(0);
        return serviceInstance.getHost() + ":" + serviceInstance.getPort();
    }
}



