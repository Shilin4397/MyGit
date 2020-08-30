package model;

import util.ChatroomException;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class UserDao {
    //1.新增一个用户（注册功能）
    public void add(User user) {
        //1.获取连接
        Connection connection = DBUtil.getConnection();
        //2.拼接sal语句     now()：获取当前时间
        String sql = "insert into user values(null,?,?,?,now())";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNickName());

            //3.执行sql语句
            //插入数据,删除数据，修改数据都是executeUpdate

            int ret = ps.executeUpdate();
            System.out.println(ret);
            if(ret != 1) {
                throw new ChatroomException("插入用户失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new ChatroomException("插入用户失败");
        }finally {
            //4.释放连接
            DBUtil.close(connection,ps);
        }

    }

    //2.按用户名查找用户信息（登陆功能\
    public User selectByName(String name) {
        Connection c = DBUtil.getConnection();
        String sql = "select * from user where name =?";
        PreparedStatement ps = null;
        ResultSet r = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setString(1,name);
            //3.执行sal语句
            r = ps.executeQuery();
            //4.遍历结果集
            //查找结果预期只有一条则用if即可，否则使用while；
            //如果resultSet.next直接为false 则说明不存在
            if(r.next()) {
                User user = new User();
                user.setUserId(r.getInt("userId"));
                user.setName(r.getString("name"));
                user.setPassword(r.getString("password"));
                user.setNickName(r.getString("nickName"));
                user.setLastLogout(r.getTimestamp("lastLogout"));
                return user;
            }
        } catch (SQLException throwables) {
            throw new ChatroomException("按用户查找失败");
        }finally {
            DBUtil.close(c,ps,r);
        }
        return null;
    }

    //3.按用户id查找用户信息（把userId转换成昵称）
    public User selectById(int userId) {
        Connection c = DBUtil.getConnection();
        String sql = "select * from user where userId = ?";
        PreparedStatement ps = null;
        ResultSet r = null;
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,userId);
            r = ps.executeQuery();
            if(r.next()) {
                User user = new User();
                user.setUserId(r.getInt("userId"));
                user.setName(r.getString("name"));
                user.setPassword(r.getString("password"));
                user.setNickName(r.getString("nickName"));
                user.setLastLogout(r.getTimestamp("lastLogout"));
                return user;
            }
        } catch (SQLException throwables) {
            throw new ChatroomException("按id查找用户失败");
        }finally {
            DBUtil.close(c,ps,r);
        }
        return null;
    }

    //4.更新用户的lastLogout时间,哪个用户下线就更新谁
    public void updatelogout(int userId) {
        Connection c = DBUtil.getConnection();
        PreparedStatement ps = null;
        String sql = "update user set lastLogout = now() where userId = ?";
        try {
            ps = c.prepareStatement(sql);
            ps.setInt(1,userId);
            int ret = ps.executeUpdate();
            if(ret != 1) {
                throw new ChatroomException("更新退出时间失败");
            }
            System.out.println("更新时间成功");
        } catch (SQLException throwables) {
            throw new ChatroomException("修改用户lastLogout时间失败");
        } finally {
            DBUtil.close(c,ps);
        }
    }

//    public static void main(String[] args) {
//        UserDao userDao = new UserDao();
//
//        User user = new User();
//        user.setName("taa");
//        user.setPassword("123");
//        user.setNickName("nicheng");
//        user.setUserId(1);
////        userDao.add(user);
////        System.out.println(userDao.selectById(1).toString());;
////        System.out.println(userDao.selectByName("taa").toString());;
////        userDao.updatelogout(1);
//    }
}
