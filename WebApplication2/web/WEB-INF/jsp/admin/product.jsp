<%-- 
    Document   : product
    Created on : Sep 28, 2019, 7:43:23 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sản phẩm</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div class="container">
            <div class="mt-2">
                <a href="<%=pathWebcontent%>/admin/home">Home</a>/ 
                <a href="<%=pathWebcontent%>/admin/product"> Sản phẩm</a>
                <hr>
            </div>
                <div style="text-align: center; color: red">
                <c:if test="${rsAddProd > 0 || addProdDetai > 0}">
                    Thêm sản phẩm thành công
                </c:if>
            </div>
                <div style="text-align: center; color: red">
                <c:if test="${rsSetProd > 0 || addSetDetai > 0}">
                    Cập nhật sản phẩm thành công
                </c:if>
            </div>
            <div style="text-align: center; color: red">
                <c:if test="${rsDel >0 }">
                    Xóa thành công
                </c:if>
            </div>
                <div style="text-align: center; color: red">
                <c:if test="${rsSetState >0 }">
                    Cập nhật trạng thái thành công
                </c:if>
            </div>
                   </div>
                <div style="text-align: center; color: red">
                <c:if test="${rsSetSell >0 }">
                    Cập nhật bán chạy thành công
                </c:if>
            </div>
                <div style="text-align: center; color: red">
                <c:if test="${rsAdd >0 }">
                    Nhập thêm sản phẩm thành công
                </c:if>
            </div>
            <table class="table table-bordered container-fluid">
                <thead>
                    <tr>
                        <th scope="col" colspan="3">Danh sách sản phẩm 
                            <c:if test="${curr == null}">
                                (page 1)
                            </c:if>
                            <c:if test="${curr != null}">
                                (page ${curr})
                            </c:if>
                        </th>
                        <th scope="col" id="sum" colspan="2" >
                            Tổng: ${sumProd} sản phẩm
                        </th>
                        <th scope="col" colspan="4" >
                            Search <input type="text" onkeyup="search(value)"  placeholder="Tìm kiếm ..."   />
                        </th>
                        <th scope="col" colspan="6" >
                            <a href="<%=pathWebcontent%>/admin/product/add-product" 
                               class="btn btn-success">Thêm sản phẩm</a>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Ảnh nền</th>
                        <th scope="col">Nhâp</th>
                        <th scope="col">Bán</th>
                        <th scope="col">Số lượng</th>
                        <th scope="col">Giảm giá</th>
                        <th scope="col">Chi tiết</th>
                        <th scope="col">Ảnh</th>
                        <th scope="col">Trạng thái</th>
                        <th scope="col" colspan="4">Thao tác</th>
                    </tr>
                </thead>
                <tbody id="tbody">
                    <c:set var="i" value="${1}" />
                    <c:forEach var="prod" items="${listProd}">
                        <tr>
                            <th scope="row">${i}</th>
                            <td>${prod.id}</td>
                            <td>${prod.description}</td>
                            <td><img width="100px" src="<%=pathWebcontent %>/images/${prod.images}" /></td>
                            <td>
                                <fmt:formatNumber type="number">
                                    ${prod.priceStore} 
                                </fmt:formatNumber>
                                VND
                            </td>
                            <td><fmt:formatNumber type="number">
                                    ${prod.price}
                                </fmt:formatNumber>
                                VND
                            </td>
                            <td>${prod.quantityStore} Sản phẩm</td>
                            <td>
                                <fmt:formatNumber type="number">
                                    ${prod.discount}
                                </fmt:formatNumber>
                                VND
                            </td>
                            <td>
                                <c:if test="${prod.kind_id != 4 && prod.kind_id != 5}">
                                    <a data-toggle="modal" href="#a${prod.id}">
                                    Chi tiết
                                </a>
                                </c:if>
                            </td>
                            <td><c:if test="${prod.kind_id != 4 && prod.kind_id != 5}">
                                    <a href="<%=pathWebcontent%>/admin/product/images/${prod.id}"> Ảnh</a>
                                </c:if>
                                </td>
                                <td>
                                    <c:if test="${prod.actived == 1}">
                                        <a class="btn btn-primary"
                                            href="<%=pathWebcontent%>/admin/product/state/${prod.id}">
                                            Đang bán
                                        </a>
                                    </c:if>
                                    <c:if test="${prod.actived != 1}">
                                        <a class="btn btn-danger"
                                            href="<%=pathWebcontent%>/admin/product/state/${prod.id}">
                                            Ngưng bán
                                        </a>
                                    </c:if>
                                </td>
                                <td>
                                    <c:if test="${prod.sell == 1}">
                                        <a class="btn btn-danger"
                                            href="<%=pathWebcontent%>/admin/product/sell/${prod.id}">
                                            Bán chạy
                                        </a>
                                    </c:if>
                                    <c:if test="${prod.sell != 1}">
                                        <a class="btn btn-primary"
                                            href="<%=pathWebcontent%>/admin/product/sell/${prod.id}">
                                            Bình thường
                                        </a>
                                    </c:if>
                                </td>
                            <td><a href="<%=pathWebcontent%>/admin/product/update/${prod.id}" 
                                   class="btn btn-primary">Sửa</a></td>
                            <td><a href="<%=pathWebcontent%>/admin/product/del/${prod.id}"
                                   onclick="return confirm('Are you sure to delete?')"
                                   class="btn btn-danger">Xóa</a></td>
                                   <td><a class="btn btn-success" data-toggle="modal" href="#add${prod.id}">
                                    Nhập
                                </a></td>
                        </tr>

                                                <!-- Button to Open the Modal -->

                       
                        <c:set var="i" value="${i+1}" />
                    </c:forEach>
                </tbody>
            </table>
                    <c:forEach var="prod" items="${listProd}">
                         <!-- The Modal -->
                        <div class="modal" id="add${prod.id}">
                          <div class="modal-dialog">
                            <div class="modal-content">

                              <!-- Modal Header -->
                              <div class="modal-header">
                                <h4 class="modal-title">Nhập thêm sản phẩm</h4>
                                <button type="button" class="close" data-dismiss="modal">&times;</button>
                              </div>

                              <!-- Modal body -->
                              <form class="modal-body " onsubmit="return isEmpty(${prod.id})" action="product/add-quantity/${prod.id}" method="post">
                                  <div class="form-group">
                                      <label>ID sản phẩm</label>
                                      <input type="number" class="form-control"
                                             value="${prod.id}"  readonly="" />
                                  </div>
                                  <div class="form-group">
                                      <label>Sản phẩm</label>
                                      <input type="text" class="form-control"
                                             value="${prod.description}" readonly="" />
                                  </div>
                                  <div class="form-group">
                                      <label>Số lượng</label>
                                      <input type="number" class="form-control"
                                             id="q${prod.id}"  name ="q${prod.id}" />
                                  </div>
                                  <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"
                                        >Thêm</button>
                              </div>
                              </form>
                              <!-- Modal footer -->
                              

                            </div>
                          </div>
                        </div>
                    </c:forEach>
                    

            <c:forEach var="prod" items="${listDetail}">
                <div class="modal fade" id="a${prod.prodId}">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">
                                    Thông số sản phẩm <br/>

                                </h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <div class="row">
                                    <div class="col-6">
                                        Màn hình: 
                                    </div>
                                    <div class="col-6">
                                        ${prod.display} inchs
                                    </div>
                                    <div class="col-6">
                                        Camera:
                                    </div>
                                    <div class="col-6">
                                        ${prod.fCamera} MP/${prod.bCamera} MP
                                    </div>
                                    <div class="col-6">
                                        RAM:
                                    </div>
                                    <div class="col-6">
                                        ${prod.ram} GB
                                    </div>
                                    <div class="col-6">
                                        ROM:
                                    </div>
                                    <div class="col-6">
                                        ${prod.rom} GB
                                    </div>
                                    <div class="col-6">
                                        Hệ điều hành:
                                    </div>
                                    <div class="col-6">
                                        ${prod.OS}
                                    </div>
                                    <div class="col-6">
                                        Pin:
                                    </div>
                                    <div class="col-6">
                                        ${prod.battery} mah
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            </div>

                        </div>
                    </div>
                </div>
            </c:forEach>


            <div class="mt-2" >
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
                                <a class="page-link" href="<%=pathWebcontent%>/admin/product/?page=${curr-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${totalPage}">
                            <li class="page-item">
                                <a class="page-link"
                                   href="<%=pathWebcontent%>/admin/product/?page=${i}">${i}</a></li>
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
                                <a class="page-link" href="<%=pathWebcontent%>/admin/product/?page=${curr+1}" aria-label="Next">
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
        function search(id) {
            $.ajax("/WebApplication2/product/" + id).done(function(rs) {
                $("#tbody").html("");
                $(".mt-2").html("");
                $("#sum").html("Tìm thấy " +rs.length+" sản phẩm")
                var i = 1;
                        for (var prod of rs){
                            var chitiet;
                            if(prod.kind_id != 4 && prod.kind_id != 5){
                                   chitiet = `  <a data-toggle= modal href= #a`+prod.id+`>
                                    Chi tiết
                                </a>`;
                    }
                    var anh;
                    if(prod.kind_id != 4 && prod.kind_id != 5){
                        anh=` <a href=<%=pathWebcontent%>/admin/product/images/`+prod.id+`> Ảnh</a> `;
                        }
                        var state;
                       if(prod.actived == 1){
                              state = `          <a class='btn btn-primary'
                              href=<%= pathWebcontent%>/admin/product/state/`+prod.id+`>
                                            Đang bán
                                        </a>`;
                            }else{
                              state =   `        <a class='btn btn-danger'
                              href=<%=pathWebcontent%>/admin/product/state/`+prod.id+`>
                                            Ngưng bán
                                        </a> `;
                            }
                $("#tbody").append(`  <tr>
                            <th scope=row>`+i+`</th>
                            <td>`+prod.id+`</td>
                            <td>`+prod.description+`</td>
                            <td><img width= 100px src=<%=pathWebcontent%>/images/`+prod.images+` /></td>
                            <td>`+ numeral(prod.priceStore).format('0,0')+`
                                
                                VND
                            </td>
                            <td>`+numeral(prod.price).format('0,0')
                                     +`
                                
                                VND
                            </td>
                            <td> `+numeral(prod.quantityStore).format('0,0')+` Sản phẩm</td>
                            <td>`+
                                numeral(prod.discount).format('0,0')
                                     +`
                               
                                VND
                            </td>
                            <td>
                                `+ chitiet +`
                            </td>
                            <td>`+ anh +`
                                </td>
                                <td>
                                    `+ state +`
                                </td>
                                <td><a href=<%=pathWebcontent%>/admin/product/update/`+prod.id +` class= 'btn btn-primary'>Sửa</a></td>
                                <td><a href=<%=pathWebcontent%>/admin/product/del/`+prod.id+`
                                   onclick="return confirm('Are you sure to delete?')"
                                   class='btn btn-danger'>Xóa</a></td>
                                           <td><a class='btn btn-success' data-toggle= modal href= #add`+prod.id+`>
                                    Nhập
                                </a></td>
                        </tr>`);
                        i++;
                }
            });
        }
        
        function isEmpty(p){
        var quantity = $("#q"+p).val();
        if(quantity == ""){
            alert("Số lượng không được để trống");
            return false;
        }else{
        return true;
        }
    }
    </script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/numeral.js/2.0.6/numeral.min.js"></script>
</html>
