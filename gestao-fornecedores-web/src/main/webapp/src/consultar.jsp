<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/style/style.css">    
    <title>Fornecedores | Alterar</title>
</head>
<body>
    <%@page import="facade.Fachada" %>
	<%@page import="dominio.Fornecedor" %>
	<%@page import="application.Dominio" %>
	<%@page import="application.Resultado" %>
	<%@page import="java.util.List" %>
    <%
    			List<Dominio> dominios = (List<Dominio>) request.getAttribute("resultado");    			
    %>
    <header>
        <div class="navigation">
            <ul>
                <li>
                    <a href="/gestao-fornecedores-web/Fornecedor?operacao=EXIBIR">
                        <span class="icon"><i class="fas fa-search"></i></span>
                        <span class="title">Consultar</span>
                    </a>
                </li>
                <li>
                    <a href="<%= request.getContextPath() %>/index.jsp">
                        <span class="icon"><i class="fas fa-address-book"></i></span>
                        <span class="title">Inserir</span>
                    </a>
                </li>
                 <li>
                    <a href="<%= request.getContextPath() %>/logout">
                    	<span class="icon"><i class="fas fa-cog"></i></span>
                    	<span class="title">Log out</span>
                    </a>
                </li>
            </ul>
        </div>
    </header>
    <div class="container">
        <div class="" style="background: white; padding: 30px; border-radius: 30px; box-shadow: 5px 5px 5px rgba(68, 68, 68, 0.1)">  
	     	<table class="table" style="padding: 20px;">
	     		<thead>
		     		<tr>		     		
			     		<th scope="col">Empresa</th>
			     		<th scope="col">Telefone</th>
			     		<th scope="col">E-mail</th>
			     		<th scope="col">Produto</th>
			     		<th scope="col">Endereço</th>
			     		<th scope="col">Cidade</th>
			     		<th scope="col">UF</th>
			     		<th scope="col">País</th>
			     		<th scope="col">Editar</th>
			     		<th scope="col">Remover</th>
		     		</tr>
	     		</thead>
	     		<tbody>
		     		<%
		     		if(dominios != null){
		     		for(Dominio fornecedor:dominios){
		     			Fornecedor f = (Fornecedor)fornecedor;
		     		%>
		     		<tr>	     			
		     			<td><%=f.getNomeFantasia()%></td>
		     			<td><%=f.getContato().getTelefone().getNumber() %></td>
		     			<td><%=f.getContato().getEmail().getDescricao() %></td>
		     			<td><%=f.getProduto().getDescricao() %></td>     
		     			<td><%=f.getEndereco().getDescricao() %></td>		
		     			<td><%=f.getEndereco().getCidade().getDescricao() %></td>
		     			<td><%=f.getEndereco().getUf().getDescricao() %></td>
		     			<td><%=f.getEndereco().getPais().getDescricao() %></td>
		     			<td><input type="button" onclick="edit(<%=f.getId() %>)" value="Editar" class="btn btn-warning" style="width: 100%"></td>
		     			<td><input type="button" onclick="remove(<%=f.getId() %>)" value="Remover" class="btn btn-danger" style="width: 100%"></td>
		     		</tr>
		     		<%}} %>
	     		</tbody>
	     	</table>
	     </div>     
    </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
   		function edit(id){
   			location.href="/gestao-fornecedores-web/Fornecedor?id="+id+"&operacao=ALTERAR";   			
   		}
   		
   		function remove(id){
   			location.href="/gestao-fornecedores-web/Fornecedor?id="+id+"&operacao=REMOVER";
   		}
    </script>
</body>
</html>