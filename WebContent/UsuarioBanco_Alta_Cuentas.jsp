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
 
 <title>Alta de Cuenta - Banco Tecnologico</title>


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

<h1>Alta de Cuenta</h1>

 <% 
if(request.getAttribute("estado")!=null)
		{
	
%>

Cuenta Creada!

<%

}
%>

<div class="container">
 <div class="row">
 <form action="servletCuenta" method="post">
    <div class="form-group">
    <label for="inputSaldo">Saldo</label>
    <input type="input" class="form-control" name="inputSaldo" aria-describedby="emailHelp">
    <small id="emailHelp" class="form-text text-muted">Saldo a asignar a la cuenta - si no se ingresa un monto, 10 mil pesos seran los auto asignados -</small>
  </div>
   <div class="form-group">
    <label for="inputTipoCuenta">
    <select name="inputTipoCuenta">
     <option value=0> Caja de Ahorro </option>
     <option value=1> Cuenta Corriente </option>
    </select> </label>
    <small id="emailHelp" class="form-text text-muted">Cuenta Corriente o Cuenta Sueldo</small>
  <button type="submit" class="btn btn-primary">Generar Cuenta</button>
</form>
 </div>
</div>

 <form action="servletCuentaAsignacion" method="get">

	<button type="submit" class="btn btn-primary" name="volverPagina" value="1">Volver a Pagina Principal</button>
	
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>