<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3><center>Product Page</center></h3>
<c:url value="/updateProduct" var="updateString"></c:url>
<form:form action="${updateString}" modelAttribute="product">

<table align="center">
      <tr bgcolor="blue">
         <td colspan="2">Product Detail</td>
      </tr>
    <tr bgcolor="blue">
       <td>ProductId</td>
    <td>
    <form:input path="productId" id="productId" readonly="true"/>
    </td>
    </tr>
    <tr bgcolor="red">
    <td>ProductName</td>
    <td>
    <form:input path="productName" id="productName"/></td>
    </tr>
    <tr bgcolor="red">
    <td>ProductDesc</td>
    <td>
    <form:input path="productDesc" id="productDesc"/></td>
    </tr>
    
     <tr bgcolor="brown">
    <td>Category</td>
    <td>
       <form:input path="categoryId" id="categoryId"/></td>
    </tr>
  <tr bgcolor="blue">
    <td>Supplier</td>
    <td>
    <form:input path="supplierId" id="suppilerId"/></td>
    </tr>
   <tr bgcolor="blue">
    <td>Price</td>
    <td><form:input path="price" id="price"/></td>
    </tr>
  <tr bgcolor="blue">
    <td>Stock</td>
    <td><form:input path="stock" id="stock"/></td>
    </tr>
    <tr bgcolor="blue">
    <td colspan="2"><center><input type="submit" value="SUBMIT"/></center>
   </td>
   </tr>
</table>
</form:form>
<table  cellpadding="5" cellspacing="5" align="center">
   <tr>
        <td>Product Id</td>
        <td>ProductName</td>
        <td>Product Desc</td>
        <td>price</td>
        <td>Stock</td>
        <td>SuppilerId</td>
        <td>CategoryId</td> 
        <td>Operation</td>
    </tr>
    <c:forEach items="${listproduct}" var="product">
    <tr>
    <td>${product.productId}</td>
    <td>${product.productName}</td>
    <td>${product.productDesc}</td>
    <td>${product.price}</td>
    <td>${product.stock}</td>
    <td>${product.supplierId}</td>
    <td>${product.categoryId}</td>
    <td>
    <a href="<c:url value="/updateProduct/${product.productId}"/>">Update</a> &nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a> &nbsp;&nbsp;&nbsp;
    </td>
    </tr>    
    </c:forEach>
    </table>


</body>
<%@include file="Footer.jsp" %>
</html>