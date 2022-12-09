package app;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent raiz = new TabuleiroVisao();
			
		Scene principal = new Scene(raiz, 300, 300);
		primaryStage.setScene(principal);
		primaryStage.setTitle("Jogo Da Velha");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
