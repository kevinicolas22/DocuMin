package documin.extendsElemento;

import java.util.List;

import documin.entities.Documento;
import documin.entities.Elemento;

/**
 * A classe Atalho representa um elemento de atalho que referencia outro documento.
 * Estende a classe Elemento.
 */
public class Atalho extends Elemento {
    private Documento documentoReferenciado;

    /**
     * Constroi um objeto Atalho com o documento referenciado.
     * Calcula a prioridade e o valor com base no documento referenciado.
     *
     * @param documentoReferenciado o documento referenciado pelo atalho.
     * @throws IllegalArgumentException se o documento referenciado for nulo.
     * @throws IllegalStateException    se o documento referenciado ja possuir atalhos.
     */
    public Atalho(Documento documentoReferenciado) {
        super(calcularPrioridade(documentoReferenciado), calcularValor(documentoReferenciado), null);
        validarDocumentoReferenciado(documentoReferenciado);
        this.documentoReferenciado = documentoReferenciado;
    }

    /**
     * Calcula a prioridade do atalho com base no documento referenciado.
     *
     * @param documento o documento referenciado.
     * @return a prioridade calculada.
     */
    private static int calcularPrioridade(Documento documento) {
        return documento.calcularMediaPrioridades();
    }

    /**
     * Calcula o valor do atalho com base no documento referenciado.
     *
     * @param documento o documento referenciado.
     * @return o valor calculado.
     */
    private static String calcularValor(Documento documento) {
        return documento.getTitulo();
    }

    /**
     * Valida o documento referenciado pelo atalho.
     *
     * @param documento o documento referenciado.
     * @throws IllegalArgumentException se o documento referenciado for nulo.
     * @throws IllegalStateException se o documento referenciado ja possuir atalhos.
     */
    private void validarDocumentoReferenciado(Documento documento) {
        if (documento == null) {
            throw new IllegalArgumentException("Documento referenciado é nulo.");
        }

        if (documento.documentoPossuiAtalhos()) {
            throw new IllegalStateException("Um documento que é atalho não pode ter atalhos adicionados.");
        }
    }


    /**
     * Retorna o documento referenciado pelo atalho.
     *
     * @return o documento referenciado.
     */
    public Documento getDocumentoReferenciado() {
        return documentoReferenciado;
    }

    /**
     * Gera a representacao completa do atalho.
     * A representacao e obtida a partir do ultimo elemento prioritario do documento referenciado.
     *
     * @return a representacao completa do atalho.
     */
    @Override
    public String gerarRepresentacaoCompleta() {
        StringBuilder sb = new StringBuilder();
        Elemento ultimoElementoPrioritario = null;
        for (Elemento elemento : documentoReferenciado.getElementos()) {
            if (elemento.getPrioridade() >= 4 && elemento.getPrioridade() <= 5) {
                ultimoElementoPrioritario = elemento;
            }
        }
        if (ultimoElementoPrioritario != null) {
            sb.append(ultimoElementoPrioritario.gerarRepresentacaoCompleta());
        }
        return sb.toString();
    }

    /**
     * Gera a representacao resumida do atalho.
     * A representacao resumida e obtida a partir da concatenacao das representacoes resumidas
     * de todos os elementos do documento referenciado, separados por virgula.
     *
     * @return a representacao resumida do atalho.
     */
    @Override
    public String gerarRepresentacaoResumida() {
        StringBuilder sb = new StringBuilder();
        List<Elemento> elementos = documentoReferenciado.getElementos();
        for (int i = 0; i < elementos.size(); i++) {
            Elemento elemento = elementos.get(i);
            sb.append(elemento.gerarRepresentacaoResumida());
            if (i < elementos.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
}
