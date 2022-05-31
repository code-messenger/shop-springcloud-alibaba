package cool.yunlong.shop.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author yunlong
 * @since 2022/4/22 11:27
 */
@Configuration
public class LoadBalanceConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
