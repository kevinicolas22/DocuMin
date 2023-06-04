package documin.extendsElemento;

import java.util.Map;

import documin.entities.Elemento;

public class Lista extends Elemento {
    private String separador;
    private String caractereLista;

    /**
     * Cria uma nova instancia de Lista com os parametros especificados.
     *
     * @param prioridade a prioridade do elemento da lista.
     * @param valor o valor do elemento da lista.
     * @param propriedades as propriedades do elemento da lista.
     * @param separador o separador utilizado para dividir os elementos da lista.
     * @param caractereLista o caractere utilizado para representar cada item da lista.
     */
    public Lista(int prioridade, String valor, Map<String, String> propriedades, String separador, String caractereLista) {
        super(prioridade, valor, propriedades);
        this.separador = separador;
        this.caractereLista = caractereLista;
    }

    /**
     * Gera a representacao completa do elemento da lista.
     *
     * @return a representcao completa do elemento da lista.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        String[] palavras = getValor().split(separador);
        StringBuilder sb = new StringBuilder();
        for (String palavra : palavras) {
            sb.append(caractereLista).append(" ").append(palavra).append("\n");
        }
        return sb.toString().trim();
    }

    /**
     * Gera a representacao resumida do elemento da lista.
     *
     * @return a representacao resumida do elemento da lista.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        return getValor().replace(separador, ", ");
    }
}
