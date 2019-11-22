<%-- 
    Document   : salesmans
    Created on : Nov 18, 2019, 12:20:09 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesmen</title>
    </head>
    <body>

        <%@include file="../header.jsp"%>
        <!--Includes the file at translation time: when the jsp is translated into servlet-->
        <div align="center">
            <h2>List of Salesmen</h2>
            <a href="${pageContext.request.getContextPath()}/salesman/createSalesman">New Salesman</a>
            <c:if test="${message!=null}">
                <h3>${message}</h3>
            </c:if>
            <table border="1">
                <c:forEach items="${salesmanList}" var="salesman">
                    <tr>
                        <td>${salesman.scode}</td>
                        <td>${salesman.name}</td>
                        <td>${salesman.city}</td>
                        <td>${salesman.commission}</td>
                        <td><a href="${pageContext.request.getContextPath()}/salesman/viewSalesman?id=${salesman.scode}">Details</a></td>
                        <td><a href="${pageContext.request.getContextPath()}/salesman/updateSalesman?id=${salesman.scode}">Update</a></td>
                        <td>
                            <a href="javascript:confirmDelete(${salesman.scode})">Delete</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
        <!--Includes the file at runtime-->
        <jsp:include page="../footer.jsp"/>
        <script>
            function confirmDelete(salesmanId) {
                if (confirm('Are you sure you want to delete the salesman with ID:' + salesmanId + '?')) {
                    window.location = '${pageContext.request.getContextPath()}/salesman/deleteSalesman?id=' + salesmanId;
                }
            }
        </script>
    </body>
</html>
