package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Produtos {

    private String name, brand, description;
    private int idProduct, quantityStock, idCategory;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(int quantityStock) {
        this.quantityStock = quantityStock;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void registerProduct(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inform the name: ");
        this.name = scanner.nextLine();
        System.out.println("Inform the brand: ");
        this.brand = scanner.nextLine();
        System.out.println("Write the description: ");
        this.description = scanner.nextLine();
        System.out.println("Inform the price: ");
        this.price = scanner.nextDouble();
        System.out.println("Inform the quantity in stock: ");
        this.quantityStock = scanner.nextInt();
        System.out.println("Inform the category's id of the product: ");
        this.idCategory = scanner.nextInt();
    }
}
