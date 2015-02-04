package ge.security;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SecurityFilter implements Filter {

    @Override
    public void destroy() {
        System.out.println("filter : destroy");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("filter : init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest)) return;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>..<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        HttpServletRequest hrequest = ((HttpServletRequest) request);

        String url = hrequest.getRequestURL().toString();
        System.out.println("filter : url : " + url);
        boolean isRequest = false;
        if (hrequest.getHeader("X-Requested-With") != null) {
            isRequest = true;
        }
        HttpSession httpSession = hrequest.getSession();

        if (url.indexOf("/logon.html") != -1) {
            filterChain.doFilter(request, response);
        } else if (httpSession == null) {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            if (isRequest == false)
                ((HttpServletResponse) response).sendRedirect("logon.html");
        } else {

            filterChain.doFilter(request, response);
        }
    }

}
