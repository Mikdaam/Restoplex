package ca.uqo.restoplex.presentation;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.util.Objects;

public class TableOverviewGUI extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Presantation.fxml")));
			Scene scene = new Scene(root);

			scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("application.css")).toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		launch(args);
//	}
}
