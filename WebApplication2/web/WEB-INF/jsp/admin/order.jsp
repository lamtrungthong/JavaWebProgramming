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
                <a href="<%=pathWebcontent%>/admin/home">Home</a>/ 
                <a href="<%=pathWebcontent%>/admin/order"> Đơn hàng</a>
                <hr>
            </div>
            <div style="text-align: center; color: red">
                <c:if test="${rsSet > 0}">
                    Cập nhật trạng thái thành công
                </c:if>
                <c:if test="${rsDel > 0}">
                    Sản phẩm đã bán thành công
                </c:if>
                <c:if test="${rsCancel >0}">
                    Đơn hàng đã được hủy và thông báo cho khách hàng thành công
                </c:if>
            </div>
                <a href="<%=pathWebcontent %>/admin/order/done"
                   class="btn btn-success mb-2 mt-2">Các đơn hàng đã hoàn thành</a>
                   <a href="<%=pathWebcontent %>/admin/order/cancel"
                   class="btn btn-danger mb-2 mt-2">Các đơn hàng đã hủy</a>
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
                        <th scope="col">Hủy</th>
                        <th scope="col">Chi tiết hóa đơn</th>
                    </tr>
                </thead>
                <tbody>
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
                                    <c:when test="${order.orderStatus == 1}">
                                        <a href="<%=pathWebcontent%>/admin/order/state/${order.id}"
                                           class="btn btn-primary"
                                           >${order.os.name}</a>
                                    </c:when>
                                    <c:when test="${order.orderStatus == 2}">
                                        <a href="<%=pathWebcontent%>/admin/order/state/${order.id}"
                                           class="btn btn-success"
                                           >${order.os.name}</a>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="<%=pathWebcontent%>/admin/order/state/${order.id}"
                                           class="btn btn-danger"
                                           >${order.os.name}</a>
                                    </c:otherwise>
                                </c:choose>

                            </td>
                            <td>
                                <button type="button" class="btn btn-danger" 
                                        data-toggle="modal" data-target="#o${order.id}">
                                    Hủy
                                </button>
                            </td>
                            <td><a href="<%=pathWebcontent%>/admin/order/view/${order.id}">Chi tiết </a></td>
                        </tr>


                        <!-- The Modal -->
                    <div class="modal" id="o${order.id}">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <!-- Modal Header -->
                                <div class="modal-header">
                                    <h4 class="modal-title">Thông báo hủy đơn hàng</h4>
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                </div>
                                <form class="modal-body" action="order/delOrder" method="post">
                                    <!-- Modal body -->
                                    <div class="form-group ">
                                        <label>ID Order</label>
                                        <input type="text" class="form-control" 
                                               value="${order.id}" name="idOrder" readonly="" />
                                    </div>
                                    <div class="form-group ">
                                        <label>Lý do</label>
                                        <input type="text" name="reason" value="Sản phẩm tạm thời hết hàng, mong quý khách thông cảm" class="form-control" 
                                                />
                                    </div>

                                    <!-- Modal footer -->
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-danger">Gửi</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:forEach>


                </tbody>
            </table>

            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
