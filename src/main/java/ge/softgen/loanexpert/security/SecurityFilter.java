package ge.softgen.loanexpert.security;

import ge.softgen.loanexpert.model.SecUser;
import ge.softgen.loanexpert.spring.ApplicationConfig;

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
		HttpServletResponse hResponse = ((HttpServletResponse) response);

		if (ApplicationConfig.isDevMod()) {
			hResponse.setHeader("Access-Control-Allow-Origin", "*");
			hResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
//			hResponse.setHeader("Access-Control-Max-Age", "3600");
			hResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
		}

		String url = hRequest.getRequestURL().toString();
		URL basePath = new URL(hRequest.getScheme(), hRequest.getServerName(), hRequest.getServerPort(), hRequest.getContextPath());
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
				hResponse.sendRedirect(basePath.toString());
			}
			filterChain.doFilter(request, response);
		} else if (isLoginPage || url.startsWith(basePath + "/app") || url.startsWith(basePath + "/rest/") || url.startsWith(basePath + "/js/") || url.startsWith(basePath + "/css/") || url
				.startsWith(basePath + "/images/")) {
			filterChain.doFilter(request, response);
		} else {
			hResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			if (isRequest == false) {
				hResponse.sendRedirect(basePath + "/login.html");
			}
		}
	}

}
