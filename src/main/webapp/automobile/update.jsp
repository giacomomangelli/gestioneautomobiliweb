<!doctype html>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Modifica Automobile</title>
	
	<!-- style per le pagine diverse dalla index -->
    <link href="./assets/css/global.css" rel="stylesheet">
    
</head>
<body>
	<jsp:include page="../navbar.jsp" />
	
	<main role="main" class="container">
	
		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none': ''}" role="alert">
		  ${errorMessage}
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
		
		<div class='card'>
		    <div class='card-header'>
		        <h5>Inserisci le modifiche dell'elemento</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteUpdateAutomobileServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Marca<span class="text-danger">*</span></label>
								<input type="text" name="marcaEdit" id="marca" class="form-control" value = "${update_automobile_attr.marca}" placeholder="Inserire la marca" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Modello<span class="text-danger">*</span></label>
								<input type="text" name="modelloEdit" id="modello" class="form-control" value = "${update_automobile_attr.modello}" placeholder="Inserire il modello" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Cilindrata<span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="cilindrataEdit" id="cilindrata" value = "${update_automobile_attr.cilindrata}" placeholder="Inserire la cilindrata" required>
							</div>
							<div class="form-group col-md-3">
								<label>Data di Immatricolazione<span class="text-danger">*</span></label>
								<fmt:formatDate var = "dataDiImmatricolazioneParsed" value = "${update_automobile_attr.dataDiImmatricolazione}"  type = "date" pattern = "yyyy-MM-dd" />    
                        		<input class="form-control" id="dataDiImmatricolazione" type="date" value = "${dataDiImmatricolazioneParsed}" placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataDiImmatricolazioneEdit" required>
							</div>
							
						</div>
						
						<input type = "hidden" name = "idAutomobileEdit" value = "${update_automobile_attr.id }" >
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
         				 <a href="PrepareSearchAutomobileServlet" class='btn btn-outline-secondary' style='width:80px'>
		            	 	<i class='fa fa-chevron-left'></i> Back
		       			 </a>	
						
					</form>
		    
			<!-- end card-body -->			   
		    </div>
		</div>	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>