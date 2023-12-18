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

public class OrderTakerGUI implements Initializable{
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
		private static Label tableLabel;

	   // @Override
	    public void initialize(URL location, ResourceBundle resources) {
	        // Configurer les gestionnaires d'�v�nements pour chaque bouton
	    	
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
	    	
	    	var pizza = new OrderableDescription.ItemDescription(pizzaDesc, OrderableDescription.ITEM_CATEGORY.DISH, "sauce tomate, mozarrella, champignons");
	    	var burger = new OrderableDescription.ItemDescription(burgerDesc, OrderableDescription.ITEM_CATEGORY.DISH, "pain burger, steak, concombre, tomates, fromage");
	    	var poutine = new OrderableDescription.ItemDescription(poutineDesc, OrderableDescription.ITEM_CATEGORY.STARTER, "French fries, gravy, fromage poutine");
	    	var miniBurger = new OrderableDescription.ItemDescription(miniBurgerDesc, OrderableDescription.ITEM_CATEGORY.DISH, "mini pain burger, mini steak, concombre, tomates, fromage");
	    	var Tiramisu = new OrderableDescription.ItemDescription(tiramisuDesc, OrderableDescription.ITEM_CATEGORY.DESSERT, "mascarpone, caco, biscuit cuillère");
	    	var Coke = new OrderableDescription.ItemDescription(cokeDesc, OrderableDescription.ITEM_CATEGORY.DRINK, "");
	    	
	    	var italianMeal = new OrderableDescription.MealDescription(italianDesc, List.of(pizza, Coke, Tiramisu));
	    	var kidsMeal = new OrderableDescription.MealDescription(kidMealDesc, List.of(miniBurger, Coke, Tiramisu));
	    	var familialMeal = new OrderableDescription.MealDescription(familialMealDesc, List.of(poutine, Coke, Tiramisu));

	    	
	    	if (plat1Button != null) {
	    		plat1Button.setOnAction(e -> {
						if(CURRENT_ORDER == null) {
							return;
						}

						var quantity = ORDER_CONTROLLER.addNewItemToOrder("Italien");
		    		CURRENT_ORDER.addNewOrderable(italianMeal, quantity);
		    	});
	    	}
	    	
	        if (plat2Button != null) {
	        	plat2Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Kid's Meal");
							CURRENT_ORDER.addNewOrderable(kidsMeal, quantity);
	        	});
	        }
	        
	        if (plat3Button != null) {
	        	plat3Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Familial Meal");
							CURRENT_ORDER.addNewOrderable(familialMeal, quantity);
	        	});
	        }
	        
	        if (plat4Button != null) {
	        	plat4Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Pizza");
		    			CURRENT_ORDER.addNewOrderable(pizza, quantity);
	        	});
	        }
	        
	        if (plat5Button != null) {
	        	plat5Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Burger");
							CURRENT_ORDER.addNewOrderable(burger, quantity);
	        	});
	        }
	        
	        if (plat6Button != null) {
	        	plat6Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Poutine");
							CURRENT_ORDER.addNewOrderable(poutine, quantity);
	        	});
	        }
	        
	        if (plat7Button != null) {
	        	plat7Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Mini-Burger");
							CURRENT_ORDER.addNewOrderable(miniBurger, quantity);
	        	});
	        }
	        
	        if (plat8Button != null) {
	        	plat8Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Tiramisu");
							CURRENT_ORDER.addNewOrderable(Tiramisu, quantity);
	        	});
	        }
	        
	        if (plat9Button != null) {
	        	plat9Button.setOnAction(e -> {
	        		if(CURRENT_ORDER == null) {
								return;
							}

							var quantity = ORDER_CONTROLLER.addNewItemToOrder("Coke");
							CURRENT_ORDER.addNewOrderable(Coke, quantity);
	        	});
	        }

	        // Configurer le mod�le pour la ListView
	        if (myListView != null) myListView.setItems(ORDER_CONTROLLER.getCurrentOrderItemsList());
	        
	        if(done != null) {
	        	done.setOnAction(e -> ORDER_CONTROLLER.submitTokouizine(CURRENT_ORDER));
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
	   }
	    
	    public static void switchToMenuCommande(ActionEvent event, Table selectedTable) throws IOException {
			Parent root2 = FXMLLoader.load(Objects.requireNonNull(OrderTakerGUI.class.getResource("MenuCommande.fxml")));
			var stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			var scene= new Scene(root2);
			stage.setScene(scene);

			System.out.println(selectedTable);
			CURRENT_ORDER = ORDER_CONTROLLER.createOrder(selectedTable);
		    
			stage.show();
		}
		
		public static void switchToTable(ActionEvent event) throws IOException {
			Parent root1 = FXMLLoader.load(Objects.requireNonNull(OrderTakerGUI.class.getResource("Tablee.fxml")));
			var stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			var scene = new Scene(root1);
			stage.setScene(scene);
			stage.show();
		}
}
