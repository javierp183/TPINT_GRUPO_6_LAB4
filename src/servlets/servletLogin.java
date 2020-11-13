package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.ClienteDaoImpl;
import dominio.Cliente;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDaoImpl negocio;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String mail = request.getParameter("emailLogin").toString();
		String pass = request.getParameter("passLogin").toString();
		
		System.out.println(mail);
		System.out.println(pass);
		
		if(mail !=null && pass != null) {
			Cliente client = negocio.getClientePorMail(mail, pass);
			if(client.getCorreoElectronico() == mail && client.getPassword() == pass) {
				System.out.println("Hay correo en la db");
				
			}else if(client.getCorreoElectronico() == "Sin Correo") {
				System.out.println("No hay correo en la db");
			}
		}
		//doGet(request, response);
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.forward(request, response);
	}

}
