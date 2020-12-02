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
import dominio.Cliente;
import dominio.Cuenta;
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
		System.out.println("todo bien?");
		System.out.println("listando cuentas");
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
		request.setAttribute("listaclientes", listaclientes);
		String Cbu = request.getParameter("inputCbu");
		
		if(request.getParameter("btnAsignar")!=null)
		{
		int dnicliente = Integer.parseInt(request.getParameter("inputDni"));

		
		cuentaaux = cuentadaoimpl.Search(Cbu);
		cuentaaux.setDni(dnicliente);
		
		System.out.println("cbu");
		System.out.println(Cbu);
		System.out.println("Dni");
		System.out.println(dnicliente);
	
		
			if(cuentadaoimpl.Modify(cuentaaux) == true)
				{
					estado = 1;
					request.setAttribute("estado", estado );
			}
		
		}
		
		if(request.getParameter("volverPagina")!=null) {
			System.out.println("quiere volver, con la frente marchita");
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
