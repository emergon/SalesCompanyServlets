<%-- 
    Document   : sales
    Created on : Nov 18, 2019, 12:20:09 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sales</title>
    </head>
    <body>

        <%@include file="../header.jsp"%>
        <!--Includes the file at translation time: when the jsp is translated into servlet-->
        <div align="center">
            <h2>List of Sales</h2>
            <a href="${pageContext.request.getContextPath()}/sale/createSale">New Sale</a>
            <c:if test="${message!=null}">
                <h3>${message}</h3>
            </c:if>
            <table border="1">
                <thead>
                <th>Code</th>
                <th>Salesman</th>
                <th>Customer</th>
                <th>Product</th>
                <th>Quantity</th>
                <th>Cost</th>
                <th>Date</th>
                <th colspan="3">Actions</th>
                </thead>
                <c:forEach items="${listOfSales}" var="sale">
                    <tr>
                        <td>${sale.scode}</td>
                        <td>${sale.salesman.name}</td>
                        <td>${sale.customer.cname}</td>
                        <td>${sale.product.description}</td>
                        <td>${sale.quantity}</td>
                        <td>${sale.cost}</td>
                        <td>${sale.date}</td>
                        <td><a href="${pageContext.request.getContextPath()}/sale/viewSalesman?id=${sale.scode}">Details</a></td>
                        <td><a href="${pageContext.request.getContextPath()}/sale/updateSalesman?id=${sale.scode}">Update</a></td>
                        <td>
                            <a href="javascript:confirmDelete(${sale.scode})">Delete</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
        <!--Includes the file at runtime-->
        <jsp:include page="../footer.jsp"/>
        <script>
            function confirmDelete(saleId) {
                if (confirm('Are you sure you want to delete the sale with ID:' + saleId + '?')) {
                    window.location = '${pageContext.request.getContextPath()}/sale/deleteSale?id=' + saleId;
                }
            }
        </script>
    </body>
</html>
