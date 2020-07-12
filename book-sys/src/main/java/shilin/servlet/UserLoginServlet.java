package shilin.servlet;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: ShiLin
 * Date:
 * Time:
 */
import shilin.dao.UserDAO;
import shilin.excption.BusinessException;
import shilin.model.User;
import shilin.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/login")
public class UserLoginServlet extends AbstractBaseServlet{

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        req.getParameter("")这个方法只能获取url和请求体，key=value形式的数据
        User user = JSONUtil.read(req.getInputStream(),User.class);//http请求解析的用户数据
        User queryUser = UserDAO.query(user);//通过请求的用户名密码在数据查询，获取用户查询信息
        if(queryUser == null)
            throw new BusinessException("000001","用户名或密码错误！");
        HttpSession session = req.getSession();
        session.setAttribute("user", queryUser);
        return null;
    }
}
