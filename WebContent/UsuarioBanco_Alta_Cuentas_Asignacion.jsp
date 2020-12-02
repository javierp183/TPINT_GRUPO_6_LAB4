<%@ page import="dominio.Cliente" %>
<%@ page import="dominio.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Asignacion de cuenta - Banco Tecnologico</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

				  
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$('#table_id').DataTable();
	});
</script>

<script type="text/javascript">

function readselectFunc() {


var selectedValue = document.getElementById("inputCBU");

return selectedValue.value;
}


function addURL(element)
{
	
	var leerCBU = readselectFunc();
    $(element).attr('href', function() {
        return this.href + '&inputCbu=' + leerCBU;
    });
}


</script>

</head>
<body>

</head>
<body>

<table class="table table-dark">
  <thead>
    <tr>
      <th>
        Nombre y Apellido del Usuario
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



<h1>Asignacion de cuentas a usuarios</h1>

 <form action="servletCuentaAsignacion" method="get">

	<button type="submit" class="btn btn-primary">Listar Usuarios y Cuentas</button>
	
</form>

	
	<table id="table_id" class="display">
		<thead>
			<tr>
				<th>Dni</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Asignar cuenta</th>
				<th></th>
			</tr>
		</thead>
		<tbody>

<%
ArrayList<Cliente> listaClientes = null;
ArrayList<Cuenta> listaCuentas = null;

if(request.getAttribute("listaclientes")!=null)
{
	listaClientes = (ArrayList<Cliente>) request.getAttribute("listaclientes");
	listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listacuentas");
	for(Cliente cliente : listaClientes)
	{
%>

 <% 
if(request.getAttribute("estado")!=null)
		{
	
%>

Cuenta Asignada!

<%

}
%>

<tr>
<td><%=cliente.getDni() %></td>
<td><%=cliente.getNombre()%></td>
<td><%=cliente.getApellido() %></td>
<td>

<label for="inputCbu">Seleccionar cuenta ( CBU ):</label>
 

 
 <select id="inputCBU">
	<% 
	if(listaCuentas!=null) {
		for(Cuenta cuenta: listaCuentas)
		{
			
			if(cuenta.getTipoCuenta()==0)
			{
				String cajadeahorro = "caja de ahorro";
			
			%>
			
			<option value=<%=cuenta.getCbu()%>><%= cuenta.getCbu()%> - <%=cajadeahorro %></option>
			
	<%	} else {
		
		String cuentacorriente = "cuenta corriente";
		%>
		
		<option value=<%=cuenta.getCbu()%>><%= cuenta.getCbu()%> - <%=cuentacorriente %></option>
		
	<%
	}
			
			
			
		} 
	
	
	%>
	
	<%	}else {%>
	<option>no hay nada que asignar</option>
	<%	}%>
	<option>no hay nada que asignar</option>
</select>

</td>

<td>

<a onclick="addURL(this)" href="servletCuentaAsignacion?btnAsignar=1&inputDni=<%=cliente.getDni() %>">Asignar Cuenta a Cliente</a>

</td>
</tr>


<%}}%>

</tbody>
</table>

		
	
	

 <form action="servletCuentaAsignacion" method="get">

	<button type="submit" class="btn btn-primary" name="volverPagina" value="1">Volver a Pagina Principal</button>
	
</form>




</body>
</html>