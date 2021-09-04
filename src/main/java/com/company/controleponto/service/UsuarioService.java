package com.company.controleponto.service;

import com.company.controleponto.model.Usuario;
import com.company.controleponto.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listar() {
        return this.usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id) {
        Usuario usuario = usuarioRepository.getById(id);
        if (usuario == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return usuario;
    }

    public Usuario atualizar(Usuario usuario, Long codigo) {
        Usuario usuarioOld = usuarioRepository.getById(codigo);
        if (usuarioOld == null) throw new EmptyResultDataAccessException(1);
        BeanUtils.copyProperties(usuario, usuarioOld, "codigo");
        Usuario usuarioAtualizado = usuarioRepository.save(usuarioOld);
        return usuarioAtualizado;
    }

    public void remover(Long codigo) {
        Usuario usuarioOld = usuarioRepository.getById(codigo);
        if (usuarioOld == null) throw new EmptyResultDataAccessException(1);
        usuarioRepository.deleteById(codigo);
    }
}
