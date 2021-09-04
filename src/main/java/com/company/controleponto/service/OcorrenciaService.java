package com.company.controleponto.service;

import com.company.controleponto.model.Ocorrencia;
import com.company.controleponto.repository.OcorrenciaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository ocorrenciaRepository) {
        this.ocorrenciaRepository = ocorrenciaRepository;
    }

    public List<Ocorrencia> listar() {
        return this.ocorrenciaRepository.findAll();
    }

    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        return ocorrenciaRepository.save(ocorrencia);
    }

    public Ocorrencia buscar(Long id) {
        Ocorrencia ocorrencia = ocorrenciaRepository.getById(id);
        if (ocorrencia == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return ocorrencia;
    }

    public Ocorrencia atualizar(Ocorrencia ocorrencia, Long codigo) {
        Ocorrencia ocorrenciaOld = ocorrenciaRepository.getById(codigo);
        if (ocorrenciaOld == null) throw new EmptyResultDataAccessException(1);
        BeanUtils.copyProperties(ocorrencia, ocorrenciaOld, "codigo");
        Ocorrencia ocorrenciaAtualizada = ocorrenciaRepository.save(ocorrenciaOld);
        return ocorrenciaAtualizada;
    }

    public void remover(Long codigo) {
        Ocorrencia ocorrenciaOld = ocorrenciaRepository.getById(codigo);
        if (ocorrenciaOld == null) throw new EmptyResultDataAccessException(1);
        ocorrenciaRepository.deleteById(codigo);
    }
}
