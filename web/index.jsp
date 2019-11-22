<%-- 
    Document   : index
    Created on : Nov 21, 2019, 8:25:11 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div align="center">
            <br/>
            <br/>
            Welcome ${username}&nbsp;&nbsp;|&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logout">Logout</a>
            <br/>
            <br/>
            <p>
                <a href="customers">List of All Customers</a>  (Only Servlet)
            </p>
            <p>
                <a href="product/listProduct.jsp">List of All Products</a>  (Only JSP)
            </p>
            <p>
                <a href="listSalesman">List of All Salesmen</a>  (JSP-Servlet)
            </p>
            <p>
                <a href="listSale">List of All Sales</a>  (JSP-Servlet)
            </p>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
