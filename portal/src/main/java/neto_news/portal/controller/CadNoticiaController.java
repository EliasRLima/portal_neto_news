package neto_news.portal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Login;

public class CadNoticiaController implements Initializable{
	
	@FXML
	JFXButton btn_exit, btn_minus, btn_voltar;
	
	private InicioService inicioService;
	private Login login;
	
	public CadNoticiaController() throws Exception {
		this.inicioService = InicioService.getInstancia();
		this.login = Login.getInstancia();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Btn_actions();
	}
	
	private void Btn_actions() {
		btn_exit.setOnAction(e -> {
			System.exit(0);
		});
		
		btn_minus.setOnAction(e -> {
			inicioService.minimizar();
		});
		
		btn_voltar.setOnAction(e -> {
			try {
				inicioService.inicial();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}
