package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		System.out.println(request.getParameter("memberno"));
		Long no = Long.parseLong(request.getParameter("no"));
		Long memberno = Long.parseLong(request.getParameter("memberno"));
			
		BoardVo vo = new BoardVo();
		
		vo.setNo(no);
		vo.setMemberno(memberno);
			
		
		BoardDao dao = new BoardDao();
		dao.delete(vo);
		
		response.sendRedirect("/mysite/bd");

	}

}
