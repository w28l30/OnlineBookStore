<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Backend Book List</title>
  </head>
	<body style="text-align: center">
   	<br/><br/>
   	
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>Book Information</h2></caption>
   		<tr>
   			<td>Name</td>
   			<td>Author</td>
   			<td>Description</td>
   			<td>Image</td>
 			<td>Operation</td>
   		</tr>
   		
   		<c:forEach var="book" items="${list}">
   			<tr>
   				<td>${book.name }</td>
   				<td>${book.author }</td>
   				<td>${book.description }</td>
   				<td><a href="${pageContext.request.contextPath }/images/${book.image }">查看图片</a></td>
	   			<td>
	   				<a href="#">修改</a>
	   				<a href="#">删除</a>
	   			</td>
   			</tr>
   		</c:forEach>
   	</table>
   	<br/><br/>
 
    
  </body>
</html>

