<%@ page import="controller.Coleta" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String logradouro = request.getParameter("logradouro");
	String material = request.getParameter("material");
	String volume = request.getParameter("volume");

	Coleta conta = new Coleta();
	conta.cadastrarSolicitacao(logradouro, material, volume);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<script>
		alert("Agendamento realizado com sucesso!");
		window.location.href = "listarColetas.jsp";
	</script>
</body>
</html>