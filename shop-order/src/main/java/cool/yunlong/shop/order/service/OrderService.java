package cool.yunlong.shop.order.service;

import cool.yunlong.shop.params.OrderParams;

/**
 * @author yunlong
 * @since 2022/4/22 11:31
 */
public interface OrderService {

    /**
     * 保存订单
     */
    void saveOrder(OrderParams orderParams);
}
