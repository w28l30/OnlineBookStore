<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单列表</title>
  </head>
  
  <body style="text-align: center">
   	<br/><br/>
   	<table frame="border" cellpadding="0" cellspacing="0" width="90%">
   		<caption><h2>Order Information</h2></caption>
   		<tr>
   			<td>Username</td>
   			<td>Time</td>
   			<td>State</td>
 			<td>Total Price</td>
 			<td>Operation</td>
   		</tr>

			<c:forEach var="order" items="${list}">
				<tr>
					<td>
						${order.user.username }
					</td>
					<td>
						${order.orderTime }
					</td>
					<td>
						${order.state==false?'Prepared':'Shipped' }
					</td>
					<td>
						${order.price }
					</td>
					<td>
						<a
							href="${pageContext.request.contextPath }/OrderManageServlet?method=find&id=${order.id }">Order Detail</a>
						<a href="#">Modified</a>
					</td>
				</tr>
			</c:forEach>
		</table>
  </body>
</html>