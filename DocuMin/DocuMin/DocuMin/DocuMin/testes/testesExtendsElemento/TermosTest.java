package testesExtendsElemento;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import documin.extendsElemento.Termos;
import documin.entities.Elemento;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TermosTest {

    @Test
    void testGerarRepresentacaoCompleta() {
        int prioridade = 1;
        String valor = "termo1 termo2 termo3";
        Map<String, String> propriedades = new HashMap<>();
        String separador = " ";
        String ordem = "ALFABÉTICA";
        Elemento termos = new Termos(prioridade, valor, propriedades, separador, ordem);

        String expected = "termo1 termo2 termo3";
        String result = termos.gerarRepresentacaoCompleta();

        assertEquals(expected, result);
    }

    @Test
    void testGerarRepresentacaoResumida() {
        int prioridade = 1;
        String valor = "termo3 termo1 termo2";
        Map<String, String> propriedades = new HashMap<>();
        String separador = " ";
        String ordem = "ALFABÉTICA";
        Elemento termos = new Termos(prioridade, valor, propriedades, separador, ordem);

        String expected = "termo1, termo2, termo3";
        String result = termos.gerarRepresentacaoResumida();

        assertEquals(expected, result);
    }

    @Test
    void testOrdenarTermos() {
        int prioridade = 1;
        String valor = "termo3 termo1 termo2";
        Map<String, String> propriedades = new HashMap<>();
        String separador = " ";
        String ordem = "ALFABÉTICA";
        Termos termos = new Termos(prioridade, valor, propriedades, separador, ordem);

        termos.ordenarTermos();

        String expected = "termo1 termo2 termo3";
        String result = termos.gerarRepresentacaoCompleta();

        assertEquals(expected, result);
    }

    @Test
    void testGetTotalTermos() {
        int prioridade = 1;
        String valor = "termo1 termo2 termo3";
        Map<String, String> propriedades = new HashMap<>();
        String separador = " ";
        String ordem = "ALFABÉTICA";
        Termos termos = new Termos(prioridade, valor, propriedades, separador, ordem);

        int expected = 3;
        int result = termos.getTotalTermos();

        assertEquals(expected, result);
    }
}

