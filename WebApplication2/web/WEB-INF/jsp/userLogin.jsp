<%-- 
    Document   : login
    Created on : Sep 21, 2019, 3:18:57 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập</title>
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container" >
            
            <c:url value="/đăng nhập" var="url" />
            <form:form modelAttribute="userLogin" onsubmit="return check();"
                       class="form-signin "  id="login"
                       style="width: 50%; margin: auto"
                       method="post" action="${url}"
                       >
                <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal mt-3">Đăng nhập</h1>
                    <p style="color: red">${err}</p>
                    <p style="color: red">${err2}</p>
                    <p style="color: red">${block}</p>
                </div>
                <div class="form-label-group mt-3">
                    <form:label path="username">Email:</form:label>
                    <form:input type="email" path="username" id="username" name="username"  cssClass="form-control"/>

                </div>

                <div class="form-label-group mt-3">

                    <form:label path="password">Mật khẩu:</form:label>
                    <form:password path="password" id="password" cssClass="form-control" />
                </div>
                <form:button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Đăng nhập</form:button>
            </form:form>
                <div style="text-align: center" class="mt-5">
                <a  href="<%=pathWebcontent%>/quên mật khẩu">Quên mật khẩu?</a>
            </div>
            <div style="text-align: center" class="mt-2">
                <a  href="<%=pathWebcontent%>/đăng ký">Tạo tài khoản mới</a>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function check() {
            var email = $("#username").val();
            var pass = $("#password").val();
            if(email == ""){
                alert('Email không được để trống!');
                return false;
            }else if(pass == ""){
                alert('Password không được để trống!');
                return false;
            }
            else{
                return true;
            }
            
        }
    </script>
</html>
