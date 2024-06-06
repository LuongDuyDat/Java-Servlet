/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author datld7
 */
public class AuthenticationFilter extends HttpFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        
        HttpSession session = req.getSession();
        String uri=req.getRequestURI();
        
        System.out.println(uri);
        
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean loginRequest = uri.contains("login");
        boolean publicResouceRequest = uri.contains("css") || uri.contains("images");
                
        if (loggedIn || loginRequest || publicResouceRequest) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect("/login");
        }
    }
}
