package com.bigdata2017.mysite.action.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata2017.mysite.dao.GuestbookDao;
import com.bigdata2017.mysite.vo.GuestbookVo;
import com.bigdata2017.web.Action;
import com.bigdata2017.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();
		
		request.setAttribute( "list", list );
		WebUtil.forward(
			"/WEB-INF/views/guestbook/list.jsp",
			request,
			response);
	}

}
