package shilin.filter;

import javax.servlet.*;
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
//@WebFilter("/*")    //模糊匹配：/*
public class LoginFilter implements Filter {

    @Override//初始化
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        String uri = req.getServletPath();//获取路径
        //如果是这些路径就放行,否则就跳转至登录页面
        if(!"/login.html".equals(uri) && !uri.startsWith("/public/")
                && !uri.startsWith("/static/")
                && !"/user/login".equals(uri)) {
            HttpSession session = req.getSession(false);//无参则自动创建一个session，false则不创建
            if(session == null) {//访问敏感资源，没有登录，需要跳转到登录页面
                String schema = req.getScheme();//http
                String host = req.getServerName();//服务器Ip或域名
                int port = req.getServerPort();//服务器端口号
                String contextPath = req.getContextPath();
                String basePath = schema+"://"+host+":"+port+contextPath;
                ((HttpServletResponse)response).sendRedirect(basePath+"/public/index.html");
                return;
            }
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {//销毁

    }
}
