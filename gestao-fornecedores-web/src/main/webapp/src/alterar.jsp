<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="../style/style.css">
    <link rel="stylesheet" href="../style/consultar.css">
    <link rel="stylesheet" href="../style/alterar.css">
    <title>Fornecedores | Alterar</title>
</head>
<body>
    <%@page import="fornecedor.FornecedorController" %>
	<%@page import="fornecedor.Fornecedor" %>
	<%@page import="java.util.List" %>
    <%
	    String username =(String) session.getAttribute("username");
	    if(username == null){
	        response.sendRedirect("login.jsp");
	    }
	    
	    FornecedorController forn = new FornecedorController(); 
	    
	    List<Fornecedor> fornecedores = forn.findAll();
	    if(!fornecedores.isEmpty()){
	    	request.setAttribute("fornecedores", fornecedores);	    	
	    }
	%>
    <header>
        <div class="navigation">
            <ul>
                <li>
                    <a href="./consultar.jsp">
                        <span class="icon"><i class="fas fa-search"></i></span>
                        <span class="title">Consultar</span>
                    </a>
                </li>
                <li>
                    <a href="../index.jsp">
                        <span class="icon"><i class="fas fa-address-book"></i></span>
                        <span class="title">Inserir</span>
                    </a>
                </li>
                <li>
                    <a href="./alterar.jsp">
                        <span class="icon"><i class="fas fa-cogs"></i></span>
                        <span class="title">Alterar</span>
                    </a>
                </li>
                <li>
                    <a href="./remover.jsp">
                        <span class="icon"><i class="fas fa-trash"></i></span>
                        <span class="title">Remover</span>
                    </a>
                </li>
                 <li>
                    <a href="../logout">
                    	<span class="icon"><i class="fas fa-cog"></i></span>
                    	<span class="title">Log out</span>
                    </a>
                </li>
            </ul>
        </div>
    </header>
    <div class="container">
        <h2>Alterar Fornecedores</h2>   
        <table>            
            <tr>
            	<th>ID</th>
                <th>Empresa</th>
                <th>Número</th>
                <th>E-mail</th>
                <th>Produto</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>UF</th>
                <th>País</th>                
            </tr>
            <%for(Fornecedor f:fornecedores){%>
	            <form action="../AlterarFornecedor?id=<%=f.getId() %>" method="post" id="form" >          	
		            <tr class="fornecedor" onclick="sendForm()">
		            	<td><%=f.getId()%></td>
		                <td><%=f.getNomeFantasia()%></td>
		                <td><%=f.getContato().getTelefone().getNumber() %></td>
		                <td><%=f.getContato().getEmail().getDescricao() %></td>
		                <td><%=f.getProduto().getDescricao() %></td>
		                <td><%=f.getEndereco().getDescricao() %></td>
		                <td><%=f.getEndereco().getCidade().getDescricao() %></td>
		                <td><%=f.getEndereco().getUf().getDescricao() %></td>
		                <td><%=f.getEndereco().getPais().getDescricao() %></td>
		            </tr> 
	            </form>
            <%}%>          
        </table>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
    	function sendForm(){
    		var form = document.getElementById("form");
    		form.submit();
    	} 
    </script>
</body>
</html>