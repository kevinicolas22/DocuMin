package testesControllers;


import documin.controllers.DocumentoController;
import documin.controllers.ElementoController;
import documin.controllers.VisaoController;
import documin.entities.Documento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;

public class VisaoControllerTest {
	private VisaoController visaoController;
    private DocumentoController documentoController;
    private ElementoController elementoController;
    private Map<String, Documento> documentos;
    
    @BeforeEach
    public void setUp() {
    	documentoController = new DocumentoController();
        documentos = documentoController.getDocumentos();
        elementoController = new ElementoController(documentoController, documentos);
        visaoController = new VisaoController(documentoController);
    }

    @Test
    public void testCriarVisaoCompleta() {
        documentoController.criarDocumento("Documento1");
        int resultado = visaoController.criarVisaoCompleta("Documento1");
        Assertions.assertEquals(0, resultado);
    }
    
    @Test
    public void testCriarVisaoCompletaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            visaoController.criarVisaoCompleta("Documento2");
        });
    }

    @Test
    public void testCriarVisaoResumida() {
        documentoController.criarDocumento("Documento3");
        int resultado = visaoController.criarVisaoResumida("Documento3");
        Assertions.assertEquals(0, resultado);
    }

    @Test
    public void testCriarVisaoResumidaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            visaoController.criarVisaoResumida("Documento4");
        });
    }

    @Test
    public void testCriarVisaoPrioritaria() {
        documentoController.criarDocumento("Documento5");
        int resultado = visaoController.criarVisaoPrioritaria("Documento5", 5);
        Assertions.assertEquals(0, resultado);
    }

    @Test
    public void testCriarVisaoPrioritariaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            visaoController.criarVisaoPrioritaria("Documento6", 3);
        });
    }

    @Test
    public void testCriarVisaoTitulo() {
        documentoController.criarDocumento("Documento6");
        int resultado = visaoController.criarVisaoTitulo("Documento6");
        Assertions.assertEquals(0, resultado);
    }

    @Test
    public void testCriarVisaoTituloDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            visaoController.criarVisaoTitulo("Documento8");
        });
    }

    @Test
    public void testExibirVisaoCompleta() {
        documentoController.criarDocumento("Documento9");
        elementoController.criarTexto("Documento9", "Texto1", 1);
        elementoController.criarTexto("Documento9", "Texto2", 1);
        String resultado = visaoController.exibirVisao(0, "Documento9");
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Texto1 Texto2", resultado);
    }

    @Test
    public void testExibirVisaoResumida() {
    	documentoController.criarDocumento("Documento10");
        elementoController.criarTexto("Documento10", "Texto1", 1);
        elementoController.criarTexto("Documento10", "Texto2", 1);
        String resultado = visaoController.exibirVisao(1, "Documento10");
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Texto1 Texto2", resultado);
    }

    @Test
    public void testExibirVisaoPrioritaria() {
    	documentoController.criarDocumento("Documento10");
        elementoController.criarTexto("Documento10", "Texto1", 2);
        elementoController.criarTexto("Documento10", "Texto2", 1);
        String resultado = visaoController.exibirVisao(2, "Documento10");
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("Texto1 Texto2", resultado);
    }

    @Test
    public void testExibirVisaoTitulo() {
        documentoController.criarDocumento("Documento12");
        elementoController.criarTitulo("Documento12", "Título1", 1, 1, true);
        elementoController.criarTexto("Documento12", "Texto1", 1);
        String resultado = visaoController.exibirVisao(3, "Documento12");
        Assertions.assertNotNull(resultado);
        Assertions.assertEquals("1. Título1 Texto1", resultado);
    }

    @Test
    public void testExibirVisaoDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            visaoController.exibirVisao(0, "Documento13");
        });
    }
}