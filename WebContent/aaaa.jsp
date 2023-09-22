<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
      <img src="images/logo.png" alt="로고 이미지" width="150px" height="150px" />
<%
	String path = request.getServletContext().getRealPath("/");
%>

<%=path %></body>
</html>