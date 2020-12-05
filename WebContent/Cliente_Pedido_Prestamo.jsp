<%@ page import="dominio.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,
					  initial-scale=1, shrink-to-fit=no">
					  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
 integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
 crossorigin="anonymous">


<title>Cliente Banco - Pedido de Prestamo - Banco Tecnologico</title>
</head>
<body>

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

function readMonto() {


	var MontoValue = document.getElementById("inputMonto");

	return MontoValue.value;
}

function readCuotas() {


	var selectedCuotas = document.getElementById("inputCuotas");

	return selectedCuotas.value;
}


function addURL(element)
{
	
	var leerCBU = readselectFunc();
	var leerMonto = readMonto();
	var leerCuotas = readCuotas();
    $(element).attr('href', function() {
        return this.href + '&inputCbu=' + leerCBU + '&inputMonto=' + leerMonto + '&inputCuotas=' + leerCuotas;
    });
}

</script>

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
        Operador
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

<h1>Pedido de prestamo</h1>

<%
ArrayList<Cuenta> listaCuentas = null;

if(request.getAttribute("listacuentas")!=null)
{
	listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listacuentas");

}
%>


<div class="container">
 <div class="row">
 <form  action="servletPrestamo" method="get">
  <div>
  
  
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
			<h1>test</h1>
	<%	} else {
		
		String cuentacorriente = "cuenta corriente";
		%>
		
		<option value=<%=cuenta.getCbu()%>><%= cuenta.getCbu()%> - <%=cuentacorriente %></option>
		
	<%
	}		
		}
	%>

  </div>
	<%	}else {%>
	<option>no hay nada que asignar</option>
	<%	}%>
	<option>no hay nada que asignar</option>
</select>

<%
if(listaCuentas!=null) {
%>


<div class="container">
 <div class="row">
 <form  action="servletPrestamo" method="get">
   <div>
 	<label for="ccuotasars">Cuotas</label>
		<select name="inputCuotas" id="inputCuotas">
  			<option value="12">12</option>
  			<option value="18">18</option>
		</select> 
  </div>
   <div class="form-group">
    <label for="inputMonto">Monto De Prestamo</label>
    <input type="input" class="form-control" name="inputMonto" id="inputMonto" aria-describedby="emailHelp">
    <small id="emailHelp" class="form-text text-muted">Sin interes</small>
  </div>
 
  <a onclick="addURL(this)" href="servletPrestamo?btnAsignar=1&inputDni=${dnidelcliente}">Pedir Prestamo</a>
  
</form>
 </div>
</div>
<%
}
%>


<button type="submit" class="btn btn-primary" name="volverPagina" value="1">Volver a Pagina Principal</button>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>