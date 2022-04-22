package cool.yunlong.shop.service;

import bean.User;

/**
 * 用户业务接口
 *
 * @author yunlong
 * @since 2022/4/22 10:14
 */
public interface UserService {

    /**
     * 根据id获取用户信息
     */
    User getUserById(Long userId);
}
