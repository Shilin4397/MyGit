package model;

import util.ChatroomException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

//把发送的消息保存起来，为了实现历史消息功能
    //把用户上次下线时间点到消磁上线之间的消息查出来
public class MessageDao {
    //1、新增消息
    public void add(Message message) {
        Connection c = DBUtil.getConnection();
        String sql = "insert into message values(null,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,message.getUserId());
            ps.setInt(2,message.getChannelId());
            ps.setString(3,message.getContent());
            ps.setTimestamp(4,message.getSendTime());

            int ret = ps.executeUpdate();
            if(ret != 1) {
                throw new ChatroomException("插入消息失败");
            }
            System.out.println("插入消息成功");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ChatroomException("插入消息失败");
        }finally {
            DBUtil.close(c,ps);
        }
    }
    //2、按时间段查询消息
    public List<Message> selectByTimeStamp(Timestamp from, Timestamp to) {
        List<Message> messages = new ArrayList<>();
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //Mysql中的datetime类型可以直接比较大小
        String sql = "select * from message where sendTime >= ? and sendTime <= ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setTimestamp(1,from);
            ps.setTimestamp(2,to);
            System.out.println("selectByTimeStamp" + ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setMessageId(rs.getInt("messageId"));
                message.setUserId(rs.getInt("userId"));
                message.setChannelId(rs.getInt("channelId"));
                message.setContent(rs.getString("content"));
                message.setSendTime(rs.getTimestamp("sendTime"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(c, ps, rs);
        }
        return messages;
    }

//    public static void main(String[] args) {
//        MessageDao m = new MessageDao();
////        Message message = new Message();
////        message.setUserId(2);
////        message.setChannelId(2);
////        message.setContext("how are you?");
////        message.setSendTime(new Timestamp(System.currentTimeMillis()));
////        m.add(message);
//
//        //此处的时间戳是一个很大的数字已经超出了int的范围，需要加上L，表示这是一个long类型
//        List<Message> messages = m.selectByTimeStamp(new Timestamp(1595503740000L),new Timestamp(1595503740000L));
//        System.out.println(messages);
//    }
}
