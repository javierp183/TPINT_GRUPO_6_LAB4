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
<title>Usuario Banco - Modificacion de Cuenta - Banco Tecnologico</title>
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

<h1>Modificacion de Cuenta</h1>

<div class="container">
 <div class="row">
 <form>
 	<label for="cars">Elegir Cuenta</label>
		<select name="cars" id="cars">
  			<option value="volvo">Cuenta A</option>
  			<option value="saab">Cuenta B</option>
		</select>
	 	<label for="cars">Elegir Usuario</label>
		<select name="cars" id="cars">
  			<option value="volvo">Usuario A</option>
  			<option value="saab">Usuario B</option>
		</select>  

  <button type="submit" class="btn btn-primary">Aceptar</button>
</form>
 </div>
</div>

</body>
</html>