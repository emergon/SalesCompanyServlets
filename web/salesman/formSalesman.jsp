<%-- 
    Document   : salesmanForm
    Created on : Nov 18, 2019, 1:16:12 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salesman Form</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${salesman==null}">
                <h2>New Salesman</h2>
                <form action="${pageContext.request.getContextPath()}/salesman/createSalesman" method="post">
                </c:when>
                <c:otherwise>
                    <h2>Edit Salesman</h2>
                    <form action="${pageContext.request.getContextPath()}/salesman/updateSalesman" method="post">
                    </c:otherwise>
                </c:choose>
                <c:if test="${salesman!=null}">
                    Scode : <input type="text" name="scode" value="${salesman.scode}" readonly><br/>
                </c:if>
                Name : <input type="text" name="name" value="${salesman.name}"><br/>
                City : <input type="text" name="city" value="${salesman.city}"><br/>
                Commission : <input type="text" name="commission" value="${salesman.commission}"><br/>
                <input type="submit" value="Submit">
            </form>

    </body>
</html>
