<%-- 
    Document   : header
    Created on : Aug 28, 2019, 9:14:20 PM
    Author     : lds2h
--%>


<%@page import="project.dto.Info"%>
<%@page import="project.model.UserModel"%>
<%@page import="project.dto.Users"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<%String pathWebcontent = request.getContextPath();%>

<style>
    .dropdown-item:hover{
        background-color: #ffd1b3;
    }
    
     .text-block {
            background-color: #563d7c;
            border-right: 30px;
            color: white;
            font-weight: bold;
            width: 100%;
        }
        .text-block p{
            margin: auto;
            margin-left: 20px;
        }

</style>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #563d7c;">
    <div class="container-fluid">


        <div class="collapse navbar-collapse "  id="navbarSupportedContent" >
            <a class="navbar-brand" href="<%=pathWebcontent%>/home" style="color: white">AppleStore</a>
            <form class="form-inline">
                <input type="text" name="country" 
                       id="product" class="form-control input-lg" 
                       autocomplete="off"  onkeyup="search(value)" placeholder="Tìm kiếm ..." />

                <button class="btn btn-success" type="submit">Tìm</button>


                <br/>
                <div id='result'></div>
            </form>
            <ul class="navbar-nav mr-auto ml-5 " >
                <li class="nav-item" >
                    <a class="nav-link" style="color: white; font-size: 18px;"
                       href="<%=pathWebcontent%>/MacBook">MacBook</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;"
                       href="<%=pathWebcontent%>/iPad">iPad</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;" 
                       href="<%=pathWebcontent%>/iPhone">iPhone</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;" 
                       href="<%=pathWebcontent%>/AppleWatch">AppleWatch</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white; font-size: 18px;"
                       href="<%=pathWebcontent%>/Phụ kiện">Phụ kiện</a>
                </li>

            </ul>
            <div style="margin-left: auto">
                <a href="<%=pathWebcontent%>/giỏ hàng" style="color: white" >
                    Giỏ hàng (
                    <c:choose>
                        <c:when test="${cart.size() == 0 || cart == null}">
                            <span id="size">0</span>
                        </c:when>
                        <c:otherwise>
                            <span id="size">${cart.size()}</span>
                        </c:otherwise>
                    </c:choose>

                    )</a>
            </div>
            <%

                if (session.getAttribute("username") != null) {
            %>


            <div class="dropdown ml-3">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <%
                        String email = (String) session.getAttribute("username");
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
                    <a class="dropdown-item" href="<%=pathWebcontent%>/info?id=<%=u.getId()%>">Thông tin tài khoản</a>
                    <a class="dropdown-item" href="<%=pathWebcontent%>/order?id=<%=u.getId()%>">Đơn hàng của tôi</a>
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
    <script>
       
            function search(id) {
                
                $.ajax("/WebApplication2/product/" + id).done(function(rs) {
                    $(".container").html(`<div class = mt-3 ><h5>Tìm thấy `+rs.length+` sản phẩm </h5></div>
                            <div class = ' row mt-2' > 
                         
                        </div>`);
                    for(var prod of rs){
                        $(".row").append(`<div class='col-md-4 mt-3' >
                                    <div class=card style=width: 18rem >
                                        <a href=`+prod.id +`>
                                            <img src=/WebApplication2/images/`+prod.images+` 
                                                 class=card-img-top alt=images width=50px ></a>
                                        <div class=text-block >
                                            <p>Giảm giá:`+numeral(prod.discount).format('0,0') 
                                     +`
                                                VND</p>
                                        </div>
                                        <div class=card-body >
                                            <h4 class=card-title >`+ prod.description +`</h4>
                                            <h5 class=card-title style= color: red; font-weight: bold>
                                               `+numeral(prod.price).format('0,0') 
                                       +`
                                                VND
                                            </h5>
                                            <a href=`+prod.id+` class= 'btn btn-primary' >View</a>
                                            <button 
                                                id=addtocart onclick=addtocart(`+prod.id+`)
                                                class='btn btn-outline-primary' >Add to cart</button>
                                        </div>
                                    </div>
                                </div>`);
                    }
                });
            }

    </script>
</nav>
 <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
