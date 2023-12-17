package ca.uqo.restoplex.presentation;
	
import java.util.Objects;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.FXML;


public class RestoPlex extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Tablee.fxml")));
			Scene scene1 = new Scene(root1);
			Parent root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("MenuCommande.fxml")));
			Scene scene2 = new Scene(root2);

			scene2.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
			primaryStage.setScene(scene2);

			scene1.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
			primaryStage.setScene(scene1);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
