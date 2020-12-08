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

import NegocioImpl.ClienteNegocioImpl;
import NegocioImpl.CuentaNegocioImpl;
import NegocioImpl.PrestamoNegocioImpl;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Prestamo;

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
		CuentaNegocioImpl cuentadaoimpl = new CuentaNegocioImpl();
		ClienteNegocioImpl clientedaoimpl = new ClienteNegocioImpl();
		PrestamoNegocioImpl prestamodaoimpl = new PrestamoNegocioImpl();
		Prestamo prestamo = new Prestamo();
		if(request.getParameter("usuario")!=null)
		{
			// Obtener el DNI
			Cliente cliente = new Cliente();
			cliente = clientedaoimpl.getClientePorDNI(request.getParameter("usuario"));
			System.out.println(cliente.getDni());
			ArrayList<Cuenta> cuentaspordni = (ArrayList<Cuenta>) cuentadaoimpl.ListarCuentasPorDNI(cliente.getDni());
			request.setAttribute("listacuentas", cuentaspordni);
			request.setAttribute("dnidelcliente", cliente.getDni());
			request.setAttribute("nombredecliente", cliente.getNombre());
			request.setAttribute("apellidodecliente", cliente.getApellido());
			
		}
		
		if(request.getParameter("btnPedirOtroPrestamo")!=null)
		{
			
			System.out.println("Esta pidiendo otro prestamo!!!");
			// Obtener el DNI
			Cliente cliente = new Cliente();
			cliente = clientedaoimpl.getClientePorDNI(request.getParameter("usuario"));
			System.out.println(cliente.getDni());
			ArrayList<Cuenta> cuentaspordni = (ArrayList<Cuenta>) cuentadaoimpl.ListarCuentasPorDNI(cliente.getDni());
			request.setAttribute("listacuentas", cuentaspordni);
			request.setAttribute("dnidelcliente", cliente.getDni());
			System.out.println(cliente.getDni());
			request.setAttribute("usuario",cliente.getUsuario());
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("apellido", cliente.getApellido());
			
		}
		
		if(request.getParameter("btnAsignar")!=null)
		{

			String Cbu = (String) request.getParameter("inputCbu");
			int Dni = Integer.parseInt(request.getParameter("inputDni"));
			float Monto = Float.parseFloat(request.getParameter("inputMonto"));
			int Cuotas = Integer.parseInt(request.getParameter("inputCuotas"));
			String Nombre = (String) request.getParameter("inputNombre");
			String Apellido = (String) request.getParameter("inputApellido");
			
			Cliente cliente = new Cliente();

			//cliente = clientedaoimpl.getClientePorUsuario(Dni);
			
			prestamo.setCbu(Cbu);
			prestamo.setDniCliente(Dni);
			prestamo.setMontoTotal(Monto);
			prestamo.setEstado(0);
			prestamo.setNumCuotas(Cuotas);
			prestamo.setMontoRestante(Monto);
			prestamo.setPagoxmes(Monto);
			prestamo.setNombre(Nombre);
			prestamo.setApellido(Apellido);
			
			prestamodaoimpl.insert(prestamo);
			cliente = clientedaoimpl.getClientePorUsuario(Dni);
			request.setAttribute("usuario",cliente.getUsuario());
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("apellido", cliente.getApellido());
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente_Pedido_Prestamo_ok.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnvolverPagina")!=null)
		{
			Cliente cliente = new Cliente();
			cliente = clientedaoimpl.getClientePorUsuario(Integer.parseInt(request.getParameter("btnvolverPagina")));
			request.setAttribute("usuario",cliente.getUsuario());
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("apellido", cliente.getApellido());
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente.jsp");
			rd.forward(request, response);
		}
		
		
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
