<%-- 
    Document   : shipping
    Created on : Sep 24, 2019, 8:10:18 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Địa chỉ giao hàng</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container"> 
            <div class="mt-2 mb-3">
                <b >Địa chỉ giao hàng </b>
            </div>
            <div class="ml-10 mt-2" style="border: 1px dashed green; width: 60%; border-radius:  20px;">
                <div class="ml-3 mt2">
                    <b>Họ tên: ${info.name}</b>
                    <p>Địa chỉ: ${info.address}<br>
                        Điện thoại: ${info.phone}
                    </p>
                </div>
                <div class="mb-3 ml-3">
                    <a href="<%=pathWebcontent %>/thanh toán" class="btn  btn-primary"> Giao tới địa chỉ này</a>
                    <button class="btn btn-outline-primary" onclick="updateInfo()">Sửa</button>
                </div>
            </div>
                    <div class="mt-3">
                        <p style="color: red">${yes}</p>
                    <p style="color: red">${no}</p>
                    </div>

        </div>
        <div class="container">
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>

                function updateInfo() {
                $(".container").append(`<c:url value="/update-info2" var="url" />
            <form:form modelAttribute="infoUser" onsubmit="return check();"
                       class="form-signin "  id="login"
                       style="width: 50%; margin: auto"
                       method="post" action="${url}"
                       >
                <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal mt-3">Thông tin tài khoản</h1>
                    <p style="color: red">${yes}</p>
                    <p style="color: red">${no}</p>
                </div>
                <div class="form-label-group mt-3">
                    <form:label path="name">Họ tên:</form:label>
                    <form:input  path="name" id="name"  cssClass="form-control"/>

                </div>
                    <div class="form-label-group mt-3">
                    <form:label path="phone">Số điện thoại:</form:label>
                    <form:input  path="phone" id="phone"  cssClass="form-control"/>

                </div>
                <div class="form-label-group mt-3">
                    <form:label path="email">Email:</form:label>
                    <form:input type="email" path="email" id="email" readonly="true" name="username"  cssClass="form-control"/>

                </div>

                <div class="form-label-group mt-3">

                    <form:label path="address">Địa chỉ:</form:label>
                    <form:input path="address" id="address" cssClass="form-control" />
                </div>
                <form:button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Cập nhật</form:button>
            </form:form>`);
                            }

    </script>
</html>
