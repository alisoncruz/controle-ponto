package com.company.controleponto.service;

import com.company.controleponto.model.Movimentacao;
import com.company.controleponto.model.Movimentacao.MovimentacaoId;
import com.company.controleponto.repository.MovimentacaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentacaoService {
  MovimentacaoRepository movimentacaoRepository;

  @Autowired
  public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
    this.movimentacaoRepository = movimentacaoRepository;
  }

  public List<Movimentacao> listar() {
    return this.movimentacaoRepository.findAll();
  }

  public Movimentacao salvar(Movimentacao movimentacao) {
    return movimentacaoRepository.save(movimentacao);
  }

  public Movimentacao buscar(Movimentacao.MovimentacaoId id) {
    Movimentacao movimentacao = movimentacaoRepository.getById(id);
    if (movimentacao == null) {
      throw new EmptyResultDataAccessException(1);
    }
    return movimentacao;
  }

  public Movimentacao atualizar(Movimentacao movimentacao, Movimentacao.MovimentacaoId codigo) {
    Movimentacao movimentacaoOld = movimentacaoRepository.getById(codigo);
    if (movimentacaoOld == null) throw new EmptyResultDataAccessException(1);
    BeanUtils.copyProperties(movimentacao, movimentacaoOld, "codigo");
    Movimentacao movimentacaoAtualizada = movimentacaoRepository.save(movimentacaoOld);
    return movimentacaoAtualizada;
  }

  public void remover(Movimentacao.MovimentacaoId codigo) {
    Movimentacao movimentacaoOld = movimentacaoRepository.getById(codigo);
    if (movimentacaoOld == null) throw new EmptyResultDataAccessException(1);
    movimentacaoRepository.deleteById(codigo);
  }
}
