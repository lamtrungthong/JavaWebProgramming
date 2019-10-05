<%-- 
    Document   : footer
    Created on : Aug 28, 2019, 10:28:57 PM
    Author     : lds2h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String pathWebcontent2 = request.getContextPath();%>
<!DOCTYPE html>
<footer class="pt-4 my-md-5 pt-md-5 border-top">
    <div class="row">
        <div class="col-12 col-md">
            <img class="mb-2" src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1200px-Apple_logo_black.svg.png" alt="" width="24" height="24">
            <small class="d-block mb-3 text-muted">© 2019</small>
        </div>
        <div class="col-6 col-md">
            <h5>Hỗ trợ khách hàng</h5>
            <ul class="list-unstyled text-small">
                <li>Mọi phản hồi xin gửi về: </li>
                <li>Đ/c: 141 Chiến Thắng </li>
                <li>Hotline: 0987654321</li>
                <li>Email: applestore@gmail.com</li>

            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Chính sách</h5>
            <ul class="list-unstyled text-small">
                
                <li><a class="text-muted" href="<%=pathWebcontent2%>/chinh sach bao hanh">Chính sách bảo hành</a></li>
                <li><a class="text-muted" href="<%=pathWebcontent2%>/chinh sach doi tra">Chính sách đổi trả</a></li>
            </ul>
        </div>
        <div class="col-6 col-md">
            <h5>Về chúng tôi</h5>
            <ul class="list-unstyled text-small">
                <li><a class="text-muted" href="<%=pathWebcontent2%>/gioi thieu">Giới thiệu</a></li>
            </ul>
        </div>
    </div>
</footer>
            <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" 
crossorigin="anonymous"></script>