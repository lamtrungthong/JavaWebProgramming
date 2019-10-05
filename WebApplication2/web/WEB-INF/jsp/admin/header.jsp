<%@page import="project.dto.Info"%>
<%@page import="project.model.UserModel"%>
<%@page import="project.dto.Users"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%String pathWebcontent = request.getContextPath();%>

<style>
    .nav-link:hover{
        background-color: black;
        border-radius: 20px;
        
    }
    

</style>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #563d7c;">
    <div class="container-fluid">


        <div class="collapse navbar-collapse "  id="navbarSupportedContent" >
            <a class="navbar-brand" href="<%=pathWebcontent%>/admin/home" style="color: white">AppleStore</a>

            <ul class="navbar-nav mr-auto ml-5 " >
                <li class="nav-item" >
                    <a class="nav-link" style="color: white; font-size: 18px;"
                       href="<%=pathWebcontent%>/admin/product">Quản lý sản phẩm</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;"
                       href="<%=pathWebcontent%>/admin/user">Quản lý người dùng</a>
                </li>
                
                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;" 
                       href="<%=pathWebcontent%>/admin/order">Quản lý đơn hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;" 
                       href="<%=pathWebcontent%>/admin/revenue">Quản lý doanh thu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;" 
                       href="<%=pathWebcontent%>/admin/advertise">Quảng cáo</a>
                </li>

            </ul>
           
            <%

                if (session.getAttribute("abc") != null) {
            %>


            <div class="dropdown ml-3">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <%
                        String email = (String) session.getAttribute("abc");
                        Users u = new UserModel().getUserByEmail(email);
                        Info info = new UserModel().getInfoById(u.getId());
                        if (info.getName() != null) {
                            out.println(info.getName());
                        } else {
                            out.println(email);
                        }
                    %>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class='dropdown-item' href= '<%=pathWebcontent%>/admin/info'> 
                        Thông tin
                    </a>
                        <a class='dropdown-item' href= '<%=pathWebcontent%>/admin/account'> 
                        Tài khoản
                    </a>
                    <a class='dropdown-item' href= '#' data-toggle= modal  data-target= '#logoutModal'>
                        Đăng xuất
                    </a>
                    
                </div>
            </div>
            <%
            } else {
            %>
            <a href="<%= pathWebcontent%>/đăng nhập" class="btn btn-primary ml-2"  style="" >Đăng nhập</a>
            <%
                }
            %>
        </div>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="<%=pathWebcontent%>/logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" 
crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
 <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
