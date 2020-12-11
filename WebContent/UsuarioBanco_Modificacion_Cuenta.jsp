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
 
 <title>Modificacion de Cuenta - Banco Tecnologico</title>


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

<h1>Modificando Cuenta</h1>


 <% 
if(request.getAttribute("estado")=="true")
		{
	
%>

Cuenta Modificada!

<%

}
%>

 <% 
if(request.getAttribute("estado")=="false")
		{
	
%>

No se a podido modificar la cuenta, revise por favor el CBU y tambien 
el tipo de cuenta. Muchas gracias

<%

}
%>


 <form action="servletCuenta_Modificacion" method="get">
 	<label for="exampleInputEmail1">CBU</label>
	<input type="input" class="form-control" name="inputCBU" aria-describedby="emailHelp">
	<button type="submit" class="btn btn-primary">Ingrese CBU a editar</button>
	<small id="emailHelp" class="form-text text-muted">Por favor Ingrese el CBU a editar</small>
</form>



<div class="container">
 <div class="row">
 <form action="servletCuenta_Modificacion" method="post">
   <div class="form-group">
    <label for="exampleInputEmail1">Cbu a Modificar</label>
    <input type="input" class="form-control" name="inputCbuModificar" aria-describedby="emailHelp" value="${CBU}" readonly>
    <small id="emailHelp" class="form-text text-muted">CBU a Modificar.</small>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Saldo</label>
    <input type="input" class="form-control" name="inputSaldo" aria-describedby="emailHelp" value="${saldo}">
    <small id="emailHelp" class="form-text text-muted">Por favor ingresar nuevo Saldo.</small>
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Tipo de Cuenta</label>
	<input type="input" class="form-control" name="inputTipoCuenta" aria-describedby="emailHelp" value="${tipocuenta}">
    <small id="emailHelp" class="form-text text-muted">Caja de Ahorro|Cuenta Corriente ( escriba el nuevo tipo de cuenta )</small>
  </div>
 </div>

  <button type="submit" onclick="myFunction()" class="btn btn-primary">Modificar Cuenta</button>
</form>
 </div>
</div>



 <form action="servletClienteModificacion" method="get">

	<button type="submit" class="btn btn-primary" name="volverPagina" value="1">Volver a Pagina Principal</button>
	
</form>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>