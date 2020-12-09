package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NegocioImpl.ClienteNegocioImpl;
import dominio.Cliente;

/**
 * Servlet implementation class servletClienteModificacion
 */
@WebServlet("/servletClienteModificacion")
public class servletClienteModificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletClienteModificacion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean estado = false;
		Cliente cliente = new Cliente();
		ClienteNegocioImpl clientenegocioimpl = new ClienteNegocioImpl();
		
		
		if(request.getParameter("inputDNI")!=null)
		{
		cliente = clientenegocioimpl.getClientePorUsuario(Integer.parseInt(request.getParameter("inputDNI")));
		System.out.println(request.getParameter("inputDNI"));
		request.setAttribute("dni", request.getParameter("inputDNI"));
		request.setAttribute("usuario", cliente.getUsuario());
		request.setAttribute("cuil", cliente.getCuil());
		request.setAttribute("nombre", cliente.getNombre());
		request.setAttribute("apellido", cliente.getApellido());
		request.setAttribute("sexo", cliente.getSexo());
		request.setAttribute("nacionalidad", cliente.getNacionalidad());
		request.setAttribute("fechanac", cliente.getFechaNac());
		request.setAttribute("direccion", cliente.getDireccion());
		request.setAttribute("localidad", cliente.getLocalidad());
		request.setAttribute("provincia", cliente.getProvincia());
		request.setAttribute("email", cliente.getCorreoElectronico());
		request.setAttribute("telefono", cliente.getTelefono());
		request.setAttribute("password", cliente.getPassword());
		
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Modificacion_Cliente.jsp");
		rd.forward(request, response);
		}
		
		if(request.getParameter("inputUpdate")!=null)
		{
			System.out.println("hay que modificar el usuario");
			estado = true;
			
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
			String usuario = request.getParameter("inputUsuario");
			
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
			
			neg.modify(cliente);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Modificacion_Cliente_ok.jsp");
			rd.forward(request, response);
		}
		
		if(request.getParameter("volverPagina")!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Usuario.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("estado", estado);
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Modificacion_Cliente.jsp");
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
