package testesControllers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.NoSuchElementException;

import documin.controllers.DocumentoController;
import documin.controllers.ElementoController;
import documin.entities.Documento;
import documin.entities.Elemento;
import documin.extendsElemento.Texto;

public class ElementoControllerTest {
    private ElementoController elementoController;
    private DocumentoController documentoController;
    private Map<String, Documento> documentos;

    @BeforeEach
    public void setUp() {
        documentoController = new DocumentoController();
        documentos = documentoController.getDocumentos();
        elementoController = new ElementoController(documentoController, documentos);
    }

    @Test
    public void testAdicionarElemento() {
        documentoController.criarDocumento("Documento1");
        Elemento elemento = new Texto(1, "Texto1", null);
        boolean resultado = elementoController.adicionarElemento("Documento1", elemento);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void testAdicionarElementoDocumentoInexistente() {
        Elemento elemento = new Texto(1, "Texto1", null);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.adicionarElemento("Documento2", elemento);
        });
    }

    @Test
    public void testGetNumeroElementos() {
        documentoController.criarDocumento("Documento3");
        Elemento elemento = new Texto(1, "Texto1", null);
        elementoController.adicionarElemento("Documento3", elemento);
        int resultado = elementoController.getNumeroElementos("Documento3");
        Assertions.assertEquals(1, resultado);
    }

    @Test
    public void testGetNumeroElementosDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.getNumeroElementos("Documento4");
        });
    }

    @Test
    public void testCriarTexto() {
        documentoController.criarDocumento("Documento6");
        int resultado = elementoController.criarTexto("Documento6", "Texto1", 1);
        Assertions.assertNotEquals(-1, resultado);
    }

    @Test
    public void testCriarTextoDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.criarTexto("Documento6", "Texto1", 1);
        });
    }

    @Test
    public void testCriarTitulo() {
        documentoController.criarDocumento("Documento7");
        int resultado = elementoController.criarTitulo("Documento7", "Título1", 1, 1, true);
        Assertions.assertNotEquals(-1, resultado);
    }

    @Test
    public void testCriarTituloDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.criarTitulo("Documento8", "Título1", 1, 1, true);
        });
    }

    @Test
    public void testCriarLista() {
        documentoController.criarDocumento("Documento9");
        int resultado = elementoController.criarLista("Documento9", "Item1,Item2,Item3", 1, ",", "-");
        Assertions.assertNotEquals(-1, resultado);
    }

    @Test
    public void testCriarListaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.criarLista("Documento10", "Item1,Item2,Item3", 1, ",", "-");
        });
    }

    @Test
    public void testCriarTermo() {
        documentoController.criarDocumento("Documento11");
        int resultado = elementoController.criarTermo("Documento11", "Termo1,Termo2,Termo3", 1, ",", "ASC");
        Assertions.assertNotEquals(-1, resultado);
    }

    @Test
    public void testCriarTermoDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.criarTermo("Documento12", "Termo1,Termo2,Termo3", 1, ",", "ASC");
        });
    }

    @Test
    public void testPegarRepresentacaoCompleta() {
        documentoController.criarDocumento("Documento13");
        Elemento elemento = new Texto(1, "Texto1", null);
        elementoController.adicionarElemento("Documento13", elemento);
        String resultado = elementoController.pegarRepresentacaoCompleta("Documento13", 0);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void testPegarRepresentacaoCompletaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.pegarRepresentacaoCompleta("Documento14", 0);
        });
    }

    @Test
    public void testPegarRepresentacaoResumida() {
        documentoController.criarDocumento("Documento15");
        Elemento elemento = new Texto(1, "Texto1", null);
        elementoController.adicionarElemento("Documento15", elemento);
        String resultado = elementoController.pegarRepresentacaoResumida("Documento15", 0);
        Assertions.assertNotNull(resultado);
    }

    @Test
    public void testPegarRepresentacaoResumidaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.pegarRepresentacaoResumida("Documento16", 0);
        });
    }

    @Test
    public void testRemoverElemento() {
        documentoController.criarDocumento("Documento17");
        Elemento elemento = new Texto(1, "Texto1", null);
        elementoController.adicionarElemento("Documento17", elemento);
        boolean resultado = elementoController.removerElemento("Documento17", elemento);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void testRemoverElementoDocumentoInexistente() {
        Elemento elemento = new Texto(1, "Texto1", null);
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.removerElemento("Documento18", elemento);
        });
    }

    @Test
    public void testMoverElementoParaCima() {
        documentoController.criarDocumento("Documento19");
        Elemento elemento1 = new Texto(1, "Texto1", null);
        Elemento elemento2 = new Texto(2, "Texto2", null);
        elementoController.adicionarElemento("Documento19", elemento1);
        elementoController.adicionarElemento("Documento19", elemento2);
        elementoController.moverElementoParaCima("Documento19", 1);
    }

    @Test
    public void testMoverElementoParaCimaDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.moverElementoParaCima("Documento20", 1);
        });
    }

    @Test
    public void testMoverElementoParaBaixo() {
        documentoController.criarDocumento("Documento21");
        Elemento elemento1 = new Texto(1, "Texto1", null);
        Elemento elemento2 = new Texto(2, "Texto2", null);
        elementoController.adicionarElemento("Documento21", elemento1);
        elementoController.adicionarElemento("Documento21", elemento2);
        elementoController.moverElementoParaBaixo("Documento21", 0);
    }

    @Test
    public void testMoverElementoParaBaixoDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.moverElementoParaBaixo("Documento22", 0);
        });
    }

    @Test
    public void testCriarAtalho() {
    	documentoController.criarDocumento("Documento23");
      	documentoController.criarDocumento("Documento24");
        int resultado = elementoController.criarAtalho("Documento23", "Documento24");
        Assertions.assertEquals(1, resultado);
    }

    @Test
    public void testCriarAtalhoDocumentoInexistente() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            elementoController.criarAtalho("Documento25", "Documento26");
        });
    }

}

