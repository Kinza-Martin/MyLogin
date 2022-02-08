package ca.sait.Mylogin.servlets;

import ca.sait.Mylogin.models.User;
import ca.sait.Mylogin.services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kinza
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session=request.getSession();
        if(session.getAttribute("username") !=null){
             String query= request.getQueryString();
            
            if(query!= null  && query.contains("logout")){
            session.invalidate();
            request.setAttribute("message", "You are logged out");
            
        }else{
              response.sendRedirect("home");
          return;
        
            
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
        String username=request.getParameter("username");
           String password=request.getParameter("password");
           
           if(username == null || username.isEmpty() || password ==null || password.isEmpty()){
               request.setAttribute("message", "Username or password is missing.");
           } else {
               AccountService account=new AccountService();
               
             User user= account.login(username, password);
             
             if(user !=null ){
                 request.getSession().setAttribute("username",username );
                 response.sendRedirect("home");
                 return;
                 
             }else {
                 request.setAttribute("username", username);
                 request.setAttribute("message", "Username or password is invalid.");
           }
           }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
