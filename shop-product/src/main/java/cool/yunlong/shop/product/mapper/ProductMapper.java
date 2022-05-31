package cool.yunlong.shop.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.yunlong.shop.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author yunlong
 * @since 2022/4/22 10:33
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 扣减商品库存
     */
    int updateProductStockById(@Param("count") Integer count, @Param("id") Long id);
}
