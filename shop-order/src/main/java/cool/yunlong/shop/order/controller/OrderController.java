package cool.yunlong.shop.order.controller;

import com.alibaba.fastjson.JSONObject;
import cool.yunlong.shop.order.service.OrderService;
import cool.yunlong.shop.params.OrderParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunlong
 * @since 2022/5/27 16:53
 */
@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/submit_order")
    public String submitOrder(OrderParams orderParams) {
        log.info("提交订单时传递的参数:{}", JSONObject.toJSONString(orderParams));
        orderService.saveOrder(orderParams);
        return "success";
    }
}
