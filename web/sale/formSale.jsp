<%-- 
    Document   : saleForm
    Created on : Nov 18, 2019, 1:16:12 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sale Form</title>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>
    <body>

        <c:choose>
            <c:when test="${sale==null}">
                <h2>New Sale</h2>
                <form action="${pageContext.request.getContextPath()}/sale/createSale" method="post">
                </c:when>
                <c:otherwise>
                    <h2>Edit Sale</h2>
                    <form action="${pageContext.request.getContextPath()}/sale/updateSale" method="post">
                    </c:otherwise>
                </c:choose>
                <c:if test="${sale!=null}">
                    Scode : <input type="text" name="scode" value="${sale.scode}" readonly><br/>
                </c:if>
                <table>
                    <tr>
                        <td align="right">Salesman :</td>
                        <td>
                            <select name="salesman" style="width: 200px">
                                <c:forEach items="${listOfSalesman}" var="salesman">
                                    <c:choose>
                                        <c:when test="${salesman.scode eq sale.salesman.scode}">
                                            <option value="${salesman.scode}" selected>
                                            </c:when>
                                            <c:otherwise>
                                            <option value="${salesman.scode}">
                                            </c:otherwise>
                                        </c:choose>
                                        ${salesman.name}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">Customer :</td>
                        <td>
                            <select name="customer" style="width: 200px">
                                <c:forEach items="${listOfCustomer}" var="customer">
                                    <c:choose>
                                        <c:when test="${customer.ccode eq sale.customer.ccode}">
                                            <option value="${customer.ccode}" selected>
                                            </c:when>
                                            <c:otherwise>
                                            <option value="${customer.ccode}">
                                            </c:otherwise>
                                        </c:choose>
                                        ${customer.cname}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td align="right">Product :</td>
                        <td>
                            <select name="product" style="width: 200px">
                                <c:forEach items="${listOfProduct}" var="product">
                                    <c:choose>
                                        <c:when test="${product.pcode eq sale.product.pcode}">
                                            <option value="${product.pcode}" selected>
                                            </c:when>
                                            <c:otherwise>
                                            <option value="${product.pcode}">
                                            </c:otherwise>
                                        </c:choose>
                                        ${product.description}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>

                    </tr>
                    <tr>
                        <td align="right">Quantity :</td>
                        <td><input type="text" name="quant" value="${sale.quantity}" size="15"></td>
                    </tr>
                    <tr>
                        <td align="right">Cost :</td>
                        <td><input type="text" name="cost" value="${sale.cost}" size="15"></td>
                    </tr>
                    <tr>
                        <td align="right">Date :</td>
                        <td><input id="datepicker" type="text" name="date" value="${sale.date}" size="15"></td>
                    </tr>
                </table>

                <br/>
                <input type="submit" value="Submit">
            </form>
            <script>
                $(function () {
                    $("#datepicker").datepicker();
                    $.datepicker.setDefaults({
                        dateFormat: 'dd/mm/yy'
                    });
                });
            </script>
    </body>
</html>
