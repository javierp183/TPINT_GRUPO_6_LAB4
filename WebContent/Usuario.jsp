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

<title>Usuario - Menu de Opciones</title>
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
           jpereyra
        </td>
        <td>
            <img src="/static/img/{{ context.6.operator.userid }}.jpg"  height="60" width="60">
        </td>
      </tr>
    </tbody>
</table>

<h1> Menu de Opciones </h1>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Asignar cuenta</th>
      <th scope="col">Alta Cliente</th>
      <th scope="col">Baja Cliente</th>
      <th scope="col">Modificacion Cliente</th>
      <th scope="col">Alta Cuenta</th>
      <th scope="col">Modificar Cuenta</th>
      <th scope="col">Baja Cuenta</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><button type="submit" class="btn btn-primary">Asignar</button></td>
      <td><button type="submit" class="btn btn-primary">Alta</button></td>
      <td><button type="submit" class="btn btn-primary">Baja</button></td>
      <td><button type="submit" class="btn btn-primary">Modificacion</button></td>
      <td><button type="submit" class="btn btn-primary">Alta Cuenta</button></td>
      <td><button type="submit" class="btn btn-primary">Modificar Cuenta</button></td>
      <td><button type="submit" class="btn btn-primary">Baja Cuenta</button></td>
    </tr>
    </tr>
  </tbody>
</table>

</body>
</html>