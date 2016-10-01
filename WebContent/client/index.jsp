<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>Index of frontEnd</title>
    
    <style type="text/css">
    	body{
    		margin:0px;
    		padding:0px;
    		text-align: center;
    	}
    	
    	#container{
    		width: 980px;
    		height: 300px;
    		text-align: left;
    	}
    	#main{
    		margin-top: 20px; 
    	}
    	#head{
    		text-align: center;
    	}
    	
    	#categories{
    		border: solid 1px blue;
    		width: 250px;
    		padding-left: 20px;
    		height: 400px;
    		line-height: 40px;
    		float: left;
    	}
    	
    	#books{
    		float: left;
    		margin-left: 40px;
    	}
    	
    	#image{
    		float: left;
    	}
    	
    	#info{
    		float: left;
    	}
    	
    	#book{
    		float: left;
    		width:230px;
    	}
    	
    </style>
  </head>
  
  <body>
  	
  	<div id="container">
  		<div id="head">
  			<%@include file="/client/head.jsp" %>
  		</div>
  		
  		<div id="main">
  			
  			<div id="categories">
  				BookList：
  				<c:forEach var="c" items="${categories}">
  					<li><a href='${pageContext.request.contextPath }/IndexServlet?category_id=${c.id }'>${c.name }</a></li>
  				</c:forEach>
  			</div>
  			
  			<div id="books">
  				<c:forEach var="book" items="${pageBean.list}" varStatus="status">
	  				<div id="book">
	  					<div id="image">
	  						<img src="${pageContext.request.contextPath }/images/${book.image }"/>
	  					</div>
	  					<div id="info">
	  						<li>${book.name }</li>
	  						<li>${book.author }</li>
	  						<li>${book.price }</li>
	  						<li>
	  							<a href="${pageContext.request.contextPath }/BuyServlet?id=${book.id }">Buy</a>
	  						</li>
	  					</div>
	  					<div style="clear: both"></div>
	  				</div>
	  				<c:if test="${status.count%3==0}">
	  					<div style="clear: both"></div>
	  					<br/>
	  				</c:if>
  				</c:forEach>
  				<div style="clear: both"></div>
  				<br/>
  				<div id="pagebar">
  					Total:${pageBean.totalPage } Pages
  					Current Page:${pageBean.currentPage } 
  					<c:forEach var="pagenum" items="${pageBean.pageBar}">
  						<a href="${pageContext.request.contextPath}/IndexServlet?currentPage=${pagenum }&category_id=${param.category_id }">${pagenum }</a>
  					</c:forEach>
  					
  				</div>
  			</div>
  		
  		</div>
   	</div>
  </body>
</html>