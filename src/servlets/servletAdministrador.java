package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.PrestamoNegocioImpl;
import dominio.Cuenta;
import dominio.Prestamo;

/**
 * Servlet implementation class servletAdministrador
 */
@WebServlet("/servletAdministrador")
public class servletAdministrador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletAdministrador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("btnListarPedidos")!=null)
		{
			System.out.println("te voy a listar los pedidos");
			Prestamo prestamo = new Prestamo();
			PrestamoNegocioImpl prestamodaoimpl = new PrestamoNegocioImpl();
			ArrayList<Prestamo> prestamossinaprobar = (ArrayList<Prestamo>) prestamodaoimpl.readAllUnapproved();
			System.out.println(prestamossinaprobar);
			request.setAttribute("prestamossinaprobar", prestamossinaprobar);
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_Autorizacion_Prestamo.jsp");
			rd.forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
