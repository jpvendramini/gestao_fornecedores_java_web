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
    <title>Fornecedores | Consultar</title>
</head>
<body>
    <%
	    String username =(String) session.getAttribute("username");
	    if(username == null){
	        response.sendRedirect("login.jsp");
	    }
	%>
    <header >
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
        <h2>Consultar Fornecedores</h2>
        <table>            
            <tr>
                <th>Empresa</th>
                <th>Número</th>
                <th>E-mail</th>
                <th>Produto</th>
                <th>Endereço</th>
                <th>Cidade</th>
                <th>País</th>
                <th>Tipo</th>                
            </tr>
            <tr class="fornecedor">
                <td >Dundler Miffin</td>          
                <td>11090-12901</td>
                <td>dunder@gmail.com</td>
                <td>Papel</td>
                <td>Avenida Scranton</td>
                <td>Scranton</td>
                <td>Estados Unidos</td>
                <td>Filial</td>
            </tr>
            <tr class="fornecedor">
                <td>Dundler Miffin</td>          
                <td>11090-12901</td>
                <td>dunder@gmail.com</td>
                <td>Papel</td>
                <td>Avenida Scranton</td>
                <td>Scranton</td>
                <td>Estados Unidos</td>
                <td>Filial</td>
            </tr>
            <tr class="fornecedor">
                <td>Dundler Miffin</td>          
                <td>11090-12901</td>
                <td>dunder@gmail.com</td>
                <td>Papel</td>
                <td>Avenida Scranton</td>
                <td>Scranton</td>
                <td>Estados Unidos</td>
                <td>Filial</td>
            </tr>
            <tr class="fornecedor">
                <td>Dundler Miffin</td>          
                <td>11090-12901</td>
                <td>dunder@gmail.com</td>
                <td>Papel</td>
                <td>Avenida Scranton</td>
                <td>Scranton</td>
                <td>Estados Unidos</td>
                <td>Filial</td>
            </tr>
        </table>
    </div>
</body>
</html>