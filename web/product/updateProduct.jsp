<%-- 
    Document   : updateProduct
    Created on : Nov 18, 2019, 2:32:54 PM
    Author     : anastasios
--%>

<%@page import="entities.Product"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="service" scope="request" class="service.ProductService"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <%
            int code;
        %>
        <c:choose>
            <c:when test="${param.description == null}">
                <%
                    code = Integer.parseInt(request.getParameter("id"));
                    Product p = service.getProduct(code);
                    request.setAttribute("product", p);
                %>
                <jsp:forward page="formProduct.jsp"/>
            </c:when>
            <c:otherwise >
                <%
                    code = Integer.parseInt(request.getParameter("pcode"));
                    String description = request.getParameter("description");
                    double price = Double.parseDouble(request.getParameter("price"));
                    service.updateProduct(code, description, price);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
                    request.setAttribute("message", "Product successfully updated");
                    dispatcher.forward(request, response);
                %>
                
            </c:otherwise>
        </c:choose>

    </body>
</html>
