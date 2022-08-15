<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>ACCUEIL</title>
</head>
<body>  

<nav class="navbar navbar-expand-lg navbar-light bg-success">
   <p style="font-size: 30px; color:white; margin-left:40px">Gestion des Salles de classe</p>
  
   <button type="button" class="btn btn-success" style="margin-left:860px"><a style="color: white; text-decoration: none;" href = "/GestionDeClasse/login"><i class="bi bi-power fs-3" style="color:white;"></i></a></button>
</nav><br><br><br>
   
<div class="container">
	<div class="row">
	     	<div class="col-4"></div>
	     	<div class="col-4">
	     	
	     		 <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-start" id="menu">
      
			        	<li>
			                <a style ="color: green; font-size: 50px" href="/GestionDeClasse/accueil" class="nav-link text-truncate">
			                    <i class="bi-house" style ="font-size: 50px"></i><span class="ms-1 d-none d-sm-inline">Accueil</span></a>
			            </li>
	     		</ul>
	     	</div>
	     	<div class="col-4"></div>
	</div>
	<div class="row">
	     	<div class="col-4"></div>
	     	<div class="col-4">
	     	
	     		 <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-start" id="menu">
      
			        	<li>
			                <a style ="color: green; font-size: 50px" href="/GestionDeClasse/prof" class="nav-link text-truncate">
			                    <i class="bi-people" style ="font-size: 50px"></i><span class="ms-1 d-none d-sm-inline">Prof</span></a>
			            </li>
	     		</ul>
	     	</div>
	     	<div class="col-4"></div>
	</div>
	<div class="row">
	     	<div class="col-4"></div>
	     	<div class="col-4">
	     	
	     		 <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-start" id="menu">
      
			        	<li>
			                <a style ="color: green; font-size: 50px" href="/GestionDeClasse/salle" class="nav-link text-truncate">
			                    <i class="bi-building" style ="font-size: 50px"></i><span class="ms-1 d-none d-sm-inline">Salle</span></a>
			            </li>
	     		</ul>
	     	</div>
	     	<div class="col-4"></div>
	</div>
	<div class="row">
	     	<div class="col-4"></div>
	     	<div class="col-4">
	     	
	     		 <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-start" id="menu">
      
			        	<li>
			                <a style ="color: green; font-size: 50px" href="/GestionDeClasse/occuper" class="nav-link text-truncate">
			                    <i class="bi-card-checklist" style ="font-size: 50px"></i><span class="ms-1 d-none d-sm-inline">Occuper</span></a>
			            </li>
	     		</ul>
	     	</div>
	     	<div class="col-4"></div>
	</div>                
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>









