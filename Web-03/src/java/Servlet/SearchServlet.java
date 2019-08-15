/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Model.NewManager;
import Model.News;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author lds2h
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            NewManager model = new NewManager();
            List<News> news = new ArrayList<>();
            
            String titleSearch = request.getParameter("search");
            
            int totalPage = 0;
            
            int recordPerPage = 2;
            int count;
            int currPage = 1;
            
            if(titleSearch == null){
                news = model.getNews(recordPerPage, recordPerPage *(currPage-1));
                 count = model.countNews();
            }else{
                news = model.search(titleSearch, recordPerPage, recordPerPage *(currPage-1));
                count = model.countSearch(titleSearch);
            }
            
            String paramPage = request.getParameter("page");
            if (paramPage != null) {
                currPage = Integer.parseInt(paramPage);
            }
            
     
            
            totalPage = (int) (Math.floor(count/recordPerPage)+1); 
            
            //news = model.search(titleSearch, recordPerPage, recordPerPage *(currPage-1));
            
            request.setAttribute("news", news);
            request.setAttribute("total", totalPage);
            request.setAttribute("curr", currPage);
            
            request.getRequestDispatcher("search.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
