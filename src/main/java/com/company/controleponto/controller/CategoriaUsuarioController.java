package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.CategoriaUsuarioDTO;
import com.company.controleponto.controller.form.CategoriaUsuarioForm;
import com.company.controleponto.model.CategoriaUsuario;
import com.company.controleponto.service.CategoriaUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaUsuarioController {

  CategoriaUsuarioService categoriaUsuarioService;

  @Autowired
  public CategoriaUsuarioController(CategoriaUsuarioService categoriaUsuarioService) {
    this.categoriaUsuarioService = categoriaUsuarioService;
  }

  @GetMapping
  public ResponseEntity<?> listarCategoriaUsuarios() {
    List<CategoriaUsuario> categoriaUsuarios = categoriaUsuarioService.listar();
    if (categoriaUsuarios.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(CategoriaUsuarioDTO.listaDTO(categoriaUsuarios));
  }

  @PostMapping
  public ResponseEntity<CategoriaUsuarioDTO> criarCategoriaUsuario(
      @RequestBody @Valid CategoriaUsuarioForm categoriaUsuarioForm, HttpServletResponse httpServletResponse) {
    CategoriaUsuario categoriaUsuarioSalva = categoriaUsuarioService.salvar(categoriaUsuarioForm.converter());
    return ResponseEntity.ok(new CategoriaUsuarioDTO(categoriaUsuarioSalva));
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<CategoriaUsuarioDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
    CategoriaUsuario categoriaUsuario = categoriaUsuarioService.buscar(codigo);
    return ResponseEntity.ok(new CategoriaUsuarioDTO(categoriaUsuario));
  }

  @PutMapping("/{codigo}")
  public ResponseEntity<CategoriaUsuarioDTO> atualizar(
      @PathVariable("codigo") Long codigo, @RequestBody @Valid CategoriaUsuarioForm categoriaUsuario) {
    CategoriaUsuario categoriaUsuarioAtualizada = categoriaUsuarioService.atualizar(categoriaUsuario.converter(), codigo);
    return ResponseEntity.ok(new CategoriaUsuarioDTO(categoriaUsuarioAtualizada));
  }

  @DeleteMapping("/{codigo}")
  public ResponseEntity<?> removerCategoriaUsuario(@PathVariable Long codigo) {
    categoriaUsuarioService.remover(codigo);
    return ResponseEntity.noContent().build();
  }
}
