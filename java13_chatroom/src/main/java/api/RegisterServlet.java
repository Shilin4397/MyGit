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
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
public class RegisterServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    //这个类似内部类的方式来组织，这个 Request 类知识针对 RegisterServet 来使用的
    //其他的 Servlet 对于的 Request 类可能结构不同
    //从 body 的 json 中转换过来的
    static class Request {
      public String name;
      public String password;
      public String nickName;
    }

    //响应数据内容
    //把这个对象转会 json 字符串，并写回给客户端
    static class Response {
        public int ok;
        public String reason;
    }

//创建用户
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //以utf-8的编码格式处理请求
        req.setCharacterEncoding("utf-8");
        Response response = new Response();

        try {
            //1、读取 body 中的信息（Json 格式的字符串）
            String body = Util.readBody(req);

            //2、把 json 数据转成 java 中的对象
            //创建一个Resquest 类来表示这次请求的结构
            //需要把body 转回 json对象
            //此处最好借助第三方库来完成，（json 的第三方库右很多，fastjson,jackson..)
            //此处我们使用GSON（Google的一个库）
            Request request = gson.fromJson(body, Request.class);

            //3、在数据库中查一下，看看用户名是否已经讯在，如果存在就认为注册失败
            UserDao userDao = new UserDao();
            User existsUser = userDao.selectByName(request.name);
            if(existsUser != null) {
                throw new ChatroomException("用户名已存在");    
            }

            //4、把新的用户名和密码构造 User 对象存入数据库
            User user = new User();
            user.setName(request.name);
            user.setPassword(request.password);
            user.setNickName(request.nickName);
            userDao.add(user);

            //5、返回一个注册成功的响应结果
            response.ok = 1;
            response.reason = "";
        } catch (JsonSyntaxException | ChatroomException e) {
            e.printStackTrace();
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            resp.setContentType("application/json; charset = utf-8");
            String jsonString = gson.toJson(response);
            resp.getWriter().write(jsonString);
        }
    }
    
}
