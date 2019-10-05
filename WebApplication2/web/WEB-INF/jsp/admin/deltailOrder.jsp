<%-- 
    Document   : deltailOrder
    Created on : Sep 30, 2019, 10:58:52 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết đơn hàng ID</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a> / 
                <a href="<%=pathWebcontent%>/admin/order"> Đơn hàng</a> / 
                <a href="<%=pathWebcontent%>/admin/order/view/${orders.id}"> Chi tiết đơn hàng</a>
                <hr>
            </div>
            <div class="mt-3">
                <h3>Thông tin khách hàng</h3>
                <p>
                    Name: ${orders.users.name} <br>
                    Email: ${orders.users.username} <br>
                    Phone: ${orders.users.info.phone} <br>
                    Address: ${orders.users.info.address}
                </p>
                <h4>
                    <c:set var="sum" value="${0}" />
                    <c:forEach var="item" items="${orders.orderItems}">
                        <c:set var="sum" value="${sum + item.amount}" />
                    </c:forEach>
                    Tổng giá trị đơn hàng: <fmt:formatNumber type="number" > ${sum} </fmt:formatNumber> VND
                </h4>
            </div>
            <hr>
            <h3>Chi tiết đơn hàng</h3>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Mã sản phẩm</th>
                        <th scope="col">Tên sản phẩm</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Giá</th>
                        <th scope="col">Thành tiền</th>
                    </tr>
                </thead>
                <tbody>
                <c:set var="i" value="${1}" />
                <c:forEach var="item" items="${orders.orderItems}" >
                     <tr>
                        <th scope="row">${i}</th>
                        <td>${item.prod.id}</td>
                        <td>${item.prod.name}</td>
                        <td>${item.quantity}</td>
                        <td><fmt:formatNumber type="number" >${item.prod.price}</fmt:formatNumber> VND</td>
                        <td><fmt:formatNumber type="number"> ${item.amount}</fmt:formatNumber> VND</td>
                    </tr>
                    <c:set var="i" value="${i+1}" />
                </c:forEach>
                   
                    
                </tbody>
            </table>

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
