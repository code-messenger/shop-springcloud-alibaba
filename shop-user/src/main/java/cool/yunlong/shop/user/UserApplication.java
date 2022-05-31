package cool.yunlong.shop.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 用户服务启动类
 *
 * @author yunlong
 * @since 2022/4/22 10:00
 */
@EnableTransactionManagement(proxyTargetClass = true)
@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
