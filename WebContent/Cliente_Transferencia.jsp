<%@ page import="dominio.Cliente" %>
<%@ page import="dominio.Cuenta" %>
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


	var selectedCuotas = document.getElementById("inputCBUexterno");

	return selectedCuotas.value;
}


function addURL(element)
{
	
	var leerCBU = readselectFunc();
	var leerMonto = readMonto();
	var leerCuotas = readCuotas();
    $(element).attr('href', function() {
        return this.href + '&inputCBU=' + leerCBU + '&inputMonto=' + leerMonto + '&inputCBUexterno=' + leerCuotas;
    });
}

</script>
 
 
<title>Cliente Banco - Transferencias - Banco Tecnologico</title>
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

<h1>Transferencia a propia cuenta o hacia otras cuentas</h1>

<div class="container">
 <div class="row">
 <form>
<div>
<label for="cars">Seleccionar Cuenta</label>
<select name="inputCBU" id="inputCBU">
  
 <%
ArrayList<Cuenta> listaCuentas = null;

if(request.getAttribute("listacuentas")!=null)
{
	listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listacuentas");
	for(Cuenta cuenta : listaCuentas)
	{
%>

	<option value=<%=cuenta.getCbu() %>><%=cuenta.getCbu() %> - Tipo Cuenta: <%=cuenta.getTipoCuenta() %> - Saldo: <%=cuenta.getSaldo() %></option>

<%
	}}
%>

</select>
</div>
   <div>
	 <input type="text" class="form-control" id="inputCBUexterno" aria-describedby="cbuNumber">
	 <small id=""cbuNumber"" class="form-text text-muted">Ingrese CBU del otro cliente</small>
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Monto a Transferir</label>
    <input type="text" class="form-control" name="inputMonto" id="inputMonto" aria-describedby="emailHelp">
  </div>
  
  <button type="submit" class="btn btn-primary">Transferir</button>
  <a onclick="addURL(this)" href="servletCliente_Transferencia?btnTransferir=1">Click para Transferir</a>
</form>
 </div>
</div>

<button type="submit" class="btn btn-primary">Volver a Pagina Principal</button>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>