package com.bikash;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "bikashServlet", urlPatterns = {"/bikashServlet"})
public class BikashServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, MalformedURLException, org.json.simple.parser.ParseException {
        //response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String dateTime = request.getParameter("t1");
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date inputDate = dateformat.parse(dateTime);
            long unixTime = inputDate.getTime() / 1000;
            String timeZoneNewYork = "America/New_York";
            String timeZoneLondon = "Europe/London";
            String timeZoneSanFrancisco = "America/Los_Angeles";
            URLconnection urlConnection = new URLconnection();
            String dateYork = urlConnection.getDate(timeZoneNewYork, unixTime);
            URLconnection urlConnection2 = new URLconnection();
            String dateLon = urlConnection2.getDate(timeZoneLondon, unixTime);
            URLconnection urlConnection3 = new URLconnection();
            
            String dateSan = urlConnection3.getDate(timeZoneSanFrancisco, unixTime);
            //String resDate="hello bikash";
            request.setAttribute("dateNewYork", dateYork);
            request.setAttribute("dateLondon", dateLon);
            request.setAttribute("dateSanFrancisco", dateSan);
            request.getRequestDispatcher("dateTimeJSP.jsp").forward(request, response);
            //response.sendRedirect("http://localhost:8080/WebAppJSP/dateTimeJSP.jsp");
//            out.println(dateYork);
//            out.println(dateLon);
//            out.println(dateSan);
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
        try {
            processRequest(request, response);
        } catch (ParseException | MalformedURLException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(BikashServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException | MalformedURLException | org.json.simple.parser.ParseException ex) {
            Logger.getLogger(BikashServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
