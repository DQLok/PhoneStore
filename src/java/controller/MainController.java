/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author duylp
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";
    private final String GENERATE_DATA = "GenerateDataController";
    private final String CHECK_DATA = "CheckDataController";
    private final String DOWNLOAD_DATA = "DownloadDataController";
    private final String LOAD_DATA = "LoadDataController";
    private final String GENERATE_CRAWL_DATA = "GenerateCrawlDataController";
    private final String ADD_PRODUCT_DATA = "AddProductController";
    private final String UPDATE_PRODUCT_DATA = "UpdateProductController";
    private final String DELETE_PRODUCT_DATA = "DeleteProductController";
    private final String EXPORT_PDF_DATA = "ExportPDFController";
    private final String DOWNLOAD_PDF= "DownloadPDFController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("btnAction");
        String url = INDEX_PAGE;
        try {
            if ("Generate".equals(action)) {
                url = GENERATE_DATA;
            }
            if ("Check XML".equals(action)) {
                url = CHECK_DATA;
            }
            if ("Dowload Data".equals(action)) {
                url = DOWNLOAD_DATA;
            }
            if ("Load".equals(action)) {
                url = LOAD_DATA;
            }
            if ("Crawl Data".equals(action)) {
                url = GENERATE_CRAWL_DATA;
            }
            if ("Add Product".equals(action)) {
                url = ADD_PRODUCT_DATA;
            }
            if ("Update Product".equals(action)) {
                url = UPDATE_PRODUCT_DATA;
            }
            if ("Delete Product".equals(action)) {
                url = DELETE_PRODUCT_DATA;
            }
            if ("ExportPDF".equals(action)) {
                url = EXPORT_PDF_DATA;
            }
            if ("Dowload PDF".equals(action)) {
                url = DOWNLOAD_PDF;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
