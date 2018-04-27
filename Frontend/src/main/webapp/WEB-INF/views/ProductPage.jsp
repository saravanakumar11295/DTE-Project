<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>Product Page</title>
</head>
<br>
<br>
<br>
<br>
<body class="bg">
  <table align="center">
     <tr bgcolor="Blue">
     <td colspan="4">Product Detail</td>
     </tr>
     <tr>
  <c:forEach items="${listProducts}" var="product">
     
     <td>
     <img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="150" height="200"/>
         <br/>
         <a href="<c:url value="/productDesc/${product.productId}"/>">${product.productName}</a>
         <br/>INR.${product.price} /-
            
     </td>
  </c:forEach>
  </tr>
  </table>


</head>

<%@include file="Footer.jsp" %>
</body>
</html>
