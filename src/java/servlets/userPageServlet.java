/*
 *Julian A Plasencia
 *invoice project 
 *
 *servlet used to take data from the user's info page and stores them in the session.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import testObjects.data;


@WebServlet(name = "userPageServlet", urlPatterns = {"/userPageServlet"})
public class userPageServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            HttpSession ses1;
            ses1 = request.getSession();
            data dd = (data) ses1.getAttribute("d");
            
            String uName;
            String uStreet;
            String uCity;
            String uState;
            String uZip;
            String uPhone;
            String uEmail;
            
            uName = request.getParameter("userName");
            uStreet = request.getParameter("userAdd");
            uCity = request.getParameter("userCity");
            uState = request.getParameter("userSt");
            uZip = request.getParameter("userZip");
            uPhone = request.getParameter("userPhone");
            uEmail = request.getParameter("userEmail");
            
            dd.userName = uName;
            dd.userStreet = uStreet;
            dd.userCity = uCity;
            dd.userState = uState;
            dd.userZip = uZip;
            dd.userPhone = uPhone;
            dd.userEmail = uEmail;
                    
            ses1 = request.getSession();
            ses1.setAttribute("d", dd);
            System.out.println("Customer data added to Session");
            
            RequestDispatcher rd = request.getRequestDispatcher("testSites1/taskTable.html");//////////////////////////////////////////////////////////////////////////////////
            rd.forward(request, response);  
            /////Tested to feel if the data is being processed corectly
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet userPageServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>User Name " + dd.userName + "</h1>");
            out.println("<h1>User street " + dd.userStreet + "</h1>");
            out.println("<h1>User city " + dd.userCity + "</h1>");
            out.println("<h1>User state " + dd.userState + "</h1>");
            out.println("<h1>User zip " + dd.userZip + "</h1>");
            out.println("<h1>User phone " + dd.userPhone + "</h1>");
            out.println("<h1>User email " + dd.userEmail + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
