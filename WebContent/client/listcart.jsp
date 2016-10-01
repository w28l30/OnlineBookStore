<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>购物车列表页面</title>
  </head>
  
   <body style="text-align: center">
   	<%@include file="/client/head.jsp" %>
   
   	<br/><br/>
   	
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>Cart</h2></caption>
   		<tr>
   			<td>Name</td>
   			<td>Price</td>
   			<td>Count</td>
   			<td>Total Price</td>
   		</tr>
   		
   		<c:forEach var="entry" items="${cart.map}">
   			<tr>
	   			<td>${entry.value.book.name }</td>
	   			<td>${entry.value.book.price }</td>
	   			<td>${entry.value.quantity }</td>
	   			<td>${entry.value.price }</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">Total price</td>
   			<td colspan="2">${cart.price }</td>
   		</tr>
   	</table>
    
    <a href="${pageContext.request.contextPath }/OrderServlet">生成订单</a>
  </body>
</html>