<%-- 
    Document   : order
    Created on : Sep 25, 2019, 8:59:59 AM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đơn hàng của tôi</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <c:set var="discount" scope="session" value="${0}" />
        <c:set var="total" scope="session" value="${0}" />
        <c:set var="value" scope="session" value="${0}" />
        <div class="container">
            <div class="row container-fluid mt-3" style="width: 80%; text-align: center">       
                <div class="col-12 col-md-12">
                    <h3>Đơn hàng của tôi</h3>
                    <p style="color: red">${messege}</p>
                </div>

            </div>
            <div class="container-fluid" >

                <c:if test="${orderlist.size() == 0 || orderlist == null}">
                    <div style="text-align: center">
                        <p style="color: orangered">
                            Hiện tại bạn chưa đặt đơn hàng nào.</p>
                    </div>
                </c:if>
                <table class="table-striped table-bordered container-fluid " style="width: 100%;">
                    <tr style="text-align: center" class="header-dark">
                        <th>Mã đơn hàng</th>
                        <th colspan="2">Sản phẩm</th>
                        <th>Màu</th>
                        <th>Giá</th>
                        <th>Giảm giá</th>
                        <th>Số lượng</th>
                        <th>Tổng tiền</th>
                        <th>Trạng thái</th>
                        <th>Ngày mua</th>
                    </tr>

                    <c:forEach var="order" items="${orderlist}">
                        <c:forEach var="item" items="${order.orderItems}">
                            <tr>
                                <td>
                                    ${order.id}
                                </td>
                                <td>
                                    <div style="width: 150px; height: 150px">
                                        <img src="<%=pathWebcontent %>/images/${item.prod.images}" class="container-fluid" />
                                    </div>
                                </td>
                                <td>
                                    ${item.prod.description}  
                                </td>
                                <td>
                                    <c:if test="${item.prod.kind_id != 4 && item.prod.kind_id != 5}">
                                        ${item.color}
                                    </c:if>
                                </td>
                                <td>
                                    <fmt:formatNumber type="number">${item.prod.price}</fmt:formatNumber>
                                        VND 
                                    </td>
                                    <td>
                                    <fmt:formatNumber type="number">${item.prod.discount}</fmt:formatNumber>
                                        VND
                                    </td>
                                    <td>
                                    ${item.quantity}
                                </td>
                                <td>
                                    <c:set var="total" value="${item.prod.price * item.quantity}"></c:set>
                                    <c:set var="discount" value="${item.prod.discount * item.quantity}"></c:set>
                                    <fmt:formatNumber type="number">${total - discount}</fmt:formatNumber>
                                    VND
                                    </td>
                                    <td>
                                    ${order.os.name}
                                </td>
                                <td>
                                    ${order.orderedAt}
                                </td>
                            </tr>

                        </c:forEach>
                    </c:forEach> 
                </table>

            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
