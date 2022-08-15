<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<title>FORMULAIRE</title>
</head>
<body style="background-color:#f1f1f1">
<div class="offcanvas offcanvas-start w-25" tabindex="-1" id="offcanvas" data-bs-keyboard="false" data-bs-backdrop="false">
    <div class="offcanvas-header" style="background-color:green">
     	<p class="offcanvas-title d-none d-sm-block" id="offcanvas" style ="color: white; margin-left: 110px; font-size : 50px"><i class="bi-person-circle"></i></p>
       <!--   <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>-->
    </div>
    <div class="offcanvas-body px-0" style="background-color:green">
        <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-start" id="menu">
      
        	<li>
                <a style ="color: white; font-size:30px" href="/GestionDeClasse/accueil" class="nav-link text-truncate">
                    <i class="fs-3 bi-house"></i><span class="ms-1 d-none d-sm-inline">Accueil</span></a>
            </li>
            <li class="nav-item">
                <a href="/GestionDeClasse/prof" class="nav-link text-truncate" style ="color: white; font-size:30px">
                    <i class="fs-3 bi-people"></i><span class="ms-1 d-none d-sm-inline">Prof</span>
                </a>
            </li>
            <li>
               <a href="/GestionDeClasse/salle" class="nav-link text-truncate" style ="color: white; font-size:30px">
                    <i class="fs-3 bi-building"></i><span class="ms-1 d-none d-sm-inline">Salle</span>
                </a>
            </li>
            <li>
                <a href="/GestionDeClasse/occuper" class="nav-link text-truncate" style ="color: white; font-size:30px">
                    <i class="fs-3 bi-card-checklist"></i><span class="ms-1 d-none d-sm-inline">Occuper</span></a>
            </li>
        </ul>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col min-vh-100 py-3">
            <!-- toggler -->
         
                <i class="bi-list fs-2  float-end" data-bs-toggle="offcanvas" data-bs-target="#offcanvas" role="button" style ="color: green"></i><br><br><br>
       			
<div class="container">
  <div class="row">
    <div class="col-2">
		<button type="button" class="btn btn-success"><a style="color: white; text-decoration: none;" href = "/GestionDeClasse/newSalle?action=new"><i class="bi-plus fs-5"></i></a></button>
	</div>
  </div><br>
		
		<table class="table">
		<tr>
				<th>Code Salle</th>
			    <th>Designation</th>
		</tr>
		<c:forEach items="${ Salles }" var="sl">	
			<tr>
				<td><c:out value="${ sl.codesalle }"/></td>
			    <td><c:out value="${ sl.designation }"/></td>	
				<td>
 					<button type="button" class="btn btn-success"><a style="color: white" href="/GestionDeClasse/salle?action=modifier&codesalle='<c:out value='${ sl.codesalle }' />'"><i class="bi-pencil-fill"></i></a></button>       
					<button type="button" class="btn btn-danger" onclick="return confirm('Êtes-vous sûr de vouloir supprimer?')"><a style="color: white"  href="/GestionDeClasse/salle?action=supprimer&codesalle=<c:out value='${ sl.codesalle }' />"><i class="bi-trash"></i></a></button>             	
                </td>
			</tr>
		</c:forEach>
		</table>
</div>

        </div>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>

