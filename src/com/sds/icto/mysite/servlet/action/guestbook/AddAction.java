package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;

import com.sds.icto.web.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String message = request.getParameter("content");
		
		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPwd(password);
		vo.setMsg(message);
		
		
		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);
		
		response.sendRedirect("/mysite/gb");
	}

}
