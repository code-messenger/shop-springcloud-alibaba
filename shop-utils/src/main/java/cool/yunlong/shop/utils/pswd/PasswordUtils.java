package cool.yunlong.shop.utils.pswd;

import cool.yunlong.shop.utils.md5.MD5Hash;

/**
 * @author yunlong
 * @since 2022/4/22 9:35
 */
public class PasswordUtils {

    public static String getPassoword(String password) {
        if (password == null || password.trim().isEmpty()) return password;
        for (int i = 0; i < 5; i++) {
            password = MD5Hash.md5Java(password);
        }
        return password;
    }
}
