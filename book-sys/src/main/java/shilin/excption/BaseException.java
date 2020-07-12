package shilin.excption;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
@Getter
@Setter
public class BaseException extends RuntimeException{
    //错误码
    protected String code;

    public BaseException(String code,String message) {
        super(message);
        this.code = code;
    }

    public BaseException(String code,Throwable cause) {
        super(cause);
        this.code = code;
    }
}
