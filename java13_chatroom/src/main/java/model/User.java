package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
@Setter
@Getter
@ToString
public class User {
    private int UserId;
    private String name;
    private String password;
    private String nickName;
    Timestamp lastLogout;
}
