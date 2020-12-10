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
import NegocioImpl.MovimientoNegocioImpl;
import NegocioImpl.UsuarioNegocioImpl;
import dominio.Cliente;
import dominio.Cuenta;
import dominio.Movimiento;
import dominio.Usuario;

/**
 * Servlet implementation class servletCliente
 */
@WebServlet("/servletCliente")
public class servletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("usuario")!=null)
		{
			// Obtener Datos Operador

			

			RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Clientes.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getParameter("bntBaja")!=null)
		{
			Usuario usuario = new Usuario();
			UsuarioNegocioImpl usuarionegocioimpl = new UsuarioNegocioImpl();
			
			
			usuario = usuarionegocioimpl.getTipoUsuario(request.getParameter("usuariobajacliente"));
			System.out.println(usuario.getUsuario());
			request.setAttribute("nombre", usuario.getNombre());
			request.setAttribute("apellido", usuario.getApellido());
			request.setAttribute("usuario", usuario.getUsuario());
			
			System.out.println(request.getParameter("usuariobajacliente"));
			RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Baja_Cliente.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("volverPagina")!=null) {
			System.out.println("quiere volver, con la frente marchita");
			RequestDispatcher rd = request.getRequestDispatcher("Usuario.jsp");
			rd.forward(request, response);
		}
		
		Cliente cliente = new Cliente();
		try {
		int inputDNIbaja = Integer.parseInt(request.getParameter("inputDNIbaja"));
		cliente.setDni(inputDNIbaja);
		}
		
		catch(Exception e)
		{
			System.out.println("fallo todo!!!");
		}
		
		ClienteNegocioImpl clientedaoimpl = new ClienteNegocioImpl();
		
		if(request.getParameter("inputDNIbaja")!=null)
		{
			System.out.println("baja papi");
			if(clientedaoimpl.delete(cliente) == true) {
				request.setAttribute("estado", 1);
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Baja_Cliente.jsp");
			rd.forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
		if(request.getParameter("inputDNI")!=null)
		{
			int inputDNI = Integer.parseInt(request.getParameter("inputDNI"));
			String inputUsuario = request.getParameter("inputUsuario");
			String inputCuil = request.getParameter("inputCuil");
			String inputNombre = request.getParameter("inputNombre");
			String inputApellido = request.getParameter("inputApellido");
			String inputSexo = request.getParameter("inputSexo");
			String inputNacionalidad = request.getParameter("inputNacionalidad");
			String inputFechaNac = request.getParameter("inputFechaNac");
			String inputDireccion = request.getParameter("inputDireccion");
			String inputLocalidad = request.getParameter("inputLocalidad");
			String inputProvincia = request.getParameter("inputProvincia");
			String inputEmail = request.getParameter("inputEmail");
			String inputTelefono = request.getParameter("inputTelefono");
			String inputPassword = request.getParameter("inputPassword");
			String inputPassword2 = request.getParameter("inputPassword2");
			boolean estado = false;
			String usuario = request.getParameter("inputUsuario");
			
			if(inputPassword.equals(inputPassword2))
			{
				if(inputPassword.length() == 8)
				{
				System.out.println("misma clave");
				
				Cliente cliente = new Cliente();
				cliente.setDni(inputDNI);
				cliente.setUsuario(inputUsuario);
				cliente.setCuil(inputCuil);
				cliente.setNombre(inputNombre);
				cliente.setApellido(inputApellido);
				cliente.setSexo(inputSexo);
				cliente.setNacionalidad(inputNacionalidad);
				cliente.setFechaNac(inputFechaNac);
				cliente.setDireccion(inputDireccion);
				cliente.setLocalidad(inputLocalidad);
				cliente.setProvincia(inputProvincia);
				cliente.setCorreoElectronico(inputEmail);
				cliente.setTelefono(inputTelefono);
				cliente.setPassword(inputPassword);
				cliente.setTipoUsuario(0);
				ClienteNegocioImpl neg = new ClienteNegocioImpl();
				neg.insert(cliente);
				estado = true;
				Movimiento movimiento = new Movimiento();
				MovimientoNegocioImpl movimientonegocioimpl = new MovimientoNegocioImpl();
				
				movimiento.setDni(inputDNI);
				movimiento.setUsuario(inputUsuario);
				movimiento.setTipoMovimiento("ALTA");
				movimiento.setDescripcion("Alta de cuenta");
				movimientonegocioimpl.insert(movimiento);
				
				
				
				
				request.setAttribute("estado", "true");
				request.setAttribute("usuario", usuario);
				RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Clientes.jsp");
				rd.forward(request, response);
				} else {
					System.out.println("no es la misma clave capo!!");
					estado = false;
					request.setAttribute("estado", "false");
					request.setAttribute("usuario", usuario);
					RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Clientes.jsp");
					rd.forward(request, response);
					
				}
			}

		}
		

		
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Clientes.jsp");
		rd.forward(request, response);
	}

}
