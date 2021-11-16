<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="./style/style.css">
    <title>Fornecedores | Inserir</title>
    <style>
		input{
			border: none;
			border-bottom: 1.8px solid gray;
		}
	
	</style>
</head>
<body>
    <%@page import="fornecedor.FornecedorFacade" %>
	<%@page import="fornecedor.Fornecedor" %>
    <%
    String username =(String) session.getAttribute("username");
    	    if(username == null){
    	        response.sendRedirect("src/login.jsp");
    	    }
    	    Long id = Long.parseLong(request.getParameter("id"));	  
    	    FornecedorFacade fc = new FornecedorFacade();
    	    Fornecedor forn = fc.getById(id);
    	    if(forn == null){
    	        response.sendRedirect("index.jsp");
    	    }
    %>	
    <main>
        <div class="container">
            <h2>Cadastro de Fornecedores</h2>
            <form action="AlterarFornecedor" method="post">        
                <table>                    
                    <tr><th colspan="4" align="left"><h3>Endereço</h3></th></tr>
                    <tr>
                        <td>Endereço</td>
                        <input type="hidden" name="endId" value="<%=forn.getEndereco().getId() %>">
                        <td><input type="text" placeholder="Endereço" name="endereco" value="<%=forn.getEndereco().getDescricao() %>"></td>
                        <td>Cidade</td>
                        <input type="hidden" name="cidadeId" value="<%=forn.getEndereco().getCidade().getId() %>">
                        <td><input type="text" placeholder="Cidade" name="cidade" value="<%=forn.getEndereco().getCidade().getDescricao() %>"></td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <input type="hidden" name="ufId" value="<%=forn.getEndereco().getUf().getId() %>">
                        <td><input type="text" placeholder="UF" name="uf" value="<%=forn.getEndereco().getUf().getDescricao() %>"></td>
                        <td>País</td>
                        <input type="hidden" name="paisId" value="<%=forn.getEndereco().getPais().getId() %>">
                        <td><input type="text" placeholder="Brasil, EUA" name="pais" value="<%=forn.getEndereco().getPais().getDescricao() %>"></td>
                    </tr>
                    <tr>
                    	<td>Bairro</td>      
                        <td><input type="text" placeholder="bairro" name="bairro" value="<%=forn.getEndereco().getBairro() %>"></td>
                        <td>Numero</td>                        
                        <td><input type="number" placeholder="numero" name="numero" value="<%=forn.getEndereco().getNumero() %>"></td>
                    </tr>
                    <tr>
                    	<td>CEP</td>                    	
                        <td><input type="text" placeholder="cep" name="cep" value="<%=forn.getEndereco().getCep() %>"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Contato</h3></th></tr>
                    <tr>
                        <td>Departamento</td>
                        <td><input type="text" placeholder="Papelaria, Marcenaria..." ></td>
                        <td>E-mail</td>
                        <input type="hidden" name="emailId" value="<%=forn.getContato().getEmail().getId() %>">
                        <td><input type="text" name="email" value="<%=forn.getContato().getEmail().getDescricao() %>"></td>
                    </tr>
                    <tr>
                        <td>Celular</td>
                        <input type="hidden" name="telefoneId" value="<%=forn.getContato().getTelefone().getId() %>">
                        <td><input type="text" name="codigo" style="width:50px;" value="<%=forn.getContato().getTelefone().getCodigo() %>">
                        <input type="number" name="ddd"style="width:50px;" value="<%=forn.getContato().getTelefone().getDdd() %>">
                        <input type="number" name="telefone"style="width:100px;" value="<%=forn.getContato().getTelefone().getNumber() %>"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Empresa</h3></th></tr>
                    <tr>
                        <td><input type="radio" name="tipo_empresa" checked="checked">Matriz</td>
                        <td><input type="radio" name="tipo_empresa">Filial</td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Fornecedor</h3></th></tr>
                    <tr>
                        <td>CNAE</td>
                        <input type="hidden" name="fornecedorId" value="<%=forn.getId()%>">
                        <input type="hidden" name="cnaeId" value="<%=forn.getCnae().getId()%>">
                        <td><input type="text" name="cnae" value="<%=forn.getCnae().getDescricao() %>"></td>
                        <td>CNPJ</td>
                        <td><input type="text" name="cnpj" value="<%=forn.getCnpj() %>"></td>
                    </tr>
                    <tr>
                        <td>Inscrição Estadual</td>
                        <td><input type="number" name="inscricaoEstadual" value="<%=forn.getInscricaoEstadual() %>"></td>
                        <td>Inscrição Municipal</td>
                        <td><input type="number" name="inscricaoMunicipal" value="<%=forn.getInscricaoMunicipal() %>"></td>
                    </tr>
                    <tr>
                        <td>Razão Social</td>
                        <td><input type="text" name="razaoSocial" value="<%=forn.getRazaoSocial() %>"></td>
                        <td>Nome Fantasia</td>
                        <td><input type="text" name="nomeFantasia" value="<%=forn.getNomeFantasia() %>"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Produto</h3></th></tr>
                    <tr>
                    	<td>Produto</td>
                    	<input type="hidden" name="produtoId" value="<%=forn.getProduto().getId()%>">
                        <td><input type="text" name="produto" value="<%=forn.getProduto().getDescricao() %>"></td>                        
                        <td>
                        	<label>Produto</label><input type="radio" name="tipoProduto" checked="checked">
                        	<label>Serviço</label><input type="radio" name="tipoProduto">
                        </td>
                    </tr>
                </table>
                <div style="display: flex; justify-content: center;">
	                <input type="submit" id="send-button">
	                <input type="button" id="send-button" value="Cancel">
                </div>
            </form>
        </div>
    </main>
</body>
</html>