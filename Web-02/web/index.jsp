<%-- 
    Document   : index.jsp
    Created on : Aug 2, 2019, 7:59:15 PM
    Author     : lamtrungthong
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="DB.Student"%>
<%@page import="DB.StudentManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <table class="table">
                <tr class="thead-dark">
                    <th>ID</th>
                    <th>Ho Ten</th>
                    <th>Khoa</th>
                    <th>Lop</th>
                    <th>Chuc Nang</th>
                </tr>
                <tr>
                    <%
                        StudentManager stm = new StudentManager();
                        List<Student> list = new ArrayList<Student>();

                        list = stm.getStudent();

                        for (Student student : list) {

                    %>
                    <td><%= student.getId() %></td>
                    <td><%= student.getHoTen() %></td>
                    <td><%= student.getKhoa() %></td>
                    <td><%= student.getLop() %></td>
                    
                    <td>
                        <a href="update.jsp?id=<%= student.getId() %>" class="btn btn-primary">Sua</a>
                        <a href="DeleteStudentServlet?id=<%= student.getId() %>" class="btn btn-danger">Xoa</a>
                    </td>
                    </tr>
                    <%                                }
                    %>

                
            </table>
            <a href="add.jsp" class="btn btn-success">Them moi</a>
        </div>
    </body>
</html>
