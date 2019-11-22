<%-- 
    Document   : familyForm
    Created on : Nov 18, 2019, 1:16:12 PM
    Author     : anastasios
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Family Form</title>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        
    </head>
    <body>

        <c:choose>
            <c:when test="${family==null}">
                <h2>New Family</h2>
                <form action="${pageContext.request.getContextPath()}/family/createFamily" method="post">
                </c:when>
                <c:otherwise>
                    <h2>Edit Family</h2>
                    <form action="${pageContext.request.getContextPath()}/family/updateFamily" method="post">
                    </c:otherwise>
                </c:choose>
                <c:if test="${family!=null}">
                    Code : <input type="text" name="fid" value="${family.id}" readonly><br/>
                </c:if>
                Name : <input type="text" name="name" value="${family.name}"><br/>
                Relation : <input type="text" name="relation" value="${family.relationship}"><br/>
                Date of Birth : <input id="datepicker" type="text" name="dob" value="${family.dob}" ><br/>
                <input type="submit" value="Submit">
            </form>

                <script>
            $(function () {
                $("#datepicker").datepicker();
                $.datepicker.setDefaults({
                    dateFormat : 'dd/mm/yy'
                });
            });
        </script>
    </body>
</html>
