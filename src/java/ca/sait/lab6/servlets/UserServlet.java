
package ca.sait.lab6.servlets;

import ca.sait.lab6.models.Role;
import ca.sait.lab6.models.User;
import ca.sait.lab6.services.RoleService;
import ca.sait.lab6.services.UserService;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sri
 */
public class UserServlet extends HttpServlet 
{
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
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        if(action != null && action.equals("edit"))
        {
            String email = (String) request.getAttribute("email");
            
            UserService service = new UserService();
            
            try 
            {
                User user = service.get(email);
                
                request.setAttribute("user", user);
                
                this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response); 
            } 
            catch (Exception ex) 
            {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
       
        try 
        {
            UserService service = new UserService();
            List<User> users = service.getAll();
            
            request.setAttribute("users", users);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response); 
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            throws ServletException, IOException 
    {
         try 
        {
             boolean edited = false;
             
            String action = request.getParameter("action");

            String email = (String) request.getAttribute("email");

            String fname = (String) request.getAttribute("fname");

            String lname = (String) request.getAttribute("lname");

            String password = (String) request.getAttribute("password");

            int roleID = (int) request.getAttribute("role");

            String roleName = null;
            
            RoleService roleService = new RoleService();

            List<Role> roles;

                roles = roleService.getAll();

                
            if(action != null && action.equals("editForm"))
            {
                UserService service = new UserService();

                for(int i =0; i < roles.size(); i++)
                {
                    if (roles.get(i).getId() == roleID)
                    {
                        roleName = roles.get(i).getName();
                    }
                    
                    break;
                }

                Role roleObject = new Role(roleID, roleName);
                
               edited = service.update(email, true, fname, lname, password, roleObject);
            }
                 
        } 
        
        catch (Exception ex) 
        {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response); 
    }

    
}
