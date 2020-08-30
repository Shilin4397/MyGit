package model;

import util.ChatroomException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//围绕频道进行的逻辑
public class ChannelDao {
    //1.新增频道
    public void add(Channel channel) {
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼接sal语句     now()：获取当前时间
        String sql = "insert into channel values(null,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);

            ps.setString(1,channel.getChnnelName());
            //3.执行sql语句
            //插入数据,删除数据，修改数据都是executeUpdate

            int ret = ps.executeUpdate();
            System.out.println(ret);
            if(ret != 1) {
                throw new ChatroomException("插入频道失败");
            }
            System.out.println("插入频道成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new ChatroomException("插入频道失败");
        }finally {
            //4.释放连接
            DBUtil.close(connection,ps);
        }
    }
    //2.删除频道
    public void delete(int channelId) {
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼接sal语句     now()：获取当前时间
        String sql = "delete from channel where channelId=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,channelId);
            //3.执行sql语句
            //插入数据,删除数据，修改数据都是executeUpdate

            int ret = ps.executeUpdate();
            System.out.println(ret);
            if(ret != 1) {
                throw new ChatroomException("删除频道失败");
            }
            System.out.println("删除频道成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new ChatroomException("删除频道失败");
        }finally {
            //4.释放连接
            DBUtil.close(connection,ps);
        }
    }
    //3.查看频道
    public List<Channel> selectAll() {
        List<Channel> channels = new ArrayList<>();
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "select * from channel";
        ResultSet r = null;
        try {
            ps = c.prepareStatement(sql);
            r = ps.executeQuery();
            while (r.next()) {
                Channel channel = new Channel();
                channel.setChannelId(r.getInt("channelId"));
                channel.setChnnelName(r.getString("channelName"));
                channels.add(channel);
            }
            System.out.println("查看频道成功");
            return channels;
        } catch (SQLException e) {
            throw new ChatroomException("查看频道失败");
        } finally {
            DBUtil.close(c,ps,r);
        }
    }

//    public static void main(String[] args) {
//        ChannelDao c = new ChannelDao();
//        Channel channel = new Channel();
//        channel.setChnnelName("今日十佳");
//        c.add(channel);
//
////        c.delete(3);
//        List<Channel> channelList = c.selectAll();
//        for (Channel ch:channelList) {
//            System.out.println(ch.toString());
//        }
//    }
}
