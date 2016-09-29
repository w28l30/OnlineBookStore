<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Category List</title>
  </head>
  
  <body style="text-align: center">
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>Information of Books' Categories</h2></caption>
   		<tr>
   			<td>Name</td>
   			<td>Description</td>
   			<td>Operation</td>
   		</tr>
   		
   		<c:forEach var="category" items="${categories}">
   			<tr>
   				<td>${category.name }</td>
	   			<td>${category.description }</td>
	   			<td>
	   				<a href="#">Modify</a>
	   				<a href="#">Delete</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	
  </body>
</html>