package co.com.ps.C22JA.service;


import co.com.ps.C22JA.entity.Usuario;
import co.com.ps.C22JA.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UsuarioService implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario getUsuario(Long id) {
        return usuarioRepository.getReferenceById(id);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario s = usuarioRepository.getReferenceById(usuario.getId());
        s.setNombre(usuario.getNombre());
        s.setEmail(usuario.getEmail());

        if (s == null) {
            return null;
        } else {
            return usuarioRepository.save(usuario);
        }

    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);

    }




}
