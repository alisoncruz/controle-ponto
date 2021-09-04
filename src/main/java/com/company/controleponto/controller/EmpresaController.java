package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.EmpresaDTO;
import com.company.controleponto.controller.form.EmpresaForm;
import com.company.controleponto.model.Empresa;
import com.company.controleponto.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

  EmpresaService empresaService;

  @Autowired
  public EmpresaController(EmpresaService empresaService) {
    this.empresaService = empresaService;
  }

  @GetMapping
  public ResponseEntity<?> listarEmpresas() {
    List<Empresa> empresas = empresaService.listar();
    if (empresas.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(EmpresaDTO.listaDTO(empresas));
  }

  @PostMapping
  public ResponseEntity<EmpresaDTO> criarEmpresa(
      @RequestBody @Valid EmpresaForm empresaForm, HttpServletResponse httpServletResponse) {
    Empresa empresaSalva = empresaService.salvar(empresaForm.converter());
    return ResponseEntity.ok(new EmpresaDTO(empresaSalva));
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<EmpresaDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
    Empresa empresa = empresaService.buscar(codigo);
    return ResponseEntity.ok(new EmpresaDTO(empresa));
  }

  @PutMapping("/{codigo}")
  public ResponseEntity<EmpresaDTO> atualizar(
      @PathVariable("codigo") Long codigo, @RequestBody @Valid EmpresaForm empresa) {
    Empresa empresaAtualizada = empresaService.atualizar(empresa.converter(), codigo);
    return ResponseEntity.ok(new EmpresaDTO(empresaAtualizada));
  }

  @DeleteMapping("/{codigo}")
  public ResponseEntity<?> removerEmpresa(@PathVariable Long codigo) {
    empresaService.remover(codigo);
    return ResponseEntity.noContent().build();
  }
}
