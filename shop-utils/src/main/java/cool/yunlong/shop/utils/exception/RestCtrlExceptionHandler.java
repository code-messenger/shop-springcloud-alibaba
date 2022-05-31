package cool.yunlong.shop.utils.exception;

import cool.yunlong.shop.utils.constants.HttpCode;
import cool.yunlong.shop.utils.resp.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理类
 *
 * @author yunlong
 * @since 2022/4/22 8:51
 */
public class RestCtrlExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(RestCtrlExceptionHandler.class);

    /**
     * 全局异常处理，统一返回状态码
     */
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        logger.error("服务器抛出了异常：", e);
        return new Result<>(HttpCode.FAILURE, "执行失败", e.getMessage());
    }
}
