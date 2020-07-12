package shilin.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class DBUtilTest {
    @Test
    public void test() {
        Assert.assertNotNull(DBUtil.getConnection());
    }
}
