package br.csi.util;

import br.csi.model.Usuario;

import java.sql.*;

public class Testes {

    public static void main(String[] args) {




        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver loaded");

            String url = "jdbc:postgresql://localhost:5432/poow1";
            String user = "postgres";
            String senha = "1234";
            Connection conn =
                    DriverManager.getConnection(url, user, senha);
            System.out.println("Conectado");
            Statement stmt = conn.createStatement();
            ResultSet rs =  stmt.executeQuery("select * from usuario");

            while (rs.next()) {

                System.out.println(rs.getInt("id_usuario"));
                System.out.println(rs.getString("email"));

                System.out.println(rs.getString("senha"));


            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();

        } catch (ClassNotFoundException ex) {
            System.out.println("Drive não carregou");
            ex.printStackTrace();
        }

        Usuario usuario = new Usuario();

//        usuario.setId_usuario(1);
//        usuario.setSenha("senha");
//        usuario.setAtivo(true);


    }
    public void imprimir(Usuario usuario) {
        System.out.println("Id: "+ usuario.getId_usuario()
                +" email: "+ usuario.getEmail()
                +" senha: "+ usuario.getSenha());
    }

}
