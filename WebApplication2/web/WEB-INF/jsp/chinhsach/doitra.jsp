<%-- 
    Document   : baohanh
    Created on : Aug 30, 2019, 9:44:09 PM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Chính sách đổi trả</title>
    </head>
    <body>
        <%@include file="./../header.jsp" %>
        <div class="container pt-4">
            <h1>Chính sách đổi trả tại Apple Store </h1>
            <div class="container-fluid">
                <table class="table table-bordered">
                    <thead style="text-align: center">
                    <th>
                        30 NGÀY ĐẦU
                    </th>
                    <th>
                        NGÀY THỨ 31-360
                    </th>
                    <tbody>
                        <tr>
                            <td colspan="2" style="text-align: center; background-color: gainsboro">
                                <b>Sản phẩm lỗi do nhà sản xuất</b>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <p>Miễn phí đổi sản phẩm khác có giá trị bằng hoặc 
                                    lớn hơn giá trị sản phẩm lỗi, khách hàng bù tiền chênh lệch
                                    nếu có.</p>

                                <b>Hoặc</b>
                                <p>Khách hàng trả sản phẩm và Apple Store hoàn lại 
                                    tiền với mức giá bằng 80% giá sản phẩm trên hoá đơn.</p>
                            </td>
                            <td>
                                <p>Khách hàng có nhu cầu đổi hoặc trả sản phẩm: 
                                    Apple Store hoàn lại tiền với mức phí thêm
                                    5% mỗi tháng so với mức hoàn tiền 30 ngày đầu</p>

                                <b> Cụ thể:</b>
                                <p>Từ ngày 31-60: hoàn lại 75% giá trị sản phẩm trên hóa đơn</p>
                                <p>Từ ngày 61-90: hoàn lại 70% giá trị sản phẩm trên hóa đơn</p>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" style="text-align: center; background-color: gainsboro">
                                <b>Sản phẩm lỗi do người sử dụng</b>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <p style="color: red"><b>Không áp dụng đổi trả</b> với sản phẩm bị va chạm, 
                                    cấn móp, vào nước…không đủ điều kiện bảo hành
                                    theo chính sách của hãng, Apple Store hỗ trợ chuyển 
                                    bảo hành và khách hàng chịu phí sữa chữa.</p>
                            </td>
                        </tr>
                    </tbody>
                    </thead>
                </table>
            </div>

            <%@include file="./../footer.jsp" %>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
