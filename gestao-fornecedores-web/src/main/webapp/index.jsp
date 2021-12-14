<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
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
    <%
	    String username =(String) session.getAttribute("username");
	    if(username == null){
	        response.sendRedirect("src/login.jsp");
	    }
	    
	    String message = (String) request.getAttribute("message");
	%>	
    <header >
        <div class="navigation">
            <ul>
                <li>
                    <a href="/gestao-fornecedores-web/Fornecedor?operacao=EXIBIR">
                        <span class="icon"><i class="fas fa-search"></i></span>
                        <span class="title">Consultar</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <span class="icon"><i class="fas fa-address-book"></i></span>
                        <span class="title">Inserir</span>
                    </a>
                </li>
                <li>
                    <a href="logout">
                    	<span class="icon"><i class="fas fa-cog"></i></span>
                    	<span class="title">Log out</span>
                    </a>
                </li>
            </ul>
        </div>
    </header>
    <main>
        <div class="container">
        	<div class="">
	            <h2>Cadastro de Fornecedores</h2>
	            <form action="Fornecedor" method="post">        
	                <table>                    
	                    <tr><th colspan="4" align="left"><h3>Endereço</h3></th></tr>
	                    <tr>
	                        <td>Endereço</td>
	                        <td><input type="text" placeholder="Endereço" name="endereco" class="form-control"></td>
	                        <td>Cidade</td>
	                        <td><input type="text" placeholder="Cidade" name="cidade" class="form-control"></td>
	                    </tr>
	                    <tr>
	                        <td>Estado</td>
	                        <td><input type="text" placeholder="UF" name="uf" class="form-control"></td>
	                        <td>País</td>
	                        <td><input type="text" placeholder="Brasil, EUA" name="pais" class="form-control"></td>
	                    </tr>
	                    <tr>
	                    	<td>Bairro</td>
	                        <td><input type="text" placeholder="bairro" name="bairro" class="form-control"></td>
	                        <td>Numero</td>
	                        <td><input type="number" placeholder="numero" name="numero" class="form-control"></td>
	                    </tr>
	                    <tr>
	                    	<td>CEP</td>
	                        <td><input type="text" placeholder="cep" id="cep" name="cep" class="form-control"></td>
	                    </tr>
	                    <tr><th colspan="4" align="left"><h3>Contato</h3></th></tr>
	                    <tr>
	                        <td>Departamento</td>
	                        <td><input type="text" placeholder="Papelaria, Marcenaria..." class="form-control"></td>
	                        <td>E-mail</td>
	                        <td><input type="text" name="email" class="form-control"></td>
	                    </tr>
	                    <tr>
	                    	<div class="form-row">
		                        <td>Celular</td>
		                        <td><input type="number" name="codigo" class="form-control" id="codigo"></td>
		                        <td><input type="number" name="ddd" class="form-control" id="ddd"></td>
		                        <td><input type="number" name="telefone" class="form-control" id="numero"></td>
	                        </div>
	                    </tr>
	                    <tr><th colspan="4" align="left"><h3>Empresa</h3></th></tr>
	                    <tr>                                               
	                        <td><input type="radio" name="tipo_empresa" checked="checked" class="form-check-input">Matriz</td>
	                        <td><input type="radio" name="tipo_empresa" class="form-check-input">Filial</td>
	                    </tr>
	                    <tr><th colspan="4" align="left"><h3>Fornecedor</h3></th></tr>
	                    <tr>
	                        <td>CNAE</td>
	                        <td><input type="text" id="cnae" name="cnae" class="form-control"></td>
	                        <td>CNPJ</td>
	                        <td><input type="text" id="cnpj" name="cnpj" class="form-control"></td>
	                    </tr>
	                    <tr>
	                        <td>Inscrição Estadual</td>
	                        <td><input type="number" id="estadual" name="inscricaoEstadual" class="form-control"></td>
	                        <td>Inscrição Municipal</td>
	                        <td><input type="number" id="municipal" name="inscricaoMunicipal" class="form-control"></td>
	                    </tr>
	                    <tr>
	                        <td>Razão Social</td>
	                        <td><input type="text" name="razaoSocial" class="form-control"></td>
	                        <td>Nome Fantasia</td>
	                        <td><input type="text" name="nomeFantasia" class="form-control"></td>
	                    </tr>
	                    <tr><th colspan="4" align="left"><h3>Produto</h3></th></tr>
	                    <tr>
	                    	<td>Produto</td>
	                        <td><input type="text" name="produto" class="form-control"></td>                        
	                        <td>
	                        	<label>Produto</label><input type="radio" name="tipoProduto" value="produto" checked="checked">
	                        	<label>Serviço</label><input type="radio" name="tipoProduto" value="servico">
	                        </td>
	                    </tr>
	                </table>
	                <div style="display: flex; justify-content: center;">
	                	<input type="submit" id="send-button" name="operacao" value="SALVAR" class="btn btn-success">
	                </div>
	            </form>
            </div>
        </div>
    </main>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.10/jquery.mask.js"></script>
    <script type="text/javascript">
		$(document).ready(function(){	
			$("#cnpj").mask("99999999999999");
			
			$("#estadual").mask("999999999");
			
			$("#municipal").mask("99999999999");
			
			$("#cnae").mask("9999999");
			
			$("#cep").mask("99999999");
			
			$("#codigo").mask("99");
			$("#ddd").mask("99");
			$("#numero").mask("99999999");
						
		});
				
		message = <%=message%>;
		
    </script>
</body>
</html>