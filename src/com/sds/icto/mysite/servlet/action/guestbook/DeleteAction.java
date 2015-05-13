package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		
		Long no = Long.parseLong(request.getParameter("no"));
		String pwd = request.getParameter("password");
			
		GuestBookVo vo = new GuestBookVo();
		
		vo.setNo(no);
		vo.setPwd(pwd);
			
		
		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);
		
		response.sendRedirect("/mysite/gb");

	}

}
