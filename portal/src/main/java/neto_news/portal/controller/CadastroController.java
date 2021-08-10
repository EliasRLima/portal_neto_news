package neto_news.portal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Login;

public class CadastroController implements Initializable{
	
	@FXML
	JFXButton btn_voltar, btn_minus, btn_close, btn_cadastrar;
	
	private InicioService inicioService;
	private Login login;
    
	public CadastroController() throws Exception {
			this.inicioService = InicioService.getInstancia();
			this.login = Login.getInstancia();
			login.iniciarClasse(null);
	}
	  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Btn_actions();
		Btn_effects();
		
	}
	
	private void Btn_actions() {
		
		btn_voltar.setOnAction(e -> {
			try {
				inicioService.login();
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
			Cadastrar();
		});
		
    }
	
	private void Btn_effects() {
		effect_mouse(btn_cadastrar, "#99ff00", "-fx-background-color: #0080ff; -fx-text-fill: #fff;");
	}
	
	private void effect_mouse(JFXButton btn, String color, String after) {
		  btn.setOnMouseEntered(e -> {
			  btn.setStyle("-fx-background-color: "+color+";");
		  });

		  btn.setOnMouseExited(e -> {
			  btn.setStyle(""+after);
		  });
	  }
	
	private void Cadastrar() {
		
	}

}
