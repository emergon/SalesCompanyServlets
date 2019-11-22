<%-- 
    Document   : deleteProduct
    Created on : Nov 18, 2019, 2:17:37 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="service" scope="request" class="service.ProductService"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product</title>
    </head>
    <body>
        <%
            int code = Integer.parseInt(request.getParameter("id"));
            service.deleteProduct(code);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listProduct.jsp");
            request.setAttribute("message", "Product successfully deleted");
            dispatcher.forward(request, response);
        %>
        
    </body>
</html>
