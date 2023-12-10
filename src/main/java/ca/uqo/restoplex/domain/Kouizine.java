package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.data.Cookable;
import ca.uqo.restoplex.data.Order;
import ca.uqo.restoplex.data.OrderableDescription;
import java.util.Arrays;
import java.util.LinkedHashSet;

final class Kouizine {
  private final LinkedHashSet<Cookable> toCook = new LinkedHashSet<>();
  private final LinkedHashSet<Cookable> inPreparation = new LinkedHashSet<>();

  Kouizine() {}

  void associateOrderLineWithNewCookables(Order.OrderLine orderLine) {
    var description = orderLine.orderableDescription();
    switch (description) {
      case OrderableDescription.ItemDescription itemDescription -> {
        var cookable = new Cookable(42L, orderLine.quantity(), itemDescription, orderLine); // TODO bon id
        orderLine.associateWithCookable(cookable);
        toCook.addLast(cookable);
      }
      case OrderableDescription.MealDescription mealDescription -> Arrays.stream(mealDescription.items())
              .map(itemDescription -> new Cookable(42L, orderLine.quantity(), itemDescription, orderLine)) // TODO bon id
              .forEach(cookable -> {
                orderLine.associateWithCookable(cookable);
                toCook.addLast(cookable);
              });
    }
  }

  void prepareCookable(Cookable cookable) {
    toCook.remove(cookable);
    cookable.associatedOrderLine().markInPreparation();
    inPreparation.addLast(cookable);
  }

  void notifyReadyCookable(Cookable cookable) {
    inPreparation.remove(cookable);
    cookable.associatedOrderLine().markReady();
    // TODO send Ready notif
  }

  // TODO ICICIIC autre methodes de la kouizine
}
