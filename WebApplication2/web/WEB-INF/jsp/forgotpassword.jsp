<%-- 
    Document   : forgotpassword
    Created on : Sep 24, 2019, 10:36:49 AM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quên mật khẩu</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div style="text-align: center" class="mt-3">
                <p>Nhập email mà bạn đã đăng ký và mật khẩu mới.<br/>
                    Hệ thống sẽ gửi 1 mã xác nhận tới email của bạn. Bạn vui lòng kiểm tra email sau khi submit.</p>
            </div>
            <form method="post" action="forgotpass" onsubmit="return isEmpty();"
                  class="container-fluid mt-2">
                <div class="form-group">
                    <label class="form-label-group">Email</label>
                    <input class="form-control"
                           type="email" id="email" name="email" placeholder="Email" />
                </div>
                <div class="form-group">
                    <label class="form-label-group">Mật khẩu mới</label>
                    <input class="form-control"
                           type="password" id="password" name="password"  />
                </div>
                <button class="btn btn-success"  >Submit</button>
            </form>

            <%@include file="footer.jsp" %>
        </div>
    </body>

    <script>
        function isEmpty() {
            var email = $("#email").val();
            var pass = $("#password").val();
            if (email == "") {
                alert("Email không được để trống!");
                return false;
            } else if (pass == "") {
                alert("Mật khẩu không được để trống!");
                return false;
            } else {
                return true;
            }
        }
    </script>
</html>
