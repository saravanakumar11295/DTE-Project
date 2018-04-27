<html>
<head>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title>Thank You</title>
</head>
<body class="bg">
<div class="container">
  <c:url value="/thankYou" var="actionString"></c:url>
  	<form:form action="${actionString}" modelAttribute="order" cssClass="form-horizontal">
  
	<div class="row text-center">
		<div class="col-sm-6 col-sm-offset-3">
           <div class="panel-title">Congratulations,Dear User!</div>
	    </div>
	    <div class="panel-body">
        		<h3 align="center" class="well">You have placed your order successfully.</h3>
        		<p> Your order will be delivered at <b>${shippingAddress}</b> within 7 business days. </p>
        	    <h3 align="center" class="well">Please visit again.</h3>
        </div>
</div>
</form:form>
</div>
<%@include file="Footer.jsp" %>
</body>
</html>
