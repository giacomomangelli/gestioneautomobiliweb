<!-- navbar -->
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-primary">

	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
       <span class="navbar-toggler-icon"></span>
     </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="login.jsp">Login<span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item">
        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="ExecuteListAutomobileServlet">Automobili</a>
          <a class="dropdown-item" href="PrepareInsertAutomobileServlet">Inserisci nuova Automobile</a>
          <a class="dropdown-item" href="PrepareSearchAutomobileServlet">Cerca Automobile</a>
        </div>
      </li>
    </ul>
    <div class = "padding-right-5" > 
    	<span class="navbar-text" >
    		<strong class="text-dark" >
				${utente_logged_attr.nome}      
			</strong>
		</span>
	</div>
    <form class="form-inline my-2 my-lg-0" action = "LogoutServlet">
    
      <button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button>
    </form>
  </div>
</nav>
