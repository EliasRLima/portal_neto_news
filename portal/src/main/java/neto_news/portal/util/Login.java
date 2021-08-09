package neto_news.portal.util;

import javafx.stage.Stage;

public class Login {
	
	private static Login instancia;
	private String user;
	private boolean login;
	
	private Login(String usuario) {
	    this.user = usuario;
	    this.login = user != null;
	}

	  
	public static Login iniciarClasse(String usuario) {
	    instancia = new Login(usuario);
	    return instancia;
	}

	
	public static Login getInstancia() throws Exception {
	  if (instancia == null)
	      throw new Exception("Instancia da classe Login não foi criada!");
	  return instancia;
	}
	
	
	
	public boolean isLogado() {
		return this.login;
	}

}
