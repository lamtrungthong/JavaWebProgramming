<%-- 
    Document   : order
    Created on : Sep 17, 2019, 8:21:09 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:set var="discount" scope="session" value="${0}" />
        <c:set var="total" scope="session" value="${0}" />
        <c:set var="value" scope="session" value="${0}" />
        <div class="container">
            <form action="đặt hàng" method="post">
            <div class="row container-fluid mt-3" style="width: 80%; text-align: center">       
                <div class="col-6 col-md-6">
                    <h3>GIỎ HÀNG CỦA BẠN</h3>

                </div>
                <div class="col-6 col-md-6">
                    <a href="<%= pathWebcontent%>/home">Mua thêm sản phẩm khác</a>
                </div>

            </div>
            <div class="container-fluid" >

                <c:if test="${cart.size() == 0 || cart == null}">
                    <div style="text-align: center">
                        <p style="color: orangered">
                        Hiện tại giỏ hàng của bạn chưa có đơn hàng nào.</p>
                    </div>
                </c:if>
                
                <table class="table table-bordered">
                    <c:forEach var="item" items="${cart}">
                        <tr>
                            <th>
                        <div style="width: 150px; height: 150px">
                            <img src="<%=pathWebcontent %>/images/${item.prod.images}" class="container-fluid" />
                        </div>
                        </th>
                        <th>
                        <h4>${item.prod.description}</h4>    
                        </th>
                        <th>
                        <h5>
                            <fmt:formatNumber type="number" value="${item.prod.price}"/>
                            VND
                        </h5>
                            
                        </th>  
                        <th>
                            <c:if test="${item.prod.kind_id != 4 && item.prod.kind_id != 5}">
                                <c:forEach var="Img" items="${item.prod.listImg}">
                                    <input type="radio" name="${item.prod.id}" checked="" value="${Img.name}" >
                                    <label>${Img.name}</label>
                                </c:forEach>
                            </c:if>
                        </th>
                        <th colspan="2">
                            <button type="button" id="sub" class="btn btn-outline-dark" 
                                    onclick="subQuantity(${item.prod.id})">-</button>
                            <span id="quantity${item.prod.id}">${item.quantity}</span>
                            <button type="button" id="add" class="btn btn-outline-dark" 
                                    onclick="addQuantity(${item.prod.id})">+</button>
                        </th>
                        <th>
                            <a href="<%=pathWebcontent%>/giỏ hàng/xóa/${item.prod.id}"
                               class="btn btn-primary"
                               >Xóa </a>
                        </th>
                        </tr>
                        <c:set var="total" scope="session" value="${total + (item.prod.price * item.quantity)}" />
                        <c:set var="discount" scope="session" value="${discount + (item.prod.discount*item.quantity)}" />
                    </c:forEach>
                </table>

            </div>
            <c:if test="${cart.size() != 0 && cart != null}">
                <div style="text-align: right;" class="container mt-5">

                    <table style="margin-left: auto" class="table-striped">
                        <tr>
                            <td>
                                <h4 style="text-align: left">
                                    Tạm tính:
                                </h4>
                            </td>
                            <td>
                                <h4><span id="total">
                                        <fmt:formatNumber type="number">

                                            <c:out  value="${total}" />

                                        </fmt:formatNumber></span>
                                </h4>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h4 style="text-align: left">
                                    Giảm giá:
                                </h4>
                            </td>
                            <td>
                                <h4 >
                                    -<span id="discount"> 
                                        <fmt:formatNumber type="number">

                                            <c:out value="${discount}" /> 

                                        </fmt:formatNumber></span>
                                </h4>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h4 style="text-align: left">
                                    Thành tiền: 
                                </h4>
                            </td>
                            <td >
                                <h4>
                                    <span id="value" style="color: red"> 
                                        <fmt:formatNumber  type="number">
                                            <c:out value="${total - discount}" />
                                        </fmt:formatNumber>
                                    </span>
                                </h4>
                            </td>
                        </tr>
                    </table>
                    <button type="submit"  class="btn btn-danger mt-3"> Tiến hành đặt hàng</button>
                </div>
            </c:if>
        </form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
                function addQuantity(id){
                var total = 0;
                        var discount = 0;
                        var value = 0;
                        $.ajax("/WebApplication2/addquantity/" + id).done(function(rs){
                for (var orderItem of rs){
                if (orderItem.prod.id == id){
                if((orderItem.prod.quantityStore -orderItem.quantity )<= 5 ){
                    $("#add").hide();
                }else{
                    $("#quantity" + id).html(orderItem.quantity);
                }    
                
                
                }
                total += (orderItem.quantity * orderItem.prod.price);
                        discount += (orderItem.quantity * orderItem.prod.discount);
                }
                value = total - discount;
                        $("#total").html(numeral(total).format('0,0'));
                        $("#discount").html(numeral(discount).format('0,0'));
                        $("#value").html(numeral(value).format('0,0'));
                });
                }

        function subQuantity(id){
        var total = 0;
                var discount = 0;
                var value = 0;
                $.ajax("/WebApplication2/subquantity/" + id).done(function(rs){
        for (var orderItem of rs){
        if (orderItem.prod.id == id){
        $("#quantity" + id).html(orderItem.quantity);
        
        }
        total += (orderItem.quantity * orderItem.prod.price);
                discount += (orderItem.quantity * orderItem.prod.discount);
        }
        value = total - discount;
                $("#total").html(numeral(total).format('0,0'));
                $("#discount").html(numeral(discount).format('0,0'));
                $("#value").html(numeral(value).format('0,0'));
        });
        }
        
        
    </script>
     <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
</html>
