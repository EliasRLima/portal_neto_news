package neto_news.portal.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.jfoenix.controls.JFXTextArea;
import neto_news.portal.util.InicioService;

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
      
	  public BaseController() throws Exception {
			this.inicioService = InicioService.getInstancia();
		}
	  
	  @Override
	  public void initialize(URL arg0, ResourceBundle arg1) {
		  
		  btn_actions();
		  
	  }
	  
	  private void btn_actions() {
		  
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
}
