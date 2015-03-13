package ge.softgen.loanexpert.spring;

import ge.softgen.loanexpert.model.SecUser;
import ge.softgen.loanexpert.security.SessionUtils;
import ge.softgen.loanexpert.security.annotation.Access;
import ge.softgen.loanexpert.security.annotation.Anonymous;
import ge.softgen.loanexpert.security.annotation.AnyAccess;
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

		SecUser user = checkAuthorization(response);
		if (user == null || !checkAccesses(cls, request, response, method, user)) {
			return false;
		}
		return super.preHandle(request, response, handler);
	}

	private SecUser checkAuthorization(HttpServletResponse response) throws IOException {
		SecUser user = SessionUtils.getUser();
		if (user == null) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().append("<html><body><center style=\"font-size:15px;margin-top:50px;\">გაიარეთ ავტორიზაია!</center></body></html>");
			return null;
		}
		return user;
	}

	private boolean checkAccesses(Class<?> cls, HttpServletRequest request, HttpServletResponse response,
								  HandlerMethod method, SecUser user) throws IOException {
		boolean flag = true;
		AnyAccess anyAccess;
		Access access = cls.getAnnotation(Access.class);
		if (access != null)
			flag = checkAccess(access, user);

		access = method.getMethodAnnotation(Access.class);
		if (access != null)
			flag = flag && checkAccess(access, user);

		if (flag) {
			anyAccess = cls.getAnnotation(AnyAccess.class);
			if (anyAccess != null)
				flag = checkAnyAccess(anyAccess.value(), user);

			anyAccess = method.getMethodAnnotation(AnyAccess.class);
			if (anyAccess != null)
				flag = flag && checkAnyAccess(anyAccess.value(), user);
		}

		if (!flag) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			response.getWriter().write("<html><body><center style=\"font-size:15px;margin-top:50px;\">არ გაქვთ უფლება!</center></body></html>");
		}

		return flag;
	}

	private boolean checkAnyAccess(Access[] accesses, SecUser user) throws IOException {
		for (Access access : accesses) {
			if (checkAccess(access, user)) {
				return true;
			}
		}
		return false;
	}

	private boolean checkAccess(Access access, SecUser user) throws IOException {
		String[] permissionNames = null;
		if (access != null)
			permissionNames = access.value();
		if (permissionNames != null && permissionNames.length > 0 && !checkRole(user, permissionNames)) {
			return false;
		}
		return true;
	}

	private boolean checkRole(SecUser user, String[] permissionNames) {
		for (String role : permissionNames) {
			if (!user.hasPermission(role))
				return false;
		}
		return true;
	}

}