package com.company.controleponto.controller;

import com.company.controleponto.controller.dto.BancoHorasDTO;
import com.company.controleponto.controller.form.BancoHorasForm;
import com.company.controleponto.model.BancoHoras;
import com.company.controleponto.service.BancoHorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/bancohoras")
public class BancoHorasController {

    BancoHorasService bancoHorasService;

    @Autowired
    public BancoHorasController(BancoHorasService bancoHorasService) {
        this.bancoHorasService = bancoHorasService;
    }

    @GetMapping
    public ResponseEntity<?> listarBancoHorass() {
        List<BancoHoras> bancoHorass = bancoHorasService.listar();
        if (bancoHorass.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(BancoHorasDTO.listaDTO(bancoHorass));
    }

    @PostMapping
    public ResponseEntity<BancoHorasDTO> criarBancoHoras(
            @RequestBody @Valid BancoHorasForm bancoHorasForm, HttpServletResponse httpServletResponse) {
        BancoHoras bancoHorasSalvo = bancoHorasService.salvar(bancoHorasForm.converter());
        return ResponseEntity.ok(new BancoHorasDTO(bancoHorasSalvo));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<BancoHorasDTO> buscarPorCodigo(@PathVariable("codigo") BancoHoras.BancoHorasId codigo) {
        BancoHoras bancoHoras = bancoHorasService.buscar(codigo);
        return ResponseEntity.ok(new BancoHorasDTO(bancoHoras));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<BancoHorasDTO> atualizar(
            @PathVariable("codigo") BancoHoras.BancoHorasId codigo, @RequestBody @Valid BancoHorasForm bancoHoras) {
        BancoHoras bancoHorasAtualizado = bancoHorasService.atualizar(bancoHoras.converter(), codigo);
        return ResponseEntity.ok(new BancoHorasDTO(bancoHorasAtualizado));
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<?> removerBancoHoras(@PathVariable BancoHoras.BancoHorasId codigo) {
        bancoHorasService.remover(codigo);
        return ResponseEntity.noContent().build();
    }
}
