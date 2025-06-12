package esfe.persistencia;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import java.sql.Connection; // Importa la clase Connection del paquete java.sql, que se utiliza para establecer una conexión con la base de datos.
import java.sql.SQLException; // Importa la clase SQLException del paquete java.sql, que se utiliza para manejar excepciones relacionadas con operaciones de base de datos.

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {
    ConnectionManager connectionManager;
    @BeforeEach
    void setUp() throws SQLException {
        // Se ejecuta antes de cada método de prueba.
        // Inicializa el ConnectionManager.
        connectionManager = ConnectionManager.getInstance();
    }

    @AfterEach
    void tearDown() throws SQLException {
        // Se ejecuta después de cada método de prueba.
        // Cierra la conexión y limpia los recursos.
        if (connectionManager != null) {
            connectionManager.disconnect();
            connectionManager = null; // Para asegurar que no se use accidentalmente
        }
    }

    @Test
    void connect() throws SQLException {
        // Intenta establecer una conexión a la base de datos utilizando el método connect() de ConnectionManager.
        Connection conn = connectionManager.connect();

        assertNotNull(conn, "La conexion no debe ser nula");

        assertFalse(conn.isClosed(), "La conexion debe esta abierta");
        if (conn != null) {
            conn.close(); // Cierra la conexión después de la prueba.
        }
    }
}