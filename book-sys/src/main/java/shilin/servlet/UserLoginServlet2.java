package shilin.servlet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/login2")
public class UserLoginServlet2 extends AbstractBaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return null;
    }
}


//public class UserLoginServlet extends HttpServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //针对请求体设置编码，注意对url中的请求数据无效
//        req.setCharacterEncoding("UTF-8");
//        //针对响应体设置编码
//        resp.setCharacterEncoding("UTF-8");
//        //设置响应
//        resp.setContentType("text/html");
//        //前端珠宝，看到有k=v这样的数据（url,请求体)，就可以获取端，但是Key一定要一至
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        System.out.printf("用户名= %s,密码=%s\n",username,password);
//
//        PrintWriter pw = resp.getWriter();
//        pw.println("登录成功");
//        pw.flush();
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doPost(req,resp);
//    }
//}