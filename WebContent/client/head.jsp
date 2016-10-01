<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Online Book Store</h1>
<br/><br/>
<div>    
<div style="margin-left: 40%;float: left">
	<a href="${pageContext.request.contextPath }/index.jsp">Index</a>
	<a href="${pageContext.request.contextPath }/client/listcart.jsp">Cart</a>
	<a href="#">Orders</a>
</div>
 	
<div style="float: right;">
		<c:if test="${user==null}">
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
 			Username：<input type="text" name="username" style="width: 50px">
 			Password：<input type="password" name="password" style="width: 50px">
 			<input type="submit" value="Login">
 			<input type="button" value="Register" onclick="javascript:window.location.href='/day22/client/register.jsp'">
		</form>
		</c:if>
		<c:if test="${user!=null}">
			${user.username }
		</c:if>
		
</div>
<div style="clear: both"></div>
</div>
<hr>