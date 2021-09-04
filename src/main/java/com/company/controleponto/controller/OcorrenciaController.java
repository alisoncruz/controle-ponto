package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.OcorrenciaDTO;
import com.company.controleponto.controller.form.OcorrenciaForm;
import com.company.controleponto.model.Ocorrencia;
import com.company.controleponto.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    OcorrenciaService ocorrenciaService;

    @Autowired
    public OcorrenciaController(OcorrenciaService ocorrenciaService) {
        this.ocorrenciaService = ocorrenciaService;
    }

    @GetMapping
    public ResponseEntity<?> listarOcorrencias() {
        List<Ocorrencia> ocorrencias = ocorrenciaService.listar();
        if (ocorrencias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(OcorrenciaDTO.listaDTO(ocorrencias));
    }

    @PostMapping
    public ResponseEntity<OcorrenciaDTO> criarOcorrencia(
            @RequestBody @Valid OcorrenciaForm ocorrenciaForm, HttpServletResponse httpServletResponse) {
        Ocorrencia ocorrenciaSalva = ocorrenciaService.salvar(ocorrenciaForm.converter());
        return ResponseEntity.ok(new OcorrenciaDTO(ocorrenciaSalva));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<OcorrenciaDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
        Ocorrencia ocorrencia = ocorrenciaService.buscar(codigo);
        return ResponseEntity.ok(new OcorrenciaDTO(ocorrencia));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<OcorrenciaDTO> atualizar(
            @PathVariable("codigo") Long codigo, @RequestBody @Valid OcorrenciaForm ocorrencia) {
        Ocorrencia ocorrenciaAtualizado = ocorrenciaService.atualizar(ocorrencia.converter(), codigo);
        return ResponseEntity.ok(new OcorrenciaDTO(ocorrenciaAtualizado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerOcorrencia(@PathVariable Long codigo) {
        ocorrenciaService.remover(codigo);
        return ResponseEntity.noContent().build();
    }
}
