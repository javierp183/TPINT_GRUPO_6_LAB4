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
 
 <title>Alta de Cliente - Banco Tecnologico</title>


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

<h1>Modificando Cliente</h1>

 <form action="servletClienteModificacion" method="get">
 	<label for="exampleInputEmail1">DNI</label>
	<input type="input" class="form-control" name="inputDNI" aria-describedby="emailHelp">
	<button type="submit" class="btn btn-primary">Traer usuario a editar</button>
	<small id="emailHelp" class="form-text text-muted">Por favor ingresar DNI.</small>
</form>

 <% 
if(request.getAttribute("estado")!=null)
{
	
%>

Cliente Modificada!

<%

}
%>

<div class="container">
 <div class="row">
 <form action="servletClienteModificacion" method="post">
 
  <div class="form-group">
    <label for="exampleInputEmail1">DNI</label>
    <input type="input" class="form-control" name="inputDNI" aria-describedby="emailHelp" value=${dni}>
    <small id="emailHelp" class="form-text text-muted">Por favor ingresar DNI.</small>
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Usuario</label>
    <input type="input" class="form-control" name="inputUsuario" aria-describedby="emailHelp" value=${usuario}>
    <small id="emailHelp" class="form-text text-muted">Ingrese nombre de Usuario para el nuevo Cliente</small>
  </div>
   <div class="form-group">
    <label for="exampleInputEmail1">Cuil</label>
    <input type="input" class="form-control" name="inputCuil" aria-describedby="emailHelp" value=${cuil}>
    <small id="emailHelp" class="form-text text-muted">Ingrese numero de CUIL</small>
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Nombre</label>
    <input type="input" class="form-control" name="inputNombre" aria-describedby="emailHelp" value=${nombre}>
    <small id="emailHelp" class="form-text text-muted">Ingrese Nombre de Cliente</small>
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Apellido</label>
    <input type="input" class="form-control" name="inputApellido" aria-describedby="emailHelp" value=${apellido}">
    <small id="emailHelp" class="form-text text-muted">Ingrese Apellido de Cliente</small>
  </div>
     <div class="form-group">
    <label for="exampleInputEmail1">Sexo</label>
    <input type="input" class="form-control" name="inputSexo" aria-describedby="emailHelp" value=${sexo}>
    <small id="emailHelp" class="form-text text-muted">Ingrese el Sexo(M|F)</small>
  </div>
      <div class="form-group">
    <label for="exampleInputEmail1">Nacionalidad</label>
    <input type="input" class="form-control" name="inputNacionalidad" aria-describedby="emailHelp" value=${nacionalidad}>
    <small id="emailHelp" class="form-text text-muted">Ingrese la Nacionalidad</small>
  </div>
     <div class="form-group">
    <label for="exampleInputEmail1">Fecha de nacimiento</label>
    <input type="input" class="form-control" name="inputFechaNac" aria-describedby="emailHelp" value=${fechanac}>
    <small id="emailHelp" class="form-text text-muted">Fecha de Nacimiento.-</small>
  </div>
     <div class="form-group">
    <label for="exampleInputEmail1">Direccion</label>
    <input type="input" class="form-control" name="inputDireccion" aria-describedby="emailHelp" value=${direccion}>
    <small id="emailHelp" class="form-text text-muted">Ingrese Direccion del cliente</small>
  </div>
      <div class="form-group">
    <label for="exampleInputEmail1">Localidad</label>
    <input type="input" class="form-control" name="inputLocalidad" aria-describedby="emailHelp" value=${localidad}>
    <small id="emailHelp" class="form-text text-muted">Ingrese Localidad</small>
  </div>
       <div class="form-group">
    <label for="exampleInputEmail1">Provincia</label>
    <input type="input" class="form-control" name="inputProvincia" aria-describedby="emailHelp" value=${provincia}>
    <small id="emailHelp" class="form-text text-muted">Ingrese Nombre de la Provincia</small>
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Correo Electronico</label>
    <input type="input" class="form-control" name="inputEmail" aria-describedby="emailHelp" value=${email}>
    <small id="emailHelp" class="form-text text-muted">Ingrese Correo Electronico</small>
  </div>
       <div class="form-group">
    <label for="exampleInputEmail1">Telefono</label>
    <input type="input" class="form-control" name="inputTelefono" aria-describedby="emailHelp" value=${telefono}>
    <small id="emailHelp" class="form-text text-muted">Ingrese Telefono</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Clave de acceso</label>
    <input type="password" class="form-control" name="inputPassword" value=${password}>
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Confirmar clave de acceso</label>
    <input type="password" class="form-control" name="inputPassword2" value=${password}>
  </div>
    </div>
    <div class="form-group">
    <label for="exampleInputPassword1">Confirmar clave de acceso</label>
    <input type="hidden" value=1 class="form-control" name="inputUpdate" value=1>
  </div>
    </div>
  <button type="submit" class="btn btn-primary">Modificar Cliente</button>
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