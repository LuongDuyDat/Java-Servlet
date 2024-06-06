/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myapp.listeners;

import javax.servlet.annotation.WebListener; 
import javax.servlet.http.HttpSessionEvent; 
import javax.servlet.http.HttpSessionListener; 

/**
 *
 * @author datld7
 */
@WebListener
public class SessionListener 
    implements HttpSessionListener { 
    
    @Override
    public void sessionCreated(HttpSessionEvent sessionEvent) 
    { 
        System.out.println( 
            "Session Created:: ID="
            + sessionEvent.getSession().getId()); 
    } 
    
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) 
    { 
        System.out.println( 
            "Session Destroyed:: ID="
            + sessionEvent.getSession().getId()); 
    } 
}