/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import category.CategoriesDAO;
import category.CategoriesDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import products.ProductDAO;
import products.ProductDTO;

/**
 *
 * @author LokDQ
 */
@WebServlet(name = "AddProductController", urlPatterns = {"/AddProductController"})
public class AddProductController extends HttpServlet {

    private final String INDEX_PAGE = "LoadDataController";
    private final String ERROR_PAGE = "error.html";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = INDEX_PAGE;        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String path = request.getServletContext().getRealPath("/xml/fileXML.xml");            
            String productName = request.getParameter("productName");
            String price = request.getParameter("price");
            String image = request.getParameter("image");
            String creationDate = LocalDateTime.now().format(formatter);
            String categoryId = request.getParameter("categoryId");
            ProductDAO dao = new ProductDAO();
            List<ProductDTO> list = dao.getAllProducts(path);
            String productId = String.valueOf(list.size()+1);
            ProductDTO dto = new ProductDTO(productId, productName, new BigDecimal(price), image, creationDate, categoryId);
            dao.addProduct(dto, path);
        } catch (Exception e) {
            e.printStackTrace();
            url = ERROR_PAGE;
        }finally {
            request.getRequestDispatcher(url).forward(request, response);
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
