/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.AccountService;
/**
 *
 * @author Jaz Baliola
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if (request.getParameter("logout")!=null){
         session.invalidate();
         String message ="You have succesfully logged out";
         request.setAttribute("message", message);
         session = request.getSession();
        }
        
        if(session.getAttribute("username")!=null){
            response.sendRedirect("home");
        }
        else
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountService as = new AccountService();
        
        HttpSession session = request.getSession();
        
        if(as.login(username, password)!=null){
            session.setAttribute("username", username);
            session.setAttribute("password", null);
            response.sendRedirect("home");
        }
        else {
            String message="Username and/or password are invalid";
            session.setAttribute("message", message);          
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(request, response);
        
        }
    }

}