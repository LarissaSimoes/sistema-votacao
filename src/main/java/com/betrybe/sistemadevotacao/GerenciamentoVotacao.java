package com.betrybe.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe que representa o gerenciamento de votação.
 */
public class GerenciamentoVotacao implements GerenciamentoVotacaoInterface {
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfsComputados;

  /**
   * Construtor da classe GerenciamentoVotacao.
   */
  public GerenciamentoVotacao() {
    pessoasCandidatas = new ArrayList<>();
    pessoasEleitoras = new ArrayList<>();
    cpfsComputados = new ArrayList<>();
  }


  @Override
  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
      if (pessoaCandidata.getNumero() == numero) {
        System.out.println("Número da pessoa candidata já utilizado!");
        return;
      }
    }
    pessoasCandidatas.add(new PessoaCandidata(nome, numero));
  }

  @Override
  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoaEleitora : pessoasEleitoras) {
      if (pessoaEleitora.getCpf().equals(cpf)) {
        System.out.println("Pessoa eleitora já cadastrada!");
        return;
      }
    }
    pessoasEleitoras.add(new PessoaEleitora(nome, cpf));
  }

  @Override
  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    if (cpfsComputados.contains(cpfPessoaEleitora)) {
      System.out.println("Pessoa eleitora já votou!");
      return;
    }

    boolean candidatoEncontrado = false;
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        candidata.receberVoto();
        candidatoEncontrado = true;
        break;
      }
    }

    if (!candidatoEncontrado) {
      System.out.println("Número de candidato não encontrado!");
      return;
    }

    cpfsComputados.add(cpfPessoaEleitora);
  }


  @Override
  public void mostrarResultado() {
    boolean verificaVotos = cpfsComputados.isEmpty();
    if (!verificaVotos) {
      double totalVotos = cpfsComputados.size();
      for (PessoaCandidata pessoaCandidata : pessoasCandidatas) {
        int conta = (int) Math.floor((pessoaCandidata.getVotos() / totalVotos) * 100);
        System.out.println("Nome: " + pessoaCandidata.nome
            + " - " + pessoaCandidata.getVotos() + " votos ( " + conta + "% )");
      }
      System.out.println("Total de votos: " + totalVotos);
    }
  }
}
