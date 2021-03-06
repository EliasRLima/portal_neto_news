package neto_news.portal.resource;

public enum Templates {
  
  BASE("view/neto_news.fxml"),
  CADASTRO("view/tela_cadastro.fxml"),
  CADASTRONOTICIA("view/tela_ntc_cadastro.fxml"),
  LOGIN("view/tela_login.fxml"),
  LISTANOTICIA("view/tela_listagem_noticias.fxml"),
  REPORT("view/report.fxml");
  
  private String url;
  private Templates(String url){
    this.url = url;
  }
  public String getUrl() {
    return this.url;
  }
  
}
