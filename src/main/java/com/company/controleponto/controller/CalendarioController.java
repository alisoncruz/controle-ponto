package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.CalendarioDTO;
import com.company.controleponto.controller.form.CalendarioForm;
import com.company.controleponto.model.Calendario;
import com.company.controleponto.service.CalendarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {

    CalendarioService calendarioService;

    @Autowired
    public CalendarioController(CalendarioService calendarioService) {
        this.calendarioService = calendarioService;
    }

    @GetMapping
    public ResponseEntity<?> listarCalendarios() {
        List<Calendario> calendarios = calendarioService.listar();
        if (calendarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(CalendarioDTO.listaDTO(calendarios));
    }

    @PostMapping
    public ResponseEntity<CalendarioDTO> criarCalendario(
            @RequestBody @Valid CalendarioForm calendarioForm, HttpServletResponse httpServletResponse) {
        Calendario calendarioSalvo = calendarioService.salvar(calendarioForm.converter());
        return ResponseEntity.ok(new CalendarioDTO(calendarioSalvo));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CalendarioDTO> buscarPorCodigo(@PathVariable("codigo") Long codigo) {
        Calendario calendario = calendarioService.buscar(codigo);
        return ResponseEntity.ok(new CalendarioDTO(calendario));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<CalendarioDTO> atualizar(
            @PathVariable("codigo") Long codigo, @RequestBody @Valid CalendarioForm calendario) {
        Calendario calendarioAtualizado = calendarioService.atualizar(calendario.converter(), codigo);
        return ResponseEntity.ok(new CalendarioDTO(calendarioAtualizado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerCalendario(@PathVariable Long codigo) {
        calendarioService.remover(codigo);
        return ResponseEntity.noContent().build();
    }
}
