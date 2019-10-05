<%-- 
    Document   : prodImages
    Created on : Sep 29, 2019, 9:51:57 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý màu sản phẩm</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a> / 
                <a href="<%=pathWebcontent%>/admin/product"> Sản phẩm</a> / 
                <a href="<%=pathWebcontent%>/admin/product/images/${products.id}">Màu sản phẩm</a>
                <hr>
            </div>
                <div style="text-align: center; color: red">
                    <c:if test="${rsAdd > 0}">
                        Thêm thành công
                    </c:if>
                </div>
                <div style="text-align: center; color: red">
                    <c:if test="${rsSet > 0}">
                        Cập nhật thành công
                    </c:if>
                </div>
                <div style="text-align: center; color: red">
                    <c:if test="${rsDel > 0}">
                        Xóa thành công
                    </c:if>
                </div>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th scope="col" colspan="4">Tên sản phẩm: ${products.description}</th>
                        <th scope="col" colspan="2">
                            <a href="<%=pathWebcontent%>/admin/product/images/add-images/${products.id}" class="btn btn-success">Thêm ảnh/màu</a>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID sản phẩm</th>
                        <th scope="col">Màu</th>
                        <th scope="col">Ảnh</th>
                        <th scope="col" colspan="2">Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="i" value="${1}"></c:set>
                    <c:forEach var="prod" items="${listProdImages}">
                        <tr>
                        <th scope="row">${i}</th>
                        <td>${prod.prod_id}</td>
                        <td>${prod.name}</td>
                        <td>
                            <img width="100px" src="<%=pathWebcontent %>/images/${prod.image}" />
                        </td>
                        <td><a href="<%=pathWebcontent %>/admin/product/images/update-images/${prod.prod_id}/${prod.id}" class="btn btn-primary">Sửa</a></td>
                        <td>
                            <a href="<%=pathWebcontent %>/admin/product/images/del-images/${prod.prod_id}/${prod.id}" 
                               onclick="return confirm('Are you sure to delete?')"
                               class="btn btn-danger">Xóa</a>
                        </td> 
                    </tr>
                    <c:set var="i" value="${i+1}" />
                    </c:forEach>
                    
                    
                </tbody>
            </table>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
