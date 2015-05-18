<%@page import="com.sds.icto.mysite.vo.MemberVo"%>
<%@page import="com.sds.icto.mysite.dao.BoardDao"%>
<%@page import="com.sds.icto.mysite.vo.BoardVo"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% BoardVo vo = new BoardVo(); 
BoardDao dao = new BoardDao();
MemberVo authMember = (MemberVo)session.getAttribute("authMember");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page = "/views/include/header.jsp" flush="false"/>
		</div>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="/mysite/bd">
					<input type="hidden" name="a" value="delete">
					<input type='hidden' name="no" value="<%=request.getParameter("no")%>">
					<input type='hidden' name="memberno" value="<%=authMember.getNo()%>">
					<label>정말로 삭제하시겠습니까?    </label>
					
					<input type="submit" value="YES">
				</form>
				<a href="/mysite/bd?a=list">게시판 리스트</a>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page = "/views/include/navigation.jsp" flush = "false"/>
		</div>
		<div id="footer">
			<jsp:include page = "/views/include/footer.jsp" flush = "false"/>
		</div>
	</div>
</body>
</html>