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
        <title>Đăng ký</title>
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
        <link href="./css/login.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container" >
            <c:url value="/đăng ký" var="url" />
            <form:form modelAttribute="register"
                       class="form-signin " onsubmit="return check();"
                       style="width: 50%; margin: auto"
                       method="post" action="${url}"
                       >
                <div class="text-center mb-4">
                    <h1 class="h3 mb-3 font-weight-normal mt-3">Đăng ký</h1>
                </div>
               <div class="form-label-group mt-3">
                    <form:label path="email">Email:</form:label>
                    <form:input path="email" type="email" id="email" cssClass="form-control"/>

                </div>

                <div class="form-label-group mt-3">

                    <form:label path="password">Mật khẩu:</form:label>
                    <form:password path="password" id="password"  cssClass="form-control" />
                </div>
                <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Đăng ký</button>
            </form:form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function check() {
            var name = $("#name").val();
            var email = $("#email").val();
            var pass = $("#password").val();
            if(name == ""){
                alert('Họ tên không được để trống!');
                return false;
            }else if(pass == ""){
                alert('Mật khẩu không được để trống!');
                return false;
            }
            else if(email == ""){
                alert('Email không được để trống!');
                return false;
            }
            else{
                return true;
            }
            
        }
    </script>
</html>
