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
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import testObjects.data;
import testObjects.templateOne;


@WebServlet(name = "custPageServlet", urlPatterns = {"/custPageServlet"})
public class custPageServlet extends HttpServlet {

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
            data d = new data();
            String cName;
            String cPhone;
            String cEmail;
            String cStreet;
            String cCity;
            String cStates;
            String cZip;
            
            cName = request.getParameter("custName");
            cPhone = request.getParameter("custPhone");
            cEmail = request.getParameter("custEmail");
            cStreet = request.getParameter("custAdd");
            cCity = request.getParameter("custCity");
            cStates = request.getParameter("custSta");
            cZip = request.getParameter("custZip");
            
            d.custName = cName;
            d.custPhone = cPhone;
            d.custEmail = cEmail;
            d.jobStreet = cStreet;
            d.jobCity = cCity;
            d.jobState = cStates;
            d.jobZip = cZip;
            
            //Step #5 - Put Student Object in Session using HttpSession
            HttpSession ses1;
            ses1 = request.getSession();
            ses1.setAttribute("d", d);
            System.out.println("Customer data added to Session");
            
            RequestDispatcher rd = request.getRequestDispatcher("testSites1/userInfo.html");
            rd.forward(request, response);  

            

            /*
            System.out.println("Create Simple PDF file with blank Page");
            String fileName = "testCust.pdf"; // name of our file
            templateOne t1 = new templateOne();
            PDDocument doc;
            try{
                doc = new PDDocument(); // creating instance of pdfDoc
                PDPage page = new PDPage();
                doc.addPage(page); // adding page in pdf doc file
                try (PDPageContentStream stuff = new PDPageContentStream(doc, page) //needed to add content to page
                ) {
                    t1.custJobBox(stuff);
                    t1.custJobtext(stuff, d);
                }
                doc.save(fileName); // saving as pdf file with name perm 
        
                doc.close(); // cleaning memory 
        
                System.out.println("your file created in : "+ System.getProperty("user.dir"));
            }
            catch(IOException e){
                System.out.println(e.getMessage());
            }*/
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet custPageInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cust Name: " + d.custName + "</h1>");
            out.println("<h1>Cust Phone: " + d.custPhone + "</h1>");
            out.println("<h1>Cust Email: " + d.custEmail + "</h1>");
            out.println("<h1>Cust Street: " + d.jobStreet + "</h1>");
            out.println("<h1>Cust City: " + d.jobCity + "</h1>");
            out.println("<h1>Cust State: " + d.jobState + "</h1>");
            out.println("<h1>Cust zip: " + d.jobZip + "</h1>");
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
