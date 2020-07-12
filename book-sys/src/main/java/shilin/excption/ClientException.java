package shilin.excption;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class ClientException extends BaseException{
    public ClientException(String code, String message) {
        super("CLI"+code,"客户端错误："+message);
    }

    public ClientException(String code, String message, Throwable cause) {
        super("CLI"+code,"客户端错误："+message);
    }
}
