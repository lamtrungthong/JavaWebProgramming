<%-- 
    Document   : addProd
    Created on : Sep 28, 2019, 9:22:20 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm sản phẩm</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a> / 
                <a href="<%=pathWebcontent%>/admin/product"> Sản phẩm</a> / 
                <a href="<%=pathWebcontent%>/admin/product/add-product">Thêm sản phẩm</a>
                <hr>
            </div>
            
            <form method="post" onsubmit="return isEmpty();" action="addprod" enctype="multipart/form-data">
                <h5 style="text-align: center; ">Thông tin sản phẩm</h5>
                <div class="row">

                    <div class="col-md-4  col-4">
                        <label>Loại sản phẩm</label>
                        <select class="form-control" id="kind" name="kind" onclick="checkDetail()">
                            <option value="">---Loại sản phẩm---</option>
                            <option value="1">MacBook</option>
                            <option value="2">iPad</option>
                            <option value="3">iPhone</option>
                            <option value="4">Apple Watch</option>
                            <option value="5">Phụ kiện</option>
                        </select>
                    </div>
                    <div class="col-md-4  col-4">
                        <label>Giá nhập</label>
                        <input type="number" id="priceStore" name="priceStore" class="form-control" />
                    </div>
                    <div class="col-md-4  col-4">
                        <label>Giảm giá</label>
                        <input type="number" id="discount" name="discount"  class="form-control" />
                    </div>
                    <div class="col-md-4  col-4">
                        <label>Tên sản phẩm</label>
                        <input type="text" name="name" id="name" placeholder="Tên sản phẩm" class="form-control" />
                    </div>
                    <div class="col-md-4  col-4">
                        <label>Giá bán</label>
                        <input type="number" id="price" name="price" class="form-control" />
                    </div>
                    <div class="col-md-4  col-4">
                        <label>Ảnh nền</label>
                        <input type="file" id="file" name="file" class="form-control-file" id="exampleFormControlFile1">
                    </div>

                    <div class="col-md-4  col-4">
                        <label>Mô tả sản phẩm</label>
                        <input type="text" id="description" name="description" placeholder="Mô tả sản phẩm" class="form-control" />
                    </div>
                    <div class="col-md-4  col-4">
                        <label>Số lương</label>
                        <input type="number" id="quantityStore" name="quantityStore" class="form-control" />
                    </div> 

                </div>
                <hr/>
                <div id="deltail" >
                    <h5 style="text-align: center; ">Thêm mô tả chi tiết sản phẩm</h5>
                    <div class="row">
                        <div class="col-md-4  col-4">
                            <label>Màn hình</label>
                            <input type="text" id="display" name="display" class="form-control" />
                        </div>
                        <div class="col-md-4  col-4">
                            <label>Hệ điều hành</label>
                            <input type="text" id="os" name="os" class="form-control" />
                        </div>
                        <div class="col-md-4  col-4">
                            <label>RAM</label>
                            <input type="number" id="ram" name="ram" class="form-control" />
                        </div>
                        <div class="col-md-4  col-4">
                            <label>ROM</label>
                            <input type="number" id="rom" name="rom" class="form-control" />
                        </div>
                        <div class="col-md-4  col-4">
                            <label>Camera trước</label>
                            <input type="number" id="fCamera" name="fCamera" class="form-control" />
                        </div>
                        <div class="col-md-4  col-4">
                            <label>Camera sau</label>
                            <input type="number" id="bCamera" name="bCamera" class="form-control" />
                        </div>
                        <div class="col-md-4  col-4">
                            <label>Pin</label>
                            <input type="number" id="battery" name="battery" class="form-control" />
                        </div>
                    </div>
                </div>
                <div class="mt-3" style="text-align: center">
                    <button type="submit" class="form-control btn btn-success"  >Thêm sản phẩm</button>
                </div>
            </form>
            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function checkDetail() {
            var kind = $("#kind").val();
            if (kind == 4 || kind == 5) {
                $("#deltail").hide();
            } else {
                $("#deltail").show();
            }
        }

        function isEmpty() {
            var kind = $("#kind").val();
            var name = $("#name").val();
            var description = $("#description").val();
            var priceStore = $("#priceStore").val();
            var price = $("#price").val();
            var quantityStore = $("#quantityStore").val();
            var discount = $("#discount").val();
            var file = $("#file").val();
            var display = $("#display").val();
            var os = $("#os").val();
            var ram = $("#ram").val();
            var rom = $("#rom").val();
            var fCamera = $("#fCamera").val();
            var bCamera = $("#bCamera").val();
            var battery = $("#battery").val();

            if (kind != "") {
                if (kind == 4 || kind == 5) {
                    if (name == "") {
                        alert("Tên sản phẩm không được để trống");
                        return false;
                    } else if (description == "") {
                        alert("Mô tả sản phẩm không được để trống");
                        return false;
                    } else if (priceStore == "") {
                        alert("Giá nhập sản phẩm không được để trống");
                        return false;
                    } else if (price == "") {
                        alert("Giá bán sản phẩm không được để trống");
                        return false;
                    } else if (quantityStore == "") {
                        alert("Số lượng sản phẩm không được để trống");
                        return false;
                    } else if (discount == "") {
                        alert("Giảm giá sản phẩm không được để trống");
                        return false;
                    } else if (file == "") {
                        alert("Ảnh sản phẩm không được để trống");
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    if (name == "") {
                        alert("Tên sản phẩm không được để trống");
                        return false;
                    } else if (description == "") {
                        alert("Mô tả sản phẩm không được để trống");
                        return false;
                    } else if (priceStore == "") {
                        alert("Giá nhập sản phẩm không được để trống");
                        return false;
                    } else if (price == "") {
                        alert("Giá bán sản phẩm không được để trống");
                        return false;
                    } else if (quantityStore == "") {
                        alert("Số lượng sản phẩm không được để trống");
                        return false;
                    } else if (discount == "") {
                        alert("Giảm giá sản phẩm không được để trống");
                        return false;
                    } else if (file == "") {
                        alert("Ảnh sản phẩm không được để trống");
                        return false;
                    } else if (display == "") {
                        alert("Màn hình sản phẩm không được để trống");
                        return false;
                    } else if (os == "") {
                        alert("HDH sản phẩm không được để trống");
                        return false;
                    } else if (ram == "") {
                        alert("RAM sản phẩm không được để trống");
                        return false;
                    } else if (rom == "") {
                        alert("ROM sản phẩm không được để trống");
                        return false;
                    } else if (fCamera == "") {
                        alert("Camera trước sản phẩm không được để trống");
                        return false;
                    } else if (bCamera == "") {
                        alert("Camera sau sản phẩm không được để trống");
                        return false;
                    } else if (battery == "") {
                        alert("Pin sản phẩm không được để trống");
                        return false;
                    }
                    else {
                        return true;
                    }
                }
            } else {
                if (name == "") {
                    alert("Tên sản phẩm không được để trống");
                    return false;
                } else if (description == "") {
                    alert("Mô tả sản phẩm không được để trống");
                    return false;
                } else if (priceStore == "") {
                    alert("Giá nhập sản phẩm không được để trống");
                    return false;
                } else if (price == "") {
                    alert("Giá bán sản phẩm không được để trống");
                    return false;
                } else if (quantityStore == "") {
                    alert("Số lượng sản phẩm không được để trống");
                    return false;
                } else if (discount == "") {
                    alert("Giảm giá sản phẩm không được để trống");
                    return false;
                } else if (file == "") {
                    alert("Ảnh sản phẩm không được để trống");
                    return false;
                } else if (display == "") {
                    alert("Màn hình sản phẩm không được để trống");
                    return false;
                } else if (os == "") {
                    alert("HDH sản phẩm không được để trống");
                    return false;
                } else if (ram == "") {
                    alert("RAM sản phẩm không được để trống");
                    return false;
                } else if (rom == "") {
                    alert("ROM sản phẩm không được để trống");
                    return false;
                } else if (fCamera == "") {
                    alert("Camera trước sản phẩm không được để trống");
                    return false;
                } else if (bCamera == "") {
                    alert("Camera sau sản phẩm không được để trống");
                    return false;
                } else if (battery == "") {
                    alert("Pin sản phẩm không được để trống");
                    return false;
                }
                else {
                    return true;
                }
            }

        }
    </script>
</html>
