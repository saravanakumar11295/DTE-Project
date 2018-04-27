<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>

<title>Cart Page</title>
</head>
<br>
<br>
<br>
<br>
<body class="bg">
  <table align="center">
     <tr>
     <td colspan="4"><center><font color="red">Cart Detail</font></center></td>
     </tr>
     <tr>
     <td>ProductId</td>
     <td>Quantity</td>
     <td>Subtotal</td>
     <td>Operation</td>
     </tr>
   
  <c:forEach items="${cartList}" var="cartItem">
    <form action="<c:url value="/editCart/${cartItem.cartItemId}"/>" method="get">
     <tr bgcolor="Tomato" class="Info"> 
     <td>${cartItem.productId}</td>
     <td><input type="text" name="qty" value="${cartItem.quantity}"/></td>
     <td>${cartItem.subtotal}</td>
     <td>
         <input type="submit" value="Edit"  class="btn-sucess"/>
         <a href="<c:url value="/deleteCart/${cartItem.cartItemId}"/>" class="btn-btn-danger btn-block">Delete</a>
     </td>
     </tr>
    </form>
  </c:forEach>
  <tr>
  <td colspan="2">grandTotal</td>
  <td colspan="2">Rs.${grandTotal}/-</td>
  </tr>
      <tr>
         <td colspan="2" >
         <a href="<c:url value="/"/>" class="btn btn-primary">Continue Shopping</a></td>
         <td colspan="2" >
         <a href="<c:url value="/ConfirmOrder"/>" class="btn btn-primary">Check Out</a></td>
  
  </table>


</head>

<%@include file="Footer.jsp" %>
</body>
</html>
