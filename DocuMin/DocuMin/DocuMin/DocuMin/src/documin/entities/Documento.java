package documin.entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import documin.extendsElemento.Atalho;

/**
 * Representa um documento com elementos.
 */
public class Documento {
    private String titulo;
    private int tamanho;
    private List<Elemento> elementos;

    /**
     * Constroi um novo objeto Documento com o titulo e tamanho especificados.
     *
     * @param titulo  o titulo do documento.
     * @param tamanho o tamanho maximo do documento.
     */
    public Documento(String titulo, int tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elementos = new ArrayList<>();
    }

    /**
     * Retorna a lista de elementos do documento.
     *
     * @return a lista de elementos.
     */
    public List<Elemento> getElementos() {
        return elementos;
    }

    /**
     * Adiciona um elemento ao documento.
     *
     * @param elemento  o elemento a ser adicionado.
     * @param favorito  indica se o elemento e favorito.
     * @return true se o elemento foi adicionado com sucesso, false caso contrario.
     * @throws IllegalArgumentException se o titulo do elemento for invalido.
     */
    public boolean adicionarElemento(Elemento elemento, boolean favorito) {
        if (elemento == null || !validarTitulo(elemento.getValor())) {
            throw new IllegalArgumentException("Titulo invalido.");
        }

        if (tamanho > 0 && elementos.size() >= tamanho) {
            return false;
        }

        elemento.setFavorito(favorito);
        elementos.add(elemento);
        return true;
    }

    /**
     * Adiciona um elemento atalho ao documento, referenciando outro documento.
     *
     * @param documentoReferenciado o documento referenciado pelo atalho.
     * @return true se o elemento atalho foi adicionado com sucesso, false caso contrario.
     * @throws IllegalStateException se o documento referenciado ja possuir atalhos adicionados.
     */
    public boolean adicionarElementoAtalho(Documento documentoReferenciado) {
        validarDocumentoAtalho(documentoReferenciado);
        Atalho atalho = new Atalho(documentoReferenciado);
        return adicionarElemento(atalho, false);
    }

    /**
     * Valida se um documento referenciado por atalho ja possui atalhos adicionados.
     *
     * @param documentoReferenciado o documento referenciado.
     * @throws IllegalStateException se o documento referenciado ja possuir atalhos adicionados.
     */
    private void validarDocumentoAtalho(Documento documentoReferenciado) {
        if (documentoReferenciado.documentoPossuiAtalhos()) {
            throw new IllegalStateException("Um documento que e atalho nao pode ter atalhos adicionados.");
        }
    }

    /**
     * Verifica se o documento possui atalhos adicionados.
     *
     * @return true se o documento possuir atalhos, false caso contrario.
     */
    public boolean documentoPossuiAtalhos() {
        for (Elemento elemento : elementos) {
            if (elemento instanceof Atalho) {
                return true;
            }
        }
        return false;
    }

    /**
     * Move um elemento para cima na lista de elementos do documento.
     *
     * @param elementoPosicao a posicao do elemento a ser movido.
     * @throws IllegalArgumentException se a posicao do elemento for invalida.
     */
    public void moverParaCima(int elementoPosicao) {
        if (elementoPosicao <= 0 || elementoPosicao >= elementos.size()) {
            throw new IllegalArgumentException("Posicao invalida.");
        }

        Elemento elemento = elementos.get(elementoPosicao);
        elementos.remove(elementoPosicao);
        elementos.add(elementoPosicao - 1, elemento);
    }

    /**
     * Move um elemento para baixo na lista de elementos do documento.
     *
     * @param elementoPosicao a posicao do elemento a ser movido.
     * @throws IllegalArgumentException se a posicao do elemento for invalida.
     */
    public void moverParaBaixo(int elementoPosicao) {
        if (elementoPosicao < 0 || elementoPosicao >= elementos.size() - 1) {
            throw new IllegalArgumentException("Posicao invalida.");
        }

        Elemento elemento = elementos.get(elementoPosicao);
        elementos.remove(elementoPosicao);
        elementos.add(elementoPosicao + 1, elemento);
    }

    /**
     * Remove um elemento do documento.
     *
     * @param elemento o elemento a ser removido.
     * @return true se o elemento foi removido com sucesso, false caso contrario.
     * @throws IllegalArgumentException se o elemento for invalido.
     */
    public boolean removerElemento(Elemento elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("Elemento invalido.");
        }

        return elementos.remove(elemento);
    }

    /**
     * Retorna o numero de elementos do documento.
     *
     * @return o numero de elementos.
     */
    public int getNumeroElementos() {
        return elementos.size();
    }

    /**
     * Retorna a representacao completa do documento como um array de strings.
     *
     * @return a representacao completa do documento.
     */
    public String[] getRepresentacao() {
        String[] representacao = new String[elementos.size()];
        for (int i = 0; i < elementos.size(); i++) {
            representacao[i] = elementos.get(i).gerarRepresentacaoCompleta();
        }
        return representacao;
    }

    /**
     * Valida o titulo do elemento.
     *
     * @param titulo o titulo do elemento.
     * @return true se o titulo for valido, false caso contrario.
     */
    private boolean validarTitulo(String titulo) {
        return titulo != null && !titulo.trim().isEmpty();
    }

    /**
     * Ordena os elementos do documento com base na representacao completa de cada elemento.
     */
    public void ordenarTermos() {
        List<Elemento> elementosOrdenados = new ArrayList<>(elementos);
        elementosOrdenados.sort(Comparator.comparing(Elemento::gerarRepresentacaoCompleta));

        elementos.clear();
        elementos.addAll(elementosOrdenados);
    }

    /**
     * Obtem a representacao completa de um elemento do documento.
     *
     * @param tituloDoc       o titulo do documento.
     * @param elementoPosicao a posicao do elemento.
     * @return a representacao completa do elemento.
     * @throws IllegalArgumentException se o documento nao for encontrado ou a posicao do elemento for invalida.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        if (!titulo.equals(tituloDoc)) {
            throw new IllegalArgumentException("Documento nao encontrado.");
        }

        if (elementoPosicao < 0 || elementoPosicao >= elementos.size()) {
            throw new IllegalArgumentException("Posicao invalida.");
        }

        Elemento elemento = elementos.get(elementoPosicao);
        if (!elemento.isFavorito()) {
            return "Elemento nao e favorito.";
        }

        return elemento.gerarRepresentacaoCompleta();
    }

    /**
     * Obtem a representacao resumida de um elemento do documento.
     *
     * @param tituloDoc       o titulo do documento.
     * @param elementoPosicao a posicao do elemento.
     * @return a representacao resumida do elemento.
     * @throws IllegalArgumentException se o documento nao for encontrado ou a posicao do elemento for invalida.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        if (!titulo.equals(tituloDoc)) {
            throw new IllegalArgumentException("Documento nao encontrado.");
        }

        if (elementoPosicao < 0 || elementoPosicao >= elementos.size()) {
            throw new IllegalArgumentException("Posicao invalida.");
        }

        Elemento elemento = elementos.get(elementoPosicao);
        if (!elemento.isFavorito()) {
            return "Elemento nao e favorito.";
        }

        return elemento.gerarRepresentacaoResumida();
    }

    /**
     * Calcula a media das prioridades dos elementos do documento.
     *
     * @return a media das prioridades.
     */
    public int calcularMediaPrioridades() {
        if (elementos.isEmpty()) {
            return 0;
        }

        int somaPrioridades = 0;
        for (Elemento elemento : elementos) {
            somaPrioridades += elemento.getPrioridade();
        }

        return somaPrioridades / elementos.size();
    }

    /**
     * Retorna o titulo do documento.
     *
     * @return o titulo do documento.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Retorna uma representacao completa do documento, concatenando as representacoes completas de seus elementos.
     *
     * @return a representacao completa do documento.
     */
    public String visualizarCompleta() {
        String resultado = "";
        for (Elemento elemento : elementos) {
            resultado = resultado + elemento.gerarRepresentacaoCompleta() + " ";
        }
        return resultado.trim();
    }

    /**
     * Retorna uma representacao resumida do documento, concatenando as representacoes resumidas de seus elementos.
     *
     * @return a representacao resumida do documento.
     */
    public String visualizarResumida() {
        String resultado = "";
        for (Elemento elemento : elementos) {
            resultado = resultado + elemento.gerarRepresentacaoResumida() + " ";
        }
        return resultado.trim();
    }

    /**
     * Retorna uma representacao prioritaria do documento, contendo apenas os elementos com prioridade igual ou superior a uma prioridade minima.
     *
     * @param prioridadeMinima a prioridade minima.
     * @return a representacao prioritaria do documento.
     */
    public String visualizarPrioritaria(int prioridadeMinima) {
        String resultado = "";
        for (Elemento elemento : elementos) {
            if (elemento.getPrioridade() >= prioridadeMinima) {
                resultado = resultado + elemento.gerarRepresentacaoCompleta() + " ";
            }
        }
        return resultado.trim();
    }

    /**
     * Retorna uma representacao dos titulos dos elementos do documento.
     *
     * @return a representacao dos titulos dos elementos.
     */
    public String visualizarTitulos() {
        String resultado = "";
        for (Elemento elemento : elementos) {
            resultado = resultado + elemento.gerarRepresentacaoResumida() + " ";
        }
        return resultado.trim();
    }
}
