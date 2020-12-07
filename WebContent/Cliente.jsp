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
<title>Cliente - Menu de Opciones</title>
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

<h1> Menu de Opciones </h1>

<% String name=request.getParameter("userLogin");
request.setAttribute("miusuario", name);
%>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Pedido de Prestamo</th>
      <th scope="col">Pago de Prestamo</th>
      <th scope="col">Ver Historial de movimientos</th>
      <th scope="col">Realizar Transferencias</th>
      <th scope="col">Ver informacion del Cliente</th>
    </tr>
  </thead>
  <tbody>
    <tr>
    <td><a href="servletPrestamo?usuario=${miusuario}">Pedir Prestamo</a></td>
      <td><button type="submit" class="btn btn-primary"></button></td>
      <td><button type="submit" class="btn btn-primary">Pago Prestamo</button></td>
      <td><a href="servletClienteHistorial?usuario=${miusuario}">Ver Historial</a></td>
      <td><button type="submit" class="btn btn-primary">Transferencias</button></td>
      <td><button type="submit" class="btn btn-primary">Ver Informacion</button></td>
       
    </tr>
    </tr>
  </tbody>
</table>

</body>
</html>