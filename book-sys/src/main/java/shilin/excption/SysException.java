package shilin.excption;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class SysException extends BaseException{
    public SysException(String code, String message) {
        super("Sys"+code,"系统异常："+message);
    }

    public SysException(String code, String message, Throwable cause) {
        super("Sys"+code,"系统异常："+message);
    }
}
