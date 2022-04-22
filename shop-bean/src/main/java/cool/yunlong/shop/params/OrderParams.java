package params;

/**
 * @author yunlong
 * @since 2022/4/22 11:03
 */
public class OrderParams {

    /**
     * 商品id
     */
    private Long productId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 购买的商品数量
     */
    private Integer count;

    public boolean isEmpty() {
        return (productId == null || productId <= 0) ||
                       (userId == null) ||
                       (count == null || count <= 0);
    }
}
