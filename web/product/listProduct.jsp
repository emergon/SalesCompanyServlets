<%-- 
    Document   : products
    Created on : Nov 18, 2019, 12:20:09 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ page isELIgnored="false" %>--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="entities.Product" %>
<jsp:useBean id="service" scope="request" class="service.ProductService"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
    </head>
    <body>

        <%@include file="../header.jsp"%>
        <!--Includes the file at translation time: when the jsp is translated into servlet-->
        <div align="center">
            <h2>List of Products</h2>
            <a href="${pageContext.request.getContextPath()}/product/formProduct.jsp">New Product</a>
            <c:if test="${message!=null}">
                <h3>${message}</h3>
            </c:if>
            <table border="1">
                <c:forEach items="${service.products}" var="product">
                    <tr>
                        <td>${product.pcode}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td><a href="${pageContext.request.getContextPath()}/product/updateProduct.jsp?id=${product.pcode}">Update</a></td>
                        <td>
                            <a href="javascript:confirmDelete(${product.pcode})">Delete</a>
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>
        <!--Includes the file at runtime-->
        <jsp:include page="../footer.jsp"/>
        <script>
            function confirmDelete(productId) {
                if (confirm('Are you sure you want to delete the product with ID:' + productId + '?')) {
                    window.location = 'deleteProduct.jsp?id=' + productId;
                }
            }
        </script>
    </body>
</html>
