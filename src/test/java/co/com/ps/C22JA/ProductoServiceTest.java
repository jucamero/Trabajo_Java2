package co.com.ps.C22JA;

import co.com.ps.C22JA.entity.Producto;
import co.com.ps.C22JA.repository.ProductoRepository;
import co.com.ps.C22JA.service.ProductoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductoServiceTest {
    private ProductoRepository productoRepository;
    private ProductoService productoService;

    @BeforeEach
    public void setUp() {
        productoRepository = mock(ProductoRepository.class);
        productoService = new ProductoService(productoRepository);
    }

    @Test
    public void testGetProducto() {
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Producto de prueba");
        producto.setPrecio(100.5);

        when(productoRepository.getReferenceById(1L)).thenReturn(producto);

        Producto resultado = productoService.getProducto(1L);

        assertNotNull(resultado);
        assertEquals("Producto de prueba", resultado.getNombre());
        assertEquals(100.5, resultado.getPrecio());
    }

    @Test
    public void testGetAllProductos() {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(new Producto(1L, "Producto 1", 10.0));
        listaProductos.add(new Producto(2L, "Producto 2", 20.0));

        when(productoRepository.findAll()).thenReturn(listaProductos);

        List<Producto> resultado = productoService.getAllProductos();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
    }
}