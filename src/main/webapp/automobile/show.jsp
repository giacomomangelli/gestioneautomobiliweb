<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>
<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Visualizza elemento</title>
	
	<!-- style per le pagine diverse dalla index -->
	
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
		
		<div class='card'>
		    <div class='card-header'>
		        Visualizza dettagli
		    </div>
		
		    <div class='card-body'>
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Marca</dt>
				  <dd class="col-sm-9">${visualizza_automobile_attr.marca}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Modello:</dt>
				  <dd class="col-sm-9">${visualizza_automobile_attr.modello}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Cilindrata:</dt>
				  <dd class="col-sm-9">${visualizza_automobile_attr.cilindrata}</dd>
		    	</dl>
		    	
		    	<dl class="row">
				  <dt class="col-sm-3 text-right">Data di Immatricolazione:</dt>
				  <dd class="col-sm-9">
				  	<fmt:formatDate var = "dataDiImmatricolazioneParsed"
				  	value = "${visualizza_automobile_attr.dataDiImmatricolazione}"  type = "date" pattern = "dd/MM/yyyy" />    
                  	${dataDiImmatricolazioneParsed} 
                  </dd>
		    	</dl>
		    	
		    </div>
		    
		    <div class='card-footer'>
		        <a href="PrepareSearchAutomobileServlet" class='btn btn-outline-secondary' style='width:80px'>
		            <i class='fa fa-chevron-left'></i> Back
		        </a>
		    </div>
		</div>	
	
	<!-- end main container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>