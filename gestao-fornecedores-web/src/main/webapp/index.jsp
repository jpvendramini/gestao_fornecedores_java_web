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
    <%
	    String username =(String) session.getAttribute("username");
	    if(username == null){
	        response.sendRedirect("src/login.jsp");
	    }
	%>	
    <header >
        <div class="navigation">
            <ul>
                <li>
                    <a href="./src/consultar.jsp">
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
                    <a href="./src/alterar.jsp">
                        <span class="icon"><i class="fas fa-cogs"></i></span>
                        <span class="title">Alterar</span>
                    </a>
                </li>
                <li>
                    <a href="./src/remover.jsp">
                        <span class="icon"><i class="fas fa-trash"></i></span>
                        <span class="title">Remover</span>
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
            <h2>Cadastro de Fornecedores</h2>
            <form action="cadastrar/fornecedor" method="post">        
                <table>                    
                    <tr><th colspan="4" align="left"><h3>Endereço</h3></th></tr>
                    <tr>
                        <td>Endereço</td>
                        <td><input type="text" placeholder="Endereço" value="Rua Dunder Mifflin" name="endereco"></td>
                        <td>Cidade</td>
                        <td><input type="text" placeholder="Cidade" value="Springton" name="cidade"></td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <td><input type="text" placeholder="UF" value="MS" name="uf"></td>
                        <td>País</td>
                        <td><input type="text" placeholder="Brasil, EUA" value="US" name="pais"></td>
                    </tr>
                    <tr>
                    	<td>Bairro</td>
                        <td><input type="text" placeholder="bairro" value="Morada do sol" name="bairro"></td>
                        <td>Numero</td>
                        <td><input type="number" placeholder="numero" value="77" name="numero"></td>
                    </tr>
                    <tr>
                    	<td>CEP</td>
                        <td><input type="text" placeholder="cep" value="189281928" name="cep"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Contato</h3></th></tr>
                    <tr>
                        <td>Departamento</td>
                        <td><input type="text" placeholder="Papelaria, Marcenaria..." value="Papelaria"></td>
                        <td>E-mail</td>
                        <td><input type="text" value="papel@gmail.com" name="email"></td>
                    </tr>
                    <tr>
                        <td>Celular</td>
                        <td><input type="number" value="55" name="codigo" style="width:50px;">
                        <input type="number" value="11" name="ddd"style="width:50px;">
                        <input type="number" value="1231231231" name="telefone"style="width:100px;"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Empresa</h3></th></tr>
                    <tr>
                        <td>OS</td>
                        <td><input type="number" value="198291829"></td>
                        <td><input type="radio" name="tipo_empresa" checked="checked">Matriz</td>
                        <td><input type="radio" name="tipo_empresa">Filial</td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Fornecedor</h3></th></tr>
                    <tr>
                        <td>CNAE</td>
                        <td><input type="text" value="9128912" name="cnae"></td>
                        <td>CNPJ</td>
                        <td><input type="text" value="12881923" name="cnpj"></td>
                    </tr>
                    <tr>
                        <td>Inscrição Estadual</td>
                        <td><input type="number" value="12938192839" name="inscricaoEstadual"></td>
                        <td>Inscrição Municipal</td>
                        <td><input type="number" value="19291829112" name="inscricaoMunicipal"></td>
                    </tr>
                    <tr>
                        <td>Razão Social</td>
                        <td><input type="text" value="Empresa empresa" name="razaoSocial"></td>
                        <td>Nome Fantasia</td>
                        <td><input type="text" value="empresona" name="nomeFantasia"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Produto</h3></th></tr>
                    <tr>
                    	<td>Produto</td>
                        <td><input type="text" name="produto" value="papel A4"></td>                        
                        <td>
                        	<label>Produto</label><input type="radio" name="tipoProduto" value="produto" checked="checked">
                        	<label>Serviço</label><input type="radio" name="tipoProduto" value="servico">
                        </td>
                    </tr>
                </table>
                <div style="display: flex; justify-content: center;">
                	<input type="submit" id="send-button">
                </div>
            </form>
        </div>
    </main>
</body>
</html>