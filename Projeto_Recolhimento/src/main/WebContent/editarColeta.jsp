<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Entulho" %>
<%
    Entulho e = (Entulho) request.getAttribute("entulho");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Agendamento</title>
<link rel="stylesheet" href="css/cadastro.css">
</head>
<body>
    <div class="form-container">
        <h2 class="nome">Editar Solicitação</h2>
        
        <form action="update" method="post">
            <input type="hidden" name="id" value="<%= e.getId() %>">
            
            <label class="endereco">Endereço/Logradouro:</label> 
            <input type="text" name="logradouro" value="<%= e.getLogradouro() %>" required>
             
            <label class="classificacao">Tipo de Entulho:</label>
            <select name="material">
                <option value="Construção/Alvenaria" <%= "Construção/Alvenaria".equals(e.getMaterial()) ? "selected" : "" %>>Construção/Alvenaria</option>
                <option value="Poda de Árvores" <%= "Poda de Árvores".equals(e.getMaterial()) ? "selected" : "" %>>Poda de Árvores</option>
                <option value="Móveis/Madeira" <%= "Móveis/Madeira".equals(e.getMaterial()) ? "selected" : "" %>>Móveis/Madeira</option>
            </select>
            
            <label class="quantidade">Volume:</label> 
            <input type="text" name="volume" value="<%= e.getVolume() %>"> 
            
            <input type="submit" value="Salvar Alterações" class="enviar">
        </form>
        <br> 
        <a href="main" class="retorno">Cancelar e Voltar</a>
    </div>
</body>
</html>