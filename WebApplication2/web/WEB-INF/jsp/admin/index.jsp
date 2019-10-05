<%-- 
    Document   : index
    Created on : Sep 25, 2019, 10:12:09 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello Admin</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="row mt-3">
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Tổng sản phẩm</h4>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title pricing-card-title"> 
                                <small class="text-muted">${sumProd} sản phẩm </small>
                            </h3>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Tổng số tiền</h4>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title pricing-card-title"> 
                                <small class="text-muted"><fmt:formatNumber type="number">
                                        ${sumPriceStore}
                                    </fmt:formatNumber>
                                     VND
                                </small>
                            </h3>
                            </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Tổng đơn hàng</h4>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title pricing-card-title">
                                <small class="text-muted">
                                    ${sumOrder} đơn hàng
                                </small>
                            </h3>
                            </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Tổng thành vên</h4>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title pricing-card-title">
                                <small class="text-muted">
                                ${sumUser}    thành vên 
                                </small>
                            </h3>
                           </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Doanh thu hôm nay (${date})</h4>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title pricing-card-title">
                                <small class="text-muted">
                                    <c:set var="dt" value="${0}" />
                                    <c:forEach var="order" items="${listOrderDoneByDate}">
                                        <c:set var="sum" value="${0}" />
                                        <c:forEach var="item" items="${order.orderItems}">
                                            <c:set var="sum" value="${sum + item.amount}" />
                                        </c:forEach>
                                        <c:set var="dt" value="${dt+sum}" />
                                    </c:forEach>
                                    <fmt:formatNumber type="number">${dt}</fmt:formatNumber> VND
                                 </small>
                            </h3>
                           </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="card mb-4 shadow-sm">
                        <div class="card-header">
                            <h4 class="my-0 font-weight-normal">Doanh thu tháng ${month}</h4>
                        </div>
                        <div class="card-body">
                            <h3 class="card-title pricing-card-title">
                                <small class="text-muted">
                                    <c:set var="dt" value="${0}" />
                                    <c:forEach var="order" items="${listOrderDoneByMonth}">
                                        <c:set var="sum" value="${0}" />
                                        <c:forEach var="item" items="${order.orderItems}">
                                            <c:set var="sum" value="${sum + item.amount}" />
                                        </c:forEach>
                                        <c:set var="dt" value="${dt+sum}" />
                                    </c:forEach>
                                    <fmt:formatNumber type="number">${dt}</fmt:formatNumber> VND
                                </small>
                            </h3>
                             </div>
                    </div>
                </div>
            </div>

            <%@include file="footer.jsp" %>
        </div>

    </body>
</html>
