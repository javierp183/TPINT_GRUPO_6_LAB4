package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.ClienteNegocioImpl;
import NegocioImpl.CuentaNegocioImpl;
import dominio.Cliente;
import dominio.Cuenta;

/**
 * Servlet implementation class servletCuenta
 */
@WebServlet("/servletCuenta")
public class servletCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCuenta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Baja de cuenta papurringui");
		Cuenta cuenta = new Cuenta();
		String inputCBUbaja = request.getParameter("inputCBUbaja");
		cuenta.setCbu(inputCBUbaja);
		CuentaNegocioImpl cuentadaoimpl = new CuentaNegocioImpl();
		
		if(request.getParameter("inputCBUbaja")!=null)
		{
			System.out.println("baja papi");
			cuentadaoimpl.Delete(cuenta);
			
			RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Baja_Cuenta.jsp");
			rd.forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alta de cuenta papurringui");
		Cuenta cuenta = new Cuenta();
		CuentaNegocioImpl neg = new CuentaNegocioImpl();
		
		neg.Insert(cuenta);
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Cuentas.jsp");
		rd.forward(request, response);
	}

	}


