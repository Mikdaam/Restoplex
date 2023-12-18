package ca.uqo.restoplex.presentation;
import javafx.stage.Stage;
import ca.uqo.restoplex.data.Order;
import ca.uqo.restoplex.data.OrderableDescription;
import ca.uqo.restoplex.data.Table;
import ca.uqo.restoplex.domain.Factory;
import ca.uqo.restoplex.domain.OrderController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Node;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ClassController implements Initializable{
	private final static OrderController ORDER_CONTROLLER = Factory.getOrderControllerInstance();
	
	private static Order CURRENT_ORDER;
	
	

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
		
		@FXML
		private Button done;
		
		@FXML
		private Button backToTable;
		
		@FXML
	    private Label nomTable;
		@FXML
	    private Label nomCommande;
		private static Table selectedTable;

	   @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        // Configurer les gestionnaires d'ï¿½vï¿½nements pour chaque bouton
	    	
	    	var italianDesc = new OrderableDescription.OrderableDescriptionData(1L, "Italien", 35.20);
	    	italianDesc.reveal();
	    	var kidMealDesc = new OrderableDescription.OrderableDescriptionData(2L, "Kid's Meal", 25.99);
	    	kidMealDesc.reveal();
	    	var familialMealDesc = new OrderableDescription.OrderableDescriptionData(3L, "Familial Meal", 60.89);
	    	familialMealDesc.reveal();
	    	var pizzaDesc = new OrderableDescription.OrderableDescriptionData(4L, "Pizza", 18.99);
	    	pizzaDesc.reveal();
	    	var burgerDesc = new OrderableDescription.OrderableDescriptionData(5L, "Burger", 5.99);
	    	burgerDesc.reveal();
	    	var poutineDesc = new OrderableDescription.OrderableDescriptionData(6L, "Poutine", 9.99);
	    	poutineDesc.reveal();
	    	var miniBurgerDesc = new OrderableDescription.OrderableDescriptionData(7L, "Mini-Burger", 3.25);
	    	miniBurgerDesc.reveal();
	    	var tiramisuDesc = new OrderableDescription.OrderableDescriptionData(8L, "Tiramisu", 12.35);
	    	tiramisuDesc.reveal();
	    	var cokeDesc = new OrderableDescription.OrderableDescriptionData(9L, "Coke", 6.59);
	    	cokeDesc.reveal();
	    	
	    	var pizza = new OrderableDescription.ItemDescription(pizzaDesc, OrderableDescription.ITEM_CATEGORY.DISH, "TODO");
	    	var burger = new OrderableDescription.ItemDescription(burgerDesc, OrderableDescription.ITEM_CATEGORY.DISH, "TODO");
	    	var poutine = new OrderableDescription.ItemDescription(poutineDesc, OrderableDescription.ITEM_CATEGORY.STARTER, "TODO");
	    	var miniBurger = new OrderableDescription.ItemDescription(miniBurgerDesc, OrderableDescription.ITEM_CATEGORY.DISH, "TODO");
	    	var Tiramisu = new OrderableDescription.ItemDescription(tiramisuDesc, OrderableDescription.ITEM_CATEGORY.DESSERT, "TODO");
	    	var Coke = new OrderableDescription.ItemDescription(cokeDesc, OrderableDescription.ITEM_CATEGORY.DRINK, "TODO");
	    	
	    	var italianMeal = new OrderableDescription.MealDescription(italianDesc, List.of(pizza, Coke, Tiramisu));
	    	var kidsMeal = new OrderableDescription.MealDescription(kidMealDesc, List.of(miniBurger, Coke, Tiramisu));
	    	var familialMeal = new OrderableDescription.MealDescription(familialMealDesc, List.of(poutine, Coke, Tiramisu));
	    	
	    	if (plat1Button != null) {
	    		plat1Button.setOnAction(e -> {
		    		onPlatButtonClick("Italien");
		    		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(italianMeal, (short) 1);
		    	});
	    	}
	    	
	        if (plat2Button != null) {
	        	plat2Button.setOnAction(e -> {
	        		onPlatButtonClick("Kid's Meal");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(kidsMeal, (short) 1);
	        	});
	        }
	        
	        if (plat3Button != null) {
	        	plat3Button.setOnAction(e -> {
	        		onPlatButtonClick("Familial Meal");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(familialMeal, (short) 1);
	        	});
	        }
	        
	        if (plat4Button != null) {
	        	plat4Button.setOnAction(e -> {
	        		onPlatButtonClick("Pizza");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(pizza, (short) 1);
	        	});
	        }
	        
	        if (plat5Button != null) {
	        	plat5Button.setOnAction(e -> {
	        		onPlatButtonClick("Burger");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(burger, (short) 1);
	        	});
	        }
	        
	        if (plat6Button != null) {
	        	plat6Button.setOnAction(e -> {
	        		onPlatButtonClick("Poutine");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(poutine, (short) 1);
	        	});
	        }
	        
	        if (plat7Button != null) {
	        	plat7Button.setOnAction(e -> {
	        		onPlatButtonClick("Mini-Burger");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(miniBurger, (short) 1);
	        	});
	        }
	        
	        if (plat8Button != null) {
	        	plat8Button.setOnAction(e -> {
	        		onPlatButtonClick("Tiramisu");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(Tiramisu, (short) 1);
	        	});
	        }
	        
	        if (plat9Button != null) {
	        	plat9Button.setOnAction(e -> {
	        		onPlatButtonClick("Coke");
	        		if(CURRENT_ORDER == null) {
		    			return;
		    		}
		    		
		    		CURRENT_ORDER.addNewOrderable(Coke, (short) 1);
	        	});
	        }

	        if (myListView != null) myListView.setItems(ORDER_CONTROLLER.getPlatList());
	        
	        if(done != null) {
	        	done.setOnAction(e -> {
	                ORDER_CONTROLLER.submitTokouizine(CURRENT_ORDER);
	                ORDER_CONTROLLER.getPlatList().clear();
	            });
	        }
	        
	        if(backToTable != null) {
	        	backToTable.setOnAction(event -> {
					try {
						switchToTable(event);
					} catch (IOException e) {
						System.err.println(e.getMessage());
						System.exit(1);
						return;
					}
				});
	        }
	        
	        if(nomTable !=null && CURRENT_ORDER !=null) {
	        	var table= CURRENT_ORDER.getTable();
	        	nomTable.setText("Table #"+ table.id());
	        }
	   }
	    
	    public void onPlatButtonClick(String nomPlat) {
	    	ORDER_CONTROLLER.getPlatList().add(nomPlat);
	    }
	    
	    //à revoir avec Axel
	    public static void switchToMenuCommande(ActionEvent event, Table selectedTable) throws IOException {
			Parent root2 = FXMLLoader.load(Objects.requireNonNull(ClassController.class.getResource("MenuCommande.fxml")));
			var stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			var scene= new Scene(root2);
			stage.setScene(scene);
		    
			CURRENT_ORDER = ORDER_CONTROLLER.createOrder(selectedTable);
		    stage.show();
		}
		
		public static void switchToTable(ActionEvent event) throws IOException {
			Parent root1 = FXMLLoader.load(Objects.requireNonNull(ClassController.class.getResource("Tablee.fxml")));
			var stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			var scene = new Scene(root1);
			stage.setScene(scene);
			stage.show();
		}
		
		@FXML
	    private void goToHomePage(ActionEvent event) throws IOException {
			//demander à Axel l'interface qu'il a créé pour home et changer le nom de la localisation
	        Parent root = FXMLLoader.load(Objects.requireNonNull(ClassController.class.getResource("VotrePageAccueil.fxml")));
	        Scene scene = new Scene(root);
	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(scene);
	        stage.show();
	    }
}
