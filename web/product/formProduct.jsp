<%-- 
    Document   : productForm
    Created on : Nov 18, 2019, 1:16:12 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Form</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${product==null}">
                <h2>New Product</h2>
                <form action="${pageContext.request.getContextPath()}/product/createProduct.jsp" method="post">
                </c:when>
                <c:otherwise>
                    <h2>Edit Product</h2>
                    <form action="${pageContext.request.getContextPath()}/product/updateProduct.jsp" method="post">
                    </c:otherwise>
                </c:choose>
                <c:if test="${product!=null}">
                    Pcode : <input type="text" name="pcode" value="${product.pcode}" readonly><br/>
                </c:if>
                Description : <input type="text" name="description" value="${product.description}"><br/>
                Price: <input type="text" name="price" value="${product.price}"><br/>
                <input type="submit" value="Submit">
            </form>

    </body>
</html>
