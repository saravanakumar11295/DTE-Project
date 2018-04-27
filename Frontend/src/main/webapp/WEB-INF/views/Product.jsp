<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3><center>Product Page</center></h3>

<form:form action="InsertProduct" modelAttribute="product" enctype="multipart/form-data">

<table align="center">
      <tr bgcolor="blue"><td colspan="2"><center>Product Detail</center></td></tr>
    <tr bgcolor="blue">
    <td>Product Name</td>
    <td><form:input path="productName"/></td>
    </tr>
    <tr bgcolor="red">
    <td>Product Desc</td>
    <td><form:input path="productDesc"/></td>
    </tr>
     <tr bgcolor="brown">
    <td>Category</td>
    <td>
       <form:select path="categoryId">
         <form:option value="0" lable="---select---"/>
         <form:options items="${catlist}"/>
         </form:select>
       </td>
    </tr>
  <tr bgcolor="blue">
    <td>Supplier</td>
    <td><form:input path="supplierId"/></td>
    </tr>
   <tr bgcolor="blue">
    <td>Price</td>
    <td><form:input path="price"/></td>
    </tr>
  <tr bgcolor="blue">
    <td>Stock</td>
    <td><form:input path="stock"/></td>
    </tr>
    <tr>
    <td>Productimages</td>
    <td><form:input type="file" path="pimage"/></td>
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
</html>