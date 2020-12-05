package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.CuentaNegocioImpl;
import dominio.Cliente;
import dominio.Cuenta;

/**
 * Servlet implementation class servletPrestamo
 */
@WebServlet("/servletPrestamo")
public class servletPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPrestamo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("usuario")!=null)
		{
			System.out.println("amigo, esta es la rula!!!");
			
		}
		
		Cliente cliente = new Cliente();
		String Monto = request.getParameter("inputMonto");
		String Cuotas = request.getParameter("inputCuotas");
		String Dni = request.getParameter("inputDNI");
		CuentaNegocioImpl cuentadaoimpl = new CuentaNegocioImpl();
		ArrayList<Cuenta> listacuentassinasignar = (ArrayList<Cuenta>) cuentadaoimpl.Readallunassigned();
		request.setAttribute("listacuentas", listacuentassinasignar);
		request.setAttribute("dni", cliente.getDni());
		String[] uris=request.getRequestURI().split("/");
		
		System.out.println(Monto);
		System.out.println(Cuotas);
		System.out.println(request.getAttribute("test"));
		System.out.println(Dni);
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("Cliente_Pedido_Prestamo.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
