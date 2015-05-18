<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="fn"%>
<%@page import="com.sds.icto.mysite.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page="/views/include/header.jsp" flush="false" />
		</div>
		<div id="content">
			<div id="user">
				<%-- 이름 : <%=authMember.getName()%><br><br>
				이메일 : <%=authMember.getEmail()%><br><br>
				성별 : <%=authMember.getGender()%><br><br> --%>
				
				<form id="join-form" name="joinForm" method="post" action="/mysite/member">
					
					<label class="block-label" for="name">이름</label>
					<input id="name" name="name" type="text" value="${authMember.name }">

					<label class="block-label" for="email">이메일</label>
					<input id="email" name="email" type="text" value="${authMember.email }">
					
					
					<label class="block-label" for="gender">성별</label>
					<c:choose>
					<c:when test="${authMember.gender=='female' }">
					<input name="gender" type="text" value="여자"><br><br>
					</c:when>
					<c:otherwise>
					<input name="gender" type="text" value="남자"><br><br>
					</c:otherwise>
					</c:choose>
					
					<%-- <% if(authMember.getGender().equals("female")){%>	
								
					<input name="gender" type="text" value="여자"><br><br>
					<%
					}else{
					%>
					<input name="gender" type="text" value="남자"><br><br>
					<%
					}
					%> --%>
					
					<a href="/mysite/index">홈으로</a>
				</form>	

				
			</div>
		</div>
		<div id="navigation">
			<jsp:include page="/views/include/navigation.jsp" />
		</div>
		<div id="footer">
			<jsp:include page="/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>