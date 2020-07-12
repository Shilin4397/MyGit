package shilin.util;

import org.junit.Assert;
import org.junit.Test;
import shilin.model.ResponseResult;

import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class JSONUtilTest {

    @Test
    public void testRead() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("response.json");
        ResponseResult r = JSONUtil.read(is,ResponseResult.class);
        System.out.println(r);
        Assert.assertNotNull(r);
    }

    @Test
    public void testWrite() {
        ResponseResult r = new ResponseResult();
        r.setCode("k3000");
        r.setMessage("要你命3000");
        r.setSuccess(true);
        r.setTotal(9);
        String s = JSONUtil.write(r);
        System.out.println(s);
        Assert.assertNotNull(s);
        Assert.assertTrue(s.trim().length()>0);
    }
}
