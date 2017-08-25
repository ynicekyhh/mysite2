package com.bigdata2017.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata2017.mysite.dao.GuestbookDao;
import com.bigdata2017.mysite.vo.GuestbookVo;
import com.bigdata2017.web.Action;
import com.bigdata2017.web.util.WebUtil;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter( "name" );
		String password = request.getParameter( "pass" );
		String content = request.getParameter( "content" );
		
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setContent(content);
		vo.setPassword(password);
		
		GuestbookDao dao = new GuestbookDao();
		dao.insert(vo);
		
		WebUtil.redirect( request.getContextPath() + "/guestbook", request, response );
	}

}
