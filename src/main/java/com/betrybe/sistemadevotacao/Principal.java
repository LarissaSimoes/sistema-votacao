package com.betrybe.sistemadevotacao;

import java.util.Scanner;

/**
 * Classe principal do sistema de votação.
 */
public class Principal {

  /**
   * Método principal do sistema de votação.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamento = new GerenciamentoVotacao();
    Scanner scanner = new Scanner(System.in);

    // Cadastro de pessoas candidatas
    while (true) {
      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      String opcaoCandidato = scanner.nextLine();

      if ("2".equals(opcaoCandidato)) {
        break;
      }

      if ("1".equals(opcaoCandidato)) {
        System.out.print("Entre com o nome da pessoa candidata: ");
        String nomeCandidata = scanner.nextLine();

        System.out.print("Entre com o número da pessoa candidata: ");
        int numeroCandidata = Integer.parseInt(scanner.nextLine());

        gerenciamento.cadastrarPessoaCandidata(nomeCandidata, numeroCandidata);
      }
    }

    // Cadastro de pessoas eleitoras
    while (true) {
      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");
      System.out.print("Entre com o número correspondente à opção desejada: ");
      String opcaoEleitor = scanner.nextLine();

      if ("2".equals(opcaoEleitor)) {
        break;
      }

      if ("1".equals(opcaoEleitor)) {
        System.out.print("Entre com o nome da pessoa eleitora: ");
        String nomeEleitora = scanner.nextLine();

        System.out.print("Entre com o CPF da pessoa eleitora: ");
        String cpfEleitora = scanner.nextLine();

        gerenciamento.cadastrarPessoaEleitora(nomeEleitora, cpfEleitora);
      }
    }

    // Votação
    boolean continuarVotando = true;
    while (continuarVotando) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Finalizar Votação");
      String opcaoVotacao = scanner.nextLine();

      switch (opcaoVotacao) {
        case "1":
          System.out.print("Entre com o CPF da pessoa eleitora: ");
          String cpfEleitora = scanner.nextLine();

          System.out.print("Entre com o número da pessoa candidata: ");
          int numeroCandidata = Integer.parseInt(scanner.nextLine());

          gerenciamento.votar(cpfEleitora, numeroCandidata);
          break;
        case "2":
          gerenciamento.mostrarResultado();
          break;
        case "3":
          gerenciamento.mostrarResultado();
          continuarVotando = false;
          break;
        default:
          System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
          break;
      }
    }
  }
}
