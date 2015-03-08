package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.message.MessageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by bacho on 3/8/15.
 */
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(MessageException.class)
	public void handleError(HttpServletResponse resp, MessageException exception) {
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			resp.setIntHeader("le-message", 1);
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resp.getWriter().append(exception.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
