<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
    <div>
        <a href="${pageContext.request.contextPath}/admin">
            <img src="${pageContext.request.contextPath}/images/salesCompany.png" width="200" height="100">
        </a>

    </div>
    <br/>
    <div id="headermenu">
        <br/>
        <br/>
        Welcome ${username}
        <br/>
        <br/>

        <a href="${pageContext.request.contextPath}/customers">
            Customers
        </a>
        |
        <a href="${pageContext.request.contextPath}/product/listProduct.jsp">
            Products
        </a>
        |
        <a href="#">
            Salesmen
        </a>
        |
        <a href="#">
            Sales
        </a>
        |
        <a href="#">
            Stores
        </a>
    </div>
    <br/>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>
</div>
</div>
