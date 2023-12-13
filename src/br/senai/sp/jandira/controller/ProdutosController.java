package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Conexao;
import br.senai.sp.jandira.model.Produtos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutosController {

    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();

    public void listarProdutos() throws SQLException {

        Statement statement = connection.createStatement();
        String queryList = "SELECT * FROM produtos";

        ResultSet resultSet = statement.executeQuery(queryList);
        Produtos produtos = new Produtos();
        while(resultSet.next()){

            produtos.setIdProduct(resultSet.getInt("id_produto"));
            produtos.setName(resultSet.getString("nome"));
            produtos.setBrand(resultSet.getString("marca"));
            produtos.setDescription(resultSet.getString("descricao"));
            produtos.setPrice(resultSet.getDouble("preco"));
            produtos.setQuantityStock(resultSet.getInt("quantidade_estoque"));

            System.out.println("id: " + produtos.getIdProduct());
            System.out.println("name: " + produtos.getName());
            System.out.println("brand: "  + produtos.getBrand());
            System.out.println("description: " + produtos.getDescription());
            System.out.println("price: " + produtos.getPrice());
            System.out.println("quantity in stock: " + produtos.getQuantityStock());
            System.out.println("==============================================");
        }
    }

    public void editarProduto(int idProduct, double price) throws SQLException {

        Statement statement = connection.createStatement();
        String queryUpdate = "UPDATE produtos SET preco = " + price + " WHERE id_produto = " + idProduct;

        statement.executeUpdate(queryUpdate);
        System.out.println("Dados alterados com sucesso!");
    }

    public void deletarProduto(int idProduct) throws SQLException {

        Statement statement = connection.createStatement();
        String queryDelete = "DELETE FROM produtos WHERE id_produto = " + idProduct;

        statement.executeQuery(queryDelete);
        System.out.println("Produto deletado com sucesso!");
    }

    public void cadastrarProduto(Produtos produto) throws SQLException {

        Statement statement = connection.createStatement();
        String queryRegister = "INSERT INTO produtos VALUES (0, '" + produto.getName() + "', '" + produto.getBrand() + "', '" + produto.getDescription() + "' , " + produto.getPrice() + ", " +produto.getQuantityStock() + ", " + produto.getIdCategory() + ")";

        statement.executeUpdate(queryRegister);
        System.out.println("Produto cadastrado com sucesso");
    }

    public void consultarProduto(String name) throws SQLException {

        Statement statement = connection.createStatement();
        String queryConsult = "SELECT * FROM produtos WHERE nome LIKE '%" + name + "%'";

        ResultSet resultSet = statement.executeQuery(queryConsult);
        Produtos produtos = new Produtos();
        while(resultSet.next()){

            produtos.setIdProduct(resultSet.getInt("id_produto"));
            produtos.setName(resultSet.getString("nome"));
            produtos.setBrand(resultSet.getString("marca"));
            produtos.setDescription(resultSet.getString("descricao"));
            produtos.setPrice(resultSet.getDouble("preco"));
            produtos.setQuantityStock(resultSet.getInt("quantidade_estoque"));

            System.out.println("id: " + produtos.getIdProduct());
            System.out.println("name: " + produtos.getName());
            System.out.println("brand: "  + produtos.getBrand());
            System.out.println("description: " + produtos.getDescription());
            System.out.println("price: " + produtos.getPrice());
            System.out.println("quantity in stock: " + produtos.getQuantityStock());
            System.out.println("==============================================");
        }
    }
}
