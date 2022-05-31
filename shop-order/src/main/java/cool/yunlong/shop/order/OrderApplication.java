package cool.yunlong.shop.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 订单服务启动类
 *
 * @author yunlong
 * @since 2022/4/22 11:27
 */
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
