package ca.uqo.restoplex.presentation;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Cursor;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class ViewOrderController {
	/*@FXML
    private ListView<CommandeViewModel> mainListView;

    private final OrderController commandeController = new OrderController();

    public void initialize() {
    	@FXML
        private ListView<CommandeViewModel> mainListView;

        private final OrderController orderController = new OrderController();

        public void initialize() {
            // Remplissez la liste principale avec les commandes existantes
            mainListView.setItems(orderController.getOrderList().stream()
                    .map(CommandeViewModel::new)
                    .collect(Collectors.toList()));

            // Configurer l'affichage personnalisé pour chaque élément de la liste principale
            mainListView.setCellFactory(param -> new ListCell<>() {
                @Override
                protected void updateItem(CommandeViewModel item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                    } else {
                        // Afficher le numéro de la commande par exemple (vous pouvez personnaliser ceci)
                        setText("Commande #" + item.getOrder().getIdOrder());

                        // Créer et configurer la sous-liste pour les lignes de commande
                        ListView<Order.OrderLine> orderLinesListView = new ListView<>(item.getOrderLines());
                        setGraphic(orderLinesListView);
                    }
                }
            });
        }*/

	
}
