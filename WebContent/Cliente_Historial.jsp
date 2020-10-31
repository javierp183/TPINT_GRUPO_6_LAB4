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

Seleccionar cuenta: 
 	<label for="cars">Elegir Tipo de Cuenta:</label>
		<select name="cars" id="cars">
  			<option value="volvo">Caja de ahorro</option>
  			<option value="saab">Cuenta Corriente</option>
		</select> <button type="submit" class="btn btn-primary">Aceptar</button>

<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Fecha</th>
      <th scope="col">Concepto</th>
      <th scope="col">Debitos</th>
      <th scope="col">Creditos</th>
      <th scope="col">Saldo</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>1</td>
      <td>1/17/2020</td>
      <td>TRANSF ACC B</td>
      <td>200</td>
      <td>0</td>
      <td>1000000</td>
    </tr>
    <tr>
      <th scope="row">1</th>
      <td>2</td>
      <td>1/8/2020</td>
      <td>TRANSF ACC A</td>
      <td>200</td>
      <td>0</td>
      <td>1000000</td>
    </tr>
  </tbody>
</table>

</body>
</html>