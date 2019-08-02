<%-- 
    Document   : update
    Created on : Aug 2, 2019, 8:51:34 PM
    Author     : lamtrungthong
--%>

<%@page import="DB.StudentManager"%>
<%@page import="DB.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
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
        </nav>
        <br>
        <%
            Student st = new Student();
            StudentManager stm = new StudentManager();
            int id = Integer.parseInt(request.getParameter("id"));
            st = stm.getStudentByID(id);
            
            
            %>
        <div class="container">
            <form action="UpdateStudentServlet" method="post">
                <div class="form-group">
                    <label>Ho Ten</label>
                    <input type="number" name="id" value="<%= id%>"  class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Ho Ten</label>
                    <input type="text" name="hoten" value="<%= st.getHoTen() %>" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Khoa</label>
                    <input type="text" name="khoa" value="<%= st.getKhoa() %>" class="form-control"/>
                </div>
                <div class="form-group">
                    <label>Lop</label>
                    <input type="text" name="lop" value="<%= st.getLop() %>" class="form-control"/>
                </div>
                <div class="form-group">
                    <input type="submit" value="Sua" class="btn btn-success" />
                </div>
            </form>
        </div>
    </body>
</html>
