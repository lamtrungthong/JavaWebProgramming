<%-- 
    Document   : advertise
    Created on : Oct 1, 2019, 5:08:16 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quảng cáo</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2"> 
                <a href="<%=pathWebcontent%>/admin/home">Home</a>/  
                <a href="<%=pathWebcontent%>/admin/product"> Quảng cáo</a>
                <hr>
            </div>
                <div style="text-align: center; color: red">
                    <c:if test="${rsDel > 0} ">
                        Xóa thành công
                    </c:if>
                </div>
                <div style="text-align: center; color: red">
                    <c:if test="${rsAdd > 0} ">
                        Thêm thành công
                    </c:if>
                </div>
            <div class="row mt-2">
                <c:forEach var="ad" items="${listAd}"> 
                    <div class="col-4 col-md-4 mb-2 mt-2 ml-2">
                        <div class="card" style="width:400px">
                            <img class="card-img-top" src="<%=pathWebcontent%>/images/${ad.images}" alt="Card image" style="width:100%">
                            <div class="card-body">
                                <h4 class="card-title">${ad.prod.description}</h4>
                                <a href="<%=pathWebcontent %>/admin/advertise/del-advertise/${ad.id}"
                                   class="btn btn-danger">Xóa</a>
                                <c:if test="${ad.state == 1}">
                                    <a href="<%=pathWebcontent %>/admin/advertise/state-advertise/${ad.id}"
                                   class="btn btn-success">Hiện</a>
                                </c:if>
                                   <c:if test="${ad.state != 1}">
                                    <a href="<%=pathWebcontent %>/admin/advertise/state-advertise/${ad.id}"
                                   class="btn btn-danger">Ẩn</a>
                                </c:if>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
            <div>
                <button type="button" class="btn btn-primary form-control" data-toggle="modal" data-target="#myModal">
                    Thêm quảng cáo
                </button>

                <!-- The Modal -->
                <div class="modal" id="myModal">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Thêm quảng cáo</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                            </div>

                            <!-- Modal body -->
                            <form class="modal-body" onsubmit="return isEmpty()" 
                                  method="post" action="advertise/add-advertise" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label></label>
                                    <select class="form-control" id="product" name="product">
                                        <option value="" >Sản phẩm</option>
                                        <c:forEach var="prod" items="${listProd}">
                                            <option value="${prod.id}" >${prod.description}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <label>Poster</label>
                                    <input type="file" id="file" name="file" class="form-control"  />
                                </div>
                                <div class="modal-footer">
                                <button type="submit" class="btn btn-success" >Thêm</button>
                            </div>
                            </form>

                            <!-- Modal footer -->
                            

                        </div>
                    </div>
                </div>
            </div>

            <%@include file="footer.jsp" %>
        </div>
    </body>
    <script>
        function isEmpty(){
            var prod = $("#product").val();
            var file = $("#file").val();
            if(prod == ""){
                alert('Bạn cần chọn sản phẩm để quảng cáo');
                return false;
            }else if(file == ""){
                alert('Bạn cần chọn ảnh');
                return false;
            }else{
                return true;
            }
        }
    </script>
</html>
