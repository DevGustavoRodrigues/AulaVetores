package com.mycompany.vetoresobjetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio2 {

    private ArrayList<Aluguel> alugueis;

    public Exercicio2() {
        this.alugueis = new ArrayList<>();
    }

    public void realizarAluguel(Usuario usuario, Livro livro) {
        Aluguel aluguel = new Aluguel(usuario, livro);
        alugueis.add(aluguel);
    }

    public void exibirDadosAluguel() {
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel registrado!");
        } else {
            System.out.println("Aluguéis realizados:");
            for (Aluguel aluguel : alugueis) {
                aluguel.exibirDados();
            }
        }
    }

    public static void main(String[] args) {
        Exercicio2 biblioteca = new Exercicio2();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Realizar aluguel");
            System.out.println("2 - Exibir aluguéis");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    Usuario usuario = new Usuario();
                    usuario.receberDados();
                    Livro livro = new Livro();
                    livro.receberDados();
                    biblioteca.realizarAluguel(usuario, livro);
                    System.out.println("Aluguel realizado!");
                    break;
                case 2:
                    biblioteca.exibirDadosAluguel();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }

            System.out.println();
        }
    }
}

class Usuario {

    private String nome;
    private String id;

    public Usuario() {
        this.nome = "";
        this.id = "";
    }

    public void receberDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do usuário: ");
        this.nome = scanner.nextLine();
        System.out.print("ID do usuário: ");
        this.id = scanner.nextLine();
    }

    public void exibirDados() {
        System.out.println("Usuário: " + this.nome + " (ID: " + this.id + ")");
    }
}

class Livro {

    private String nome;
    private String autor;
    private String tombo;

    public Livro() {
        this.nome = "";
        this.autor = "";
        this.tombo = "";
    }

    public void receberDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do livro: ");
        this.nome = scanner.nextLine();
        System.out.print("Autor do livro: ");
        this.autor = scanner.nextLine();
        System.out.print("Tombo do livro: ");
        this.tombo = scanner.nextLine();
    }

    public void exibirDados() {
        System.out.println("Livro: " + this.nome + " (Autor: " + this.autor + ", Tombo: " + this.tombo + ")");
    }
}

class Aluguel {

    private static int proximoId = 1;

    private Livro livro;
    private Usuario usuario;
    private String data;
    private int id;

    public Aluguel(Usuario usuario, Livro livro) {
        this.usuario = usuario;
        this.livro = livro;
        this.data = "";
        this.id = proximoId;
        proximoId++;
    }

    public void exibirDados() {
        System.out.println("ID do aluguel: " + this.id);
        System.out.println("Livro alugado:");
        this.livro.exibirDados();
        System.out.println("Usuário que realizou o aluguel:");
        this.usuario.exibirDados();
        System.out.println("Data do aluguel: " + this.data);
    }

    public void receberDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Data do aluguel (DD/MM/AAAA): ");
        this.data = scanner.nextLine();
    }
}
