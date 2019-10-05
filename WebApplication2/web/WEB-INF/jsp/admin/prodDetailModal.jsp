<%-- 
    Document   : prodDetailModal
    Created on : Sep 14, 2019, 11:59:14 AM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="${prod.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">
                    Thông số cơ bản <br/>
                    ${prod.description}
                </h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body container-fluid">
                <table class="table-striped" style="width: 100%; text-align: left"> 
                    <tr>
                        <td>Màn hình: </td>
                        <td>${prod.display} inchs</td>
                    </tr>
                    <tr>
                        <td>Camera: </td>
                        <td>${prod.fCamera} MP/${prod.bCamera} MP</td>
                    </tr>
                    <tr>
                        <td>RAM: </td>
                        <td>${prod.ram} GB</td>
                    </tr>
                    <tr>
                        <td>ROM: </td>
                        <td>${prod.rom} GB</td>
                    </tr>
                    <tr>
                        <td>Hệ điều hành: </td>
                        <td>${prod.OS}</td>
                    </tr>
                    <tr>
                        <td>Pin: </td>
                        <td>${prod.battery} mah</td>
                    </tr>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>