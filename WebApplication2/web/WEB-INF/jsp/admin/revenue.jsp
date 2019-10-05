<%-- 
    Document   : rev
    Created on : Oct 1, 2019, 12:42:44 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý doanh thu</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a>/ 
                <a href="<%=pathWebcontent%>/admin/revenue"> Doanh thu</a>
                <hr>
            </div>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th colspan="4">
                            <input id="date-form" onchange ="date()" class="form-control" type="date" />
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Doanh thu ngày</th>
                        <th scope="col">Doanh thu tháng</th>
                        <th scope="col">Doanh thu năm</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>
                            <c:set var="dt" value="${0}" />
                                    <c:forEach var="order" items="${listOrderDoneByDate}">
                                        <c:set var="sum" value="${0}" />
                                        <c:forEach var="item" items="${order.orderItems}">
                                            <c:set var="sum" value="${sum + item.amount}" />
                                        </c:forEach>
                                        <c:set var="dt" value="${dt+sum}" />
                                    </c:forEach>
                            <span id="date"><fmt:formatNumber type="number" >
                                    ${dt}
                                </fmt:formatNumber></span> VND </td>
                        <td>
                            <c:set var="dt" value="${0}" />
                                    <c:forEach var="order" items="${listOrderDoneByMonth}">
                                        <c:set var="sum" value="${0}" />
                                        <c:forEach var="item" items="${order.orderItems}">
                                            <c:set var="sum" value="${sum + item.amount}" />
                                        </c:forEach>
                                        <c:set var="dt" value="${dt+sum}" />
                                    </c:forEach>
                            <span id="month"><fmt:formatNumber type="number" >
                                    ${dt}
                                </fmt:formatNumber></span> VND </td>
                        <td>
                            <c:set var="dt" value="${0}" />
                                    <c:forEach var="order" items="${listOrderDoneByYear}">
                                        <c:set var="sum" value="${0}" />
                                        <c:forEach var="item" items="${order.orderItems}">
                                            <c:set var="sum" value="${sum + item.amount}" />
                                        </c:forEach>
                                        <c:set var="dt" value="${dt+sum}" />
                                    </c:forEach>
                            <span id="year"><fmt:formatNumber type="number" >
                                    ${dt}
                                </fmt:formatNumber></span> VND</td>
                    </tr>
                    
                </tbody>
            </table>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function date (){
            var dt = $("#date-form").val();
            var sumYear = 0;
            $.ajax("/WebApplication2/admin/revenue/date/"+dt).done(function (rs){
                var sumDate = 0;
                for(var order of rs){
                    var sum = 0;
                    for(var item of order.orderItems){
                        sum+= item.amount;
                    }
                    sumDate += sum; 
                    
                }
                $("#date").html(numeral(sumDate).format('0,0'));
            });
            var d = new Date(dt);
            var month = d.getMonth()+1;
            $.ajax("/WebApplication2/admin/revenue/month/"+month).done(function (rs){
                var sumMonth = 0;      
                for(var order of rs){
                    var sum = 0;
                    for(var item of order.orderItems){
                        sum+= item.amount;
                    }
                    sumMonth += sum; 
                }
                $("#month").html(numeral(sumMonth).format('0,0'));
                
            });
            
            $.ajax("/WebApplication2/admin/revenue/year/"+d.getFullYear()).done(function (rs){
                for(var order of rs){
                    var sum = 0;
                    for(var item of order.orderItems){
                        sum+= item.amount;
                    }
                    sumYear += sum; 
                }
                $("#year").html(numeral(sumYear).format('0,0'));
            });
            
            
           
        }
    </script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
</html>
