package testesExtendsElemento;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import documin.extendsElemento.Lista;
import documin.entities.Elemento;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListaTest {

    @Test
    void testGerarRepresentacaoCompleta() {
        int prioridade = 1;
        String valor = "Item1;Item2;Item3";
        Map<String, String> propriedades = new HashMap<>();
        String separador = ";";
        String caractereLista = "-";
        Elemento lista = new Lista(prioridade, valor, propriedades, separador, caractereLista);

        String expected = "- Item1\n- Item2\n- Item3";
        String result = lista.gerarRepresentacaoCompleta();

        assertEquals(expected, result);
    }

    @Test
    void testGerarRepresentacaoResumida() {
        int prioridade = 1;
        String valor = "Item1;Item2;Item3";
        Map<String, String> propriedades = new HashMap<>();
        String separador = ";";
        String caractereLista = "-";
        Elemento lista = new Lista(prioridade, valor, propriedades, separador, caractereLista);

        String expected = "Item1, Item2, Item3";
        String result = lista.gerarRepresentacaoResumida();

        assertEquals(expected, result);
    }
}


