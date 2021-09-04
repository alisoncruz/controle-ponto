package com.company.controleponto.controller.dto;

import com.company.controleponto.model.Empresa;
import com.company.controleponto.model.embedded.Endereco;

import java.util.List;
import java.util.stream.Collectors;

public class EmpresaDTO {
  private Long id;
  private String descricao;
  private String cnpj;
  private Endereco endereco;
  private String telefone;

  public EmpresaDTO(Empresa empresa) {
    this.id = empresa.getId();
    this.descricao = empresa.getDescricao();
    this.cnpj = empresa.getCnpj();
    this.endereco = empresa.getEndereco();
    this.telefone = empresa.getTelefone();
  }

  public static List<EmpresaDTO> listaDTO(List<Empresa> listaEmpresas) {
    return listaEmpresas.stream()
        .map(empresa -> new EmpresaDTO(empresa))
        .collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
}
