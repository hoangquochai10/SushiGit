/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haihq.Servlet;

import haihq.DAO.InfoDAO;
import haihq.DAO.MenuDAO;
import haihq.DAO.ProductDAO;
import haihq.DTO.InfoDTO;
import haihq.DTO.MenuDTO;
import haihq.DTO.ProductDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author haihq
 */
public class MainServlet extends HttpServlet {

    String homePage = "homePage.jsp";
    String menuPage = "menuPage.jsp";
    String infoPage = "findUs.jsp";
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String btAction = request.getParameter("btAction");
            if (btAction==null)
            {
                List<ProductDTO> listProducts = new ArrayList<>();
                ProductDAO dao = new ProductDAO();
                InfoDAO infoDao = new InfoDAO();
                listProducts = dao.getAllProducts();
                HttpSession session = request.getSession();
                InfoDTO dto = new InfoDTO();
                dto = infoDao.getInfo();
                if(session.getAttribute("ADDRESS")==null)
                {
                    int numberVIewer = dto.getNumberViewer()+1;
                    dto.setNumberViewer(numberVIewer);
                    session.setAttribute("ADDRESS", dto);
                    infoDao.updateViewer(dto.getInfoID(), numberVIewer);
                }
                session.setAttribute("PRODUCTS", listProducts);
                RequestDispatcher rd = request.getRequestDispatcher(homePage);
                rd.forward(request, response);
            }
            else if (btAction.equals("showProductByMenuID"))
            {
                List<MenuDTO> listMenus = new ArrayList<>();
                MenuDAO dao = new MenuDAO();
                listMenus=dao.getAllMenus();
                for (int i=0;i<listMenus.size();i++)
                {
                    String id = listMenus.get(i).getMenuID();
                    listMenus.get(i).setListProduct(dao.getProductByMenuID(id));
                }
                HttpSession session = request.getSession();
                session.setAttribute("PRODUCT_FOLLOW_MENU", listMenus);
                RequestDispatcher rd = request.getRequestDispatcher(menuPage);
                rd.forward(request, response);
            }
            else if (btAction.equals("showInfo"))
            {
                InfoDTO dto = new InfoDTO();
                InfoDAO dao = new InfoDAO();
                dto=dao.getInfo();
                HttpSession session = request.getSession();
                if(session.getAttribute("ADDRESS")==null)
                {
                    int numberViewer = dto.getNumberViewer()+1;
                    dto.setNumberViewer(numberViewer);
                    session.setAttribute("ADDRESS", dto);
                    dao.updateViewer(dto.getInfoID(), numberViewer);
                }
                RequestDispatcher rd = request.getRequestDispatcher(infoPage);
                rd.forward(request, response);
            }
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
        } catch (SQLException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(MainServlet.class.getName()).log(Level.SEVERE, null, ex);
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
