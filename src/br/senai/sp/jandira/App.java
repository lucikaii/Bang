package br.senai.sp.jandira;

import br.senai.sp.jandira.controller.CategoriasController;
import br.senai.sp.jandira.controller.ClientesController;
import br.senai.sp.jandira.controller.Menu;
import br.senai.sp.jandira.controller.ProdutosController;
import br.senai.sp.jandira.model.Categorias;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {

        Menu menu = new Menu();
        menu.executarMenu();
    }
}
