<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>LOGIN</title>
</head>
<body style="background-color:#f1f1f1">
<div class="container-fluid">
    <div class="row">
        <div class="col min-vh-100 py-3">     
				<div class="container">
	<div class="row">
		<div class= "col-4">
		</div>
		<div class= "col-4">
			<div class="card" style="width: 18rem; margin-top: 150px">
				 <div class="card-header" style="text-align: center; background-color: green">
    				<span style="color: white; font-size: 20px; font-weight: bold;">Identifiez-vous</span>
 				 </div>
			  <div class="card-body">
			    <form action="/GestionDeClasse/login" method="post">
								<table style="text-align: center;" align="center">
									<tr>
										<td><input type="text" name="login" placeholder="Nom d'utilisateur" class="form-control" required></td>
									</tr>
									<tr>
										<td><input type="password" name="password" placeholder="Mot de passe" class="form-control" required></td>
									</tr>
									<tr>
									</tr>
								</table><br>
									<div style="margin-left:200px;">
										<button type="submit" class="btn btn-outline-success"><i class="fs-8 bi-arrow-right"  role="submit"></i></button>
									</div>
										<input type="hidden" value="login" name="action">	
					</form>
				</div>
		</div>
  </div>
</div>
</div>
        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>









