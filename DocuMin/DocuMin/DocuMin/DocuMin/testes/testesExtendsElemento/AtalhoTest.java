package testesExtendsElemento;

import documin.entities.Documento;
import documin.extendsElemento.Termos;
import documin.extendsElemento.Titulo;
import documin.extendsElemento.Atalho;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtalhoTest {
    private Documento documentoReferenciado;

    @BeforeEach
    public void setUp() {
        documentoReferenciado = new Documento("Documento Referenciado", 10);
    }
    
    @Test
    public void testConstrutorValido() {
        Atalho atalho = new Atalho(documentoReferenciado);
        assertNotNull(atalho);
        assertEquals(documentoReferenciado, atalho.getDocumentoReferenciado());
    }


    @Test
    public void testConstrutorDocumentoReferenciadoNulo() {
        assertThrows(NullPointerException.class, () -> {
            new Atalho(null);
        });
    }


    @Test
    public void testConstrutorDocumentoReferenciadoComAtalhos() {
        documentoReferenciado.adicionarElementoAtalho(new Documento("Atalho 1", 5));
        assertThrows(IllegalStateException.class, () -> {
            new Atalho(documentoReferenciado);
        });
    }

    @Test
    public void testPegarRepresentacaoResumida() {
        Titulo titulo1 = new Titulo(3, "Título 1", null, 3, false);
        Termos termos1 = new Termos(2, "Termos 1", null, ",", "ALFABÉTICA");
        Termos termos2 = new Termos(4, "Termos 2", null, ",", "ALFABÉTICA");
        Titulo titulo2 = new Titulo(5, "Título 2", null, 3, false);

        documentoReferenciado.adicionarElemento(titulo1, false);
        documentoReferenciado.adicionarElemento(termos1, false);
        documentoReferenciado.adicionarElemento(termos2, false);
        documentoReferenciado.adicionarElemento(titulo2, false);

        Atalho atalho = new Atalho(documentoReferenciado);
        String representacaoResumida = atalho.gerarRepresentacaoResumida();
        assertEquals("3. Título 1, Termos 1, Termos 2, 3. Título 2", representacaoResumida);
    }

    @Test
    public void testPegarRepresentacaoCompleta() {
        Titulo titulo1 = new Titulo(3, "Título 1", null, 3, false);
        Termos termos1 = new Termos(2, "Termos 1", null, ",", "ALFABÉTICA");
        Termos termos2 = new Termos(4, "Termos 2", null, ",", "ALFABÉTICA");
        Titulo titulo2 = new Titulo(5, "Título 2", null, 3, false);

        documentoReferenciado.adicionarElemento(titulo1, false);
        documentoReferenciado.adicionarElemento(termos1, false);
        documentoReferenciado.adicionarElemento(termos2, false);
        documentoReferenciado.adicionarElemento(titulo2, false);

        Atalho atalho = new Atalho(documentoReferenciado);
        String representacaoCompleta = atalho.gerarRepresentacaoCompleta();
        assertEquals("3. Título 2", representacaoCompleta);
    }

    @Test
    public void testGerarRepresentacaoCompletaSemElementos() {
        Atalho atalho = new Atalho(documentoReferenciado);
        String representacaoCompleta = atalho.gerarRepresentacaoCompleta();
        assertEquals("", representacaoCompleta);
    }

    @Test
    public void testGerarRepresentacaoResumidaSemElementos() {
        Atalho atalho = new Atalho(documentoReferenciado);
        String representacaoResumida = atalho.gerarRepresentacaoResumida();
        assertEquals("", representacaoResumida);
    }
}
