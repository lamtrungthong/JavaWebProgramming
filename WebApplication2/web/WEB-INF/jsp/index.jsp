<%-- 
    Document   : index
    Created on : Sep 23, 2019, 8:09:57 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Apple Store</title>
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
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
           <div class="container-fluid">
                <div class="bd-example">
                    <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <c:forEach var="i" begin="1" end="${listProdAdvertise.size()}" >
                                <c:choose>
                                    <c:when test="${i == 1}">
                                        <li data-target="#carouselExampleCaptions" data-slide-to="${i}" class="active"></li>
                                        </c:when>
                                        <c:otherwise>
                                        <li data-target="#carouselExampleCaptions" data-slide-to="${i}"></li>
                                        </c:otherwise>
                                    </c:choose>

                            </c:forEach>
                        </ol>
                        <div class="carousel-inner ">
                            <c:set var="i" value="${0}" />
                            <c:forEach var="prodAdvertise" items="${listProdAdvertise}">
                                <c:choose>
                                    <c:when test="${i == 0}">
                                        <div class="carousel-item active">                                        
                                            <a href="<%=pathWebcontent%>/${prodAdvertise.prodId}" class="container-fluid">
                                                <img src="<%=pathWebcontent %>/images/${prodAdvertise.images}" 
                                                     class="d-block w-100">
                                            </a>                                            
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="carousel-item">                                        
                                            <a href="<%=pathWebcontent%>/${prodAdvertise.prodId}" class="container-fluid">
                                                <img src="<%=pathWebcontent %>/images/${prodAdvertise.images}" 
                                                     class="d-block w-100">
                                            </a>                                            
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                                <c:set var="i" value="${i+1}" />
                            </c:forEach>

                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>     
            </div>

            <div class="container-fluid">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">
                            Các sản phẩm khuyến mại

                        </h4>

                    </div>
                    <div class="card-body">
                        <div class="row">
                            <c:forEach var="ProdDiscount" items="${listProdDiscount}">
                                <div class="col-md-4 mt-3">
                                    <div class="card" style="width: 18rem;">
                                        <a href="${ProdDiscount.id}">
                                            <img src="<%=pathWebcontent %>/images/${ProdDiscount.images}" 
                                                 class="card-img-top" alt="images" width="50px"></a>
                                        <div class="text-block">
                                            <p>Giảm giá: <fmt:formatNumber 
                                                    value = "${ProdDiscount.discount}" />
                                                VND</p>
                                        </div>
                                        <div class="card-body">
                                            <h4 class="card-title">${ProdDiscount.description}</h4>
                                            <h5 class="card-title" style="color: red; font-weight: bold">
                                                <fmt:formatNumber 
                                                    value = "${ProdDiscount.price}" />
                                                VND
                                            </h5>
                                            <a href="<%=pathWebcontent%>/${ProdDiscount.id}" class="btn btn-primary">View</a>
                                            <c:if test="${ProdDiscount.actived == 1}">
                                                <button 
                                                id="addtocart" onclick="addtocart(${ProdDiscount.id})"
                                                class="btn btn-outline-primary">Add to cart</button>
                                            </c:if>
                                            
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="card mb-4 shadow-sm">
                    <div class="card-header">
                        <h4 class="my-0 font-weight-normal">Các sản phẩm bán chạy</h4>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <c:forEach var="ProdSell" items="${listProdSell}">
                                <div class="col-md-4 mt-3">
                                    <div class="card" style="width: 18rem;">
                                        <a href="${ProdSell.id}">
                                            <img src="<%=pathWebcontent %>/images/${ProdSell.images}" 
                                                 class="card-img-top" alt="images" width="50px">
                                        </a>
                                        <div class="card-body">
                                            <h4 class="card-title">${ProdSell.description}</h4>
                                            <h5 class="card-title" style="color: red; font-weight: bold">
                                                <fmt:formatNumber 
                                                    value = "${ProdSell.price}" />
                                                VND
                                            </h5>
                                            <a href="<%=pathWebcontent%>/${ProdSell.id}" class="btn btn-primary">View</a>
                                            <button class="btn btn-outline-primary" onclick="addtocart(${ProdSell.id})">Add to cart</button>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
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
