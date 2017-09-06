package com.bigdata2017.mysite.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata2017.mysite.dao.UserDao;
import com.bigdata2017.mysite.vo.UserVo;
import com.bigdata2017.web.Action;

import net.sf.json.JSONObject;

public class CheckEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter( "email" );
		UserVo vo = new UserDao().get( email );

		Map<String, Object> map = 
				new HashMap<String, Object>();
		map.put( "result", "success" );
		map.put( "message", null );
		if( vo == null ) {  // 이메일을 사용할 수 있음
			map.put( "data", true ); 
		} else {
			map.put( "data", false ); 
		}
		
		response.setContentType( "application/json; charset=utf-8" ); 
		PrintWriter out = response.getWriter();
		
		JSONObject json = JSONObject.fromObject( map );
		out.print( json.toString() );
	}

}
