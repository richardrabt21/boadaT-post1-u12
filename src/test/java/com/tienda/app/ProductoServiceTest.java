package com.tienda.app;

import com.tienda.app.model.Producto;
import com.tienda.app.repository.ProductoRepository;
import com.tienda.app.service.ProductoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    private ProductoRepository repository;

    @InjectMocks
    private ProductoService service;

    @Test
    @DisplayName("Debe listar todos los productos")
    void listarTodos() {
        when(repository.findAll()).thenReturn(List.of(new Producto(1L, "Laptop", "Tecnologia", 1200.0)));

        List<Producto> productos = service.listarTodos();

        assertEquals(1, productos.size());
        assertEquals("Laptop", productos.get(0).getNombre());
        verify(repository).findAll();
    }

    @Test
    @DisplayName("Debe buscar producto por ID")
    void buscarPorId() {
        when(repository.findById(1L)).thenReturn(Optional.of(new Producto(1L, "Mouse", "Tecnologia", 25.0)));

        Optional<Producto> producto = service.buscarPorId(1L);

        assertTrue(producto.isPresent());
        assertEquals("Mouse", producto.get().getNombre());
    }
}
