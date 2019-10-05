<%-- 
    Document   : detail
    Created on : Sep 12, 2019, 4:35:41 PM
    Author     : thonglt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${prod.description}</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="container-fluid mt-3">
                <a href="<%=pathWebcontent%>">AppleStore</a> / 
                <a href="<%=pathWebcontent%>/${kindProd.name}">${kindProd.name}</a>/
                <a href="<%=pathWebcontent%>/${prod.id}">${prod.description}</a>
                <hr/>
            </div>
            <div class="row">
                <div class="col-6 col-md-6">
                    <div id="xyz" class="container-fluid img-prod" style="margin: auto; padding: auto">
                        <img  src="<%=pathWebcontent %>/images/${prod.images}" width="400px">
                    </div>
                </div>

                <div class="col-6">
                        <c:if test="${prod.actived != 1}">
                            <h4 style="color: red">
                                Sản phẩm ngừng kinh doanh
                            </h4>
                        </c:if>
                    
                    <h3>${prod.description}</h3>
                    <div style="background-color: green; height:  50px; border-radius: 20px ">
                        <p style="color: white; margin-left: 20px; font-size: 24px">
                            Ưu đãi/ Khuyến mãi:
                        </p>
                    </div>
                    <div style="  border: 1px dashed green; border-radius: 20px">
                        <div style="margin: 10px">
                            <p> Giảm thêm đến 300,000đ khi thanh toán 100% giá trị đơn hàng qua VNPay-QR</p>
                            <c:if test="${prod.kind_id != 4 && prod.kind_id != 5 }">
                            <p>  Giảm 1,000,000đ khi mua combo ${name}+ Airpods</p>
                            </c:if>
                        </div>
                    </div>
                    <c:if test="${prod.kind_id != 4 && prod.kind_id != 5 }">
                        <h5 style="margin: 5px 5px">Màu:</h5>
                        <div class="row">
                            <c:forEach var="prodImg" items="${listProdImg}">
                                <div id="${prodImg.id}" onclick="prodimg(${prodImg.id});" class="color" style="margin-left: 20px; text-align: center; width: 100px; height: 100px; border: 1px solid">
                                    <img class="container-fluid img-color"
                                         src="<%=pathWebcontent %>/images/${prodImg.image}"
                                         />
                                    <div style="display: flex">
                                        
                                        <img id="ck${prodImg.id}"
                                            class="container-fluid img-check" 
                                             style="margin: 0; padding: 0;width: 30px; display: none"
                                             width="20px" height="20px" 
                                             src="https://image.flaticon.com/icons/svg/447/447147.svg"
                                              />
                                        <p style="margin: auto">${prodImg.name}</p>
                                        
                                    </div>

                                </div>

                            </c:forEach>

                        </div>
                    </c:if>
                    <div class="row">
                        <div class="col-6" >
                            <h5 style="margin: 5px; color: red">
                                Giá: <fmt:formatNumber type="number" 
                                                  value="${prod.price}" />  
                                VND
                            </h5>
                        </div>
                    </div>
                    <div class="row container-fluid " style="display: flex">
                        <div style="margin-left: 10px">
                            <c:if test="${prod.actived == 1 && prod.quantityStore > 5}">
                                <button class="btn btn-danger"
                                    onclick="addtocart(${prod.id})"
                                    >Thêm vào giỏ hàng</button>
                            </c:if>
                            <c:if test="${prod.actived == 1 && prod.quantityStore <= 5}">
                                <button class="btn btn-danger" >Liên hệ</button>
                            </c:if>
                            
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${prod.kind_id != 4 && prod.kind_id != 5 }">
                <div class="mt-5" style="text-align: center" >
                    <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#exampleModal">
                        Chi tiết sản phẩm
                    </button>
                    <!--                Modal-->
                    <%@include file="prodDetailModal.jsp" %>
                </div>
            </c:if>
            <div class="mt-5" style="text-align: center" >
                <h1>Các dòng sản phẩm khác</h1>
            </div>
            <div class="mt-5 container-fluid" style="text-align: center" >
                <div class="row container-fluid">
                    <c:forEach var="togetherProd" items="${togetherProd}">
                        <div class="col-md-3">
                            <div class="card mb-4 shadow-sm">
                                <a href="${togetherProd.id}">
                                    <img src="<%=pathWebcontent %>/images/${togetherProd.images}" 
                                         class="card-img-top"
                                         alt="${togetherProd.name}">
                                </a>
                                <div class="card-body">
                                    <p class="card-text">${togetherProd.description}</p>
                                    <p class="card-text">
                                        <fmt:formatNumber type="number" 
                                                          value="${togetherProd.price}" />

                                        VND
                                    </p>

                                </div>
                            </div>
                        </div>
                    </c:forEach>
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
            
            function prodimg(prodImgid) {
                $.ajax("/WebApplication2/prod/" + prodImgid).done(function(rs) {
                    
                   $("#xyz").html(" <img  src=/WebApplication2/images/"+rs.image+" width="+400+"px"+">");
                   $.ajax("/WebApplication2/prod-other/" + prodImgid).done(function (rs2){
                       for(var img of rs2){
                            $("#ck"+img.id).hide();
                       }
       
                   });
                   $("#ck"+prodImgid).show();
                });
            }
        </script>

</html>
