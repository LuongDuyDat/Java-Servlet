/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.myapp.servlets;

import db.AccountDB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author datld7
 */
public class LoginServlet extends HttpServlet {

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
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
        //processRequest(request, response);
        System.out.println("POST request");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        AccountDB accountDB = new AccountDB();
        int verifiedId = accountDB.checkLogin(username, password);
        
        if (verifiedId != 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            session.setAttribute("id", verifiedId);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30*60);
            response.sendRedirect("/home");
        } else {
            request.setAttribute("error_login", "Tai khoan hoac mat khau khong hop le!");
            doGet(request, response);
        }
    }
}
