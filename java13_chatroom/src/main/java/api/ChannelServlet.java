package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Channel;
import model.ChannelDao;
import model.User;
import util.ChatroomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
//处理频道的api
public class ChannelServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    //新增频道
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Channel channel = null;
        try {
            //1、验证登录状态，如果未登录则不能查看
            HttpSession httpSession = req.getSession(false);
            if(httpSession == null) {
                throw new ChatroomException("你尚未登录");
            }
            //2、查看数据库
            channel = (Channel)httpSession.getAttribute("channel");
            ChannelDao channelDao = new ChannelDao();
            channelDao.add(channel);
        } catch (ChatroomException e) {
            e.printStackTrace();
        } finally {
            //3、把查询结果包装成响应内容
            //如果参数是个list,转出的 json 字符串就是一个数组
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(channel);
            resp.getWriter().write(jsonString);
        }
    }

    //获取频道列表
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Channel> channels = new ArrayList<>();
        try {
            //1、验证登录状态，如果未登录则不能查看
            HttpSession httpSession = req.getSession(false);
            if(httpSession == null) {
                throw new ChatroomException("你尚未登录");
            }
            User user = (User)httpSession.getAttribute("user");
            //2、查看数据库
            ChannelDao channelDao = new ChannelDao();
            System.out.println(1);
            channels = channelDao.selectAll();
            for (Channel ch:channels) {
                System.out.println(ch.toString());
            }
        } catch (ChatroomException e) {
            e.printStackTrace();
            //如果前面触发了异常，此时 channels 将是一个空数组
            //下面的 finally 中将会构造一个空数组的 json
        }finally {
            //3、把查询结果包装成响应内容
              //如果参数是个list,转出的 json 字符串就是一个数组
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(channels);
            resp.getWriter().write(jsonString);
        }
    }

    //删除频道
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Channel channel = null;
        try {
            //1、验证登录状态
            HttpSession httpSession = req.getSession(false);
            if(httpSession == null) {
                throw new ChatroomException("您尚未登录");
            }
            //2、查看数据库
            channel = (Channel)httpSession.getAttribute("channel");
            ChannelDao channelDao = new ChannelDao();
            channelDao.delete(channel.getChannelId());
        } catch (ChatroomException e) {
            e.printStackTrace();
        } finally {
            //3、把查询结果包装成响应内容
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(channel);
            resp.getWriter().write(jsonString);
        }
    }
}
