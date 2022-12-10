package app;

import app.visao.TabuleiroVisao;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		String CSS = getClass()
				.getResource("/app/visao/jogoDaVelha.css").toExternalForm();
		
		Parent raiz = new TabuleiroVisao();
			
		Scene principal = new Scene(raiz, 300, 300);
		principal.getStylesheets().add(CSS);
		
		primaryStage.setScene(principal);
		primaryStage.setTitle("Jogo Da Velha");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
