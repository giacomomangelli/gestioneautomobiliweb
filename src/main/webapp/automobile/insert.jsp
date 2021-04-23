<!doctype html>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<html lang="it">
<head>
	<jsp:include page="../header.jsp" />
	<title>Inserisci nuova Automobile</title>
	
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
		        <h5>Inserisci una nuova automobile</h5> 
		    </div>
		    <div class='card-body'>

					<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>

					<form method="post" action="ExecuteInsertAutomobileServlet" novalidate="novalidate">
					
						<div class="form-row">
							<div class="form-group col-md-6">
								<label>Marca <span class="text-danger">*</span></label>
								<input type="text" name="marcaInsert" id="marca" class="form-control" placeholder="Inserire la marca" value = "${insert_automobile_attr.marca}" required>
							</div>
							
							<div class="form-group col-md-6">
								<label>Modello <span class="text-danger">*</span></label>
								<input type="text" name="modelloInsert" id="modello" class="form-control" placeholder="Inserire il modello" value = "${insert_automobile_attr.modello}" required>
							</div>
						</div>
						
						<div class="form-row">	
							<div class="form-group col-md-6">
								<label>Cilindrata <span class="text-danger">*</span></label>
								<input type="number" class="form-control" name="cilindrataInsert" id="cilindrata" placeholder="Inserire cilindrata" value = "${insert_automobile_attr.cilindrata}"  required>
							</div>
							<div class="form-group col-md-4">
								<label>Data di Immatricolazione <span class="text-danger">*</span></label>
								<fmt:formatDate var = "dataDiImmatricolazioneParsed" value = "${insert_automobile_attr.dataDiImmatricolazione}"  type = "date" pattern = "yyyy-MM-dd" />    
                        		<input class="form-control" id="dataDiImmatricolazione" type="date" value = "${dataDiImmatricolazioneParsed}" 
                        			placeholder="dd/MM/yy"
                            		title="formato : gg/mm/aaaa"  name="dataDiImmatricolazioneInsert" required>
							</div>
							
						</div>
							
						<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>

					</form>

			<!-- end card-body -->			   
		    </div>
		</div>	
	
	
	<!-- end container -->	
	</main>
	<jsp:include page="../footer.jsp" />
	
</body>
</html>