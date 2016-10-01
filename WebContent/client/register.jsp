<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'register.jsp' starting page</title>
  </head>
  
  <body style="text-align: center">
    
    <form action="${pageContext.request.contextPath }/RegisterServlet" method="post">
    	<table width="300px">
    	<caption><h2>Register</h2></caption>
    	<tr>
    		<td>username</td>
    		<td><input type="text" name="username" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>password</td>
    		<td><input type="password" name="password" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>phone</td>
    		<td><input type="text" name="phone" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>cellphone</td>
    		<td><input type="text" name="cellphone" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>address</td>
    		<td><input type="text" name="address" style="width: 200px"></td>
    	</tr>
    	<tr>
    		<td>email</td>
    		<td>
    			<input type="text" name="email" style="width: 200px">
    		</td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="Register"></td>
    	</tr>
    	</table>
    </form>
    
    
  </body>
</html>