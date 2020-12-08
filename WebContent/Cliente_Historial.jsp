<%@ page import="dominio.Movimiento" %>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente Banco - Historial de Movimientos - Banco Tecnologico</title>
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


<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Tipo de movimiento</th>
      <th scope="col">Descripcion</th>
    </tr>
  </thead>
  <tbody>
   
 
  <%
ArrayList<Movimiento> listaMovimientos = null;
if(request.getAttribute("listamovimientos")!=null)
{
	listaMovimientos = (ArrayList<Movimiento>) request.getAttribute("listamovimientos");
	for(Movimiento movimiento : listaMovimientos)
	{
%>
 <tr>
      <td scope="col"><%=movimiento.getFechanac() %> </td>
      <td scope="col"><%=movimiento.getTipoMovimiento() %></td>
      <td scope="col"><%=movimiento.getDescripcion() %></td>
          </tr>
<%
} }
%>

  </tbody>
</table>
<a href="servletPagoPrestamo?btnvolverPagina=${usuario}">Volver Menu Principal</a>


</body>
</html>