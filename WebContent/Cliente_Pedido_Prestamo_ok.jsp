<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cliente Banco - Prestamo satisfactorio - Banco Tecnologico</title>
</head>
<body>

<h1>Prestamo conconcedido, espere por su aprobacion : ${nombre} ${apellido}</h1>

<a href="servletPrestamo?btnPedirOtroPrestamo=1&usuario=${usuario}">Pedir otro prestamo</a>

<a href="servletPrestamo?usuario=${usuario}">Volver Menu Principal</a>




</body>
</html>