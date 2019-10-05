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
        <title>Xác thực</title>

        <link href="./css/login.css" rel="stylesheet">
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container" >
            <div>
                <p class="mt-3">
                    Mã xác thực đã được gửi vào email của bạn, vui lòng kiểm tra email.</p>
                <p style="color: red">${err}</p>
            </div>
            <c:url value="/login" var="url" />
            <form:form onsubmit="return check(); " method="post" 
                       action="${url}" name="check"
                       style="text-align: center" >
                <input type="number" id="code" name="numcheck" class="form-control"
                       style="width: 30%; margin: auto" placeholder="Nhập mã xác thực" />
                <span> <button type="submit" class="btn btn-primary mt-3">Submit </button></span>
            </form:form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function check(){
            var code = $("#code").val();
            if(code == ""){
                alert('Mã xác nhận không được để trống');
                return false;
            }else{
                return true;
            }
        }
    </script>
</html>
