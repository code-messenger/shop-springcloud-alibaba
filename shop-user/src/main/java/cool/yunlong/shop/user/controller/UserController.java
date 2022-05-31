package cool.yunlong.shop.user.controller;

import com.alibaba.fastjson.JSONObject;
import cool.yunlong.shop.bean.User;
import cool.yunlong.shop.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author yunlong
 * @since 2022/4/22 10:20
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/get/{userId}")
    public User getUser(@PathVariable("userId") Long userId) {
        User user = userService.getUserById(userId);
        log.info("获取到的用户信息为：{}", JSONObject.toJSONString(user));
        return user;
    }
}
