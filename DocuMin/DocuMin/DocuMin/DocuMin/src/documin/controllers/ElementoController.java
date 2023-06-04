package documin.controllers;

import java.util.Map;
import java.util.NoSuchElementException;

import documin.entities.Documento;
import documin.entities.Elemento;
import documin.extendsElemento.Lista;
import documin.extendsElemento.Termos;
import documin.extendsElemento.Texto;
import documin.extendsElemento.Titulo;

public class ElementoController {
    private DocumentoController documentoController;
    private Map<String, Documento> documentos;
    /**
     * Construtor da classe ElementoController.
     *
     * @param documentoController o controlador de documentos.
     * @param documentos o mapa de documentos.
     */
    public ElementoController(DocumentoController documentoController, Map<String, Documento> documentos) {
        this.documentoController = documentoController;
        this.documentos = documentos;
    }
    /**
     * Adiciona um elemento ao documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param elemento o elemento a ser adicionado.
     * @return true se o elemento foi adicionado com sucesso, false caso contrario.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public boolean adicionarElemento(String titulo, Elemento elemento) {
        validarTitulo(titulo);

        if (!documentoController.getDocumentos().containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(titulo);
        return documento.adicionarElemento(elemento, false);
    }
    /**
     * Retorna o numero de elementos do documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @return o numero de elementos do documento.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public int getNumeroElementos(String titulo) {
        validarTitulo(titulo);

        if (!documentoController.getDocumentos().containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(titulo);
        return documento.getNumeroElementos();
    }

    /**
     * Cria um elemento de texto e o adiciona ao documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param valor o valor do texto.
     * @param prioridade a prioridade do texto.
     * @return o numero de elementos do documento apos a criacao do texto.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        Elemento elemento = new Texto(prioridade, valor, null);
        boolean sucesso = adicionarElemento(tituloDoc, elemento);
        if (sucesso) {
            return getNumeroElementos(tituloDoc);
        }
        return -1;
    }
    /**
     * Cria um elemento de titulo e o adiciona ao documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param valor o valor do titulo.
     * @param prioridade a prioridade do titulo.
     * @param nivel o nivel do titulo.
     * @param linkavel  indica se o titulo e linkavel.
     * @return o numero de elementos do documento apos a criacao do titulo.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public int criarTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
        Elemento elemento = new Titulo(prioridade, valor, null, nivel, linkavel);
        boolean sucesso = adicionarElemento(titulo, elemento);
        if (sucesso) {
            return getNumeroElementos(titulo);
        }
        return -1;
    }
    /**
     * Cria um elemento de lista e o adiciona ao documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param valorLista o valor da lista.
     * @param prioridade a prioridade da lista.
     * @param separador o separador da lista.
     * @param charLista o caractere de lista.
     * @return o numero de elementos do documento apos a criacao da lista.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public int criarLista(String titulo, String valorLista, int prioridade, String separador, String charLista) {
        Elemento elemento = new Lista(prioridade, valorLista, null, separador, charLista);
        boolean sucesso = adicionarElemento(titulo, elemento);
        if (sucesso) {
            return getNumeroElementos(titulo);
        }
        return -1;
    }
    /**
     * Cria um elemento de termos e o adiciona ao documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param valorTermos o valor dos termos.
     * @param prioridade a prioridade dos termos.
     * @param separador o separador dos termos.
     * @param ordem a ordem dos termos.
     * @return o numero de elementos do documento apos a criacao dos termos.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public int criarTermo(String titulo, String valorTermos, int prioridade, String separador, String ordem) {
        Elemento elemento = new Termos(prioridade, valorTermos, null, separador, ordem);
        boolean sucesso = adicionarElemento(titulo, elemento);
        if (sucesso) {
            return getNumeroElementos(titulo);
        }
        return -1;
    }
    /**
     * Retorna a representacao completa do elemento de um documento com o titulo e a posicao especificados.
     *
     * @param titulo o titulo do documento.
     * @param elementoPosicao a posicao do elemento.
     * @return a representacao completa do elemento.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        return documento.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }
    /**
     * Retorna a representacao resumida do elemento de um documento com o titulo e a posicao especificados.
     *
     * @param titulo o titulo do documento.
     * @param elementoPosicao a posicao do elemento.
     * @return a representacao resumida do elemento.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        return documento.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    /**
     * Remove um elemento do documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param elementoPosicao o elemento a ser removido.
     * @return true se o elemento foi removido com sucesso, false caso contrario.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public boolean removerElemento(String titulo, Elemento elementoPosicao) {
        validarTitulo(titulo);

        if (!documentoController.getDocumentos().containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(titulo);
        return documento.removerElemento(elementoPosicao);
    }
    /**
     * Move um elemento para cima dentro do documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param elementoPosicao a posicao do elemento a ser movido.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public void moverElementoParaCima(String titulo, int elementoPosicao) {
        validarTitulo(titulo);

        if (!documentoController.getDocumentos().containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(titulo);
        documento.moverParaCima(elementoPosicao);
    }
    /**
     * Move um elemento para baixo dentro do documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @param elementoPosicao a posicao do elemento a ser movido.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public void moverElementoParaBaixo(String titulo, int elementoPosicao) {
        validarTitulo(titulo);

        if (!documentoController.getDocumentos().containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(titulo);
        documento.moverParaBaixo(elementoPosicao);
    }
    
    /**
     * Valida se o titulo e valido, lancando uma excecao se for invalido.
     *
     * @param titulo o titulo a ser validado.
     * @throws IllegalArgumentException se o titulo for invalido.
     */
    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo invalido. O titulo nao pode ser uma string vazia ou composta apenas por espacos.");
        }
    }
    
    /**
     * Cria um atalho para um documento referenciado no documento com o titulo especificado.
     *
     * @param tituloDoc o titulo do documento.
     * @param tituloDocReferenciado o titulo do documento referenciado.
     * @return 1 se o atalho foi criado com sucesso, 0 caso contrario.
     * @throws IllegalArgumentException se o titulo do documento ou do documento referenciado forem invalidos.
     * @throws NoSuchElementException   se o documento ou o documento referenciado nao forem encontrados.
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        Documento documento = buscarDocumentoPorTitulo(tituloDoc, documentos);
        Documento documentoReferenciado = buscarDocumentoPorTitulo(tituloDocReferenciado, documentos);

        if (documento == null || documentoReferenciado == null) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        return documento.adicionarElementoAtalho(documentoReferenciado) ? 1 : 0;
    }
    
    /**
     * Busca um documento pelo titulo no mapa de documentos.
     *
     * @param titulo o titulo do documento a ser buscado.
     * @param documentos o mapa de documentos.
     * @return o documento com o titulo especificado, ou null se nao encontrado.
     */
 
    private Documento buscarDocumentoPorTitulo(String titulo, Map<String, Documento> documentos) {
        for (Documento documento : documentos.values()) {
            if (documento.getTitulo().trim().equalsIgnoreCase(titulo)) {
                return documento;
            }
        }
        return null;
    }

}
