package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.MovimentacaoDTO;
import com.company.controleponto.controller.form.MovimentacaoForm;
import com.company.controleponto.model.Movimentacao;
import com.company.controleponto.model.Movimentacao.MovimentacaoId;
import com.company.controleponto.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping
    public ResponseEntity<?> listarMovimentacoes() {
        List<Movimentacao> movimentacaos = movimentacaoService.listar();
        if (movimentacaos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(MovimentacaoDTO.listaDTO(movimentacaos));
    }

    @PostMapping
    public ResponseEntity<MovimentacaoDTO> criarMovimentacao(
            @RequestBody @Valid MovimentacaoForm movimentacaoForm, HttpServletResponse httpServletResponse) {
        Movimentacao movimentacaoSalvo = movimentacaoService.salvar(movimentacaoForm.converter());
        return ResponseEntity.ok(new MovimentacaoDTO(movimentacaoSalvo));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<MovimentacaoDTO> buscarPorCodigo(@PathVariable("codigo") Movimentacao.MovimentacaoId codigo) {
        Movimentacao movimentacao = movimentacaoService.buscar(codigo);
        return ResponseEntity.ok(new MovimentacaoDTO(movimentacao));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<MovimentacaoDTO> atualizar(
            @PathVariable("codigo") Movimentacao.MovimentacaoId codigo, @RequestBody @Valid MovimentacaoForm movimentacao) {
        Movimentacao movimentacaoAtualizada = movimentacaoService.atualizar(movimentacao.converter(), codigo);
        return ResponseEntity.ok(new MovimentacaoDTO(movimentacaoAtualizada));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerMovimentacao(@PathVariable Movimentacao.MovimentacaoId codigo) {
        movimentacaoService.remover(codigo);
        return ResponseEntity.noContent().build();
    }
}
