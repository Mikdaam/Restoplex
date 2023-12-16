package ca.uqo.restoplex.presentation;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassController implements Initializable{
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void switchToMenuCommande(ActionEvent event) throws IOException {
		Parent root2 = FXMLLoader.load(getClass().getResource("MenuCommande.fxml"));
		
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root2);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToTable(ActionEvent event) throws IOException {
		Parent root1 = FXMLLoader.load(getClass().getResource("Tablee.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root1);
		stage.setScene(scene);
		stage.show();
	}


		@FXML
		private ListView<String> myListView;
		@FXML
		private Button plat1Button;  
		@FXML
		private Button plat2Button;
		@FXML
		private Button plat3Button;
		@FXML
	    private Button plat4Button;  
		@FXML
		private Button plat5Button;
		@FXML
		private Button plat6Button;
		@FXML
	    private Button plat7Button;
		@FXML
		private Button plat8Button;
		@FXML
		private Button plat9Button;
			 
	    private OrderController orderController = new OrderController();

	   // @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        // Configurer les gestionnaires d'événements pour chaque bouton
	    	if (plat1Button != null) plat1Button.setOnAction(e -> onPlatButtonClick("Italien"));
	        if (plat2Button != null) plat2Button.setOnAction(e -> onPlatButtonClick("Kid's Meal"));
	        if (plat3Button != null) plat3Button.setOnAction(e -> onPlatButtonClick("Familial Meal"));
	        if (plat4Button != null) plat4Button.setOnAction(e -> onPlatButtonClick("Pizza"));
	        if (plat5Button != null) plat5Button.setOnAction(e -> onPlatButtonClick("Burger"));
	        if (plat6Button != null) plat6Button.setOnAction(e -> onPlatButtonClick("Poutine"));
	        if (plat7Button != null) plat7Button.setOnAction(e -> onPlatButtonClick("Mini-Burger"));
	        if (plat8Button != null) plat8Button.setOnAction(e -> onPlatButtonClick("Tiramisu"));
	        if (plat9Button != null) plat9Button.setOnAction(e -> onPlatButtonClick("Coke"));

	        // Configurer le modèle pour la ListView
	        if (myListView != null) myListView.setItems(orderController.getPlatList());
	   }
	    
	    public void onPlatButtonClick(String nomPlat) {
	        
	        orderController.getPlatList().add(nomPlat);
	    }
	
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
