<%@ page import="dominio.Prestamo" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,
					  initial-scale=1, shrink-to-fit=no">
					  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
 crossorigin="anonymous">
 
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>


 
<title>Autorizacion de prestamo - Administrador - Banco Tecnologico</title>
</head>
<body>

<table class="table table-dark">
  <thead>
    <tr>
      <th>
        Nombre y Apellido del Administrador
      </th>
      <th>
        Usuario 
      </th>
      <th>
        Operador
      </th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td>
           Javier Pereyra
        </td>
        <td>
           Admin123
        </td>
        <td>
            <img src="/static/img/{{ context.6.operator.userid }}.jpg"  height="60" width="60">
        </td>
      </tr>
    </tbody>
</table>

<form>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Monto a aprobar</th>
      <th scope="col">Plan de pago ( En cuotas )</th>
      <th scope="col">Valor de la cuota</th>
      <th scope="col">Autorizacion ( Estado )</th>
    </tr>
  </thead>
  <tbody>
   
 <%
ArrayList<Prestamo> listaPrestamos = null;
if(request.getAttribute("prestamossinaprobar")!=null)
{
	listaPrestamos = (ArrayList<Prestamo>) request.getAttribute("prestamossinaprobar");
	for(Prestamo prestamo : listaPrestamos)
	{
%>
	<tr>
      <td><%=prestamo.getNombre() %> </td>
      <td><%=prestamo.getApellido() %></td>
      <td><%=prestamo.getMontoTotal() %></td>
      <td><%=prestamo.getNumCuotas() %></td>
      <td><%=prestamo.getMontopormes() %></td>
     
       <a  href="servletAdministrador?btnHabilitarPrestamo=1&txtPrestamoID=<%=prestamo.getIdPrestamo()%>">Aprobar Prestamo</a>
      </td>
      </tr>

<%
}}
%>
    
  </tbody>
</table>

  <button type="submit" class="btn btn-primary">Autorizar</button>
</form>




<button type="submit" class="btn btn-primary">Volver a Pagina Principal</button>

</body>
</html>