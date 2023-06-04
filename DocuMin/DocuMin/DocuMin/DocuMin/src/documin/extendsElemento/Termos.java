package documin.extendsElemento;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import documin.entities.Elemento;

public class Termos extends Elemento {
    private String separador;
    private String ordem;
    private String[] termos;

    /**
     * Cria uma nova instancia de Termos com os parametros especificados.
     *
     * @param prioridade a prioridade do elemento de termos.
     * @param valor o valor do elemento de termos.
     * @param propriedades as propriedades do elemento de termos.
     * @param separador o separador utilizado para dividir os termos.
     * @param ordem a ordem dos termos (alfabetica ou por tamanho).
     */
    public Termos(int prioridade, String valor, Map<String, String> propriedades, String separador, String ordem) {
        super(prioridade, valor, propriedades);
        this.setSeparador(separador);
        this.ordem = ordem;
        this.termos = valor.split(separador);
    }

    /**
     * Gera a representacao completa do elemento de termos.
     *
     * @return a representacao completa do elemento de termos.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        StringBuilder sb = new StringBuilder();
        for (String termo : termos) {
            sb.append(termo).append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Gera a representacao resumida do elemento de termos.
     *
     * @return a representacao resumida do elemento de termos.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        if (ordem.equals("ALFABÉTICA")) {
            Arrays.sort(termos, String.CASE_INSENSITIVE_ORDER);
        } else if (ordem.equals("TAMANHO")) {
            Arrays.sort(termos, (a, b) -> {
                int lengthCompare = Integer.compare(a.length(), b.length());
                return lengthCompare != 0 ? lengthCompare : a.compareTo(b);
            });
        }

        StringBuilder sb = new StringBuilder();
        for (String termo : termos) {
            sb.append(termo).append(", ");
        }
        return sb.toString().trim().substring(0, sb.length() - 2);
    }
    
    /**
     * Ordena os termos em ordem alfabetica.
     */
    public void ordenarTermos() {
        Arrays.sort(termos);
    }

    /**
     * Verifica se um objeto e igual a este objeto de Termos.
     *
     * @param o o objeto a ser comparado.
     * @return true se os objetos forem iguais, false caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Termos termosObj = (Termos) o;
        return super.equals(o) &&
                Objects.equals(separador, termosObj.separador) &&
                Objects.equals(ordem, termosObj.ordem) &&
                Arrays.equals(termos, termosObj.termos);
    }

    /**
     * Retorna o codigo de hash para este objeto de Termos.
     *
     * @return o codigo de hash calculado.
     */
    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hash(separador, ordem);
        result = 31 * result + Arrays.hashCode(termos);
        return result;
    }

    /**
     * Retorna uma representacao em string deste objeto de Termos.
     *
     * @return uma representacao em string do objeto.
     */
    @Override
    public String toString() {
        return "Termos{" +
                "separador='" + separador + '\'' +
                ", ordem='" + ordem + '\'' +
                ", termos=" + Arrays.toString(termos) +
                '}';
    }

    /**
     * Retorna o numero total de termos.
     *
     * @return o numero total de termos.
     */
    public int getTotalTermos() {
        return termos.length;
    }

    /**
     * Retorna o separador utilizado para dividir os termos.
     *
     * @return o separador dos termos.
     */
    public String getSeparador() {
        return separador;
    }

    /**
     * Define o separador utilizado para dividir os termos.
     *
     * @param separador o separador dos termos.
     */
    public void setSeparador(String separador) {
        this.separador = separador;
    }

}
