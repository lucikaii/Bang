package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Categorias {

    private String name;
    private int idCategory=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public void registerCategory(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inform the name: ");
        this.name = scanner.nextLine();
    }
}
