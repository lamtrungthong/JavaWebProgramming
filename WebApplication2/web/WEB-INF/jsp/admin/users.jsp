<%-- 
    Document   : users
    Created on : Sep 27, 2019, 9:17:17 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý người dùng</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a>/ 
                <a href="<%=pathWebcontent%>/admin/user"> Thành viên</a>
                <hr>
            </div>
                <div style="text-align: center; color: red">
                    <c:if test="${rs > 0}">
                        Xóa thành công
                    </c:if>
                </div>
            <table class="table table-bordered container-fluid">
                <thead>
                    <tr>
                        <th scope="col" colspan="3">Danh sách thành viên
                            <c:if test="${curr == null}">
                                (page 1)
                            </c:if>
                            <c:if test="${curr != null}">
                                (page ${curr})
                            </c:if>
                        </th>
                        <th scope="col" colspan="2" >
                            Search <input type="text" 
                       autocomplete="off"  onkeyup="search(value)" placeholder="Tìm kiếm ..." />
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col">Xóa</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <c:set var="i" value="${1}"/>
                    <c:forEach var="user" items="${listUser}">
                        <tr>
                            <th scope="row">${i}</th>
                            <td>${user.id}</td>
                            <td>${user.name}</td>
                            <td>
                                <c:if test="${user.actived == 1}">
                                    <a href="<%=pathWebcontent%>/admin/user/actived/${user.id}" id="hien" class="btn btn-success">Hiển thị</a>
                                </c:if>
                                <c:if test="${user.actived != 1}">
                                    <a href="<%=pathWebcontent%>/admin/user/actived/${user.id}" id="an" class="btn btn-danger">Ẩn</a>
                                </c:if>
                            </td>
                            <td><a href="<%=pathWebcontent%>/admin/user/del/${user.id}" class="btn btn-danger">Xóa</a></td>
                            <c:set var="i" value="${i+1}"></c:set>
                            </tr>
                    </c:forEach>
                </tbody>
            </table>
                    <div class="mt-2" id="paging" >
                <nav aria-label="Page navigation example" style="margin-right:   auto">
                    <ul class="pagination" >
                        <c:if test="${curr == 1}">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${curr > 1 || curr == null}">
                            <li class="page-item">
                                <a class="page-link" href="<%=pathWebcontent%>/admin/user/?page=${curr-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${totalPage}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="<%=pathWebcontent%>/admin/user/?page=${i}">${i}</a></li>
                            </c:forEach>
                            <c:if test="${curr == totalPage}">
                            <li class="page-item">
                                <a class="page-link" href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${curr < totalPage || curr == null}">
                            <li class="page-item">
                                <a class="page-link" href="<%=pathWebcontent%>/admin/user/?page=${curr+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if> 
                    </ul>
                </nav>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function search(name){
            $("#tbody").html("");
            $("#paging").html("");
            $.ajax("/WebApplication2/admin/user/"+name).done(function (rs){
                var i = 1;
                for(var user of rs){
                    var actived;
                    if(user.actived == 1){
                        actived = `<a href='/admin/user/actived/'`+user.id+` id=hien 
                            class='btn btn-success'>Hiển thị</a>`;
                    }else{
                      actived=  `<a href='/admin/user/actived/'`+user.id+`
                    id=an class='btn btn-danger'>Ẩn</a>`;
                    }
                $("#tbody").append(`<tr>
                            <th scope='row'>`+i+`</th>
                            <td>`+user.id+`</td>
                            <td>`+user.name+`</td>
                            <td>`+
                               actived   
                           +` </td>
                            <td><a href='/admin/user/del/'`+user.id+` class='btn btn-danger'>Xóa</a></td>
                            </tr>`);
                    i++;
            }
            });
        }
    </script>
</html>
