<%-- 
    Document   : prodDetailModal
    Created on : Sep 14, 2019, 11:59:14 AM
    Author     : thonglt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Thông số cơ bản</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body container-fluid">
          <table class="table-striped" style="width: 100%; text-align: left"> 
              <tr>
                  <td>Màn hình: </td>
                  <td>${prod_detail.display} inchs</td>
              </tr>
              <tr>
                  <td>Camera: </td>
                  <td>${prod_detail.fCamera} MP/${prod_detail.bCamera} MP</td>
              </tr>
              <tr>
                  <td>RAM: </td>
                  <td>${prod_detail.ram} GB</td>
              </tr>
              <tr>
                  <td>ROM: </td>
                  <td>${prod_detail.rom} GB</td>
              </tr>
              <tr>
                  <td>Hệ điều hành: </td>
                  <td>${prod_detail.OS}</td>
              </tr>
              <tr>
                  <td>Pin: </td>
                  <td>${prod_detail.battery} mah</td>
              </tr>
          </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>