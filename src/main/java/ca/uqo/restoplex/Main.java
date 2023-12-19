package ca.uqo.restoplex;

import ca.uqo.restoplex.data.Database;
import ca.uqo.restoplex.utils.DatabaseSetup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ca/uqo/restoplex/presentation/scenes/HomePage.fxml"));
		Parent root = loader.load();

		Scene scene = new Scene(root);
		primaryStage.setTitle("RestoPlex");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// Set up database connection
		try {
			var connectionSource = Database.getConnectionSource();
			DatabaseSetup.setUp(connectionSource);
			Application.launch(args);
			Database.closeConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
