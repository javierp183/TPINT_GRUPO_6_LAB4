package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ClienteDaoImpl;
import daoImpl.CuentaDaoImpl;
import daoImpl.PrestamoDaoImpl;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Prestamo;

/**
 * Servlet implementation class servletCliente_VerInformacion
 */
@WebServlet("/servletCliente_VerInformacion")
public class servletCliente_VerInformacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente_VerInformacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClienteDaoImpl clientedaoimpl = new ClienteDaoImpl();
		if(request.getParameter("usuario") != null)
		{
			Cliente cliente = new Cliente();
			
			Prestamo prestamo = new Prestamo();
			PrestamoDaoImpl prestamodaoimpl = new PrestamoDaoImpl();
			
			cliente = clientedaoimpl.getClientePorDNI(request.getParameter("usuario"));
			
			Cuenta cuenta = new Cuenta();
			CuentaDaoImpl cuentadaoimpl = new CuentaDaoImpl();
			ArrayList<Cuenta> listacuentas = (ArrayList<Cuenta>) cuentadaoimpl.ListarCuentasPorDNI(cliente.getDni());
			
			request.setAttribute("listacuentas", listacuentas);
			request.setAttribute("usuario", cliente.getUsuario());
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("apellido", cliente.getApellido());
			request.setAttribute("dni", cliente.getDni());
			request.setAttribute("email", cliente.getCorreoElectronico());
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente_Informacion_Personal.jsp");
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
