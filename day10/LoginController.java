package com.my.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		
//		String idValue = request.getParameter("id");
//		String pwdValue = request.getParameter("pwd");
//		out.write(idValue +" 로그인 실패");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String msg;
		msg = "{\"status\":1}"; //JSON형태의 문자열. JSON형태를 만들때 객체의 프로퍼티 이름은 반드시 큰 따옴표로 처리 해야한다.
		out.write(msg);
	}
}
