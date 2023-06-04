package documin.extendsElemento;

import java.util.Map;

import documin.entities.Elemento;

public class Texto extends Elemento {
    /**
     * Cria uma nova instancia de Texto com os parametros especificados.
     *
     * @param prioridade a prioridade do elemento de texto.
     * @param valor o valor do elemento de texto.
     * @param propriedades as propriedades do elemento de texto.
     */
    public Texto(int prioridade, String valor, Map<String, String> propriedades) {
        super(prioridade, valor, propriedades);
    }

    /**
     * Gera a representacao completa do elemento de texto.
     *
     * @return a representacao completa do elemento de texto.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        return getValor();
    }

    /**
     * Gera a representacao resumida do elemento de texto.
     *
     * @return a representacao resumida do elemento de texto.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return getValor();
    }
}
