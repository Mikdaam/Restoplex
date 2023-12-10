package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.data.Cookable;
import ca.uqo.restoplex.data.Order;

import java.util.HashMap;
import java.util.Objects;

public final class KouizineController {
  private final Kouizine kouizine = new Kouizine();
  private final HashMap<Long, Cookable> cookables = new HashMap<>();

  KouizineController() {}

  private Cookable getCookableFromId(long cookableId) {
    if(cookableId <= 0) {
      throw new IllegalArgumentException();
    }

    return cookables.get(cookableId);
  }

  void submitNewOrder(Order order) {
    Objects.requireNonNull(order);
    order.orderLinesToCook().forEach(orderLine -> {
      kouizine.associateOrderLineWithNewCookables(orderLine);
      orderLine.associatedCookables().forEach(cookable -> cookables.putIfAbsent(cookable.id(), cookable));
    });
  }

  public void selectCookableToPrepare(long cookableId) {
    var cookable = getCookableFromId(cookableId);
    if(cookable == null) {
      throw new IllegalStateException();
    }

    kouizine.prepareCookable(cookable);
  }

  public void selectReadyCookable(long cookableId) {
    var cookable = getCookableFromId(cookableId);
    if(cookable == null) {
      throw new IllegalStateException();
    }

    kouizine.notifyReadyCookable(cookable);
  }

  // TODO autre methodes
}
