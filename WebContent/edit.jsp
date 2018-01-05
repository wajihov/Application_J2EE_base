<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>PAGE PRODUITS Edition</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/myStyle.css">
</head>
<body>

	<%@include file="header.jsp"%>
	<div class="container col-md-8 col-md-offset-2 col-xs-12">
		<div class="panel panel-primary">
			<div class="panel-heading">Editer un produit</div>
			<div class="panel-body">
				<form action="updateProduit.do" method="post">
					<div class="form-group">
						<label class="control-label">Id Produit :   </label> <label> ${produit.id }</label>
						<input type="hidden" name="id_produit" class="form-control"
							value="${produit.id }" /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Désignation</label> <input
							type="text" name="designation" class="form-control"
							value="${produit.designation }" required="required" /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Prix</label> <input type="text"
							name="prix" class="form-control" value="${produit.prix }" /> <span></span>
					</div>
					<div class="form-group">
						<label class="control-label">Quantité </label> <input type="text"
							name="quantite" class="form-control" value="${produit.quantite }" />
						<span></span>
					</div>
					<div>
						<button class="btn btn-primary" type="submit">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>