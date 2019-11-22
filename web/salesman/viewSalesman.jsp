<%-- 
    Document   : viewSalesman
    Created on : Nov 20, 2019, 5:37:27 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Salesman</h1>
        <table border="1">
            <tr>
                <td>Code</td>
                <td>${salesman.scode}</td>
            </tr>
            <tr>
                <td>Name</td>
                <td>${salesman.name}</td>
            </tr>
            <tr>
                <td>City</td>
                <td>${salesman.city}</td>
            </tr>
            <tr>
                <td>Commission</td>
                <td>${salesman.commission}</td>
            </tr>

        </table>
        <br/>
        <c:choose>
            <c:when test="${empty salesman.family}">
                <p>Salesman has no Family Members!</p>
                <a href="${pageContext.request.getContextPath()}/family/createFamily?salesman=${salesman.scode}">New family member</a>
                    
            </c:when>
            <c:otherwise>
                <div>
                    <h3>Family</h3>
                    <a href="${pageContext.request.getContextPath()}/family/createFamily?salesman=${salesman.scode}">New family member</a>
                    <table border="1">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Relation</th>
                                <th>Date of Birth</th>
                                <th colspan="2">Actions</th>
                            </tr>
                        </thead>
                        <c:forEach items="${salesman.family}" var="member">
                            <tr>
                                <td>${member.id}</td>
                                <td>${member.name}</td>
                                <td>${member.relationship}</td>
                                <td>${member.dob}</td>
                                <td><a href="${pageContext.request.getContextPath()}/family/updateFamily?id=${member.id}">Update</a></td>
                                <td>
                                    <a href="javascript:confirmDelete(${member.id}, ${salesman.scode})">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </c:otherwise>
        </c:choose>

        <script>
            function confirmDelete(familyId, salesmanId) {
                if (confirm('Are you sure you want to delete the family member with ID:' + familyId + '?')) {
                    window.location = '${pageContext.request.getContextPath()}/family/deleteFamily?id=' + familyId + '&salesman=' + salesmanId;
                }
            }
        </script>
    </body>
</html>
