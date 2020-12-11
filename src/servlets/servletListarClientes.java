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
import dominio.Cliente;

/**
 * Servlet implementation class servletListarClientes
 */
@WebServlet("/servletListarClientes")
public class servletListarClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletListarClientes() {
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
			
		
		System.out.println("parastes aca macho!");
		System.out.println(request.getParameter("usuario"));
		ClienteNegocioImpl clientedaoimpl = new ClienteNegocioImpl();
		ArrayList<Cliente> listaclientesactivos = (ArrayList<Cliente>) clientedaoimpl.getClientesActivos();
		
		request.setAttribute("listaclientes", listaclientesactivos);
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Listar_Clientes.jsp");
		rd.forward(request, response);
		
		}
		
		if(request.getParameter("bntvolverPagina")!=null) {
			System.out.println("este muchacho quiere volver a la pagina principal?");
			
			RequestDispatcher rds = request.getRequestDispatcher("Usuario.jsp");
			rds.forward(request, response);
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
