<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bookstore Backend Management</title>
</head>
<frameset rows="18%, *">
	<frame src="${pageContext.request.contextPath}/manager/head.jsp"
		name="head">
	<frameset cols="15%, *">
		<frame src="${pageContext.request.contextPath}/manager/left.jsp"
			name="left">
		<frame src="" name="right">
	</frameset>

</frameset>
</html>