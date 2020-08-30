package api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import model.User;
import model.UserDao;
import util.ChatroomException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class LoginServlet extends HttpServlet {
    Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public String password;
    }

    static class Response {
        public int ok;
        public String reason;
        public int userId;
        public String name;
        public String nickName;
    }

    //检查是否登录
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response response = new Response();
        try {
            //1、根据请求，查看sessionId对应的session是否存在，
            //如果session 不存在，就是登录失败的状态
            HttpSession httpSession = req.getSession(false);
            if(httpSession == null) {
                throw new ChatroomException("当前未登录");
            }
            User user = (User)httpSession.getAttribute("user");
            //2、如果session 存在，直接返回一个登录成功
            response.ok = 1;
            response.name = user.getName();
            response.userId = user.getUserId();
            response.nickName = user.getNickName();
            response.reason = "";
        } catch (ChatroomException e) {
            e.printStackTrace();
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset=utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }

    //登录
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            //1、读取 body 中的数据
            String body = Util.readBody(req);
            //2、把读取的数据转成 Request 对象
            Request request = gson.fromJson(body, Request.class);
            //3、按用户名在数据库中查找该用户
            UserDao userDao = new UserDao();
            User user = userDao.selectByName(request.name);

            //4、登录失败则给出提示
            //用户名不存在，或密码错误
            if(user == null || !request.password.equals(user.getPassword())) {
                throw new ChatroomException("用户名或密码错误");
            }

            //5、登录成功，创建一个session对象
            //getSession() 参数为true则代表用户如果不存在就创建一个
            //参数为false 如果用户不存在也不创建。
            HttpSession httpSession = req.getSession(true);
            httpSession.setAttribute("user",user);
            
            //6、把结果写回浏览器
            response.ok = 1;
            response.name = user.getName();
            response.userId = user.getUserId();
            response.nickName = user.getNickName();
            response.reason = "";
        } catch (JsonSyntaxException | ChatroomException e) {
            e.printStackTrace();
            response.ok = 0;
            response.reason = e.getMessage();
        }  finally {
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
 
    }
}
