<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.junior.model.Usuario" %>
<%@ page import="java.util.List" %>
<%@ page import="com.junior.dao.UserDAO" %>
<jsp:useBean id="usuarioBean" class="com.junior.model.Usuario" scope="session"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:getProperty name="usuarioBean" property="id"/>
<jsp:getProperty name="usuarioBean" property="nome"/>
<jsp:getProperty name="usuarioBean" property="cpf"/>
<jsp:getProperty name="usuarioBean" property="email"/>

<html>
<head>
    <title>Mostrar Usuarios</title>
</head>
<body>
<h1>CRUD JSP</h1>
<%
    List<Usuario> list = UserDAO.listar();
%>
<table border=1>
    <thead>
    <tr>
        <th>ID Usuario</th>
        <th>nome</th>
        <th>CPF</th>
        <th>Email</th>
        <th colspan=2>Action</th>
    </tr>
    <%
        for (Usuario usuario : list) {
    %>
    </thead>

    <tbody>
    <td><%=usuario.getId()%>
    </td>
    <td><%=usuario.getNome()%>
    </td>
    <td><%=usuario.getCpf()%>
    </td>
    <td><%=usuario.getEmail()%>
    </td>
    <td>
        <a href="user.jsp?id=<%=usuario.getId()%>&action=editar&nome=<%=usuario.getNome()%>
            &cpf=<%=usuario.getCpf()%>&email=<%=usuario.getEmail()%>">Editar</a>
        <a href="UserController?id=<%=usuario.getId()%>&action=delete">Deletar</a>
    </td>
    </tbody>
    <%

        }
    %>
</table>
<p><a href="user.jsp?action=adicionar">Adicionar</a></p>
</body>
</html>
