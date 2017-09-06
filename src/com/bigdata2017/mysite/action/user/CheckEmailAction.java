package com.bigdata2017.mysite.action.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata2017.mysite.dao.UserDao;
import com.bigdata2017.mysite.vo.UserVo;
import com.bigdata2017.web.Action;

public class CheckEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter( "email" );
		System.out.println( email );
		
		UserVo vo = new UserDao().get( email );
		String result = "{ \"result\": \"exist\" }";
		
		if( vo == null ) {  // 이메일을 사용할 수 있음
			result = "{ \"result\": \"not exist\" }";
		} 
		
		response.setContentType( "application/json; charset=utf-8" ); 
		PrintWriter out = response.getWriter();
		out.print( result );
	}

}
