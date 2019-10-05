<%-- 
    Document   : iPad
    Created on : Sep 15, 2019, 3:20:34 PM
    Author     : thonglt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iPad</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="container">
            <div class="container-fluid mt-3">
                <a href="<%=pathWebcontent%>">AppleStore</a> / <a href="<%=pathWebcontent%>/iPad">iPad</a>
                <hr/>
            </div>
            <div>
                <h1 style="text-align: center">iPad</h1>
                <hr/>
            </div>
                <table class="table-striped container-fluid">
                <c:forEach var="prod" items="${listProd}">
                    <tr>
                        <th style="margin: auto" >
                            <img width="300px" src="<%=pathWebcontent %>/images/${prod.images}" style="margin: 10px; margin-left: 50px" />
                    </th>
                    <td>
                        <h2>${prod.name}</h2>
                        <a href="${prod.id}" class="btn btn-primary">Xem chi tiết</a>
                        <h5>
                            <fmt:formatNumber type="number" value="${prod.price}" />
                            VND
                        </h5>
                    </td>
                </tr>
                </c:forEach>
                
            </table>

            <%@include file="../footer.jsp" %>
        </div>
    </body>
</html>
