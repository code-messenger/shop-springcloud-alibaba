package cool.yunlong.shop.product.controller;

import com.alibaba.fastjson.JSONObject;
import cool.yunlong.shop.bean.Product;
import cool.yunlong.shop.product.service.ProductService;
import cool.yunlong.shop.utils.constants.HttpCode;
import cool.yunlong.shop.utils.resp.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunlong
 * @since 2022/4/22 10:28
 */
@Slf4j
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/get/{productId}")
    public Product getProduct(@PathVariable("productId") Long pid) {
        Product product = productService.getProductById(pid);
        log.info("获取到的商品信息为：{}", JSONObject.toJSONString(product));
        return product;
    }

    @GetMapping(value = "/update_count/{productId}/{count}")
    public Result<Integer> updateCount(@PathVariable("productId") Long pid, @PathVariable("count") Integer count) {
        log.info("更新商品库存传递的参数为: 商品id:{}, 购买数量:{} ", pid, count);
        int updateCount = productService.updateProductStockById(count, pid);
        return new Result<>(HttpCode.SUCCESS, "执行成功", updateCount);
    }
}

