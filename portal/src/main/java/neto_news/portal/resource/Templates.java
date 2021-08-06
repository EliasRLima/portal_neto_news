package neto_news.portal.resource;

public enum Templates {
  
  BASE("view/neto_news.fxml");
  
  private String url;
  private Templates(String url){
    this.url = url;
  }
  public String getUrl() {
    return this.url;
  }
}
