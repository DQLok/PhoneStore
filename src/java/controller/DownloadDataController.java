/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LokDQ
 */
@WebServlet(name = "DownloadDataController", urlPatterns = {"/DownloadDataController"})
public class DownloadDataController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";
    private final String ERROR_PAGE = "error.html";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8;");        
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        try {
            String typeFile = request.getParameter("typeFile");
            String path = "";
            if (typeFile.equals("xml")) {
                path = request.getServletContext().getRealPath("/xml/fileXML.xml");
                response.setHeader("Content-disposition", "attachment; filename=fileXML.xml");
            }
            if (typeFile.equals("pdf")) {
                response.setContentType("application/pdf");
                path = request.getServletContext().getRealPath("/xml/filePDF.pdf");
                response.setHeader("Content-Disposition", "attachment; filename=filePDF.pdf");                
            }
            try (FileInputStream fis = new FileInputStream(path)) {
                BufferedReader br = new BufferedReader(new InputStreamReader(fis));
                while (true) {
                    String s = br.readLine();
                    if (s == null) {
                        break;
                    }
                    out.println(s);
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            url = ERROR_PAGE;
        } finally {
            out.close();
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
