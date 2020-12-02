package servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.ClienteNegocioImpl;
import NegocioImpl.CuentaNegocioImpl;
import NegocioImpl.UsuarioNegocioImpl;
import dominio.Cliente;
import dominio.Usuario;

/**
 * Servlet implementation class servletLogin
 */
@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
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
		String usuario = request.getParameter("userLogin").toString();
        String password = request.getParameter("passLogin").toString();
        Cliente cliente = new Cliente();
        Usuario usuariobanco = new Usuario();
        ClienteNegocioImpl clientedaoimpl = new ClienteNegocioImpl();
        UsuarioNegocioImpl usuariodaoimpl = new UsuarioNegocioImpl();
        
        if(request.getParameter("userLogin")!=null)
        {
        	
        	cliente = clientedaoimpl.getTipoUsuario(usuario);
        	if(cliente.getTipoUsuario() == 0) {
        		if(cliente.getPassword().equals(password))
        		{
        			
        			request.setAttribute("nombre", cliente.getNombre());
        			request.setAttribute("apellido", cliente.getApellido());
        			request.setAttribute("usuario", cliente.getUsuario());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Cliente.jsp");
                    requestDispatcher.forward(request, response);
        		}
        		
        	}
        	
        	usuariobanco = usuariodaoimpl.getTipoUsuario(usuario);
        	if(usuariobanco.getTipoUsuario() == 1) {
        		if(usuariobanco.getPassword().equals(password)) 
        		{
        			request.setAttribute("nombre", usuariobanco.getNombre());
        			request.setAttribute("apellido", usuariobanco.getApellido());
        			request.setAttribute("usuario", usuariobanco.getUsuario());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Usuario.jsp");
                    requestDispatcher.forward(request, response);
        		}
        	}
        }
             
        //request.getSession().setAttribute("user", mail);
        //request.getSession().setAttribute("pass", pass);
        
        
        
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Usuario.jsp");
        requestDispatcher.forward(request, response);
        
//        Cliente client = negocio.getClientePorMail(mail, pass);
//        System.out.println(client.toString());
//        if(!mail.isEmpty() && !pass.isEmpty()) {
//            if(client.getCorreoElectronico() == mail && client.getPassword() == pass) {
//                System.out.println("True");
//
//            }else if(client.getCorreoElectronico() == "Sin Correo") {
//                System.out.println("False");
//            }
//        } 
//                
//        //doGet(request, response);
//        RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//        rd.forward(request, response);
	}

}
