<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Add category page</title>
  </head>
  
  <body>
    <br/><br/>
    <form action="${pageContext.request.contextPath}/CategoryServlet?method=add" method="post">
    	<table width="500px;">
    	
    	<tr>
    		<td>Name：</td>
    		<td><input type="text" name="name" style="width: 200px"></td>
    	<tr>
    	<tr>
    		<td>Description：</td>
    		<td><textarea rows="4" cols="40" name="description"></textarea></td>
    	</tr>
    	<tr>
    		<td></td><td><input type="submit" value="Add Category"></td>
    	</tr>
    	</table>
    </form>
    
  </body>
</html>