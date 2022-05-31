package cool.yunlong.shop.product.service;

import cool.yunlong.shop.bean.Product;

/**
 * @author yunlong
 * @since 2022/4/22 11:18
 */
public interface ProductService {

    /**
     * 根据商品id获取商品信息
     */
    Product getProductById(Long pid);


    /**
     * 扣减商品库存
     */
    int updateProductStockById(Integer count, Long id);
}
