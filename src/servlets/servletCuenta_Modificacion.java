package servlets;
import dominio.Cuenta;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.CuentaNegocioImpl;
import daoImpl.CuentaDaoImpl;

/**
 * Servlet implementation class servletCuenta_Modificacion
 */
@WebServlet("/servletCuenta_Modificacion")
public class servletCuenta_Modificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuenta_Modificacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("inputCBU"));
		
		if(request.getParameter("inputCBU")!=null)
		{
			Cuenta cuenta = new Cuenta();
			CuentaNegocioImpl cuentanegocioimpl = new CuentaNegocioImpl();
			cuenta = cuentanegocioimpl.Search(request.getParameter("inputCBU"));
			System.out.println(cuenta.getCbu());
			
			if(cuenta.getDni()==0)
			{
				System.out.println(cuenta.getDni());
				System.out.println("No tiene DNI");
				request.setAttribute("saldo", cuenta.getSaldo());
				request.setAttribute("CBU", cuenta.getCbu());
			}
			
			if(cuenta.getTipoCuenta()==0)
			{
				request.setAttribute("tipocuenta", "Caja de ahorro");
			}
			
			if(cuenta.getTipoCuenta()==1)
			{
				request.setAttribute("tipocuenta", "Cuenta corriente");
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Modificacion_Cuenta.jsp");
			rd.forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
