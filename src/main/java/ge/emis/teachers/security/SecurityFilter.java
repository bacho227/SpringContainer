package ge.emis.teachers.security;

import ge.emis.teachers.model.security.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class SecurityFilter implements Filter {
	private static final String[] skipPaths = {"/rest", "/app", "/js", "/css", "/images"};

	private boolean checkSkipUrl(String url, String basePath) {
		for (String skipPath : skipPaths) {
			if (url.startsWith(basePath + skipPath)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy() {
		System.out.println("filter : destroy");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("filter : init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)) return;

		HttpServletRequest hRequest = ((HttpServletRequest) request);
		HttpServletResponse hResponse = ((HttpServletResponse) response);

		String url = hRequest.getRequestURL().toString();
		String basePath = new URL(hRequest.getScheme(), hRequest.getServerName(), hRequest.getServerPort(), hRequest.getContextPath()).toString();
		boolean isRequest = false, isLoginPage = false;
		if (hRequest.getHeader("X-Requested-With") != null) {
			isRequest = true;
		}
		if (url.equals(basePath + "/login.html")) {
			isLoginPage = true;
		}
		System.out.println("filter url: " + url);

		if (checkSkipUrl(url, basePath)) {
			filterChain.doFilter(request, response);
		} else {
			User user = SessionUtils.getUser(hRequest.getSession());
			if (user != null && isLoginPage) {
				hResponse.sendRedirect(basePath);
			} else if (user != null || isLoginPage) {
				filterChain.doFilter(request, response);
			} else {
				hResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				if (isRequest == false) {
					hResponse.sendRedirect(basePath + "/login.html");
				}
			}
		}
	}

}