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

	<%@include file="header.jsp"%>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Confirmation d'un produit</div>
			<div class="panel-body">
					<div class="form-group">
						<label class="control-label">Id Produit</label>
						<label class="control-label">${produit.id }</label>
						<span></span>
					</div>
				
					<div class="form-group">
						<label class="control-label">Désignation</label>
						<label class="control-label">${produit.designation }</label>
						<span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prix</label>
						<label class="control-label">${produit.prix }</label>
						 <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantité </label>
						<label class="control-label">${produit.quantite }</label>
						<span></span>
					</div>				
			</div>
		</div>
	</div>
</body>
</html>