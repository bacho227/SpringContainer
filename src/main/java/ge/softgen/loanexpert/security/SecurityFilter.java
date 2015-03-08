package ge.softgen.loanexpert.security;

import ge.softgen.loanexpert.model.SecUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		if (!(request instanceof HttpServletRequest)) return;

		HttpServletRequest hRequest = ((HttpServletRequest) request);
		String url = hRequest.getRequestURL().toString();
		URL basePath = new URL(request.getScheme(), request.getServerName(), request.getServerPort(), ((HttpServletRequest) request).getContextPath());
		boolean isRequest = false, isLoginPage = false;
		if (hRequest.getHeader("X-Requested-With") != null) {
			isRequest = true;
		}
		if (url.equals(basePath + "/login.html")) {
			isLoginPage = true;
		}
		System.out.println("filter url: " + url);

		SecUser user = SessionUtils.getUser(hRequest.getSession());
		if (user != null) {
			if (isLoginPage) {
				((HttpServletResponse) response).sendRedirect(basePath.toString());
			}
			filterChain.doFilter(request, response);
		} else if (isLoginPage || url.startsWith(basePath + "/rest/") || url.startsWith(basePath + "/js/") || url.startsWith(basePath + "/css/") || url.startsWith(basePath + "/images/")) {
			filterChain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			if (isRequest == false) {
				((HttpServletResponse) response).sendRedirect(basePath + "/login.html");
			}
		}
	}

}
