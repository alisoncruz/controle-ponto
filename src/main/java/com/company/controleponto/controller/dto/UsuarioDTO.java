package com.company.controleponto.controller.dto;

import com.company.controleponto.model.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDTO {
  private Long id;
  private CategoriaUsuarioDTO categoriaUsuario;
  private String nome;
  private Empresa empresa;
  private NivelAcessoDTO nivelAcesso;
  private JornadaTrabalhoDTO jornadaTrabalho;
  private BigDecimal tolerancia;
  private LocalDateTime inicioJornada;
  private LocalDateTime finalJornada;

  public UsuarioDTO(Usuario usuario) {
    this.id = usuario.getId();
    this.categoriaUsuario = new CategoriaUsuarioDTO(usuario.getCategoriaUsuario());
    this.nome = usuario.getNome();
    this.empresa = usuario.getEmpresa();
    this.nivelAcesso = new NivelAcessoDTO(usuario.getNivelAcesso());
    this.jornadaTrabalho = new JornadaTrabalhoDTO(usuario.getJornadaTrabalho());
    this.tolerancia = usuario.getTolerancia();
    this.inicioJornada = usuario.getInicioJornada();
    this.finalJornada = usuario.getFinalJornada();
  }

  public static List<UsuarioDTO> listaDTO(List<Usuario> lista) {
    return lista.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CategoriaUsuarioDTO getCategoriaUsuario() {
    return categoriaUsuario;
  }

  public void setCategoriaUsuario(CategoriaUsuarioDTO categoriaUsuario) {
    this.categoriaUsuario = categoriaUsuario;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Empresa getEmpresa() {
    return empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

  public NivelAcessoDTO getNivelAcesso() {
    return nivelAcesso;
  }

  public void setNivelAcesso(NivelAcessoDTO nivelAcesso) {
    this.nivelAcesso = nivelAcesso;
  }

  public JornadaTrabalhoDTO getJornadaTrabalho() {
    return jornadaTrabalho;
  }

  public void setJornadaTrabalho(JornadaTrabalhoDTO jornadaTrabalho) {
    this.jornadaTrabalho = jornadaTrabalho;
  }

  public BigDecimal getTolerancia() {
    return tolerancia;
  }

  public void setTolerancia(BigDecimal tolerancia) {
    this.tolerancia = tolerancia;
  }

  public LocalDateTime getInicioJornada() {
    return inicioJornada;
  }

  public void setInicioJornada(LocalDateTime inicioJornada) {
    this.inicioJornada = inicioJornada;
  }

  public LocalDateTime getFinalJornada() {
    return finalJornada;
  }

  public void setFinalJornada(LocalDateTime finalJornada) {
    this.finalJornada = finalJornada;
  }
}
