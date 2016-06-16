package com.junior.dao;

import com.junior.connection.ConnectionFactory;
import com.junior.model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private static Connection connection = ConnectionFactory.getConnection();

    public static void adiciona(Usuario usuario){
        String sql = "INSERT INTO usuario" + "(id,nome,cpf,email)" + "VALUES(?,?,?,?)";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1,usuario.getId());
            stm.setString(2,usuario.getNome());
            stm.setString(3,usuario.getCpf());
            stm.setString(4,usuario.getEmail());

            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(Usuario id){
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE FROM usuario WHERE id=?");

            stm.setInt(1,id.getId());

            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editar(Usuario usuario){
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE usuario SET nome=?,cpf=?,email=? WHERE usuario.id=?");

            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getCpf());
            stm.setString(3, usuario.getEmail());
            stm.setInt(4, usuario.getId());

            stm.execute();
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> listar(){
        List<Usuario> users = new ArrayList<>();

        try {
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM usuario");

            while (rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setEmail(rs.getString("email"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }



    public static Usuario listaPorId(int id){
        Usuario user = new Usuario();

        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM usuario WHERE id=?");

            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()){
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setCpf(rs.getString("cpf"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
