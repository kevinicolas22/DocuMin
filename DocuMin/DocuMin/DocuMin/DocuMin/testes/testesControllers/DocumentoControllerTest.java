package testesControllers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import documin.controllers.DocumentoController;

import java.util.NoSuchElementException;

public class DocumentoControllerTest {
    private DocumentoController documentoController;

    @BeforeEach
    public void setUp() {
        documentoController = new DocumentoController();
    }

    @Test
    public void testCriarDocumento() {
        boolean resultado = documentoController.criarDocumento("Documento1", 10);
        Assertions.assertTrue(resultado);
    }
	
    @Test
    public void testCriarDocumentoTituloExistente() {
        documentoController.criarDocumento("Documento2");
        boolean resultado = documentoController.criarDocumento("Documento2");
        Assertions.assertFalse(resultado);
    }
	
    @Test
    public void testCriarDocumentoTamanhoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            documentoController.criarDocumento("Documento3", 0);
        });
    }

    @Test
    public void testRemoverDocumento() {
        documentoController.criarDocumento("Documento4");
        boolean resultado = documentoController.removerDocumento("Documento4");
        Assertions.assertTrue(resultado);
    }

    @Test
    public void testRemoverDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            documentoController.removerDocumento("Documento5");
        });
    }

    @Test
    public void testGetNumeroElementos() {
        documentoController.criarDocumento("Documento6");
        int resultado = documentoController.getNumeroElementos("Documento6");
        Assertions.assertEquals(0, resultado);
    }

    @Test
    public void testGetNumeroElementosDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            documentoController.getNumeroElementos("Documento7");
        });
    }

    @Test
    public void testGetRepresentacaoDocumento() {
        documentoController.criarDocumento("Documento8");
        String[] resultado = documentoController.getRepresentacaoDocumento("Documento8");
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void testGetRepresentacaoDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            documentoController.getRepresentacaoDocumento("Documento9");
        });
    }
}
