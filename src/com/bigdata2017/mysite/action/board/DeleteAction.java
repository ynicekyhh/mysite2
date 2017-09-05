package com.bigdata2017.mysite.action.board;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bigdata2017.mysite.dao.BoardDao;
import com.bigdata2017.mysite.vo.UserVo;
import com.bigdata2017.web.Action;
import com.bigdata2017.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// is auth?
		HttpSession session = request.getSession();
		if( session == null ) {
			WebUtil.redirect( request.getContextPath() + "/board", request, response );
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute( "authUser" );
		if( authUser == null ) {
			WebUtil.redirect(request.getContextPath() + "/board", request, response);
			return;
		}	
		
		long no = WebUtil.checkLongParam( request.getParameter( "no" ), 0L );
		int page = WebUtil.checkIntParam( request.getParameter( "p" ), 1 ); 
		String keyword = WebUtil.checkNullParam( request.getParameter( "kwd" ), "" );
		long userNo = authUser.getNo();
		
		new BoardDao().delete( no, userNo );
		
		WebUtil.redirect(
			request.getContextPath() + "/board?p=" + page + "&kwd=" + URLEncoder.encode( keyword, "UTF-8" ),
			request, 
			response);
	}
}