package cool.yunlong.shop.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cool.yunlong.shop.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunlong
 * @since 2022/4/22 10:16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
