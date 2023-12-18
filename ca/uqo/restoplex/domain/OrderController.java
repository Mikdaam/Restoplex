package ca.uqo.restoplex.domain;
import java.util.HashMap;
import java.util.HashSet;
import ca.uqo.restoplex.data.Table;
import ca.uqo.restoplex.data.Order;

import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public final class OrderController {
	private final Kouizine kouizine = Factory.getKouizineInstance();
	private final ObservableList<String> platList = FXCollections.observableArrayList();
	private final HashMap<Table, Set<Order>> orders = new HashMap<>();

	OrderController() {}
	
    public ObservableList<String> getPlatList() {
        return platList;
    }
    
   public Order createOrder(Table associatedTable){
	   var order = new Order(associatedTable);
	   orders.merge(associatedTable, new HashSet<Order>(), (oldSet, __) -> {
		   oldSet.add(order);
		   return oldSet;
	   });
	   
	   return order;
   }
   
   public void submitTokouizine(Order orderToSubmit) {
	   kouizine.submitNewOrder(orderToSubmit);
   }
}
