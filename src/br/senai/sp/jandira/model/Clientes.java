package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Clientes {

    private String name, email, address;
    private long phone, cpf;
    private int idClient = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void registerClient(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inform the name: ");
        this.name = scanner.nextLine();
        System.out.println("Inform the email: ");
        this.email = scanner.nextLine();
        System.out.println("Inform the address: ");
        this.address = scanner.nextLine();
        System.out.println("Inform the cpf: ");
        this.cpf = scanner.nextLong();
        System.out.println("Inform the phone: ");
        this.phone = scanner.nextLong();
        System.out.println("==============================================");


    }
}
