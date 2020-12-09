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
 <title>Baja de Cliente - Banco Tecnologico</title>
</head>
<body>

<title>Lista de Usuarios - Baja de Usuario - Banco Tecnologico</title>
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
 

<h1>Baja de Cliente</h1>

 <% 
if(request.getAttribute("estado")!=null)
{
	
%>

Cliente dado de baja!

<%
} else {
%>

No se pudo dar de baja el cliente!, por favor ingrese un DNI valido.

<% } %>

<form action="servletCliente" method="get">
 
 <div class="form-group">
    <label for="exampleInputEmail1">Ingrese DNI del cliente</label>
    <input type="input" class="form-control" name="inputDNIbaja" aria-describedby="emailHelp">
    <small id="emailHelp" class="form-text text-muted">DNI</small>
  </div>

  <button type="submit" class="btn btn-primary">Dar de Baja</button>
</form>

 <form action="servletCliente" method="get">

	<button type="submit" class="btn btn-primary" name="volverPagina" value="1">Volver a Pagina Principal</button>
	
</form>

</body>
</html>