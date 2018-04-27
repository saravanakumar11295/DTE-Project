<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<body class="bg">

<style type="text/css">
	body
	 {
    	height: 100%;
	}
	.bg { 
    	background-image: url("resources/images/shope.jpg"),url("../resources/images/shope.jpg");
    	height: 100%; 
    	background-position: center;
    	background-repeat:repeat-y;
    	background-size: cover;
	}
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
 {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
 

</style>
<c:url value="/product" var="productValue"></c:url>
<c:url value="/category" var="categoryValue"></c:url>
<c:url value="/signup" var="signValue"></c:url>
<c:url value="/logout" var="logout"></c:url>
<c:url value="/cart" var="cart"></c:url>
<c:url value="/Home" var="home"></c:url>
<div class="navbar navbar-inverse navbar-fixed-top navbar-custom">
      <div class="container">
      <div class="navbar-header">
      			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navId" aria-expanded="false">
        			<span class="sr-only">Toggle navigation</span>
        			<span class="icon-bar"></span>
	        		<span class="icon-bar"></span>
    	    		<span class="icon-bar"></span>
     	 		</button>
     	 	
        <a class="navbar-brand text-muted" href="#">MYSHOPPING</a>
        </div>
          <div class="collapse navbar-collapse" id="navId">
        <c:if test="${!sessionScope.loggedIn}">
                <ul class="nav navbar-nav navbar-right">
                <li><a href="${home} ">Home</a></li>
                <li> <a href="login">Login</a></li>
                <li><a href="${signValue}">Signup</a></li>
                <li><a href="aboutus">AboutUs</a></li>
                
              </ul>
              </c:if>  
              <c:if test="${sessionScope.loggedIn}">
                  <c:if test="${sessionScope.role=='ROLE_ADMIN'}">
                    <ul class= "nav navbar-nav navbar-right">
                       <li><a href="${home}">Home</a></li>
                       <li> <a href="${categoryValue}">Category</a></li>
                       <li><a href="${productValue}">Product</a></li>
                       <li><a href="productPage">ProductPage</a></li>
                       <li><a href="supplier">Supplier</a><li>
                       <li><a href="${logout}" >Logout</a>
                    </ul>
                  </c:if>
                  <c:if test="${sessionScope.role=='ROLE_USER'}">
                    <ul class= "nav navbar-nav navbar-right">
                      <li><a href="${home}">Home</a></li>          
                      <li><a href="aboutus">AboutUs</a></li>
                      <li><a href="productPage">ProductPage</a></li>
                      <li><a href="${cart}">cart</a></li>
                      <li><a href="${logout}">Logout</a></li>
                      </ul>
                  </c:if>
               </c:if>
        </div>
     </div>
  </div>
  
</div>

</body>
</html>

