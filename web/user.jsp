<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adicionar Usuario</title>
</head>
<body>
<form action="UserController" method="post">
    <input type="hidden" value="<%=request.getParameter("action")%>" name="action">
    <input type="hidden" value="<%=request.getParameter("id")%>" name="id">

    <label for="nome">Nome:</label>
    <input id="nome" type="text" name="nome" value="<%=request.getParameter("nome") != null ? request.getParameter("nome") : ""%>">

    <br>
    <label for="cpf">CPF:</label>
    <input id="cpf" type="text" name="cpf" value="<%=request.getParameter("cpf") != null ? request.getParameter("cpf") : ""%>">

    <br>
    <label for="email">E-Mail:</label>
    <input id="email" type="text" name="email" value="<%=request.getParameter("email") != null ? request.getParameter("email") : ""%>">

    <br>
    <br>
    <%
        if (request.getParameter("id") != null) {
    %>
    <input type="submit" value="Editar">
    <%
    } else {
    %>
    <input type="submit" value="Adicionar">
    <%
        }
    %>
</form>
</body>
</html>
