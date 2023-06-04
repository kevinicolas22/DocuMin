package testesExtendsElemento;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import documin.extendsElemento.Texto;
import documin.entities.Elemento;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TextoTest {

    @Test
    void testGerarRepresentacaoCompleta() {
        int prioridade = 1;
        String valor = "Este é um texto completo.";
        Map<String, String> propriedades = new HashMap<>();
        Elemento texto = new Texto(prioridade, valor, propriedades);

        String expected = "Este é um texto completo.";
        String result = texto.gerarRepresentacaoCompleta();

        assertEquals(expected, result);
    }

    @Test
    void testGerarRepresentacaoResumida() {
        int prioridade = 1;
        String valor = "Este é um texto resumido.";
        Map<String, String> propriedades = new HashMap<>();
        Elemento texto = new Texto(prioridade, valor, propriedades);

        String expected = "Este é um texto resumido.";
        String result = texto.gerarRepresentacaoResumida();

        assertEquals(expected, result);
    }
}

