<%-- 
    Document   : addProduct
    Created on : Nov 18, 2019, 1:10:32 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="service" scope="request" class="service.ProductService"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
        <%
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));
            service.createProduct(description, price);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
            request.setAttribute("message", "Product successfully created");
            dispatcher.forward(request, response);
        %>
        
    </body>
</html>
