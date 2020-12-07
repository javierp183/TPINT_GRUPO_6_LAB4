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
 * Servlet implementation class servletCliente_Transferencia
 */
@WebServlet("/servletCliente_Transferencia")
public class servletCliente_Transferencia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente_Transferencia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		Cliente clienteaux = new Cliente();
		Cuenta cuenta = new Cuenta();
		Cuenta cuentaaux = new Cuenta();
		CuentaDaoImpl cuentadaoimpl = new CuentaDaoImpl();
		ClienteDaoImpl clientedaoimpl = new ClienteDaoImpl();
		Prestamo prestamo = new Prestamo();
		PrestamoDaoImpl prestamodaoimpl = new PrestamoDaoImpl();
		
		if(request.getParameter("usuario") != null)
		{
			cliente = clientedaoimpl.getClientePorDNI(request.getParameter("usuario"));
			
			//Cuenta cuenta = new Cuenta();
			//CuentaDaoImpl cuentadaoimpl = new CuentaDaoImpl();
			ArrayList<Cuenta> listacuentas = (ArrayList<Cuenta>) cuentadaoimpl.ListarCuentasPorDNI(cliente.getDni());
			
			request.setAttribute("listacuentas", listacuentas);
			
			RequestDispatcher rd = request.getRequestDispatcher("Cliente_Transferencia.jsp");
			rd.forward(request, response);
		}
		
		
		if(request.getParameter("btnTransferir")!=null)
		{
			
			System.out.println("Este quiere transferir guita");
			String Cbu = request.getParameter("inputCBU");
			float Monto = Float.parseFloat(request.getParameter("inputMonto"));
			String Cbuexterno = request.getParameter("inputCBUexterno");
			Movimiento movimientosrc = new Movimiento();
			Movimiento movimientodst = new Movimiento();
			MovimientoNegocioImpl movimientonegocioimpl = new MovimientoNegocioImpl();
		
			cuenta = cuentadaoimpl.Search(Cbu);			
			cuentaaux = cuentadaoimpl.Search(Cbuexterno);
			
			movimientosrc.setDni(cuenta.getDni());
			movimientosrc.setTipoMovimiento("TRANSFERENCIA ->");
			movimientosrc.setDescripcion("Transferencia a otra cuenta");
			movimientonegocioimpl.insert(movimientosrc);
			
			movimientodst.setDni(cuentaaux.getDni());
			movimientodst.setTipoMovimiento("TRANSFERENCIA <-");
			movimientodst.setDescripcion("Recive Transferencia desde otra cuenta");
			movimientonegocioimpl.insert(movimientodst);
			
			cuenta.setSaldo(cuenta.getSaldo() - Monto);
			cuentaaux.setSaldo(cuentaaux.getSaldo() + Monto);
			cuentadaoimpl.Modify(cuenta);
			cuentadaoimpl.Modify(cuentaaux);
			
			System.out.println(cuentaaux.getSaldo());
			
			System.out.println("vamos a ver que pasa!");
			
			
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
