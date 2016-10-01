<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'orderdetail.jsp' starting page</title>
  </head>
  
  <body>
    <table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<h3>Order Detail</h3>
   		<tr>
   			<td>Name</td>
   			<td>Price</td>
   			<td>Count</td>
   			<td>Price</td>
   		</tr>
   		
   		<c:forEach var="orderitem" items="${order.orderItems}">
   			<tr>
	   			<td>${orderitem.book.name }</td>
	   			<td>${orderitem.book.price }</td>
	   			<td>${orderitem.quantity }</td>
	   			<td>${orderitem.price }</td>
   			</tr>
   		</c:forEach>
   		<tr>
   			<td colspan="2">Total Price</td>
   			<td colspan="2">${order.price }</td>
   		</tr>
   	</table>
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
  		<h3>Customer Info</h3>
  		<tr>
  			<td>Username</td>
  			<td>Phone</td>
  			<td>Cellphone</td>
  			<td>Address</td>
  			<td>Email</td>
  		</tr>
  		
  		<tr>
  			<td>${order.user.username }</td>
  			<td>${order.user.phone }</td>
  			<td>${order.user.cellphone }</td>
  			<td>${order.user.address }</td>
  			<td>${order.user.email }</td>
  		</tr>
  	</table>
  	<br/>
  	<a href="${pageContext.request.contextPath }/OrderManageServlet?method=update&id=${order.id }">Ship this order</a>
  </body>
</html>