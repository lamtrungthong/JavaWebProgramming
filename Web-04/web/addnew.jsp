<%-- 
    Document   : addnew
    Created on : Aug 23, 2019, 3:04:26 PM
    Author     : lds2h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container-fluid mt-5">
            <form action="AddNewBookServlet" method="POST">
                <div class="form-group">
                    <lable for="title">Tên sách</lable>
                    <input type="text" name="title" class="form-control" placeholder="Chí Phèo" />
                </div>
                <div class="form-group">
                    <lable for="author">Tác giả</lable>
                <input type="text" name="author" class="form-control" placeholder="Nam Cao" />
                </div>
                <div class="form-group">
                    <lable for="price">Giá</lable>
                    <input type="text" name="price" class="form-control" placeholder="20.2" />
                </div>
                <div class="form-group">
                    <lable for="title">Số lượng</lable>
                    <input type="number" name="quantity" class="form-control" placeholder="100" />
                </div>
                <input type="submit" value="Thêm" class="btn btn-success" />
            </form>
            
        </div>
    </body>
</html>
