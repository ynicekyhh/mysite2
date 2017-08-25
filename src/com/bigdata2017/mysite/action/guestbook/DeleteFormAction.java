package com.bigdata2017.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata2017.web.Action;
import com.bigdata2017.web.util.WebUtil;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebUtil.forward(
			"/WEB-INF/views/guestbook/deleteform.jsp",
			request,
			response);
	}

}
