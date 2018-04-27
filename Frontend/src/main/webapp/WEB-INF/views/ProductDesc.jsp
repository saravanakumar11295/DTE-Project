<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<br>
<br>
<br>
<h3 align="center">Product Page</h3>
<body class="bg">
<center>
<table style="width:50%" class="table"></center>
    <tr bgcolor="black">
      <td rowspan="6">
      <center><img src="<c:url value="/resources/images/${ProductInfo.productId}.jpg"/>"width="125" height="200"/></center>
      </td>
      <td>
      <font color="red">Product Id</font></td>
      <td><font color="red">${ProductInfo.productId}</font></td>
    </tr>
    <tr bgcolor="black">
       <td><font color="red">Product Name</font></td>
       <td><font color="red">${ProductInfo.productName}</font></td>
    </tr>
    <tr bgcolor="black">
       <td><font color="red">Product price</font></td>
       <td><font color="red">${ProductInfo.price}</font></td>
    </tr>
    <tr bgcolor="black">
      <td><font color="red">Category Id</font></td>
      <td><font color="red">${ProductInfo.categoryId}</font></td>
    </tr>
    <tr bgcolor="black">
      <td><font color="red">Supplier Id</font></td>
      <td><font color="red">${ProductInfo.supplierId}</font></td>
    </tr>
    <tr bgcolor="black">
    <td><font color="red">Product Description</font></td>
    <td><font color="red">${ProductInfo.productDesc}</font></td>
    </tr>
    <tr> 
    <td colspan=2>
    <form action="<c:url value="/addToCart/${ProductInfo.productId}"/>" method="get">
     <table>
       <tr bgcolor="black">
         <td><font color="red">Quantity</font></td>
           <td>
            <select name="quantity">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
           </select>
          </td>
          <td>
          <input type="submit" value="AddToCart" class="btn btn-success btn-block"/>
          </td>
      </tr>
    </table>
    </form>
   </td>
  </tr>
    
    
</table> 
<%@include file="Footer.jsp" %>   
</body>
</html>
