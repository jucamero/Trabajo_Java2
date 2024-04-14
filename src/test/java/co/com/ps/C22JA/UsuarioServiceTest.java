package co.com.ps.C22JA;

import co.com.ps.C22JA.entity.Usuario;
import co.com.ps.C22JA.repository.UsuarioRepository;
import co.com.ps.C22JA.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {
    private UsuarioRepository usuarioRepository;
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        usuarioRepository = mock(UsuarioRepository.class);
        usuarioService = new UsuarioService(usuarioRepository);
    }

    @Test
    public void testGetUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Producto de prueba");
        usuario.setEmail("Correo de prueba");

        when(usuarioRepository.getReferenceById(1L)).thenReturn(usuario);

        Usuario resultado = usuarioService.getUsuario(1L);

        assertNotNull(resultado);
        assertEquals("Producto de prueba", resultado.getNombre());
        assertEquals("Correo de prueba", resultado.getEmail());
    }

    @Test
    public void testGetAllUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        listaUsuarios.add(new Usuario(1L, "Producto 1", "Correo 1"));
        listaUsuarios.add(new Usuario(2L, "Producto 2", "Correo 2"));

        when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

        List<Usuario> resultado = usuarioService.getAllUsuarios();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }
}