package com.bigdata2017.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdata2017.mysite.dao.BoardDao;
import com.bigdata2017.mysite.vo.BoardVo;
import com.bigdata2017.web.Action;
import com.bigdata2017.web.util.WebUtil;

public class ViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long no = WebUtil.checkLongParam( request.getParameter( "no" ), 0L );
		int page = WebUtil.checkIntParam( request.getParameter( "p" ), 1 );
		String keyword = WebUtil.checkNullParam( request.getParameter( "kwd" ), "" );
		
		BoardDao dao = new BoardDao();
		BoardVo boardVo = dao.get( no );

		if( boardVo == null ) {
			WebUtil.redirect( request.getContextPath() + "/board", request, response );
			return;
		}
		
		// view count 증가
		dao.updateHit( no );
		
		request.setAttribute( "boardVo", boardVo );
		request.setAttribute( "page", page );
		request.setAttribute( "keyword", keyword );
		
		WebUtil.forward(
			"/WEB-INF/views/board/view.jsp", 
			request,
			response);
	}

}
