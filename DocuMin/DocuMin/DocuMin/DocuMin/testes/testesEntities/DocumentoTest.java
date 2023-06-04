package testesEntities;
import org.junit.jupiter.api.Test;

import documin.entities.Documento;
import documin.extendsElemento.Atalho;
import documin.extendsElemento.Termos;
import documin.extendsElemento.Titulo;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoTest {

    @Test
    void testAdicionarElemento() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, false);

        boolean result = documento.adicionarElemento(titulo, true);

        assertTrue(result);
        assertEquals(1, documento.getNumeroElementos());
        assertEquals(titulo, documento.getElementos().get(0));
    }

    @Test
    void testAdicionarElementoComTituloNulo() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, null, null, 1, false);

        assertThrows(IllegalArgumentException.class, () -> documento.adicionarElemento(titulo, true));
    }

    @Test
    void testAdicionarElementoComTamanhoMaximo() {
        Documento documento = new Documento("Meu Documento", 2);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, false);
        Titulo titulo2 = new Titulo(2, "Título 2", null, 1, false);
        Titulo titulo3 = new Titulo(3, "Título 3", null, 1, false);

        documento.adicionarElemento(titulo1, true);
        documento.adicionarElemento(titulo2, false);
        boolean result = documento.adicionarElemento(titulo3, true);

        assertFalse(result);
        assertEquals(2, documento.getNumeroElementos());
        assertEquals(titulo1, documento.getElementos().get(0));
        assertEquals(titulo2, documento.getElementos().get(1));
    }

    @Test
    void testAdicionarElementoAtalho() {
        Documento documento = new Documento("Meu Documento", 10);
        Documento documentoReferenciado = new Documento("Documento Referenciado", 10);

        boolean result = documento.adicionarElementoAtalho(documentoReferenciado);

        assertTrue(result);
        assertEquals(1, documento.getNumeroElementos());
        assertTrue(documento.getElementos().get(0) instanceof Atalho);
    }

    @Test
    void testAdicionarElementoAtalhoComDocumentoQuePossuiAtalhos() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, true);
        Titulo titulo2 = new Titulo(2, "Título 2", null, 1, true);
        documento.adicionarElemento(titulo1, true); 
        documento.adicionarElemento(titulo2, false);
    }

    @Test
    void testDocumentoPossuiAtalhos() {
        Documento documento = new Documento("Meu Documento", 10);
        Documento documentoReferenciado = new Documento("Documento Referenciado", 10);
        documento.adicionarElementoAtalho(documentoReferenciado);

        assertTrue(documento.documentoPossuiAtalhos());
    }

    @Test
    void testDocumentoNaoPossuiAtalhos() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, false);
        documento.adicionarElemento(titulo, true);

        assertFalse(documento.documentoPossuiAtalhos());
    }

    @Test
    void testMoverParaCima() {
        Documento documento = new Documento("Meu Documento", 5);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, false);
        Titulo titulo2 = new Titulo(2, "Título 2", null, 1, false);
        Titulo titulo3 = new Titulo(3, "Título 3", null, 1, false);
        documento.adicionarElemento(titulo1, true);
        documento.adicionarElemento(titulo2, false);
        documento.adicionarElemento(titulo3, false);

        documento.moverParaCima(2);

        assertEquals(titulo3, documento.getElementos().get(1));
        assertEquals(titulo2, documento.getElementos().get(2));
    }

    @Test
    void testMoverParaCimaComPosicaoInvalida() {
        Documento documento = new Documento("Meu Documento", 5);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, false);
        documento.adicionarElemento(titulo1, true);

        assertThrows(IllegalArgumentException.class, () -> documento.moverParaCima(0));
        assertThrows(IllegalArgumentException.class, () -> documento.moverParaCima(2));
    }

    @Test
    void testMoverParaBaixo() {
        Documento documento = new Documento("Meu Documento", 5);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, false);
        Titulo titulo2 = new Titulo(2, "Título 2", null, 1, false);
        Titulo titulo3 = new Titulo(3, "Título 3", null, 1, false);
        documento.adicionarElemento(titulo1, true);
        documento.adicionarElemento(titulo2, false);
        documento.adicionarElemento(titulo3, false);

        documento.moverParaBaixo(1);

        assertEquals(titulo2, documento.getElementos().get(2));
        assertEquals(titulo3, documento.getElementos().get(1));
    }

    @Test
    void testMoverParaBaixoComPosicaoInvalida() {
        Documento documento = new Documento("Meu Documento", 5);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, false);
        documento.adicionarElemento(titulo1, true);

        assertThrows(IllegalArgumentException.class, () -> documento.moverParaBaixo(0));
        assertThrows(IllegalArgumentException.class, () -> documento.moverParaBaixo(1));
    }

    @Test
    void testRemoverElemento() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, false);
        documento.adicionarElemento(titulo, true);

        boolean result = documento.removerElemento(titulo);

        assertTrue(result);
        assertEquals(0, documento.getNumeroElementos());
    }

    @Test
    void testRemoverElementoNulo() {
        Documento documento = new Documento("Meu Documento", 10);

        assertThrows(IllegalArgumentException.class, () -> documento.removerElemento(null));
    }

    @Test
    void testGetRepresentacao() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo1 = new Titulo(1, "Título 1", null, 1, false);
        Titulo titulo2 = new Titulo(2, "Título 2", null, 1, false);
        documento.adicionarElemento(titulo1, true);
        documento.adicionarElemento(titulo2, false);

        String[] representacao = documento.getRepresentacao();

        assertEquals(2, representacao.length);
        assertEquals(titulo1.gerarRepresentacaoCompleta(), representacao[0]);
        assertEquals(titulo2.gerarRepresentacaoCompleta(), representacao[1]);
    }

    @Test
    void testOrdenarTermos() {
        Documento documento = new Documento("Meu Documento", 10);
        Termos termos1 = new Termos(1, "Termos 1", null, ",", "ALFABÉTICA");
        Termos termos2 = new Termos(2, "Termos 2", null, ",", "ALFABÉTICA");
        documento.adicionarElemento(termos2, true);
        documento.adicionarElemento(termos1, false);

        documento.ordenarTermos();

        assertEquals(termos1, documento.getElementos().get(0));
        assertEquals(termos2, documento.getElementos().get(1));
    }

    @Test
    void testPegarRepresentacaoCompleta() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, true);
        documento.adicionarElemento(titulo, true);

        String representacao = documento.pegarRepresentacaoCompleta("Meu Documento", 0);

        assertEquals(titulo.gerarRepresentacaoCompleta(), representacao);
    }

    @Test
    void testPegarRepresentacaoCompletaComTituloDiferente() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, true);
        documento.adicionarElemento(titulo, true);

        assertThrows(IllegalArgumentException.class, () -> documento.pegarRepresentacaoCompleta("Outro Documento", 0));
    }

    @Test
    void testPegarRepresentacaoCompletaComPosicaoInvalida() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, true);
        documento.adicionarElemento(titulo, true);

        assertThrows(IllegalArgumentException.class, () -> documento.pegarRepresentacaoCompleta("Meu Documento", 1));
    }

    @Test
    void testPegarRepresentacaoResumida() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, true);
        documento.adicionarElemento(titulo, true);

        String representacao = documento.pegarRepresentacaoResumida("Meu Documento", 0);

        assertEquals(titulo.gerarRepresentacaoResumida(), representacao);
    }

    @Test
    void testPegarRepresentacaoResumidaComTituloDiferente() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, true);
        documento.adicionarElemento(titulo, true);

        assertThrows(IllegalArgumentException.class, () -> documento.pegarRepresentacaoResumida("Outro Documento", 0));
    }

    @Test
    void testPegarRepresentacaoResumidaComPosicaoInvalida() {
        Documento documento = new Documento("Meu Documento", 10);
        Titulo titulo = new Titulo(1, "Título 1", null, 1, true);
        documento.adicionarElemento(titulo, true);

        assertThrows(IllegalArgumentException.class, () -> documento.pegarRepresentacaoResumida("Meu Documento", 1));
    }
}

