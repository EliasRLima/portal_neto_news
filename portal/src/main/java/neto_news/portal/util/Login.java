package neto_news.portal.util;

import javafx.stage.Stage;
import neto_news.portal.Objects.Perfil;

public class Login {
	
	private static Login instancia;
	private Perfil user;
	private boolean login;
	
	private Login(Perfil usuario) {
	    this.user = usuario;
	    this.login = user != null;
	}

	  
	public static Login iniciarClasse(Perfil usuario) {
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
