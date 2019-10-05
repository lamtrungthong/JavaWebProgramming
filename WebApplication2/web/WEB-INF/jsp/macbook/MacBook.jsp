<%-- 
    Document   : MacBook
    Created on : Sep 15, 2019, 3:30:34 PM
    Author     : thonglt
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MacBook</title>
    </head>
    <body>
        <%@include file="../header.jsp" %>
        <div class="container">
            <div class="container-fluid mt-3">
                <a href="<%=pathWebcontent%>">AppleStore</a> / 
                <a href="<%=pathWebcontent%>/MacBook">MacBook</a>
                <hr/>
            </div>
                <div>
                <h1 style="text-align: center">MacBook</h1>
                <hr/>
            </div>
            
                <table class="table-striped" style="width: 100%">
                <c:forEach var="prod" items="${listProd}">
                    <tr>
                        <th style="text-align: center">
                            <img height="250px" src="<%=pathWebcontent %>/images/${prod.images}" style="margin: 10px;" />
                    </th>
                    <td style="text-align: center">
                        <h2>${prod.description}</h2>
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
