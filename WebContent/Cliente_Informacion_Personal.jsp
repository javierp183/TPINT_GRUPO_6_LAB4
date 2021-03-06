<%@ page import="dominio.Cliente" %>
<%@ page import="dominio.Cuenta" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<title>Cliente - Informacion Personal</title>
</head>
<body>


<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<div class="container">
	<div class="row">
		<div class="col-lg-3 col-sm-6">

            <div class="card hovercard">
                <div class="cardheader">

                </div>
                <div class="avatar">
                    <img alt="" src="http://lorempixel.com/100/100/people/9/">
                </div>
                <div class="info">
                    <div class="title">
                        <a target="_blank" href="https://scripteden.com/">${nombre} ${apellido}</a>
                    </div>
                    <div class="desc">Email: ${email}</div>
                    <div class="desc">DNI: ${dni}</div>
                    <div class="desc">Usuario: ${usuario}</div>
                </div>
                <div class="bottom">
                    <a class="btn btn-primary btn-twitter btn-sm" href="https://twitter.com/webmaniac">
                        <i class="fa fa-twitter"></i>
                    </a>
                    <a class="btn btn-danger btn-sm" rel="publisher"
                       href="https://plus.google.com/+ahmshahnuralam">
                        <i class="fa fa-google-plus"></i>
                    </a>
                    <a class="btn btn-primary btn-sm" rel="publisher"
                       href="https://plus.google.com/shahnuralam">
                        <i class="fa fa-facebook"></i>
                    </a>
                    <a class="btn btn-warning btn-sm" rel="publisher" href="https://plus.google.com/shahnuralam">
                        <i class="fa fa-behance"></i>
                    </a>
                </div>
            </div>

        </div>

	</div>
</div>


<table id="table_id" class="display">
<thead>
	<tr>
		<th>Cuentas ( Numero de CBU )</th>
		<th>Tipo</th>
		<th>Disponible</th>
	</tr>
</thead>
<tbody>

<%
ArrayList<Cuenta> listaCuentas = null;

if(request.getAttribute("listacuentas")!=null)
{
	listaCuentas = (ArrayList<Cuenta>) request.getAttribute("listacuentas");
%>



<%
for(Cuenta cuenta: listaCuentas)
		{
	%>
<tr>
<td><%=cuenta.getCbu() %></td>
<td> <%=cuenta.getTipoCuenta() %></td>
<td><%=cuenta.getSaldo() %></td>
</tr>

<%
		}}
%>




</tbody>
</table>



<a href="servletCliente_Transferencia?btnvolverPagina=${usuario}">Volver Menu Principal</a>

</body>
</html>