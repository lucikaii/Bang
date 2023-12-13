package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Categorias;
import br.senai.sp.jandira.model.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriasController {

    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();

    public void listarCategorias () throws SQLException {

        Statement statement = connection.createStatement();

        String queryList = "SELECT * FROM categorias";

        ResultSet resultSet = statement.executeQuery(queryList);
        Categorias categorias = new Categorias();
        while (resultSet.next()){

            categorias.setIdCategory(resultSet.getInt("id_categoria"));
            categorias.setName(resultSet.getString("nome"));

            System.out.println("id: " + categorias.getIdCategory());
            System.out.println("name: " + categorias.getName());
            System.out.println("==============================================");
        }
    }

    public void deletarCategoria(String name) throws SQLException {
        Statement statement = connection.createStatement();
        String queryDelete = "DELETE FROM categorias WHERE nome = '" + name + "'";

        statement.executeQuery(queryDelete);
        System.out.println(name + " foi deletado com sucesso!");

    }

    public void cadastrarCategoria(Categorias categoria) throws SQLException {
        Statement statement = connection.createStatement();
        String queryRegister = "INSERT INTO categorias VALUES (0, '" + categoria.getName() + "'";

        statement.executeUpdate(queryRegister);
        System.out.println("Categoria cadastrada com sucesso!");

    }
}
