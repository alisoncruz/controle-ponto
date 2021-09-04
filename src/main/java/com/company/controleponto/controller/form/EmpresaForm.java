package com.company.controleponto.controller.form;

import com.company.controleponto.model.Empresa;
import com.company.controleponto.model.embedded.Endereco;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmpresaForm {
  @NotNull
  @NotEmpty
  @Size(min = 5, max = 30)
  private String descricao;

  @NotNull
  @NotEmpty
  @Size(min = 18, max = 18)
  private String cnpj;

  @NotNull
  @NotEmpty
  @Size(max = 20)
  private String logradouro;

  @NotNull
  @NotEmpty
  @Size(max = 20)
  private String numero;

  @NotNull
  @NotEmpty
  @Size(max = 20)
  private String bairro;

  @NotNull
  @NotEmpty
  @Size(max = 20)
  private String cep;

  @NotNull
  @NotEmpty
  @Size(max = 20)
  private String cidade;

  @NotNull
  @NotEmpty
  @Size(min = 2, max = 2)
  private String estado;

  @NotNull
  @NotEmpty
  @Size(max = 15)
  private String telefone;

  public Empresa converter() {
    Endereco endereco = new Endereco();
    endereco.setBairro(this.bairro);
    endereco.setCidade(this.cidade);
    endereco.setEstado(this.estado);
    endereco.setCep(this.cep);
    endereco.setLogradouro(this.logradouro);
    endereco.setNumero(this.numero);
    return Empresa.builder().endereco(endereco).telefone(this.telefone).build();
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public String getLogradouro() {
    return logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getNumero() {
    return numero;
  }

  public void setNumero(String numero) {
    this.numero = numero;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
