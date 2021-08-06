package neto_news.portal.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;

import com.jfoenix.controls.JFXBadge;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import java.awt.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import com.jfoenix.controls.JFXTextArea;

import neto_news.portal.util.CarregadorRecursos;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Noticia;

public class BaseController implements Initializable {

	  @FXML
	  HBox hb_ntc_1, hb_ntc_2, hb_ntc_3, hb_ntc_4, hb_ntc_5, hb_ntc_6;
	  
	  @FXML
	  Label lb_ntc_principal, lb_tittle_ntc_1;
	  
	  @FXML
	  ImageView img_ntc_principal, img_ntc_1, img_ntc_2, img_ntc_3, img_ntc_4, img_ntc_5, img_ntc_6;
	  
	  @FXML
	  JFXButton btn_open_ntc_1, btn_open_ntc_2, btn_open_ntc_3, btn_open_ntc_4, btn_open_ntc_5, btn_open_ntc_6;
	  
	  @FXML
	  JFXBadge bdg_ntc_1;
	  
	  @FXML
	  JFXButton btn_like_ntc_1, btn_like_ntc_2, btn_like_ntc_3, btn_like_ntc_4, btn_like_ntc_5, btn_like_ntc_6;
	  
	  @FXML
	  JFXTextArea txt_ntc_principal;
	  
	  @FXML
	  JFXButton btn_mn_news, btn_mn_liked, btn_mn_esportes, btn_mn_games, btn_mn_politica;
	  
	  @FXML
	  JFXButton btn_minimizar, btn_close;
	  
	  @FXML
	  JFXButton btn_ntc_refresh, btn_ntc_next, btn_ntc_back;
	  
	  private InicioService inicioService;
	  private ArrayList<Noticia> ntcs;
      
	  public BaseController() throws Exception {
			this.inicioService = InicioService.getInstancia();
		}
	  
	  @Override
	  public void initialize(URL arg0, ResourceBundle arg1) {
		  
		  btn_actions();
		  ntcs = getNoticias(0);

		  if(ntcs == null) {
			  
			try {
				Image img98 = ImageIO.read(CarregadorRecursos.getResource("images/ntc_0_98x98.png"));
				Image img500 = ImageIO.read(CarregadorRecursos.getResource("images/ntc_0.png"));
				
				Noticia ntc = new Noticia("Neto News sem novidades?", 
		  		        img98, //98x98 
		                img500, 
		  				"Os jornalistas estao a \"mimi\", voce pode logar e contribuir para o portal com suas noticias!", 
		  				3);
				
				setNoticia(ntc, 1);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
		  
		  
	  }
	  
	  
	

	private void btn_actions() {
		  
		  btn_close.setOnAction(e -> {
			  
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
		  if(id == 1) {
			  bdg_ntc_1.setText(String.valueOf(30));
			  hb_ntc_1.setVisible(true);
		  }
	  }
	  
	  private ArrayList<Noticia> getNoticias(int filtro) {
		   return null;
	  }
}
