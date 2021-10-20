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
            <form action="">        
                <table>                    
                    <tr><th colspan="4" align="left"><h3>Endereço</h3></th></tr>
                    <tr>
                        <td>Endereço</td>
                        <td><input type="text" placeholder="Endereço"></td>
                        <td>Cidade</td>
                        <td><input type="text" placeholder="Cidade"></td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <td><input type="text" placeholder="UF"></td>
                        <td>País</td>
                        <td><input type="text" placeholder="Brasil, EUA"></td>
                    </tr>
                    <tr>
                    	<td>Bairro</td>
                        <td><input type="text" placeholder="bairro"></td>
                        <td>Numero</td>
                        <td><input type="number" placeholder="numero"></td>
                    </tr>
                    <tr>
                    	<td>CEP</td>
                        <td><input type="text" placeholder="cep"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Contato</h3></th></tr>
                    <tr>
                        <td>Departamento</td>
                        <td><input type="text" placeholder="Papelaria, Marcenaria..."></td>
                        <td>E-mail</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Celular</td>
                        <td><input type="number"></td>
                        <td>Telefone</td>
                        <td><input type="number"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Empresa</h3></th></tr>
                    <tr>
                        <td>OS</td>
                        <td><input type="number"></td>
                        <td><input type="radio" name="tipo_empresa">Matriz</td>
                        <td><input type="radio" name="tipo_empresa">Filial</td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Fornecedor</h3></th></tr>
                    <tr>
                        <td>CNAE</td>
                        <td><input type="text"></td>
                        <td>CNPJ</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr>
                        <td>Inscrição Estadual</td>
                        <td><input type="number"></td>
                        <td>Inscrição Municipal</td>
                        <td><input type="number"></td>
                    </tr>
                    <tr>
                        <td>Razão Social</td>
                        <td><input type="text"></td>
                        <td>Nome Fantasia</td>
                        <td><input type="text"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Produto</h3></th></tr>
                    <tr>
                    	<td>Produto</td>
                        <td><input type="text" name="produto"></td>                        
                        <td>
                        	<label>Produto</label><input type="radio" name="tipoProduto" value="produto">
                        	<label>Serviço</label><input type="radio" name="tipoProduto" value="servico">
                        </td>
                    </tr>
                </table>
                <input type="submit" id="send-button">
            </form>
        </div>
    </main>
</body>
</html>