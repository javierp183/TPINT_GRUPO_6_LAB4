package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.CuentaNegocioImpl;
import NegocioImpl.MovimientoNegocioImpl;
import NegocioImpl.PrestamoNegocioImpl;
import daoImpl.ClienteDaoImpl;
import daoImpl.CuentaDaoImpl;
import daoImpl.PrestamoDaoImpl;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Prestamo;

/**
 * Servlet implementation class servletPagoPrestamo
 */
@WebServlet("/servletPagoPrestamo")
public class servletPagoPrestamo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletPagoPrestamo() {
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
			ArrayList<Prestamo> listaprestamos = (ArrayList<Prestamo>) prestamodaoimpl.readAllbyDNI(cliente.getDni());
			
			request.setAttribute("listacuentas", listacuentas);
			request.setAttribute("listaprestamos", listaprestamos);
			request.setAttribute("usuario", cliente.getUsuario());
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("apellido", cliente.getApellido());
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente_Pago_Prestamo.jsp");
			rd.forward(request, response);
			
			
		}
		
		if(request.getParameter("btnvolverPagina")!=null)
		{
			Cliente cliente = new Cliente();
			
			cliente = clientedaoimpl.getClientePorDNI(request.getParameter("btnvolverPagina"));
			request.setAttribute("usuario",cliente.getUsuario());
			request.setAttribute("nombre", cliente.getNombre());
			request.setAttribute("apellido", cliente.getApellido());
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnPagoPrestamo")!=null)
		{
			float Montodepago = Float.parseFloat(request.getParameter("inputMonto"));
			String Cbu = request.getParameter("inputCBU");
			int IdCuenta = Integer.parseInt(request.getParameter("inputPrestamo"));
			float CalculoDePago = 0;
			Movimiento movimiento = new Movimiento();
			MovimientoNegocioImpl movimientonegocioimpl = new MovimientoNegocioImpl();
			
			
			Cuenta cuenta = new Cuenta();
			CuentaDaoImpl cuentadaoimpl = new CuentaDaoImpl();
			Prestamo prestamo = new Prestamo();
			PrestamoDaoImpl prestamodaoimpl = new PrestamoDaoImpl();
			
			cuenta = cuentadaoimpl.Search(Cbu);
			prestamo = prestamodaoimpl.getPrestamoID(IdCuenta);
			
			if(Montodepago < cuenta.getSaldo())
			{
				CalculoDePago = prestamo.getMontoRestante() - Montodepago;
				prestamo.setMontoRestante(CalculoDePago);
				prestamodaoimpl.modify(prestamo);
				
				movimiento.setCbu(prestamo.getCbu());
				movimiento.setDni(prestamo.getDniCliente());
				movimiento.setUsuario("test");
				movimiento.setTipoMovimiento("PAGO");
				movimiento.setDescripcion("Pago de prestamo");
				movimientonegocioimpl.insert(movimiento);
				
				RequestDispatcher rd = request.getRequestDispatcher("Cliente_Pago_Prestamo_ok.jsp");
				rd.forward(request, response);
				
			}
			
			
			
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente_Pago_Prestamo.jsp");
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
