package documin.extendsElemento;

import java.util.Map;

import documin.entities.Elemento;

public class Titulo extends Elemento {
    private int nivel;
    private boolean linkavel;

    /**
     * Cria uma nova instancia de Titulo com os parametros especificados.
     *
     * @param prioridade a prioridade do elemento de titulo.
     * @param valor o valor do elemento de titulo.
     * @param propriedades as propriedades do elemento de titulo.
     * @param nivel o nivel do titulo.
     * @param linkavel indica se o titulo e linkavel.
     */
    public Titulo(int prioridade, String valor, Map<String, String> propriedades, int nivel, boolean linkavel) {
        super(prioridade, valor, propriedades);
        this.nivel = nivel;
        this.linkavel = linkavel;
    }

    /**
     * Gera a representacao completa do elemento de titulo.
     *
     * @return a representacao completa do elemento de titulo.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        if (linkavel) {
            String link = getValor().toUpperCase().replaceAll("\\s+", "");
            return nivel + ". " + getValor() + " -- " + nivel + "-" + link;
        } else {
            return nivel + ". " + getValor();
        }
    }

    /**
     * Gera a representacao resumida do elemento de titulo.
     *
     * @return a representacao resumida do elemento de titulo.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return nivel + ". " + getValor();
    }
}
