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
import dominio.Cuenta;
import dominio.Movimiento;
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
		Prestamo prestamo = new Prestamo();
		Cuenta cuenta = new Cuenta();
		Movimiento movimiento = new Movimiento();
		PrestamoNegocioImpl prestamodaoimpl = new PrestamoNegocioImpl();
		CuentaNegocioImpl cuentanegocioimpl = new CuentaNegocioImpl();
		MovimientoNegocioImpl movimientonegocioimpl = new MovimientoNegocioImpl();
		
		if(request.getParameter("btnListarPedidos")!=null)
		{
			System.out.println("te voy a listar los pedidos");
			
			
			ArrayList<Prestamo> prestamossinaprobar = (ArrayList<Prestamo>) prestamodaoimpl.readAllUnapproved();
			System.out.println(prestamossinaprobar);
			request.setAttribute("prestamossinaprobar", prestamossinaprobar);
			
			RequestDispatcher rd = request.getRequestDispatcher("Administrador_Autorizacion_Prestamo.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("btnHabilitarPrestamo")!=null)
		{
			float SaldoFinalDeCuenta = 0;
			System.out.println("habilitando prestamo");
			int IdPrestamo = Integer.parseInt(request.getParameter("txtPrestamoID"));
			
			prestamo = prestamodaoimpl.getPrestamoPorID(IdPrestamo);
			prestamo.setEstado(1);
			prestamodaoimpl.modify(prestamo);
			cuenta = cuentanegocioimpl.Search(prestamo.getCbu());
			SaldoFinalDeCuenta = cuenta.getSaldo() + prestamo.getMontoTotal();
			
			cuenta.setSaldo(SaldoFinalDeCuenta);
			cuentanegocioimpl.Modify(cuenta);
			System.out.println("Empieza el resguardo del movimiento");
			movimiento.setDni(prestamo.getDniCliente());
			movimiento.setUsuario("test");
			movimiento.setTipoMovimiento("PRESTAMO");
			movimiento.setDescripcion("Se aprobo el prestamo de: " + prestamo.getMontoTotal() );
			movimientonegocioimpl.insert(movimiento);
			System.out.println("Termina el resguardo del movimiento");
			
			
			
			System.out.println("habilitando finalizar prestamo");
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
