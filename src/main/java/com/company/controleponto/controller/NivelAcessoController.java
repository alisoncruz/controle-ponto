package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.NivelAcessoDTO;
import com.company.controleponto.controller.form.NivelAcessoForm;
import com.company.controleponto.model.NivelAcesso;
import com.company.controleponto.service.NivelAcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nivelacesso")
public class NivelAcessoController {

    NivelAcessoService nivelAcessoService;

    @Autowired
    public NivelAcessoController(NivelAcessoService nivelAcessoService) {
        this.nivelAcessoService = nivelAcessoService;
    }

    @GetMapping
    public ResponseEntity<?> listarNivelAcessos() {
        List<NivelAcesso> nivelAcessos = nivelAcessoService.listar();
        if (nivelAcessos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(NivelAcessoDTO.listaDTO(nivelAcessos));
    }

    @PostMapping
    public ResponseEntity<NivelAcessoDTO> criarNivelAcesso(
            @RequestBody @Valid NivelAcessoForm nivelAcessoForm, HttpServletResponse httpServletResponse) {
        NivelAcesso nivelAcessoSalva = nivelAcessoService.salvar(nivelAcessoForm.converter());
        return ResponseEntity.ok(new NivelAcessoDTO(nivelAcessoSalva));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<NivelAcessoDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
        NivelAcesso nivelAcesso = nivelAcessoService.buscar(codigo);
        return ResponseEntity.ok(new NivelAcessoDTO(nivelAcesso));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<NivelAcessoDTO> atualizar(
            @PathVariable("codigo") Long codigo, @RequestBody @Valid NivelAcessoForm nivelAcesso) {
        NivelAcesso nivelAcessoAtualizado = nivelAcessoService.atualizar(nivelAcesso.converter(), codigo);
        return ResponseEntity.ok(new NivelAcessoDTO(nivelAcessoAtualizado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerNivelAcesso(@PathVariable Long codigo) {
        nivelAcessoService.remover(codigo);
        return ResponseEntity.noContent().build();
    }
}
