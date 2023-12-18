package ca.uqo.restoplex.domain;
import java.util.HashMap;
import java.util.HashSet;
import ca.uqo.restoplex.domain.model.Table;
import ca.uqo.restoplex.domain.model.Order;

import java.util.Set;

import ca.uqo.restoplex.utils.Factory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

public final class OrderController {
	private final Kouizine kouizine = Factory.getKouizineInstance();
	private final ObservableList<String> currentOrderItemsList = FXCollections.observableArrayList();
	private final HashMap<String, Short> currentOrderItemsQuantities = new HashMap<>(); // refactor !!
	private final HashMap<Table, Set<Order>> orders = new HashMap<>();

	public OrderController() {}

		// Juste horrible : a ne jamais faire !!!
    public ObservableList<String> getCurrentOrderItemsList() {
        return currentOrderItemsList;
    }
    
   public Order createOrder(Table associatedTable){
	   var order = new Order(associatedTable);
	   orders.merge(associatedTable, new HashSet<>(), (oldSet, __) -> {
		   oldSet.add(order);
		   return oldSet;
	   });
	   
	   return order;
   }

	 public short addNewItemToOrder(String itemName) {
		if(!currentOrderItemsQuantities.containsKey(itemName)) {
			var newItemStr = itemName + "\t|\tx" + 1;
			currentOrderItemsList.add(newItemStr);
		}

		return currentOrderItemsQuantities.merge(itemName, (short) 1, (previousQuantity, __) -> {
			var oldItemStr = itemName + "\t|\tx" + previousQuantity;
      currentOrderItemsList.remove(oldItemStr);
			var newQuantity = (short) (previousQuantity + 1);
			var newItemStr = itemName + "\t|\tx" + newQuantity;
			currentOrderItemsList.add(newItemStr);
			return newQuantity;
		});
	 }
   
   public void submitTokouizine(Order orderToSubmit) {
	   kouizine.submitNewOrder(orderToSubmit);
		 currentOrderItemsList.clear();
		 // takeOrderForTable(table)
   }
}
