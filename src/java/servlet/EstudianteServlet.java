/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import LaborModel.Estudiante;
import LaborModel.Materia;
import LaborModel.Matricula;
import daoLabora.EstudianteFacade;
import daoLabora.EstudianteFacadeLocal;
import daoLabora.MateriaFacade;
import daoLabora.MateriaFacadeLocal;
import daoLabora.MatriculaFacade;
import daoLabora.MatriculaFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.jboss.weld.servlet.SessionHolder.getSession;

/**
 *
 * @author Santiago
 */
public class EstudianteServlet extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    @EJB
    private MateriaFacadeLocal materiaFacade;
    @EJB
    private MatriculaFacadeLocal matriculaFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
        
    try{
            String action = request.getParameter("action");
            String url = "index.jsp";
            if("list".equals(action)) {
                //findAll para buscar en materias
                List<Materia> findAll = materiaFacade.findAll();
                request.getSession().setAttribute("materias", findAll);
                
                //findAll2 para buscar en estudiantes
                //No está en uso actualmente
                List<Estudiante> findAll2 = estudianteFacade.findAll();
                
                request.getSession().setAttribute("estudiantes", findAll2);
                url = "listMateria.jsp";
        } else if("login".equals(action)){
            String i = request.getParameter("idE");
            String p = request.getParameter("password");
            
            boolean checkLogin = estudianteFacade.checkLogin(Integer.valueOf(i), p);
            if(checkLogin) {
                request.getSession().setAttribute("login", i);
                url = "manager.jsp";
            } else {
                url = "login.jsp?error=1";
            }
        } else if ("enrollment".equals(action)) {        
                //Caputuramos id de la materia
                String idM = request.getParameter("id");
                //Pedimos a la sesión que nos retorne el id del usuario
                String idE = (String) request.getSession().getAttribute("login");
                
                System.out.println(idE);
                System.out.println(idM);               
                
                matriculaFacade.matricula(Integer.valueOf(idM), Integer.valueOf(idE));
                url = "EstudianteServlet?action=list";
            } else if ("logout".equals(action)){
            request.getSession().removeAttribute("login");
            url = "login.jsp";
        }
        response.sendRedirect(url);
    } finally {
            out.close();
        }
            
            
            
            
            /* Codigo autogenerado
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EstudianteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EstudianteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
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
