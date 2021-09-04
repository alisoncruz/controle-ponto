package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.TipoDataDTO;
import com.company.controleponto.controller.form.TipoDataForm;
import com.company.controleponto.model.TipoData;
import com.company.controleponto.service.TipoDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipodata")
public class TipoDataController {

    TipoDataService tipoDataService;

    @Autowired
    public TipoDataController(TipoDataService tipoDataService) {
        this.tipoDataService = tipoDataService;
    }

    @GetMapping
    public ResponseEntity<?> listarTipoDatas() {
        List<TipoData> tipoDatas = tipoDataService.listar();
        if (tipoDatas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(TipoDataDTO.listaDTO(tipoDatas));
    }

    @PostMapping
    public ResponseEntity<TipoDataDTO> criarTipoData(
            @RequestBody @Valid TipoDataForm tipoDataForm, HttpServletResponse httpServletResponse) {
        TipoData tipoDataSalva = tipoDataService.salvar(tipoDataForm.converter());
        return ResponseEntity.ok(new TipoDataDTO(tipoDataSalva));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<TipoDataDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
        TipoData tipoData = tipoDataService.buscar(codigo);
        return ResponseEntity.ok(new TipoDataDTO(tipoData));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<TipoDataDTO> atualizar(
            @PathVariable("codigo") Long codigo, @RequestBody @Valid TipoDataForm tipoData) {
        TipoData tipoDataAtualizado = tipoDataService.atualizar(tipoData.converter(), codigo);
        return ResponseEntity.ok(new TipoDataDTO(tipoDataAtualizado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerTipoData(@PathVariable Long codigo) {
        tipoDataService.remover(codigo);
        return ResponseEntity.noContent().build();
    }
}
