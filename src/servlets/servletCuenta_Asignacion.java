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
import dominio.Cliente;
import dominio.Cuenta;

/**
 * Servlet implementation class servletCuenta_Asignacion
 */
@WebServlet("/servletCuenta_Asignacion")
public class servletCuenta_Asignacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuenta_Asignacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("listando cuentas");
		CuentaNegocioImpl cuentadaoimpl = new CuentaNegocioImpl();
		Cuenta cuenta = new Cuenta();
		ArrayList<Cuenta> listacuentas = (ArrayList<Cuenta>) cuentadaoimpl.ReadAll();
		request.setAttribute("listacuentas", listacuentas);
		System.out.println(listacuentas);
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Cuentas_Asignacion.jsp");
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
