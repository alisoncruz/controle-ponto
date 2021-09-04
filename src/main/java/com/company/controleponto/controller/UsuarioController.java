package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.UsuarioDTO;
import com.company.controleponto.controller.form.UsuarioForm;
import com.company.controleponto.model.Usuario;
import com.company.controleponto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

  UsuarioService usuarioService;

  @Autowired
  public UsuarioController(UsuarioService usuarioService) {
    this.usuarioService = usuarioService;
  }

  @GetMapping
  public ResponseEntity<?> listarUsuarios() {
    List<Usuario> usuarios = usuarioService.listar();
    if (usuarios.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(UsuarioDTO.listaDTO(usuarios));
  }

  @PostMapping
  public ResponseEntity<UsuarioDTO> criarUsuario(
      @RequestBody @Valid UsuarioForm usuarioForm, HttpServletResponse httpServletResponse) {
    Usuario usuarioSalvo = usuarioService.salvar(usuarioForm.converter());
    return ResponseEntity.ok(new UsuarioDTO(usuarioSalvo));
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<UsuarioDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
    Usuario usuario = usuarioService.buscar(codigo);
    return ResponseEntity.ok(new UsuarioDTO(usuario));
  }

  @PutMapping("/{codigo}")
  public ResponseEntity<UsuarioDTO> atualizar(
      @PathVariable("codigo") Long codigo, @RequestBody @Valid UsuarioForm usuario) {
    Usuario usuarioAtualizado = usuarioService.atualizar(usuario.converter(), codigo);
    return ResponseEntity.ok(new UsuarioDTO(usuarioAtualizado));
  }

  @DeleteMapping("/{codigo}")
  public ResponseEntity<?> removerUsuario(@PathVariable Long codigo) {
    usuarioService.remover(codigo);
    return ResponseEntity.noContent().build();
  }
}
