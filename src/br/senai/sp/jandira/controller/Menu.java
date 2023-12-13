package br.senai.sp.jandira.controller;

import br.senai.sp.jandira.model.Categorias;
import br.senai.sp.jandira.model.Clientes;
import br.senai.sp.jandira.model.Produtos;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    public void executarMenu() throws SQLException {
        boolean continuar = true;

        while(continuar){

            System.out.println("============ WELCOME ============");
            System.out.println("=================================");
            System.out.println("============= MENU ==============");
            System.out.println("1 - Clients                      ");
            System.out.println("2 - Categories                   ");
            System.out.println("3 - Products                     ");
            System.out.println("=================================");

            Scanner scanner = new Scanner(System.in);

            int choice = scanner.nextInt();
            scanner.nextLine();
            Clientes clientes = new Clientes();
            ClientesController clientesController = new ClientesController();
            Categorias categorias = new Categorias();
            CategoriasController categoriasController = new CategoriasController();
            Produtos produtos = new Produtos();
            ProdutosController produtosController = new ProdutosController();

            switch (choice){

                case 1:
                    System.out.println("============ Clients ============");
                    System.out.println("1 - List                         ");
                    System.out.println("2 - Edit                         ");
                    System.out.println("3 - Delete                       ");
                    System.out.println("4 - Register                     ");
                    System.out.println("5 - Consult                      ");
                    System.out.println("=================================");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){

                        case 1:
                            clientesController.listarClientes();
                            break;
                        case 2:
                            System.out.println("Inform the new name: ");
                            String nameUpdate = scanner.nextLine();
                            System.out.println("Inform the new email: ");
                            String emailUpdate = scanner.nextLine();
                            System.out.println("Inform the new phone: ");
                            long phoneUpdate = scanner.nextLong();
                            scanner.nextLine();
                            System.out.println("Inform the new address: ");
                            String addressUpdate = scanner.nextLine();

                            clientesController.editarCliente(nameUpdate, emailUpdate, phoneUpdate, addressUpdate);
                            break;
                        case 3:
                            System.out.println("Inform the name you want to delete: ");
                            String nameDelete = scanner.nextLine();
                            clientesController.deletarCliente(nameDelete);
                            break;
                        case 4:
                            clientes.registerClient();
                            clientesController.cadastrarCliente(clientes);
                            break;
                        case 5:
                            System.out.println("Inform the cpf you want to consult: ");
                            long cpf = scanner.nextLong();
                            clientesController.consultarCliente(cpf);
                            break;
                    }

                    break;
                case 2:
                    System.out.println("========== CATEGORIES ===========");
                    System.out.println("1 - List                         ");
                    System.out.println("2 - Delete                      ");
                    System.out.println("3 - Register                    ");
                    System.out.println("=================================");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){

                        case 1:
                            categoriasController.listarCategorias();
                            break;
                        case 2:
                            System.out.println("Inform the category's name you want to delete");
                            String categoryDelete = scanner.nextLine();
                            categoriasController.deletarCategoria(categoryDelete);
                            break;
                        case 3:
                            categorias.registerCategory();
                            categoriasController.cadastrarCategoria(categorias);
                            break;
                    }

                    break;
                case 3:

                    System.out.println("=========== PRODUCTS ============");
                    System.out.println("1 - List                         ");
                    System.out.println("2 - Edit                         ");
                    System.out.println("3 - Delete                       ");
                    System.out.println("4 - Register                     ");
                    System.out.println("5 - Consult                      ");
                    System.out.println("=================================");

                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice){

                        case 1:
                            produtosController.listarProdutos();
                            break;
                        case 2:
                            System.out.println("Inform the product id you want to edit: ");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Inform the new price of the product: ");
                            double price = scanner.nextDouble();

                            produtosController.editarProduto(id, price);
                            break;
                        case 3:
                            System.out.println("Inform the id of the product you want to delete: ");
                            int idDelete = scanner.nextInt();

                            produtosController.deletarProduto(idDelete);
                            break;
                        case 4:
                            produtos.registerProduct();
                            produtosController.cadastrarProduto(produtos);
                            break;
                        case 5:
                            System.out.println("Search for the product here: ");
                            String product = scanner.nextLine();

                            produtosController.consultarProduto(product);
                            break;
                    }
            }
        }
    }
}
