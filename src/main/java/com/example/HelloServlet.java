package com.example;

import java.io.IOException;
import java.time.Instant;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<!doctype html>");
        response.getWriter().println("<html><head><title>Maven Tomcat Hands-On</title></head><body>");
        response.getWriter().println("<h1>Hello from Jenkins + Maven + Tomcat!</h1>");
        response.getWriter().println("<p>Your WAR application is running successfully.</p>");
        response.getWriter().println("<p>Server time (UTC): " + Instant.now() + "</p>");
        response.getWriter().println("</body></html>");
    }
}
