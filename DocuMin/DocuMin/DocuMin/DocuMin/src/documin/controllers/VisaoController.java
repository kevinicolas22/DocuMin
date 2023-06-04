package documin.controllers;

import java.util.NoSuchElementException;

import documin.entities.Documento;

/**
 * Controlador responsivel pela manipulacao das visoes de documentos.
 */
public class VisaoController {
    private DocumentoController documentoController;

    /**
     * Constroi um VisaoController com o controlador de documentos especificado.
     *
     * @param documentoController o controlador de documentos a ser utilizado.
     */
    public VisaoController(DocumentoController documentoController) {
        this.documentoController = documentoController;
    }

    /**
     * Cria uma visao completa do documento com o titulo especificado.
     *
     * @param tituloDoc o titulo do documento.
     * @return o tamanho da visao completa do documento.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        return documento.visualizarCompleta().length();
    }

    /**
     * Cria uma visao resumida do documento com o titulo especificado.
     *
     * @param tituloDoc o titulo do documento.
     * @return o tamanho da visao resumida do documento.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public int criarVisaoResumida(String tituloDoc) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        return documento.visualizarResumida().length();
    }

    /**
     * Cria uma visao prioritiria do documento com o titulo e prioridade especificados.
     *
     * @param tituloDoc o titulo do documento.
     * @param prioridade a prioridade da visao prioritiria.
     * @return o tamanho da visao prioritiria do documento.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        return documento.visualizarPrioritaria(prioridade).length();
    }

    /**
     * Cria uma visao de titulos do documento com o titulo especificado.
     *
     * @param tituloDoc o titulo do documento.
     * @return o tamanho da visao de titulos do documento.
     * @throws NoSuchElementException se o documento nao for encontrado.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        return documento.visualizarTitulos().length();
    }

    /**
     * Exibe a visao do documento com base no identificador de visao e titulo do documento.
     *
     * @param visaoId o identificador da visao.
     * @param tituloDoc o titulo do documento.
     * @return a visao do documento.
     * @throws NoSuchElementException se o documento nao for encontrado.
     * @throws IllegalArgumentException se o identificador da visao for invilido.
     */
    public String exibirVisao(int visaoId, String tituloDoc) {
        validarTitulo(tituloDoc);

        if (!documentoController.getDocumentos().containsKey(tituloDoc)) {
            throw new NoSuchElementException("Documento nao encontrado.");
        }

        Documento documento = documentoController.getDocumentos().get(tituloDoc);
        switch (visaoId) {
            case 0:
                return documento.visualizarCompleta();
            case 1:
                return documento.visualizarResumida();
            case 2:
                int mediaPrioridades = documento.calcularMediaPrioridades();
                return documento.visualizarPrioritaria(mediaPrioridades);
            case 3:
                return documento.visualizarTitulos();
            default:
                throw new IllegalArgumentException("Visao invilida.");
        }
    }
    
    /**
     * Valida o titulo do documento.
     *
     * @param titulo o titulo do documento.
     * @throws IllegalArgumentException se o titulo for invilido.
     */
    private void validarTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Titulo invilido. O titulo nao pode ser uma string vazia ou composta apenas por espacos.");
        }
    }
}
