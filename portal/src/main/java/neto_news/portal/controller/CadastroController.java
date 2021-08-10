package neto_news.portal.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import neto_news.portal.Objects.Perfil;
import neto_news.portal.model.AcessoModel;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Login;

public class CadastroController implements Initializable{
	
	@FXML
	JFXButton btn_voltar, btn_minus, btn_close, btn_cadastrar;
	
	@FXML
	TextField txt_nome, txt_email;
	
	@FXML
	PasswordField txt_senha, txt_senha_confirm;
	
	@FXML
	DatePicker dt_nascimento;
	
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
			try {
				Cadastrar();
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	
	private void Cadastrar() throws NoSuchAlgorithmException, IOException {
		
		String dt = "";
		try {
			dt = dt_nascimento.getValue().toString();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Formato de data invalido!");
			return;
		}
		
		if(!txt_senha.getText().equals(txt_senha_confirm.getText())) {
			JOptionPane.showMessageDialog(null, "As senhas sao diferentes!");
			return;
		}
		
		if(txt_email.getText() == null || txt_email.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O email deve ser preenchido.");
			return;
		}else {
			AcessoModel am = new AcessoModel();
			if(am.estaConectado()) {
				boolean nm = am.existeEmail(txt_email.getText());
				if(nm) {
					JOptionPane.showMessageDialog(null, "Esse email ja foi usado.");
					return;
				}
			}	
		}
		
		if(txt_nome.getText() == null || txt_nome.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "O nome nao pode ser vazio.");
			return;
		}else {
			AcessoModel am = new AcessoModel();
			if(am.estaConectado()) {
				boolean nm = am.existeNome(txt_nome.getText());
				if(nm) {
					JOptionPane.showMessageDialog(null, "Esse nome ja foi usado.");
					return;
				}
			}
		}
		
		Perfil pessoa = new Perfil(txt_nome.getText(), dt, txt_email.getText(), txt_senha.getText());
		AcessoModel am = new AcessoModel();
		if(am.estaConectado()) {
			boolean nm = am.novoCadastro(pessoa);
			if(nm) {
				JOptionPane.showMessageDialog(null, "cadastro efetuado.");
				login.iniciarClasse(pessoa);
				inicioService.inicial();
				return;
			}else {
				JOptionPane.showMessageDialog(null, "Falha ao efetuar cadastro.");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Falha ao conectar a base de dados.");
		}
	}

}
