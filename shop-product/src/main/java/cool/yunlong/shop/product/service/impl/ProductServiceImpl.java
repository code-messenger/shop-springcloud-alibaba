package cool.yunlong.shop.product.service.impl;

import cool.yunlong.shop.bean.Product;
import cool.yunlong.shop.product.mapper.ProductMapper;
import cool.yunlong.shop.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商品服务
 *
 * @author yunlong
 * @since 2022/4/22 11:19
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product getProductById(Long pid) {
        return productMapper.selectById(pid);
    }

    @Override
    public int updateProductStockById(Integer count, Long id) {
        return productMapper.updateProductStockById(count, id);
    }
}
