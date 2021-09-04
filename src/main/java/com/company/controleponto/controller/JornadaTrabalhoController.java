package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.JornadaTrabalhoDTO;
import com.company.controleponto.controller.form.JornadaTrabalhoForm;
import com.company.controleponto.model.JornadaTrabalho;
import com.company.controleponto.service.JornadaTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

  JornadaTrabalhoService jornadaTrabalhoService;

  @Autowired
  public JornadaTrabalhoController(JornadaTrabalhoService jornadaTrabalhoService) {
    this.jornadaTrabalhoService = jornadaTrabalhoService;
  }

  @GetMapping
  public ResponseEntity<?> listarJornadas() {
    List<JornadaTrabalho> jornadas = jornadaTrabalhoService.listar();
    if (jornadas.isEmpty()) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.ok(JornadaTrabalhoDTO.listaDTO(jornadas));
  }

  @PostMapping
  public ResponseEntity<JornadaTrabalhoDTO> criarJornada(
      @RequestBody @Valid JornadaTrabalhoForm jornadaTrabalhoForm,
      HttpServletResponse httpServletResponse) {
    JornadaTrabalho jornadaSalva = jornadaTrabalhoService.salvar(jornadaTrabalhoForm.converter());
    return ResponseEntity.ok(new JornadaTrabalhoDTO(jornadaSalva));
  }

  @GetMapping("/{codigo}")
  public ResponseEntity<JornadaTrabalhoDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
    JornadaTrabalho jornadaTrabalho = jornadaTrabalhoService.buscar(codigo);
    return ResponseEntity.ok(new JornadaTrabalhoDTO(jornadaTrabalho));
  }

  @PutMapping("/{codigo}")
  public ResponseEntity<JornadaTrabalhoDTO> atualizar(
      @PathVariable("codigo") Long codigo,
      @RequestBody @Valid JornadaTrabalhoForm jornadaTrabalhoForm) {
    JornadaTrabalho jornadaAtualizada =
        jornadaTrabalhoService.atualizar(jornadaTrabalhoForm.converter(), codigo);
    return ResponseEntity.ok(new JornadaTrabalhoDTO(jornadaAtualizada));
  }

  @DeleteMapping("/{codigo}")
  public ResponseEntity<?> removerJornadaTrabalho(@PathVariable Long codigo) {
    jornadaTrabalhoService.remover(codigo);
    return ResponseEntity.noContent().build();
  }
}
