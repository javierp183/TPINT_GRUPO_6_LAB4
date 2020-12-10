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
import NegocioImpl.CuentaNegocioImpl;
import NegocioImpl.MovimientoNegocioImpl;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;

import java.time.LocalDate;

/**
 * Servlet implementation class servletCuentaAsignacion
 */
@WebServlet("/servletCuentaAsignacion")
public class servletCuentaAsignacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuentaAsignacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CuentaNegocioImpl cuentadaoimpl = new CuentaNegocioImpl();
		Cuenta cuenta = new Cuenta();
		Cuenta cuentaaux = new Cuenta();
		//ArrayList<Cuenta> listacuentas = (ArrayList<Cuenta>) cuentadaoimpl.ReadAll();
		ArrayList<Cuenta> listacuentassinasignar = (ArrayList<Cuenta>) cuentadaoimpl.Readallunassigned();
		request.setAttribute("listacuentas", listacuentassinasignar);
		int estado = 0;
		//System.out.println(listacuentas);
		
		ClienteNegocioImpl clientedaoimpl = new ClienteNegocioImpl();
		ArrayList<Cliente> listaclientes = (ArrayList<Cliente>) clientedaoimpl.readAll();
		
		ArrayList<Cliente> listaclientesactivos = (ArrayList<Cliente>) clientedaoimpl.getClientesActivos();
		request.setAttribute("listaclientes", listaclientesactivos);
		String Cbu = request.getParameter("inputCbu");
		
		if(request.getParameter("btnAsignar")!=null)
		{
		int dnicliente = Integer.parseInt(request.getParameter("inputDni"));
		System.out.println(cuentadaoimpl.contarCuenta(dnicliente));

		
		cuentaaux = cuentadaoimpl.Search(Cbu);
		cuentaaux.setDni(dnicliente);

	
		if(cuentadaoimpl.contarCuenta(dnicliente) < 4)
		{
			if(cuentadaoimpl.Modify(cuentaaux) == true)
				{
				System.out.println("Este tipo tiene menos de 3 cuentas, sta bien, pasale una");
				Movimiento movimiento = new Movimiento();
				MovimientoNegocioImpl movimientonegocioimpl = new MovimientoNegocioImpl();
				
				movimiento.setDni(dnicliente);
				movimiento.setUsuario("test");
				movimiento.setTipoMovimiento("ASIGNACION CUENTA");
				movimiento.setDescripcion("Asignacion de cuenta: 10.000 pesos");
				movimientonegocioimpl.insert(movimiento);
				estado = 1;
				request.setAttribute("estado", "true" );
			}
		} else { 
			System.out.println("este chabon tiene mas de 3 cuentas, esta loco!");
			request.setAttribute("estado", "false" );
		}
		
		}
		
		if(request.getParameter("volverPagina")!=null) {
			
			
			RequestDispatcher rd = request.getRequestDispatcher("Usuario.jsp");
			rd.forward(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Cuentas_Asignacion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("algo llego");
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Cuentas_Asignacion.jsp");
		rd.forward(request, response);
	}

}
