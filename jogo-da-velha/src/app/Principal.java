package app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Principal extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		//URL arquivoFXML = getClass().getResource("/app/jogoDaVelha.fxml");
		//GridPane raiz = FXMLLoader.load(arquivoFXML);
		
		//Scene cena = new Scene(raiz, 300, 300);
		//primaryStage.setScene(cena);
		primaryStage.setTitle("Jogo Da Velha");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
