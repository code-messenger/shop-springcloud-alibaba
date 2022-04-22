package cool.yunlong.shop.mapper;

import bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author yunlong
 * @since 2022/4/22 10:16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
