package com.celeb.site.common.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;


@ControllerAdvice
@Log4j



public class CommonExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String except(Exception ex, Model model, HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*나중에 userException 필요하면 Exception상속받아서 하나 만들어서 쓰자! 자바에서 alert*/
		out.println("<script>alert('오류 발생'); </script>");
		out.flush();
		// 개발용 프린트스택 볼 때 주석
		log.error("error : " + ex.getLocalizedMessage());
		ex.printStackTrace();
		// 필요없으면 주석할 것
		//-개발용 프린트스택 볼 때 주석
		log.error("============== ControllerAdvice Exception =============");
		model.addAttribute("exception", ex);
		log.error(model);
		return "error/error_page";
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String hanle404(NoHandlerFoundException ex) { //ie11안되는듯 ㅠㅠ
		log.error("=============== CommonExceptionAdvice 404 ===============");
		return "error/error404";
	}

	@ExceptionHandler(UserException.class)
	public String bizException(Exception ex, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// alert생성후 이전 url로 history.back();
//		out.println("<script>alert('"+ex.getMessage()+"'); history.back();</script>");
		out.println("<script>alert('"+ex.getMessage()+"'); </script>");
		out.flush();
		log.error("============== ControllerAdvice Exception =============");

		return "error/error_page";
	}
}