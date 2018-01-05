<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PAGE PRODUITS</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
</head>
<body>

<%@include file="header.jsp" %>
	<div class="container col-md-10 col-md-offset-1">
		<div class="panel panel-primary">
			<div class="panel-heading">Rechercher des produits</div>
			<div class="panel-body">
				<form action="chercher.do" method="get">
					<label>Mot Clé : </label> <input type="text" name="motCle" value="${model.motCle }">
					<button type="submit" class="btn btn-primary">Chercher</button>
				</form>
				<table class="table table-striped">
					<tr>
						<th>ID</th>
						<th>DéSIGNATION</th>
						<th>PRIX</th>
						<th>QUANTITé</th>
					</tr>
					<c:forEach items="${model.produits }" var="p">
						<tr>
							<td>${p.id }</td>
							<td>${p.designation }</td>
							<td>${p.prix }</td>
							<td>${p.quantite }</td>
							<td><a onclick="return confirm('ëtes vous sûre de le supprimer?')" href="supprimer.do?id=${p.id }">Supprimer</a> </td>
							<td><a href="editer.do?id=${p.id }">Modifier</a> </td>
						</tr>

					</c:forEach>

				</table>
			</div>
		</div>
	</div>
</body>
</html>