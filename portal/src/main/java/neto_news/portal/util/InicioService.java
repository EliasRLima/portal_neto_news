package neto_news.portal.util;

import javafx.stage.Stage;

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

  

}
