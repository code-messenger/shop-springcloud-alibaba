package cool.yunlong.shop.utils.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一返回结果
 *
 * @author yunlong
 * @since 2022/4/22 8:54
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> implements Serializable {


    private static final long serialVersionUID = 1497405107265595284L;
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 状态描述
     */
    private String codeMsg;

    /**
     * 返回的数据
     */
    private T data;
}
