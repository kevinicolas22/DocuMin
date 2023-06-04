package testesExtendsElemento;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import documin.extendsElemento.Titulo;
import documin.entities.Elemento;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TituloTest {

    @Test
    void testGerarRepresentacaoCompletaLinkavel() {
        int prioridade = 1;
        String valor = "Título 1";
        Map<String, String> propriedades = new HashMap<>();
        int nivel = 2;
        boolean linkavel = true;
        Elemento titulo = new Titulo(prioridade, valor, propriedades, nivel, linkavel);

        String expected = "2. Título 1 -- 2-TÍTULO1";
        String result = titulo.gerarRepresentacaoCompleta();

        assertEquals(expected, result);
    }

    @Test
    void testGerarRepresentacaoCompletaNaoLinkavel() {
        int prioridade = 1;
        String valor = "Título 2";
        Map<String, String> propriedades = new HashMap<>();
        int nivel = 3;
        boolean linkavel = false;
        Elemento titulo = new Titulo(prioridade, valor, propriedades, nivel, linkavel);

        String expected = "3. Título 2";
        String result = titulo.gerarRepresentacaoCompleta();

        assertEquals(expected, result);
    }

    @Test
    void testGerarRepresentacaoResumida() {
        int prioridade = 1;
        String valor = "Título 3";
        Map<String, String> propriedades = new HashMap<>();
        int nivel = 4;
        boolean linkavel = true;
        Elemento titulo = new Titulo(prioridade, valor, propriedades, nivel, linkavel);

        String expected = "4. Título 3";
        String result = titulo.gerarRepresentacaoResumida();

        assertEquals(expected, result);
    }
}
