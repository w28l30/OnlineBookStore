<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台左侧导航页面</title>
    
    <style type="text/css">
      .dc { 
      		display: none; 
      		margin-left: 10px;
      	  }
	</style>
	
	<script language="javascript">
	      function test(id) {
	    	  var menu = document.getElementById("dc" + id);
	    	  menu.style.display = menu.style.display == 'block' ? 'none' : 'block' ;       
	      }
	</script>
  </head>
  
  <body>
    <ul>
    	<li>
    		<a href="#" onclick="test('1')">Category Management
    			<div class="dc" id = "dc1">
	    			<a href="${pageContext.request.contextPath}/manager/addcategory.jsp"  target="right">Add Category</a><br/>
	    			<a href="${pageContext.request.contextPath}/CategoryServlet?method=getAll"  target="right">Show Categories</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test('2')">Book Management
    			<div class="dc" id = "dc2">
	    				<a href="${pageContext.request.contextPath }/BookServlet?method=forAddUI"  target="right">Add book</a><br/>
	    				<a href="${pageContext.request.contextPath }/BookServlet?method=list"  target="right">Show Books</a>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    	<li>
    		<a href="#" onclick="test('3')">Order Management
	    		<div class="dc" id = "dc3">
	    			<a href="${pageContext.request.contextPath }/OrderServlet?method=getAll&state=false"  target="right">Pending Order</a><br/>
	    			<a href="${pageContext.request.contextPath }/OrderServlet?method=getAll&state=true"  target="right">Shipped Order</a><br/>
	    		</div>
    		</a>
    	</li>
    	
    	<br/><br/>
    	
    </ul>
  </body>
</html>