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
<title>Lista de Cuentas - Baja de Cuenta - Banco Tecnologico</title>
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

<h1>Baja de Cuenta</h1>

<form>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Apellido</th>
      <th scope="col">Usuario Cliente</th>
      <th scope="col">Baja de Cliente</th>
      <th scope="col">Cuenta</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Javier</td>
      <td>Pereyra</td>
      <td>jpereyra</td>
      <td>00000001</td>
      <td><input type="checkbox"></input</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Daniel</td>
      <td>Thornton</td>
      <td>dthorton</td>
      <td>00000002</td>
      <td><input type="checkbox"></input</td>
    </tr>
  </tbody>
</table>

  <button type="submit" class="btn btn-primary">Dar de Baja</button>
</form>
<button type="submit" class="btn btn-primary">Volver a Pagina Principal</button>

</body>
</html>