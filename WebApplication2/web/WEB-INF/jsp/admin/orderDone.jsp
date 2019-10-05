<%-- 
    Document   : order
    Created on : Sep 27, 2019, 9:07:32 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý đơn hàng</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a> / 
                <a href="<%=pathWebcontent%>/admin/order"> Đơn hàng</a> / 
                <a href="<%=pathWebcontent%>/admin/order/done"> Đơn hàng đã hoàn thành</a>
                <hr>
            </div>
                
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Order ID</th>
                        <th scope="col">Ngày order</th>
                        <th scope="col">Tên khách hàng</th>
                        <th scope="col">Địa chỉ</th>
                        <th scope="col">Email</th>
                        <th scope="col">Tổng tiền</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Chi tiết hóa đơn</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="revenue" value="${0}" />
                    <c:set var="i" value="${1}" />
                    <c:forEach var="order" items="${listOrder}">
                        <tr>
                            <th scope="row">${i}</th>
                            <td>${order.id}</td>
                            <td>${order.orderedAt}</td>
                            <td>${order.users.name}</td>
                            <td>${order.users.info.address}</td>
                            <td>${order.users.username}</td>
                            <td>
                                <c:set var="sum" value="${0}" />
                                <c:forEach var="item" items="${order.orderItems}">
                                    <c:set var="sum" value="${sum+item.amount}" />
                                </c:forEach>
                                <fmt:formatNumber type="number">${sum}</fmt:formatNumber> VND
                                </td>
                                <td>
                                <c:choose>
                                    <c:when test="${order.orderStatus == 5}">
                                        <button
                                           class="btn btn-success"
                                           >${order.os.name}</button>
                                    </c:when>
                                </c:choose>

                            </td>
                            <td><a href="<%=pathWebcontent%>/admin/order/view/${order.id}">Chi tiết </a></td>
                        </tr>
                        <c:set var="revenue" value="${revenue + sum}" />
                        <c:set  var="i" value="${i+1}" />
                </c:forEach>
                        <tr>
                            <td colspan="9">
                                Tổng doanh thu: <fmt:formatNumber type="number" >${revenue}</fmt:formatNumber> VND
                            </td>
                        </tr>


                </tbody>
            </table>

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
