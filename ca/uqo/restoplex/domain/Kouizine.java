package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.data.Order;
import ca.uqo.restoplex.data.Cookable;
import java.util.LinkedHashSet;
import java.util.Objects;

final class Kouizine {
  private final LinkedHashSet<Cookable> toCookQueue = new LinkedHashSet<>();
  private final LinkedHashSet<Cookable> inPreparationQueue = new LinkedHashSet<>();

  public void submitNewOrder(Order order) {
    Objects.requireNonNull(order);
    order.orderLinesToCook()
            .forEach(orderLine -> toCookQueue.addAll(orderLine.associatedCookables()));
  }

  public void prepareCookable(Cookable cookable) {
    Objects.requireNonNull(cookable);
    toCookQueue.remove(cookable);
    cookable.associatedOrder().prepareOrderLine(cookable);
    inPreparationQueue.addLast(cookable);
  }

  public void notifyReadyCookable(Cookable cookable) {
    Objects.requireNonNull(cookable);
    inPreparationQueue.remove(cookable);
    cookable.associatedOrder().markReadyOrderLine(cookable);
    // TODO send Ready notif
  }

  // TODO ICICIIC autre methodes de la kouizine
}
