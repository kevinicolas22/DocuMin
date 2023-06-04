package testesEntities;

import org.junit.jupiter.api.Test;
import documin.entities.Tipo;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TipoTest {

    @Test
    void testAdicionarPropriedade() {
        String chave = "chave";
        String valor = "valor";
        Tipo tipo = new Tipo("");

        tipo.adicionarPropriedade(chave, valor);

        Map<String, String> propriedades = tipo.getPropriedades();
        assertTrue(propriedades.containsKey(chave));
        assertEquals(valor, propriedades.get(chave));
    }

    @Test
    void testRemoverPropriedade() {
        String chave = "chave";
        Tipo tipo = new Tipo("");
        tipo.adicionarPropriedade(chave, "valor");

        tipo.removerPropriedade(chave);

        assertFalse(tipo.getPropriedades().containsKey(chave));
    }

    @Test
    void testObterPropriedade() {
        String chave = "chave";
        String valor = "valor";
        Tipo tipo = new Tipo("");
        tipo.adicionarPropriedade(chave, valor);

        String propriedadeObtida = tipo.obterPropriedade(chave);

        assertEquals(valor, propriedadeObtida);
    }

    @Test
    void testPossuiPropriedade() {
        String chave = "chave";
        Tipo tipo = new Tipo("");
        tipo.adicionarPropriedade(chave, "valor");

        assertTrue(tipo.possuiPropriedade(chave));
        assertFalse(tipo.possuiPropriedade("outraChave"));
    }

    @Test
    void testToString() {
        String valor = "Termos";
        Tipo tipo = new Tipo(valor);
        tipo.adicionarPropriedade("chave1", "valor1");
        tipo.adicionarPropriedade("chave2", "valor2");

        String stringTipo = tipo.toString();

        assertTrue(stringTipo.contains(valor));
        assertTrue(stringTipo.contains("chave1"));
        assertTrue(stringTipo.contains("valor1"));
        assertTrue(stringTipo.contains("chave2"));
        assertTrue(stringTipo.contains("valor2"));
    }
}

