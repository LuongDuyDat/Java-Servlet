/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myapp.servlets;

import db.FileDB;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import model.FileUpload;

/**
 *
 * @author datld7
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home"})
@MultipartConfig
public class HomeServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        int id = (Integer)(session.getAttribute("id"));
        
        FileDB fileDB = new FileDB();
        ArrayList<FileUpload> fileList = fileDB.getFileByAccount(id);
        
        request.setAttribute("fileList", fileList);
        
        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
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
        String title = request.getParameter("title");
        
        Part filePart = request.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        
         // Get the absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        
        // Construct the path to the Web pages folder (webapp or webcontent)
        String uploadPath = appPath + "uploads" + "\\" + fileName;
        
        filePart.write(uploadPath);
        
        File uploadedFile = new File(uploadPath);
        if (uploadedFile.exists() && uploadedFile.isFile()) {
            System.out.println("File uploaded successfully to " + uploadPath);
        } else {
            System.out.println("File upload failed");
        }
        
        HttpSession session = request.getSession();
        int id = (Integer)(session.getAttribute("id"));
        
        FileDB fileDB = new FileDB();
        fileDB.FileUpload(title, uploadPath, id);
        
        doGet(request, response);
    }

}
