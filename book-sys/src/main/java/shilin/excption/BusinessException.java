package shilin.excption;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class BusinessException extends BaseException{
    public BusinessException(String code, String message) {
        super("Business"+code,"业务异常："+message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super("Business"+code,"业务异常："+message);
    }
}
