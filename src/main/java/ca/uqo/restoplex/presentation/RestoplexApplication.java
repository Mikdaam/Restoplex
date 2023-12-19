package ca.uqo.restoplex.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;
//import javafx.fxml.FXML;


public class RestoplexApplication extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("TablesPage.fxml")));
			Scene scene1 = new Scene(root1);
			Parent root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("OrderPage.fxml")));
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
