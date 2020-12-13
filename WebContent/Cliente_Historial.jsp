<%@ page import="dominio.Movimiento" %>
<%@ page import="dominio.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Cliente Historial por cuenta - Banco Tecnologico</title>

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

<table class="table table-dark">
  <thead>
    <tr>
      <th>
        Nombre y Apellido del Cliente
      </th>
      <th>
        Usuario 
      </th>
      <th>
        Cliente
      </th>
    </tr>
    </thead>
    <tbody>
      <tr>
        <td>
           ${nombre} ${apellido}
        </td>
        <td>
           ${usuario}
        </td>
        <td>
            <img src="/static/img/{{ context.6.operator.userid }}.jpg"  height="60" width="60">
        </td>
      </tr>
    </tbody>
</table>

<a onclick="addURL(this)" href="servletClienteHistorial?usuariopost=${usuario}">Listar Movimientos</a>

<%

ArrayList<Cuenta> listaCuentas = null;

if(request.getAttribute("listadecuentas")!=null)
{
	listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listadecuentas");
%>


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
			
			<option value=<%=cuenta.getCbu()%>><%= cuenta.getCbu()%> - <%=cajadeahorro %> - saldo: <%=cuenta.getSaldo() %></option>
			
	<%	} else {
		
		String cuentacorriente = "cuenta corriente";
		%>
		
		<option value=<%=cuenta.getCbu()%>><%= cuenta.getCbu()%> - <%=cuentacorriente %> - saldo: <%=cuenta.getSaldo() %></option>
		

	<option>no hay nada que asignar</option>
</select>


	<%
	}}}}
	%>
	
	

	

<table id="table_id" class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Tipo de movimiento</th>
      <th scope="col">Descripcion</th>
    </tr>
  </thead>
  <tbody>
  
 <%

ArrayList<Movimiento> listaMovimientos = null;

if(request.getAttribute("movimientos")!=null)
{
	listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("movimientos");
	for(Movimiento movimiento: listaMovimientos)
	{
%>
<tr>
<td><%=movimiento.getFechanac() %></td>
<td><%=movimiento.getTipoMovimiento() %>
<td><%=movimiento.getDescripcion() %>
</tr>

  </tbody>
</table>

<%}} %>
<a href="servletPagoPrestamo?btnvolverPagina=${usuario}">Volver Menu Principal</a>


</body>
</html>