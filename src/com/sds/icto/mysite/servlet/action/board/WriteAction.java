package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;

import com.sds.icto.web.Action;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Long memberno = Long.parseLong(request.getParameter("memberno"));
		String membername = request.getParameter("membername");
		Long viewcnt = 1l;
				
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMemberno(memberno);
		vo.setMembername(membername);
		vo.setViewcnt(viewcnt);
		
		
		BoardDao dao = new BoardDao();
		dao.insert(vo);
		
		response.sendRedirect("/mysite/bd");
	}

}
