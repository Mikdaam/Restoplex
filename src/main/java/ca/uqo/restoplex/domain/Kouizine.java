package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.domain.model.Cookable;
import ca.uqo.restoplex.domain.model.Order;
import ca.uqo.restoplex.domain.model.OrderableDescription;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

import java.util.Objects;

public final class Kouizine {
  private final ObservableList<Cookable> toCook = FXCollections.observableArrayList();
  private final ObservableList<Cookable> inPreparation = FXCollections.observableArrayList();

  Kouizine() {}

  private void associateOrderLineWithNewCookables(Order.OrderLine orderLine) {
    var description = orderLine.orderableDescription();
    switch (description) {
      case OrderableDescription.ItemDescription itemDescription -> {
        var cookable = new Cookable(orderLine.quantity(), itemDescription, orderLine);
        orderLine.associateWithCookable(cookable);
        toCook.add(cookable);
      }
      case OrderableDescription.MealDescription mealDescription -> mealDescription.items().stream()
              .map(itemDescription -> new Cookable(orderLine.quantity(), itemDescription, orderLine))
              .forEach(cookable -> {
                orderLine.associateWithCookable(cookable);
                toCook.add(cookable);
              });
    }
  }

  void submitNewOrder(Order order) {
    Objects.requireNonNull(order);
    order.orderLinesToCook().forEach(this::associateOrderLineWithNewCookables);
    System.out.println("Kouizine :");
    System.out.println(toCook);
  }

  public void test(Cookable cookable) { // TODO A VIRER
    toCook.add(cookable);
  }

  public void prepareCookable(Cookable cookable) {
    toCook.remove(cookable);
//    cookable.associatedOrderLine().markInPreparation(); // TODO A REMETTRE
    inPreparation.add(cookable);
  }

  public void notifyReadyCookable(Cookable cookable) {
    inPreparation.remove(cookable);
//    cookable.associatedOrderLine().markReady(); // TODO A REMETTRE
    // TODO send Ready notif
  }

  public ListView<Cookable> bindListViewWithToCookCookables() {
    return new ListView<>(toCook);
  }
  public ListView<Cookable> bindListViewWithInPreparationCookables() {
    return new ListView<>(inPreparation);
  }
}
