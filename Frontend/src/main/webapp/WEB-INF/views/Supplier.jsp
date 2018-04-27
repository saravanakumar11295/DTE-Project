<%@include file="Header.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3><center>SuppilerPage</center></h3>

<form:form action="InsertSuppiler" modelAttribute="supplier">

<table align="center">
      <tr bgcolor="blue"><td colspan="2">SuppilerDetail</td></tr>
    <tr bgcolor="blue">
    <td>SuppilerName</td>
    <td><form:input path="suppilerName"/></td>
    </tr>
    <tr bgcolor="red">
    <td>SuppilerMobile</td>
    <td><form:input path="suppilerMobileNo"/></td>
    </tr>
    <tr bgcolor="blue">
    <td colspan="2"><center><input type="submit" value="SUBMIT"/></center>
   </td>
   </tr>
</table>
</form:form>
<table  cellpadding="18" cellspacing="18" align="center" border="1">
   <tr>
        <td>SuppilerId</td>
        <td>SuppilerName</td>
        <td>SuppilerMobileNo</td>
    </tr>
    <c:forEach items="${listsuppiler}" var="suppiler">
    <tr>
    <td>${suppiler.suppilerId}</td>
    <td>${suppiler.suppilerName}</td>
    <td>${suppiler.suppilerMobileNo}</td>
    <td>
    <a href="<c:url value="/updateSuppiler/${suppiler.suppilerId}"/>">Update</a> &nbsp;&nbsp;&nbsp;
    <a href="<c:url value="/deleteSuppiler/${suppiler.suppilerId}"/>">Delete</a> &nbsp;&nbsp;&nbsp;
    </td>
    </tr>    
    </c:forEach>
    </table>


</body>
</html>