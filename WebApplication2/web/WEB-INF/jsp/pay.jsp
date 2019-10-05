<%-- 
    Document   : pay
    Created on : Sep 24, 2019, 9:56:30 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanh toán</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:set var="discount" scope="session" value="${0}" />
        <c:set var="total" scope="session" value="${0}" />
        <c:set var="value" scope="session" value="${0}" />
        <div class="container">
            <div class="row container-fluid mt-3" style="width: 80%; text-align: center">       
                <div class="col-12 col-md-12">
                    <h3>XÁC NHẬN ĐƠN HÀNG</h3>

                </div>

            </div>
            <div class="container-fluid" >

                <c:if test="${cart.size() == 0 || cart == null}">
                    <div style="text-align: center">
                        <p style="color: orangered">
                            Hiện tại giỏ hàng của bạn chưa có đơn hàng nào.</p>
                    </div>
                </c:if>
                <table class="table-striped table-bordered container-fluid " style="width: 100%;">
                    <tr style="text-align: center">
                        <th colspan="2">Sản phẩm</th>
                        <th>Giá</th>
                        <th>Màu</th>
                        <th>Số lượng</th>
                    </tr>
                    <c:set var="i" value="${0}" />
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
                                ${listColor.get(i).toString()}
                            </c:if>
                            <c:set var="i" value="${i+1}" />
                        </th>
                        <th>
                            
                            <span id="quantity${item.prod.id}">${item.quantity}</span>
                            
                        </th>
                        
                        </tr>
                        <c:set var="total" scope="session" value="${total + (item.prod.price * item.quantity)}" />
                        <c:set var="discount" scope="session" value="${discount + (item.prod.discount*item.quantity)}" />
                    </c:forEach>
                </table>


                <div class="row container-fluid">
                    <div class="col-6 col-md-6  mt-2 container-fluid"  style=" padding: 0px; margin-right: 0; border: 1px dashed green; width: 60%; border-radius:  20px;">
                        <div class="mt-2 mb-3" style="text-align: center">
                            <b >Địa chỉ giao hàng</b>
                        </div>
                        <div class="ml-10 mt-2" >
                            <div class="ml-3 mt2">
                                <b>Họ tên: ${info.name}</b>
                                <p>Địa chỉ: ${info.address}<br>
                                    Điện thoại: ${info.phone}
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-md-6">
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
                                <a href="<%=pathWebcontent%>/đặt mua" class="btn btn-danger mt-3"> Đặt mua</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
