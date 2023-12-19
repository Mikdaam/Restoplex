package ca.uqo.restoplex.presentation.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

	@FXML
	private Button waiter;

	@FXML
	private Button cook;

	@FXML
	private Button manager;

	@FXML
	private void initialize() {
		waiter.setOnAction(this::handleWaiterButtonClick);
		cook.setOnAction(this::handleCookButtonClick);
		manager.setOnAction(this::handleManagerButtonClick);
	}

	private void openNewStage(String fxmlPath) {
		try {
			var loader = new FXMLLoader(getClass().getResource(fxmlPath));
			Parent root = loader.load();

			var stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void handleWaiterButtonClick(ActionEvent event) {
		openNewStage("/ca/uqo/restoplex/presentation/scenes/TablesPage.fxml");
	}

	private void handleCookButtonClick(ActionEvent event) {
		openNewStage("/ca/uqo/restoplex/presentation/scenes/KitchenPage.fxml");
	}

	private void handleManagerButtonClick(ActionEvent event) {
		openNewStage("/ca/uqo/restoplex/presentation/scenes/LoginPage.fxml");
	}
}