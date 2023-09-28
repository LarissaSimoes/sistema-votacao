package com.betrybe.sistemadevotacao;

/**
 * Classe que representa uma pessoa candidata.
 */
public class PessoaEleitora extends Pessoa {
  private String cpf;

  public PessoaEleitora(String nome, String cpf) {
    this.setNome(nome);
    this.cpf = cpf;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

}
