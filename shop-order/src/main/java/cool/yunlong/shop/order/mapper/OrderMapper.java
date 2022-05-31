package cool.yunlong.shop.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.yunlong.shop.bean.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunlong
 * @since 2022/4/22 11:29
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
