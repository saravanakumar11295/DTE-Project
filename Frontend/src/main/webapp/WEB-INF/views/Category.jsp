<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h3><center>Category Page</center></h3>

<form action="InsertCategory" method="post">
<table align="center">
<tr><td>Category Name</td>
  <td><input type="text" id="catname" name="catname"/></td>
</tr>
<tr>
<td>Category Desc</td>
  <td><input type="text" id="catdesc" name="catdesc"/></td>
</tr>
<tr>
   <td colspan="2"><input type="submit" value="SUBMIT"/>
   <input type="reset" value="RESET"/></td>
</tr>
</table>
</form>

<table align="center">
   <tr>
        <td>Category Id</td>
      <td>Category Name</td>
        <td>Category Desc</td> 
        <td>Operation</td>
    </tr>
    <c:forEach items="${listCategories}" var="category">
    <tr>
    <td>${category.categoryId}</td>
    <td>${category.categoryName}</td>
    <td>${category.cateogryDesc}</td>
    <td>
    <a href="<c:url value="/updateCategory/${category.categoryId}"/>">Update</a> &nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/deleteCategory/${category.categoryId}"/>">Delete</a> &nbsp;&nbsp;&nbsp;
    </td>
    </tr>    
    </c:forEach>
</table>
</body>
</html>


</html>