/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.calculator.client;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.me.calculator.CalculatorWS_Service;

/**
 *
 * @author Estudiantes
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CalculatorWSApplication/CalculatorWS.wsdl")
    private CalculatorWS_Service service;

    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            
            try( PrintWriter out = response.getWriter() ){
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ClientServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet ClientServlet at " + request.getContextPath() + "</h1>");

                try {
                    int i = 3;
                    int j = 4;
                    int result = add(i, j);
                    out.println("Result = " + result);
                }catch (Exception ex){
                    out.println("Exception: " + ex);
                }

                out.println("</body>");
                out.println("</html>");
            } 

        }

    private int add(int i, int j) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.me.calculator.CalculatorWS port = service.getCalculatorWSPort();
        return port.add(i, j);
    }

        

    

    
    
}
