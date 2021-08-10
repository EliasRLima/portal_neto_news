package neto_news.portal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import neto_news.portal.Objects.Perfil;
import neto_news.portal.model.AcessoModel;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Login;

public class AcessoController implements Initializable{
    
	@FXML
	JFXButton btn_voltar, btn_minus, btn_close, btn_cadastrar, btn_logon;
	
	@FXML
	TextField txt_email;
	
	@FXML
	PasswordField txt_senha;
	
	@FXML
	Hyperlink hl_loss, hl_help;
	
	private InicioService inicioService;
	private Login login;
    
	public AcessoController() throws Exception {
			this.inicioService = InicioService.getInstancia();
			this.login = Login.getInstancia();
			login.iniciarClasse(null);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Btn_actions();
		Btn_effects();
		
	}
	
	private void Btn_actions() {
		
		btn_voltar.setOnAction(e -> {
			try {
				inicioService.inicial();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btn_minus.setOnAction(e -> {
			inicioService.minimizar();
		});
		
		btn_close.setOnAction(e -> {
			System.exit(0);
		});
		
		btn_cadastrar.setOnAction(e -> {
			try {
				inicioService.cadastro();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btn_logon.setOnAction(e -> {
			try {
				Logar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
	}
	
	private void Btn_effects() {
		 effect_mouse(btn_cadastrar, "#ff9933", "-fx-border-color: #ff9933;");
		 effect_mouse(btn_logon, "#99ff00", "-fx-background-color: #0080ff; -fx-text-fill: #fff;");
		 
	}
	
	 private void effect_mouse(JFXButton btn, String color, String after) {
		  btn.setOnMouseEntered(e -> {
			  btn.setStyle("-fx-background-color: "+color+";");
		  });

		  btn.setOnMouseExited(e -> {
			  btn.setStyle(""+after);
		  });
	  }
	
	private void Logar() throws IOException {
		
		String user = txt_email.getText();
		String pass = txt_senha.getText();
		
		if(user == null || user.equals("")) {
			JOptionPane.showMessageDialog(null, "Digite o usuario!");
			return;
		}
		
		AcessoModel am = new AcessoModel();
		if(am.estaConectado()) {
			Perfil pes = am.buscaLogin(user, pass);
			
			if(pes == null) {
				JOptionPane.showMessageDialog(null, "Credenciais incorretas!");
				return;
			}
			
			login.iniciarClasse(pes);
			inicioService.inicial();
			
		}else {
			JOptionPane.showMessageDialog(null, "Nao foi possivel estabelecer conexao com a base de dados!");
		}
		
		
	}

}
