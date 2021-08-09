package neto_news.portal;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import neto_news.portal.util.InicioService;
import neto_news.portal.util.Login;
import neto_news.portal.resource.Templates;
import neto_news.portal.util.CarregadorRecursos;

public class portal  extends Application {
		@Override
		public void start(Stage stage) throws Exception {
			InicioService.iniciarClasse(stage);
			Login.iniciarClasse(null);
			stage.initStyle(StageStyle.UNDECORATED); // removendo botoes padrao
			Parent root = FXMLLoader.load(CarregadorRecursos.getResource(Templates.BASE.getUrl()));
			Scene scene = new Scene(root, 1024, 768); // resolucao inicial
			stage.setScene(scene);
			stage.setTitle("NETO NEWS");
			stage.setMinHeight(768);
			stage.setMinWidth(1024);
			
			stage.show();
		}

		@Override
		public void stop() throws Exception {
			super.stop();
			
		}

		public static void main(String[] args) {
			launch(args);
		}

}
