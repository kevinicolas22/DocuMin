package documin.entities;

import java.util.Map;

/**
 * A classe abstrata Elemento representa um elemento generico em um documento.
 * Possui propriedades comuns a todos os tipos de elementos, como prioridade, valor, propriedades e favoritismo.
 */
public abstract class Elemento {
    private int prioridade;
    private String valor;
    private Map<String, String> propriedades;
    private boolean favorito;

    /**
     * Constroi um objeto Elemento com a prioridade, valor e propriedades especificados.
     *
     * @param prioridade a prioridade do elemento.
     * @param valor o valor do elemento.
     * @param propriedades as propriedades do elemento.
     */
    protected Elemento(int prioridade, String valor, Map<String, String> propriedades) {
        this.prioridade = prioridade;
        this.valor = valor;
        this.propriedades = propriedades;
        this.favorito = false;
    }

    /**
     * Retorna a prioridade do elemento.
     *
     * @return a prioridade do elemento.
     */
    public int getPrioridade() {
        return prioridade;
    }

    /**
     * Retorna o valor do elemento.
     *
     * @return o valor do elemento.
     */
    protected String getValor() {
        return valor;
    }

    /**
     * Retorna as propriedades do elemento.
     *
     * @return as propriedades do elemento.
     */
    protected Map<String, String> getPropriedades() {
        return propriedades;
    }

    /**
     * Verifica se o elemento e favorito.
     *
     * @return true se o elemento e favorito, false caso contrario.
     */
    protected boolean isFavorito() {
        return favorito;
    }

    /**
     * Define se o elemento e favorito.
     *
     * @param favorito true se o elemento e favorito, false caso contrario.
     */
    protected void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    /**
     * Gera a representacao completa do elemento.
     *
     * @return a representacao completa do elemento.
     */
    public abstract String gerarRepresentacaoCompleta();

    /**
     * Gera a representação resumida do elemento.
     *
     * @return a representacao resumida do elemento.
     */
    public abstract String gerarRepresentacaoResumida();
}
