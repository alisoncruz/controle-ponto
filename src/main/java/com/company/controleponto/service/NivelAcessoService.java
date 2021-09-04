package com.company.controleponto.service;

import com.company.controleponto.model.NivelAcesso;
import com.company.controleponto.repository.NivelAcessoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NivelAcessoService {
    NivelAcessoRepository nivelAcessoRepository;

    @Autowired
    public NivelAcessoService(NivelAcessoRepository nivelAcessoRepository) {
        this.nivelAcessoRepository = nivelAcessoRepository;
    }

    public List<NivelAcesso> listar() {
        return this.nivelAcessoRepository.findAll();
    }

    public NivelAcesso salvar(NivelAcesso nivelAcesso) {
        return nivelAcessoRepository.save(nivelAcesso);
    }

    public NivelAcesso buscar(Long id) {
        NivelAcesso nivelAcesso = nivelAcessoRepository.getById(id);
        if (nivelAcesso == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return nivelAcesso;
    }

    public NivelAcesso atualizar(NivelAcesso nivelAcesso, Long codigo) {
        NivelAcesso nivelAcessoOld = nivelAcessoRepository.getById(codigo);
        if (nivelAcessoOld == null) throw new EmptyResultDataAccessException(1);
        BeanUtils.copyProperties(nivelAcesso, nivelAcessoOld, "codigo");
        NivelAcesso nivelAcessoAtualizado = nivelAcessoRepository.save(nivelAcessoOld);
        return nivelAcessoAtualizado;
    }

    public void remover(Long codigo) {
        NivelAcesso nivelAcessoOld = nivelAcessoRepository.getById(codigo);
        if (nivelAcessoOld == null) throw new EmptyResultDataAccessException(1);
        nivelAcessoRepository.deleteById(codigo);
    }
}
