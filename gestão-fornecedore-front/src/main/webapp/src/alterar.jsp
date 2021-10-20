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
    <%
	    String username =(String) session.getAttribute("username");
	    if(username == null){
	        response.sendRedirect("login.jsp");
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
                <td >Dundler Miffin</td>          
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
    <div id="modal">
        <div class="container">
            <h2>Cadastro de Fornecedores</h2>
            <form action="">    
                <div class="close-button-div">
                    <i class="fas fa-window-close fa-2x"></i>    
                </div>
                <table>                             
                    <tr><th colspan="4" align="left"><h3>Endereço</h3></th></tr>
                    <tr>
                        <td>Logradouro</td>
                        <td><input type="text" placeholder="Rua, avenida..."></td>
                        <td>Cidade</td>
                        <td><input type="text" placeholder="Cidade"></td>
                    </tr>
                    <tr>
                        <td>Estado</td>
                        <td><input type="text" placeholder="UF"></td>
                        <td>País</td>
                        <td><input type="text" placeholder="Brasil, EUA"></td>
                    </tr>
                    <tr><th colspan="4" align="left"><h3>Contato</h3></th></tr>
                    <tr>
                        <td>Departamento</td>
                        <td><input type="text" placeholder="Papelaria, Marcenaria..."></td>
                        <td>Ramal</td>
                        <td><input type=""></td>
                    </tr>
                    <tr>
                        <td>Celular</td>
                        <td><input type="number"></td>
                        <td>Telefone</td>
                        <td><input type="number"></td>
                    </tr>
                    <tr>
                        <td>E-mail</td>
                        <td><input type="text"></td>
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
                </table>
                <input type="submit" id="send-button">
            </form>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
               
        $(".fornecedor").click(function(){
            let modal = document.getElementById('modal');     
            modal.style.display = "block";
        });   
        $(".close-button-div").click(function(){
            let modal = document.getElementById('modal');     
            modal.style.display = "none";
        });
    </script>
</body>
</html>