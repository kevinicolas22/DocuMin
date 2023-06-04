package documin.entities;

import java.util.HashMap;
import java.util.Map;

/**
 * A classe Tipo representa um tipo de elemento em um documento.
 * Possui um valor e um conjunto de propriedades associadas.
 */
public class Tipo {
    private String valor;
    private Map<String, String> propriedades;

    /**
     * Constante que representa o tipo "Termos".
     */
    public static final Tipo TERMOS = new Tipo("Termos");

    /**
     * Constroi um objeto Tipo com o valor especificado.
     *
     * @param valor o valor do tipo.
     */
    public Tipo(String valor) {
        this.valor = valor;
        this.propriedades = new HashMap<>();
    }

    /**
     * Retorna o valor do tipo.
     *
     * @return o valor do tipo.
     */
    public String getValor() {
        return valor;
    }

    /**
     * Define o valor do tipo.
     *
     * @param valor o valor do tipo.
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

    /**
     * Retorna as propriedades do tipo.
     *
     * @return as propriedades do tipo.
     */
    public Map<String, String> getPropriedades() {
        return propriedades;
    }

    /**
     * Adiciona uma propriedade ao tipo.
     *
     * @param chave a chave da propriedade.
     * @param valor o valor da propriedade.
     */
    public void adicionarPropriedade(String chave, String valor) {
        propriedades.put(chave, valor);
    }

    /**
     * Remove uma propriedade do tipo.
     *
     * @param chave a chave da propriedade a ser removida.
     */
    public void removerPropriedade(String chave) {
        propriedades.remove(chave);
    }

    /**
     * Obtem o valor de uma propriedade do tipo.
     *
     * @param chave a chave da propriedade.
     * @return o valor da propriedade ou null se a chave nao existir.
     */
    public String obterPropriedade(String chave) {
        return propriedades.get(chave);
    }

    /**
     * Verifica se o tipo possui uma propriedade com a chave especificada.
     *
     * @param chave a chave da propriedade.
     * @return true se o tipo possui a propriedade, false caso contrario.
     */
    public boolean possuiPropriedade(String chave) {
        return propriedades.containsKey(chave);
    }

    /**
     * Retorna uma representacao em string do tipo.
     *
     * @return uma representacao em string do tipo.
     */
    @Override
    public String toString() {
        return "Tipo [valor=" + valor + ", propriedades=" + propriedades + "]";
    }
}
