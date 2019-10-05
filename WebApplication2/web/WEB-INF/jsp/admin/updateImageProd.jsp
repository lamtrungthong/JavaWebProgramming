<%-- 
    Document   : updateImageProd
    Created on : Sep 29, 2019, 11:22:33 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật hình ảnh</title>
    </head>
    <body>
       <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a> / 
                <a href="<%=pathWebcontent%>/admin/product"> Sản phẩm</a> / 
                <a href="<%=pathWebcontent%>/admin/product/images/${idProd}">Màu sản phẩm</a> / 
                <a href="<%=pathWebcontent%>/admin/product/images/update-images/${idProd}/${idImg}">Cập nhật màu sản phẩm</a>
                <hr>
            </div>
            <form  method="post" onsubmit="return isEmpty();" 
                   action="updateimages" enctype="multipart/form-data"
                style="margin: auto; width: 50%">
                <div class="form-group">
                    <label for="exampleFormControlFile1">ID sản phẩm</label>
                    <input type="number" value="${idProd}" name="idProd" readonly="" class="form-control" id="color">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">ID hình ảnh</label>
                    <input type="number" value="${idImg}" name="idImg" readonly="" class="form-control" id="color">
                </div>
                <div class="form-group">
                    <label for="exampleFormControlFile1">Màu</label>
                    <input type="text" name="color" value="${prod_images.name}" class="form-control" id="color">
                </div>
                <div class="form-group">

                    <label for="exampleFormControlFile1">File ảnh</label>
                    <input type="file" class="form-control-file" id="file" name="file">
                </div>
                <button type="submit" class="btn btn-success">Cập nhật</button>
            </form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function isEmpty() {
            var color = $("#color").val();
            var file = $("#file").val();
            if (color == "") {
                alert('Tên màu không được để trống');
                return false;
            } else if (file == "") {
                alert('File ảnh không được để trống');
                return false;
            } else {
                return true;
            }
        }
    </script>
</html>
