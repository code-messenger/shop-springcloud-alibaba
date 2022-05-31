package cool.yunlong.shop.utils.test;


import cool.yunlong.shop.utils.id.SnowFlakeFactory;
import cool.yunlong.shop.utils.id.SnowFlakeLoader;
import org.junit.jupiter.api.Test;

/**
 * @author yunlong
 * @since 2022/4/22 11:42
 */
public class SnowFlakeFactoryTest {

    @Test
    public void testCreateDefaultID() {
        for (int i = 0; i < 100; i++) {
            System.out.println(SnowFlakeFactory.getSnowFlakeFromCache().nextId());
        }
    }

    @Test
    public void testCreateID() {
        for (int i = 0; i < 100; i++) {
            System.out.println(SnowFlakeFactory.getSnowFlakeByDataCenterIdAndMachineIdFromCache(SnowFlakeLoader.getDataCenterId(), SnowFlakeLoader.getDataCenterId()).nextId());
        }
    }
}
