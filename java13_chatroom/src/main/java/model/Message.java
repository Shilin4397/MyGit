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
public class Message {
    private int messageId;
    private int userId;
    private int channelId;
    private String content;
    private Timestamp sendTime;

    //直接把用户昵称放到这里，方便后面的界面显示
    private String nickName;
}
