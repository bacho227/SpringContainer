package ge.spring;

import ge.model.security.User;
import ge.security.SessionUtils;
import ge.security.annotation.Access;
import ge.security.annotation.Anonymous;
import ge.security.annotation.AnyAccess;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (!handler.getClass().equals(HandlerMethod.class))
			return super.preHandle(request, response, handler);

		HandlerMethod method = (HandlerMethod) handler;
		Class<?> cls = method.getBeanType();
		Anonymous anonymous = method.getMethodAnnotation(Anonymous.class);

		if (anonymous != null)
			return super.preHandle(request, response, handler);

		User user = checkAuthorization(response);
		if (user == null || !checkAccesses(cls, request, response, method)) {
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	private User checkAuthorization(HttpServletResponse response) throws IOException {
		User user = SessionUtils.getUser();
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().append("<html><body><center style=\"font-size:15px;margin-top:50px;\">გაიარეთ ავტორიზაია!</center></body></html>");
			return null;
		}
		return user;
	}

	private boolean checkAccesses(Class<?> cls, HttpServletRequest request, HttpServletResponse response,
								  HandlerMethod method) throws IOException {
		boolean flag = true;

		AnyAccess anyAccess = null;
		Access access = null;

		access = cls.getAnnotation(Access.class);
		if (access != null)
			flag = checkAccess(access, request);

		access = method.getMethodAnnotation(Access.class);
		if (access != null)
			flag = flag && checkAccess(access, request);

		if (flag) {
			anyAccess = cls.getAnnotation(AnyAccess.class);
			if (anyAccess != null)
				flag = checkAnyAccess(anyAccess.value(), request);

			anyAccess = method.getMethodAnnotation(AnyAccess.class);
			if (anyAccess != null)
				flag = flag && checkAnyAccess(anyAccess.value(), request);
		}

		if (!flag) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("<html><body><center style=\"font-size:15px;margin-top:50px;\">არ გაქვთ უფლება!</center></body></html>");
		}

		return flag;
	}

	private boolean checkAnyAccess(Access[] accesses, HttpServletRequest request) throws IOException {
		for (Access access : accesses) {
			if (checkAccess(access, request)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkAccess(Access access, HttpServletRequest request) throws IOException {
		String[] roles = null;
		if (access != null)
			roles = access.value();
		if (roles != null && roles.length > 0 && !checkRole(request, roles)) {
			return false;
		}
		return true;
	}

	private boolean checkRole(HttpServletRequest request, String[] roles) {
		for (String role : roles) {
			if (!request.isUserInRole(role))
				return false;
		}
		return true;
	}

}