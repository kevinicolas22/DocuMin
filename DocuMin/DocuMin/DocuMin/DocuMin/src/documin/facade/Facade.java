 package documin.facade;

import documin.controllers.DocumentoController;
import documin.controllers.ElementoController;
import documin.controllers.VisaoController;
import documin.entities.Elemento;

public class Facade {
    private DocumentoController documentoController;
    private VisaoController visaoController;
    private ElementoController elementoController;

    public Facade() {
        this.documentoController = new DocumentoController();
        this.visaoController = new VisaoController(documentoController);
        this.elementoController = new ElementoController(documentoController, null);
    }
    
    public boolean criarDocumento(String titulo) {
        return documentoController.criarDocumento(titulo);
    }
    
    public boolean criarDocumento(String titulo, int tamanhoMaximoElementos) {
        return documentoController.criarDocumento(titulo, tamanhoMaximoElementos);
    }
    
    public void removerDocumento(String titulo) {
        documentoController.removerDocumento(titulo);
    }
    
    public int contarElementos(String titulo) {
        return documentoController.getNumeroElementos(titulo);
    }

    public String[] exibirDocumento(String titulo) {
        return documentoController.getRepresentacaoDocumento(titulo);
    }
    
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return elementoController.criarTexto(tituloDoc, valor, prioridade);
    }

    public int criarTitulo(String titulo, String valor, int prioridade, int nivel, boolean linkavel) {
        return elementoController.criarTitulo(titulo, valor, prioridade, nivel, linkavel);
    }
    
    public int criarLista(String titulo, String valorLista, int prioridade, String separador, String charLista) {
        return elementoController.criarLista(titulo, valorLista, prioridade, separador, charLista);
    }

    public int criarTermo(String titulo, String valorTermos, int prioridade, String separador, String ordem) {
        return elementoController.criarTermo(titulo, valorTermos, prioridade, separador, ordem);
    }
    
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return elementoController.pegarRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return elementoController.pegarRepresentacaoResumida(tituloDoc, elementoPosicao);
    }
    
    public boolean removerElemento(String titulo, Elemento elementoPosicao) {
        return elementoController.removerElemento(titulo, elementoPosicao);
    }
    
    public void moverElementoParaCima(String titulo, int elementoPosicao) {
    	elementoController.moverElementoParaCima(titulo, elementoPosicao);
    }

    public void moverElementoParaBaixo(String titulo, int elementoPosicao) {
    	elementoController.moverElementoParaBaixo(titulo, elementoPosicao);
    }
    
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return elementoController.criarAtalho(tituloDoc, tituloDocReferenciado);
    }
    
    public int criarVisaoCompleta(String tituloDoc) {
    	return visaoController.criarVisaoCompleta(tituloDoc);
    }
    
    public int criarVisaoResumida(String tituloDoc) {
        return visaoController.criarVisaoResumida(tituloDoc);
    }

    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return visaoController.criarVisaoPrioritaria(tituloDoc, prioridade);
    }

    public int criarVisaoTitulo(String tituloDoc) {
        return visaoController.criarVisaoTitulo(tituloDoc);
    }
    
    public String exibirVisao(int visaoId, String tituloDoc) {
        return visaoController.exibirVisao(visaoId, tituloDoc);
    }

}
