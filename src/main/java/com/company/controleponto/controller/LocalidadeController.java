package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.LocalidadeDTO;
import com.company.controleponto.controller.form.LocalidadeForm;
import com.company.controleponto.model.Localidade;
import com.company.controleponto.service.LocalidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController {

  LocalidadeService localidadeService;

  @Autowired
  public LocalidadeController(LocalidadeService localidadeService) {
    this.localidadeService = localidadeService;
  }

  @GetMapping
  public ResponseEntity<?> listarLocalidades() {
    List<Localidade> localidades = localidadeService.listar();
    if (localidades.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(LocalidadeDTO.listaDTO(localidades));
  }

  @PostMapping
  public ResponseEntity<LocalidadeDTO> criarLocalidade(
      @RequestBody @Valid LocalidadeForm localidadeForm, HttpServletResponse httpServletResponse) {
    Localidade localidadeSalva = localidadeService.salvar(localidadeForm.converter());
    return ResponseEntity.ok(new LocalidadeDTO(localidadeSalva));
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<LocalidadeDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
    Localidade localidade = localidadeService.buscar(codigo);
    return ResponseEntity.ok(new LocalidadeDTO(localidade));
  }

  @PutMapping("/{codigo}")
  public ResponseEntity<LocalidadeDTO> atualizar(
      @PathVariable("codigo") Long codigo, @RequestBody @Valid LocalidadeForm localidade) {
    Localidade localidadeAtualizada = localidadeService.atualizar(localidade.converter(), codigo);
    return ResponseEntity.ok(new LocalidadeDTO(localidadeAtualizada));
  }

  @DeleteMapping("/{codigo}")
  public ResponseEntity<?> removerLocalidade(@PathVariable Long codigo) {
    localidadeService.remover(codigo);
    return ResponseEntity.noContent().build();
  }
}
