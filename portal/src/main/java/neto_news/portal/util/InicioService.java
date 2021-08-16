package neto_news.portal.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import neto_news.portal.resource.Templates;

/**
 * Service para facilitar a comunicação do stage principal 
 * com outros controllers e encapsular a logica de resize do stage (maximizar, minimizar...)
 */

public final class InicioService {

  private static InicioService instancia; // singleton | instanca unica
  private Stage janela; // janela principal

  private InicioService(Stage janela) {
    this.janela = janela;
  }

  /**
   * Inicia a classe com o stage principal
   * 
   * @param janela - principal stage da aplicação
   * @return - instancia criada da classe
   */
  public static InicioService iniciarClasse(Stage janela) {
    instancia = new InicioService(janela);
    return instancia;
  }

  /**
   * 
   * @return - a instancia unica da classe
   * @throws Exception
   */
  public static InicioService getInstancia() throws Exception {
    if (instancia == null)
      throw new Exception("Instancia da classe InicialService não foi criada!");
    return instancia;
  }

  /**
   * Minimiza o stage principal
   */
  public void minimizar() {
    this.janela.setIconified(true);
  }
  
  public void login() throws IOException {
	  Parent root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.LOGIN.getUrl()));
	  Scene scene = new Scene(root, 1024, 768); // resolucao inicial
	  this.janela.setScene(scene);
	  this.janela.setTitle("NETO NEWS - Login");
	  this.janela.setMinHeight(768);
	  this.janela.setMinWidth(1024);
	  this.janela.show();
  }
  
  public void cadastro() throws IOException {
	  Parent root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.CADASTRO.getUrl()));
	  Scene scene = new Scene(root, 1024, 768); // resolucao inicial
	  this.janela.setScene(scene);
	  this.janela.setTitle("NETO NEWS - Cadastro");
	  this.janela.setMinHeight(768);
	  this.janela.setMinWidth(1024);
	  this.janela.show();
  }
  
  public void inicial() throws IOException {
	    Parent root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.BASE.getUrl()));
		Scene scene = new Scene(root, 1024, 768); // resolucao inicial
		this.janela.setScene(scene);
		this.janela.setTitle("NETO NEWS");
		this.janela.setMinHeight(768);
		this.janela.setMinWidth(1024);
		this.janela.show();
  }
  
  public void noticiaCadastro() throws IOException {
	    Parent root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.CADASTRONOTICIA.getUrl()));
		Scene scene = new Scene(root, 1024, 768); // resolucao inicial
		this.janela.setScene(scene);
		this.janela.setTitle("NETO NEWS");
		this.janela.setMinHeight(768);
		this.janela.setMinWidth(1024);
		this.janela.show();
  }
  
  public void noticiaLista() throws IOException {
	    Parent root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.LISTANOTICIA.getUrl()));
		Scene scene = new Scene(root, 1024, 768); // resolucao inicial
		this.janela.setScene(scene);
		this.janela.setTitle("NETO NEWS");
		this.janela.setMinHeight(768);
		this.janela.setMinWidth(1024);
		this.janela.show();
}
  

  

}
