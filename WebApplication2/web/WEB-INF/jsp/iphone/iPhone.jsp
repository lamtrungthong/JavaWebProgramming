<%-- 
    Document   : iphone11
    Created on : Sep 12, 2019, 11:02:17 AM
    Author     : thonglt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>iPhone</title>
    </head>
    <style>
        .text-block {
            background-color: #563d7c;
            border-right: 30px;
            color: white;
            font-weight: bold;
            width: 100%;
        }
        .text-block p{
            margin: auto;
            margin-left: 20px;
        }
    </style>
    <body>
        <%@include file="../header.jsp" %>
        <div class="container">
            <div class="container-fluid mt-3">
                <a href="<%=pathWebcontent%>">AppleStore</a> / 
                <a href="<%=pathWebcontent%>/iPhone">iPhone</a>
                <hr/>
            </div>
            <div class="row">
                <c:forEach var="prod" items="${listProd}">
                    <div class="col-md-4 mt-3">
                        <div class="card" style="width: 18rem;">
                            <a href="${prod.id}"><img src="<%=pathWebcontent %>/images/${prod.images}" 
                                             class="card-img-top" alt="images" width="50px"></a>
                            <c:if test="${prod.discount != 0}">
                                <div class="text-block">
                                    <p>Giảm giá  <fmt:formatNumber 
                                            maxFractionDigits = "3" value = "${prod.discount}" /> VND</p>
                                </div>
                            </c:if>
                            <div class="card-body">
                                <h4 class="card-title">${prod.name}</h4>
                                <h5 class="card-title" style="color: red; font-weight: bold">
                                    <fmt:formatNumber 
                                     value = "${prod.price}" /> VND
                                </h5>
                                <p class="card-text">${prod.description}</p>
                                <a href="<%=pathWebcontent%>/${prod.id}" class="btn btn-primary">View</a>
                                <c:if test="${prod.actived == 1 && prod.quantityStore > 5}">
                                    <button class="btn btn-outline-primary"
                                        onclick="addtocart(${prod.id})"
                                        >Add to cart</button>
                                </c:if>
                                <c:if test="${prod.actived == 1 && prod.quantityStore <= 5}">
                                    <button class="btn btn-danger"
                                        
                                        >Liên hệ</button>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <%@include file="../footer.jsp" %>
        </div>
    </body>
    <script>
            function addtocart(id) {
                $.ajax("/WebApplication2/addtocart/" + id).done(function(rs) {
                    $("#size").html(rs.length);
                });
            }
        </script>
</html>
