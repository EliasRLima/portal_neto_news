package neto_news.portal.controller;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXNodesList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import com.jfoenix.controls.JFXTextArea;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import neto_news.portal.resource.Templates;
import neto_news.portal.util.CarregadorRecursos;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Login;
import neto_news.portal.util.Noticia;

public class BaseController implements Initializable {

	  @FXML
	  HBox hb_ntc_1, hb_ntc_2, hb_ntc_3, hb_ntc_4, hb_ntc_5, hb_ntc_6;
	  
	  @FXML
	  Label lb_ntc_principal, lb_tittle_ntc_1, lb_tittle_ntc_2, lb_tittle_ntc_3, lb_tittle_ntc_4, lb_tittle_ntc_5, lb_tittle_ntc_6;
	  
	  @FXML
	  ImageView img_ntc_principal, img_ntc_1, img_ntc_2, img_ntc_3, img_ntc_4, img_ntc_5, img_ntc_6;
	  
	  @FXML
	  JFXButton btn_open_ntc_1, btn_open_ntc_2, btn_open_ntc_3, btn_open_ntc_4, btn_open_ntc_5, btn_open_ntc_6;
	  
	  @FXML
	  JFXBadge bdg_ntc_1, bdg_ntc_2, bdg_ntc_3, bdg_ntc_4, bdg_ntc_5, bdg_ntc_6;
	  
	  @FXML
	  JFXButton btn_like_ntc_1, btn_like_ntc_2, btn_like_ntc_3, btn_like_ntc_4, btn_like_ntc_5, btn_like_ntc_6;
	  
	  @FXML
	  JFXButton btn_rp_ntc_1, btn_rp_ntc_2, btn_rp_ntc_3, btn_rp_ntc_4, btn_rp_ntc_5, btn_rp_ntc_6;
	  
	  @FXML
	  FontAwesomeIcon icon_like_ntc_1, icon_like_ntc_2, icon_like_ntc_3, icon_like_ntc_4, icon_like_ntc_5, icon_like_ntc_6;
	  
	  @FXML
	  JFXTextArea txt_ntc_principal;
	  
	  @FXML
	  JFXButton btn_mn_news, btn_mn_liked, btn_mn_esportes, btn_mn_games, btn_mn_politica;
	  
	  @FXML
	  JFXNodesList nd_lista_acesso;
	  
	  @FXML
	  JFXButton btn_acesso, btn_sobre, btn_minimizar, btn_close;
	  
	  @FXML
	  JFXButton btn_ntc_refresh, btn_ntc_next, btn_ntc_back;
	  
	  private InicioService inicioService;
	  private ArrayList<Noticia> ntcs;
	  private Login login;
      
	  public BaseController() throws Exception {
			this.inicioService = InicioService.getInstancia();
			this.login = Login.getInstancia();
		}
	  
	  @Override
	  public void initialize(URL arg0, ResourceBundle arg1) {
		  
		  btn_actions();
		  if(login.isLogado()) {
			  btn_acesso.setText("SAIR");
		  }
		  
		  ntcs = getNoticias(0);

		  if(ntcs == null) {
			  
			try {
				Image img98 = new Image("images/ntc_0_98x98.png");
				
				//inputstream = new FileInputStream("images/ntc_0.png"); 
				Image img500 = new Image("images/ntc_0.png"); 
				
				Noticia ntc = new Noticia("Neto news esta sem noticias, can help?",
						"Sem novidades :(", 
		  		        img98, //98x98 
		                img500, 
		  				"Os jornalistas estao a \"mimi\", voce pode logar e contribuir para o portal com suas noticias!", 
		  				0);
				
				setNoticia(ntc, 1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
		  
	  }
	  
	  
	

	private void btn_actions() {
		  
		  btn_acesso.setOnAction(e -> {
			  if(btn_acesso.getText().equals("ENTRAR")) {
				  //abrir metodo de login
				  btn_acesso.setText("SAIR");
			  }else {
				  //abrir metodo de logout
				  btn_acesso.setText("ENTRAR");
			  }
		  });
		
		  btn_close.setOnAction(e -> {
			  System.exit(0);
		  });
		  
		  btn_minimizar.setOnAction(e -> {
			  this.inicioService.minimizar();
		  });
		  
		  effect_mouse(btn_close, "#ff9933");
		  effect_mouse(btn_minimizar, "#ff9933");
		  effect_mouse(btn_mn_news, "#cc6600");
		  effect_mouse(btn_mn_liked, "#cc6600");
		  effect_mouse(btn_mn_esportes, "#cc6600");
		  effect_mouse(btn_mn_games, "#cc6600");
		  effect_mouse(btn_mn_politica, "#cc6600");
		  
		  //desabilitar noticias
		  hb_ntc_1.setVisible(false); 
		  hb_ntc_2.setVisible(false);  
		  hb_ntc_3.setVisible(false);  
		  hb_ntc_4.setVisible(false);  
		  hb_ntc_5.setVisible(false); 
		  hb_ntc_6.setVisible(false); 
	  }
	  
	  private void effect_mouse(JFXButton btn, String color) {
		  btn.setOnMouseEntered(e -> {
			  btn.setStyle("-fx-background-color: "+color+";");
		  });

		  btn.setOnMouseExited(e -> {
			  btn.setStyle("");
		  });
	  }
	  
	  private void setNoticia(Noticia ntc, int id) {
		  
		  if(id == 0) {
			  lb_ntc_principal.setText(ntc.getTitulo());
			  img_ntc_principal.setImage(ntc.getImg500x350());
			  txt_ntc_principal.setText(ntc.getTexto());
		  }
		  else if(id == 1) {
			  bdg_ntc_1.setText(""+ntc.getLikes());
			  
			  btn_open_ntc_1.setOnAction(e -> {
				  setNoticia(ntc, 0);
			  });
			  
			  btn_like_ntc_1.setOnAction(e -> {
				  
				  String color = icon_like_ntc_1.getFill().toString();
				  
				  if(!color.equals("0x3399ffff")) {
					  int num = Integer.parseInt(bdg_ntc_1.getText());
					  bdg_ntc_1.setText(""+(num+1));
					  icon_like_ntc_1.setFill(Paint.valueOf("#3399ff"));
				  }else {
					  int num = Integer.parseInt(bdg_ntc_1.getText());
					  bdg_ntc_1.setText(""+(num-1));
					  icon_like_ntc_1.setFill(Paint.valueOf("#ff0101"));
				  }
				  
			  });
			  
			  lb_tittle_ntc_1.setText(ntc.getMini_titulo());
			  img_ntc_1.setImage(ntc.getImg98x98());
			  btn_rp_ntc_1.setOnAction(e -> {
				//enviar report para banco
				  Reportar(ntc.getTitulo());
			  });
			  hb_ntc_1.setVisible(true);
			  
		  }else if(id == 2) {
			  bdg_ntc_2.setText(""+ntc.getLikes());
			  
			  btn_open_ntc_2.setOnAction(e -> {
				  setNoticia(ntc, 0);
			  });
			  
			  btn_like_ntc_2.setOnAction(e -> {
				  
				  String color = icon_like_ntc_2.getFill().toString();
				  
				  if(!color.equals("0x3399ffff")) {
					  int num = Integer.parseInt(bdg_ntc_2.getText());
					  bdg_ntc_2.setText(""+(num+1));
					  icon_like_ntc_2.setFill(Paint.valueOf("#3399ff"));
				  }else {
					  int num = Integer.parseInt(bdg_ntc_2.getText());
					  bdg_ntc_2.setText(""+(num-1));
					  icon_like_ntc_2.setFill(Paint.valueOf("#ff0101"));
				  }
				  
			  });
			  
			  lb_tittle_ntc_2.setText(ntc.getMini_titulo());
			  img_ntc_2.setImage(ntc.getImg98x98());
			  btn_rp_ntc_2.setOnAction(e -> {
				//enviar report para banco
				  Reportar(ntc.getTitulo());
			  });
			  hb_ntc_2.setVisible(true);
			  
		  }else if(id == 3) {
			  bdg_ntc_3.setText(""+ntc.getLikes());
			  
			  btn_open_ntc_3.setOnAction(e -> {
				  setNoticia(ntc, 0);
			  });
			  
			  btn_like_ntc_3.setOnAction(e -> {
				  
				  String color = icon_like_ntc_3.getFill().toString();
				  
				  if(!color.equals("0x3399ffff")) {
					  int num = Integer.parseInt(bdg_ntc_3.getText());
					  bdg_ntc_3.setText(""+(num+1));
					  icon_like_ntc_3.setFill(Paint.valueOf("#3399ff"));
				  }else {
					  int num = Integer.parseInt(bdg_ntc_3.getText());
					  bdg_ntc_3.setText(""+(num-1));
					  icon_like_ntc_3.setFill(Paint.valueOf("#ff0101"));
				  }
				  
			  });
			  
			  lb_tittle_ntc_3.setText(ntc.getMini_titulo());
			  img_ntc_3.setImage(ntc.getImg98x98());
			  btn_rp_ntc_3.setOnAction(e -> {
				//enviar report para banco
				  Reportar(ntc.getTitulo());
			  });
			  hb_ntc_3.setVisible(true);
			  
		  }else if(id == 4) {
			  bdg_ntc_4.setText(""+ntc.getLikes());
			  
			  btn_open_ntc_4.setOnAction(e -> {
				  setNoticia(ntc, 0);
			  });
			  
			  btn_like_ntc_4.setOnAction(e -> {
				  
				  String color = icon_like_ntc_4.getFill().toString();
				  
				  if(!color.equals("0x3399ffff")) {
					  int num = Integer.parseInt(bdg_ntc_4.getText());
					  bdg_ntc_4.setText(""+(num+1));
					  icon_like_ntc_4.setFill(Paint.valueOf("#3399ff"));
				  }else {
					  int num = Integer.parseInt(bdg_ntc_4.getText());
					  bdg_ntc_4.setText(""+(num-1));
					  icon_like_ntc_4.setFill(Paint.valueOf("#ff0101"));
				  }
				  
			  });
			  
			  lb_tittle_ntc_4.setText(ntc.getMini_titulo());
			  img_ntc_4.setImage(ntc.getImg98x98());
			  btn_rp_ntc_4.setOnAction(e -> {
				//enviar report para banco
				  Reportar(ntc.getTitulo());
			  });
			  hb_ntc_4.setVisible(true);
			  
		  }else if(id == 5) {
			  bdg_ntc_5.setText(""+ntc.getLikes());
			  
			  btn_open_ntc_5.setOnAction(e -> {
				  setNoticia(ntc, 0);
			  });
			  
			  btn_like_ntc_5.setOnAction(e -> {
				  
				  String color = icon_like_ntc_5.getFill().toString();
				  
				  if(!color.equals("0x3399ffff")) {
					  int num = Integer.parseInt(bdg_ntc_5.getText());
					  bdg_ntc_5.setText(""+(num+1));
					  icon_like_ntc_5.setFill(Paint.valueOf("#3399ff"));
				  }else {
					  int num = Integer.parseInt(bdg_ntc_5.getText());
					  bdg_ntc_5.setText(""+(num-1));
					  icon_like_ntc_5.setFill(Paint.valueOf("#ff0101"));
				  }
				  
			  });
			  btn_rp_ntc_5.setOnAction(e -> {
				//enviar report para banco
				  Reportar(ntc.getTitulo());
			  });
			  lb_tittle_ntc_5.setText(ntc.getMini_titulo());
			  img_ntc_5.setImage(ntc.getImg98x98());
			  
			  hb_ntc_5.setVisible(true);
			  
		  }else if(id == 6) {
			  bdg_ntc_6.setText(""+ntc.getLikes());
			  
			  btn_open_ntc_6.setOnAction(e -> {
				  setNoticia(ntc, 0);
			  });
			  
			  btn_like_ntc_6.setOnAction(e -> {
				  
				  String color = icon_like_ntc_6.getFill().toString();
				  
				  if(!color.equals("0x3399ffff")) {
					  int num = Integer.parseInt(bdg_ntc_6.getText());
					  bdg_ntc_6.setText(""+(num+1));
					  icon_like_ntc_6.setFill(Paint.valueOf("#3399ff"));
				  }else {
					  int num = Integer.parseInt(bdg_ntc_6.getText());
					  bdg_ntc_6.setText(""+(num-1));
					  icon_like_ntc_6.setFill(Paint.valueOf("#ff0101"));
				  }
				  
			  });
			  
			  lb_tittle_ntc_6.setText(ntc.getMini_titulo());
			  img_ntc_6.setImage(ntc.getImg98x98());
			  btn_rp_ntc_6.setOnAction(e -> {
				  //enviar report para banco
				  Reportar(ntc.getTitulo());
			  });
			  hb_ntc_6.setVisible(true);
		  }
	  }
	  
	  private void Reportar(String tt) {
		  try {
				Stage stage = new Stage();
				Parent root;
				root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.REPORT.getUrl()));
				Scene scene = new Scene(root, 395, 153); // resolucao inicial
				stage.setScene(scene);
				stage.setTitle("Noticia - Neto News");
				stage.setResizable(false);
				stage.show();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	  }
	  
	  private ArrayList<Noticia> getNoticias(int filtro) {
		   return null;
	  }
}
