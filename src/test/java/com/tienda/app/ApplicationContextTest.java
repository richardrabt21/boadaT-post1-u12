package com.tienda.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class ApplicationContextTest {

    @Test
    void contextLoads() {
        // Verifica que todos los beans de la aplicacion se
        // construyen correctamente con el perfil dev, sin
        // necesitar una base de datos externa (usa H2 en memoria).
    }
}
