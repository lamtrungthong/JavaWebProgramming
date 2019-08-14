<%-- 
    Document   : index
    Created on : Aug 13, 2019, 9:22:20 PM
    Author     : lds2h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-success">
            <a class="navbar-brand" href="#">Tin nhanh</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
        <div class="container">
            <form style="margin-top: 70px">
                <div class="form-group">
                    <lable>Search</lable>
                    <input type="text" name="search" class="form-control" />
                </div>
                <input type="submit" value="Search" class="btn btn-primary" />
            </form>

            <c:forEach var="news" items="${news}">
                <div class="content" style="margin-top: 50px">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title"> ${news.title}</h5>
                            <p class="card-text" > ${news.summary}</p>
                            <p>thong</p>
                        </div>

                    </div>
                </div>
            </c:forEach>

            <nav aria-label="Page navigation example" style="margin-top: 50px">
                <ul class="pagination">
                    <c:if test="${curr == 1}">
                        <li class="page-item"><a class="page-link" href="#"><<</a></li>
                        </c:if>
                        <c:if test="${curr > 1}">
                        <li class="page-item"><a class="page-link" href="?page=${curr-1}"><<</a></li>
                        </c:if>

                    <c:forEach var="i" begin="1" end="${total}">
                        <li class="page-item"><a class="page-link" href="?page=${i}">${i}</a></li>
                        </c:forEach>
                        <c:if test="${curr == total}">
                        <li class="page-item"><a class="page-link" href="#">>></a></li>
                        </c:if>

                    <c:if test="${curr < total}">
                        <li class="page-item"><a class="page-link" href="?page=${curr+1}">>></a></li>
                        </c:if>
                </ul>
            </nav>
        </div>
    </body>
</html>
