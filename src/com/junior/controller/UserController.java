package com.junior.controller;


import com.junior.dao.UserDAO;
import com.junior.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserController",
            urlPatterns = "/UserController")
public class UserController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("action");

        if (acao.equalsIgnoreCase("delete")){
            Usuario usuario = UserDAO.listaPorId(Integer.parseInt(request.getParameter("id")));
            UserDAO.delete(usuario);

            response.sendRedirect("index.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("action");
        Usuario user = new Usuario();
        user.setNome(request.getParameter("nome"));
        user.setCpf(request.getParameter("cpf"));
        user.setEmail(request.getParameter("email"));
        String id = request.getParameter("id");

        if (acao.equalsIgnoreCase("adicionar")){
            UserDAO.adiciona(user);
            response.sendRedirect("index.jsp");
        }
        if (acao.equalsIgnoreCase("editar")){
            user.setId(Integer.parseInt(id));
           UserDAO.editar(user);
            response.sendRedirect("index.jsp");
        }
    }
}
