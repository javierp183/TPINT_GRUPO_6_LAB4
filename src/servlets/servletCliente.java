package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import daoImpl.ClienteDaoImpl;

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
		// TODO Auto-generated method stub
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
			ClienteDaoImpl clientedaoimpl = new ClienteDaoImpl();
			
			if(request.getParameter("inputUpdate")!=null)
				{
					clientedaoimpl.modify(cliente);
					System.out.println("modificando data");
				}
			else
			{
				
				clientedaoimpl.insert(cliente);
				System.out.println("guardando data");
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("UsuarioBanco_Alta_Clientes.jsp");
		rd.forward(request, response);
	}

}