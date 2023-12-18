package ca.uqo.restoplex.domain.model;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Order {
  public final class OrderLine { // TODO remplacer par DTO OrderLine
    private enum ORDER_LINE_STATE {TO_COOK, IN_PREPARATION, TO_DELIVER, DELIVERED}

    private final short quantity;
    private final OrderableDescription orderableDescription;
    private final HashSet<Cookable> associatedCookables = new HashSet<>();

    private ORDER_LINE_STATE currentState = ORDER_LINE_STATE.TO_COOK;

    private OrderLine(short quantity, OrderableDescription orderableDescription) {
      this.quantity = quantity;
      this.orderableDescription = orderableDescription;
    }

    public void associateWithCookable(Cookable cookable) {
      Objects.requireNonNull(cookable);
      associatedCookables.add(cookable);
    }

    public void markInPreparation() {
      if(! currentState.equals(ORDER_LINE_STATE.TO_COOK)) {
        throw new IllegalStateException();
      }

      currentState = ORDER_LINE_STATE.IN_PREPARATION;
      Order.this.toCookContent.remove(this);
    }

    public void markReady() {
      if(! currentState.equals(ORDER_LINE_STATE.IN_PREPARATION)) {
        throw new IllegalStateException();
      }

      currentState = ORDER_LINE_STATE.TO_DELIVER;
    }

    public void markDelivered() {
      if(! currentState.equals(ORDER_LINE_STATE.TO_DELIVER)) {
        throw new IllegalStateException();
      }

      currentState = ORDER_LINE_STATE.DELIVERED;
    }

    public Table associatedTable() {
      return Order.this.table;
    }

    public short quantity() {
      return quantity;
    }

    public OrderableDescription orderableDescription() {
      return orderableDescription;
    }

    public Set<Cookable> associatedCookables() {
      return Set.copyOf(associatedCookables);
    }
  }

  private static final short MAX_QUANTITY = 30;
  private final HashSet<OrderLine> toCookContent = new HashSet<>();
  private final ArrayList<OrderLine> orderContent = new ArrayList<>();
  private final Table table;

  public Order(Table table) {
    this.table = table;
  }

  public void addNewOrderable(OrderableDescription description, short quantity) {
    Objects.requireNonNull(description);
    Objects.checkIndex(quantity, MAX_QUANTITY);
    var orderLine = new OrderLine(quantity, description);
    toCookContent.add(orderLine);
    orderContent.add(orderLine);
  }

  public List<OrderLine> orderLinesToCook() {
    return List.copyOf(toCookContent);
  }
}
