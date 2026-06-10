<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Entulho" %>
<%@ page import="java.util.ArrayList" %>
<%
    ArrayList<Entulho> lista = (ArrayList<Entulho>) request.getAttribute("entulhos");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agendamentos de Recolhimento</title>
    <link rel="stylesheet" href="css/listagem.css">
</head>
<body>
    <h1 class="titulo">Solicitações de Recolhimento</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Endereço/Logradouro</th>
                <th>Tipo de Entulho</th>
                <th>Volume</th>
                <th>Ações</th>
            </tr>
        </thead>
        <tbody>
            <% if (lista != null) { 
                for (Entulho e : lista) { %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getLogradouro() %></td>
                    <td><%= e.getMaterial() %></td>
                    <td><%= e.getVolume() %></td>
                    <td>
                        <a href="select?id=<%= e.getId() %>" style="color: blue; font-weight: bold; text-decoration: none; margin-right: 15px;">Editar</a>
                        <a href="delete?id=<%= e.getId() %>" onclick="return confirm('Confirmar a exclusão deste agendamento?')" style="color: red; font-weight: bold; text-decoration: none;">Excluir</a>
                    </td>
                </tr>
            <%   } 
               } %>
        </tbody>
    </table>
    <br>
    <a href="cadastrarColeta.html" style="display: inline-block; margin-top: 20px; font-weight: bold; color: #2e7d32;">Agendar Novo Recolhimento</a> | 
    <a href="index.html" style="font-weight: bold; color: #555;">Voltar ao Início</a>
</body>
</html>