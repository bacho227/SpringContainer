package ge.softgen.loanexpert.controller;

import ge.softgen.loanexpert.message.MessageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by bacho on 3/8/15.
 */
@ControllerAdvice
public class ExceptionHandlingController {

	@ExceptionHandler(MessageException.class)
	public void handleError(HttpServletResponse resp, MessageException exception) {
		String message = exception.getMessage();
		try {
			resp.setHeader("le-message", URLEncoder.encode(message, "UTF-8").replace("+", "%20"));
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
