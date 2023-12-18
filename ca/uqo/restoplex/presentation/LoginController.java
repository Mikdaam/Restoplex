package ca.uqo.restoplex.presentation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Button logIn;
	@FXML
	private Label errorLabel;
	String user= "Bilan Sama";
	String passcode="Bilan2003#";
	
	public boolean login(TextField username, PasswordField password) {
	    String enteredUsername = username.getText();
	    String enteredPassword = password.getText();

	    return enteredUsername.equals(user) && enteredPassword.equals(passcode);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    logIn.setOnAction(event -> {
	        try {
	            // Call the login method and check if it's successful
	            if (login(username, password)) {
	                // If login is successful, switch to the "Tablee.fxml" scene
	                switchToTable(event);
	            } else {
	                // If login fails, show an error message
	                errorLabel.setText("             Login failed!\n"+"Incorrect username or password.");
	                errorLabel.setVisible(true);
	                username.clear();
	                password.clear();
	            }
	        } catch (IOException e) {
	            System.err.println(e.getMessage());
	            System.exit(1);
	        }
	    });
	}
	
	public static void switchToTable(ActionEvent event) throws IOException {
		try {
	        URL resourceUrl = LoginController.class.getResource("Tablee.fxml");

	        if (resourceUrl == null) {
	            System.err.println("FXML resource not found: Tablee.fxml");
	            return;
	        }

	        Parent root1 = FXMLLoader.load(resourceUrl);
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        Scene scene = new Scene(root1);
	        stage.setScene(scene);
	        stage.show();
	    } catch (IOException e) {
	        System.err.println("Error loading FXML resource: " + e.getMessage());
	    }
	}

}
