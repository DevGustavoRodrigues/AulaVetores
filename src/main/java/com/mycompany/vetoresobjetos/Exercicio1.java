package com.mycompany.vetoresobjetos;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio1 {

    private ArrayList<Contato> contatos;

    public Exercicio1() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void exibirContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia!");
        } else {
            System.out.println("Contatos na agenda:");
            for (Contato contato : contatos) {
                contato.exibirDados();
            }
        }
    }

    public static void main(String[] args) {
        Exercicio1 agenda = new Exercicio1();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Exibir contatos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    Contato contato = new Contato();
                    contato.receberDados();
                    agenda.adicionarContato(contato);
                    System.out.println("Contato adicionado!");
                    break;
                case 2:
                    agenda.exibirContatos();
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

class Contato {

    private String nome;
    private String fone;

    public Contato() {
        this.nome = "";
        this.fone = "";
    }

    public void receberDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        this.nome = scanner.nextLine();
        System.out.print("Fone: ");
        this.fone = scanner.nextLine();
    }

    public void exibirDados() {
        System.out.println(this.nome + " - " + this.fone);
    }
}
