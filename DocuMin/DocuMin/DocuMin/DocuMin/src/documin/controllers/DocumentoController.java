package documin.controllers;

import java.util.*;

import documin.entities.Documento;

public class DocumentoController {
    private Map<String, Documento> documentos;

    /**
     * Construtor da classe DocumentoController.
     */
    public DocumentoController() {
        documentos = new HashMap<>();
    }

    /**
     * Retorna o mapa de documentos.
     *
     * @return o mapa de documentos.
     */
    public Map<String, Documento> getDocumentos() {
        return documentos;
    }

    /**
     * Valida o titulo do documento.
     *
     * @param titulo o titulo do documento.
     * @throws IllegalArgumentException se o titulo for invalido.
     */
    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo invalido. O titulo nao pode ser uma string vazia ou composta apenas por espacos.");
        }
    }

    /**
     * Cria um novo documento com o titulo e tamanho maximo de elementos especificados.
     *
     * @param titulo                o titulo do documento.
     * @param tamanhoMaximoElementos o tamanho maximo de elementos do documento.
     * @return true se o documento foi criado com sucesso, false caso contrario.
     * @throws IllegalArgumentException se o titulo for invalido ou o tamanho maximo for menor ou igual a zero.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximoElementos) {
        validarTitulo(titulo);

        if (documentos.containsKey(titulo)) {
            return false;
        }

        if (tamanhoMaximoElementos <= 0) {
            throw new IllegalArgumentException("Tamanho invalido. O tamanho deve ser maior que zero.");
        }

        Documento documento = new Documento(titulo, tamanhoMaximoElementos);
        documentos.put(titulo, documento);
        return true;
    }

    /**
     * Cria um novo documento com o titulo especificado.
     * O tamanho maximo de elementos é definido como -1, indicando que nao ha restriçao de tamanho.
     *
     * @param titulo o titulo do documento.
     * @return true se o documento foi criado com sucesso, false caso contrario.
     * @throws IllegalArgumentException se o titulo for invalido.
     */
    public boolean criarDocumento(String titulo) {
        validarTitulo(titulo);

        if (documentos.containsKey(titulo)) {
            return false;
        }

        documentos.put(titulo, new Documento(titulo, -1));
        return true;
    }

    /**
     * Remove um documento com o titulo especificado.
     *
     * @param titulo o titulo do documento a ser removido.
     * @return true se o documento foi removido com sucesso.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public boolean removerDocumento(String titulo) {
        validarTitulo(titulo);

        if (!documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        documentos.remove(titulo);
        return true;
    }

    /**
     * Retorna o numero de elementos do documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @return o numero de elementos do documento.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public int getNumeroElementos(String titulo) {
        validarTitulo(titulo);

        if (!documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        return documentos.get(titulo).getNumeroElementos();
    }

    /**
     * Retorna a representaçao em forma de array de strings do documento com o titulo especificado.
     *
     * @param titulo o titulo do documento.
     * @return a representaçao em forma de array de strings do documento.
     * @throws IllegalArgumentException se o titulo for invalido.
     * @throws NoSuchElementException   se o documento nao for encontrado.
     */
    public String[] getRepresentacaoDocumento(String titulo) {
        validarTitulo(titulo);

        if (!documentos.containsKey(titulo)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentos.get(titulo);
        return documento.getRepresentacao();
    }

}
