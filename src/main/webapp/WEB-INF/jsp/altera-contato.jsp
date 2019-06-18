<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<title>Formulário de Contato</title>
</head>
<body>
	
	<h3>Altera Contato</h3>
	<hr/>
	<form action="mvc?logica=AlteraContatoLogica" method="POST">
		<input type="hidden" name="id" value="${contato.id}"/>
		Nome: <input type="text" name="nome" value="${contato.nome}"/><br/>
		E-mail: <input type="text" name="email" value="${contato.email}"/><br/>
		Endereço: <input type="text" name="endereco" value="${contato.endereco}"/><br/>
		Data Nascimento: <input type="text" name="datanascimento" value="<fmt:formatDate value="${contato.datanascimento}" pattern="dd/MM/yyyy"/>"><br/>

		<input type="submit" value="Gravar"/>
	</form>

	<p/>
	<a href="mvc?logica=ListaContatosLogica">Retornar a lista de Contatos</a>
	
</body>
</html>