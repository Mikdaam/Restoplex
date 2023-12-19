package ca.uqo.restoplex.presentation.controller;

import ca.uqo.restoplex.domain.Kouizine;
import ca.uqo.restoplex.domain.model.Cookable;
import ca.uqo.restoplex.utils.Factory;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class KitchenPageController {

	@FXML
	private ListView<Cookable> toCookList;

	@FXML
	private ListView<Cookable> inPreparationList;

	@FXML
	private Button accept;

	@FXML
	private Button ready;

	private final Kouizine kouizine = Factory.getKouizineInstance();

	@FXML
	private void initialize() {
		kouizine.bindListViewWithToCookCookables(toCookList);
		kouizine.bindListViewWithInPreparationCookables(inPreparationList);

		// Add event listeners or perform initialization here
		toCookList.getSelectionModel().selectedItemProperty().addListener(
				(observableValue, oldValue, newValue) -> updateSelectedCookable(newValue, "cookable")
		);

		inPreparationList.getSelectionModel().selectedItemProperty().addListener(
				(observableValue, oldValue, newValue) -> updateSelectedCookable(newValue, "readyCookable")
		);

		accept.setOnAction(__ -> handleAcceptButton());
		ready.setOnAction(__ -> handleReadyButton());
	}

	private void updateSelectedCookable(Cookable cookable, String componentId) {
		if (cookable != null) {
			BorderPane borderPane = createCookableComponent(cookable, componentId);

			// Add the created component to the appropriate ListView
			if (componentId.equals("cookable")) {
				toCookList.getItems().add(cookable);
			} else if (componentId.equals("readyCookable")) {
				inPreparationList.getItems().add(cookable);
			}
		}
	}

	private BorderPane createCookableComponent(Cookable cookable, String componentId) {
		// Create and configure the BorderPane component for the cookable
		BorderPane borderPane = new BorderPane();
		Text text = new Text(cookable.toString());
		text.setId(componentId);
		// Add other configuration for the text or borderPane if needed

		// Add the text to the center of the BorderPane
		borderPane.setCenter(text);

		return borderPane;
	}

	private void handleAcceptButton() {
		var selectedCookable = toCookList.getSelectionModel().getSelectedItem();
		if (selectedCookable != null) {
			kouizine.prepareCookable(selectedCookable);
		}
	}

	private void handleReadyButton() {
		var selectedCookable = inPreparationList.getSelectionModel().getSelectedItem();
		if (selectedCookable != null) {
			kouizine.notifyReadyCookable(selectedCookable);
		}
	}
}
