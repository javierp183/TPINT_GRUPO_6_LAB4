package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.ClienteNegocioImpl;
import NegocioImpl.MovimientoNegocioImpl;
import dominio.Cliente;
import dominio.Movimiento;

/**
 * Servlet implementation class servletClienteHistorial
 */
@WebServlet("/servletClienteHistorial")
public class servletClienteHistorial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletClienteHistorial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Mostrando historial del usuario");
		if(request.getParameter("usuario")!=null)
		{
			Cliente cliente = new Cliente();
			Movimiento movimiento = new Movimiento();
			MovimientoNegocioImpl movimientonegocioimpl = new MovimientoNegocioImpl();
			ClienteNegocioImpl clientenegocioimpl = new ClienteNegocioImpl();
			
			
			cliente = clientenegocioimpl.getClientePorDNI(request.getParameter("usuario"));
			
			ArrayList<Movimiento> listademovimientospordni =  (ArrayList<Movimiento>) movimientonegocioimpl.getMovimientoPorDnis(cliente.getDni());
			System.out.println(listademovimientospordni);
			request.setAttribute("listamovimientos", listademovimientospordni);
			RequestDispatcher rd = request.getRequestDispatcher("Cliente_Historial.jsp");
			rd.forward(request, response);
			
			
			
			System.out.println("es por aca");
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
