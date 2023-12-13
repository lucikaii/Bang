package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Clientes;
import br.senai.sp.jandira.model.Conexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientesController {

    Conexao conexao = new Conexao();
    Connection connection = conexao.getConnection();

    public void listarClientes () throws SQLException {

        Statement statement = connection.createStatement();

        String queryList = "SELECT * FROM clientes";

        ResultSet resultSet = statement.executeQuery(queryList);
        Clientes cliente = new Clientes();
        while (resultSet.next()){

            cliente.setIdClient(resultSet.getInt("id_cliente"));
            cliente.setName(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getLong("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setPhone(resultSet.getLong("telefone"));
            cliente.setAddress(resultSet.getString("endereco"));

            System.out.println("id: " + cliente.getIdClient());
            System.out.println("name: " + cliente.getName());
            System.out.println("cpf: " + cliente.getCpf());
            System.out.println("email: " + cliente.getEmail());
            System.out.println("phone: " + cliente.getPhone());
            System.out.println("address: " + cliente.getAddress());
            System.out.println("==============================================");
        }
    }

    public void editarCliente (String name, String email, long phone, String adress) throws SQLException {

        Statement statement = connection.createStatement();

        String queryUpdate = "UPDATE clientes SET email = '" + email + "' AND SET telefone = " + phone + " AND SET endereco = '" + adress + "' WHERE nome = '" + name + "'";

        statement.executeUpdate(queryUpdate);

        System.out.println("Dados alterados com sucesso!");
    }

    public void deletarCliente (String name) throws SQLException {

        Statement statement = connection.createStatement();
        String queryDelete = "DELETE FROM clientes WHERE nome = '" + name + "'";

        statement.executeQuery(queryDelete);
        System.out.println(name + " foi deletado com sucesso!");
    }

    public void cadastrarCliente (Clientes cliente) throws SQLException {

        Statement statement = connection.createStatement();

        String queryRegister = "INSERT INTO clientes VALUES (0, '" + cliente.getName() + "', '" + cliente.getEmail() + "', '" + cliente.getPhone() + "', '" + cliente.getAddress() + "', '" + cliente.getCpf() + "')";
        statement.executeUpdate(queryRegister);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public void consultarCliente (long cpf) throws SQLException {

        Statement statement = connection.createStatement();
        String queryConsult = "SELECT * FROM clientes WHERE cpf = " + cpf;

        ResultSet resultSet = statement.executeQuery(queryConsult);
        Clientes cliente = new Clientes();
        while (resultSet.next()) {

            cliente.setIdClient(resultSet.getInt("id_cliente"));
            cliente.setName(resultSet.getString("nome"));
            cliente.setCpf(resultSet.getLong("cpf"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setPhone(resultSet.getLong("telefone"));
            cliente.setAddress(resultSet.getString("endereco"));

            System.out.println("id: " + cliente.getIdClient());
            System.out.println("name: " + cliente.getName());
            System.out.println("cpf: " + cliente.getCpf());
            System.out.println("email: " + cliente.getEmail());
            System.out.println("phone: " + cliente.getPhone());
            System.out.println("address: " + cliente.getAddress());
            System.out.println("==============================================");
        }
    }
}
