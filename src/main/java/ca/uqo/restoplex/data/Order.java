package ca.uqo.restoplex.data;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class Order {
  public final class OrderLine { // TODO remplacer par DTO OrderLine
    private final short quantity;
    private final OrderableDescription orderableDescription;
    private final HashSet<Cookable> associatedCookables = new HashSet<>();

    private OrderLine(short quantity, OrderableDescription orderableDescription) {
      this.quantity = quantity;
      this.orderableDescription = orderableDescription;
    }

    public void associateWithCookable(Cookable cookable) {
      Objects.requireNonNull(cookable);
      associatedCookables.add(cookable);
    }

    public void markInPreparation() {
      // TODO ICICIIC changer order line state
    }

    public void markReady() {
      // TODO ICICIIC changer order line state
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
//  private final HashSet<OrderLine> inPreparationContent = new HashSet<>();
//  private final HashSet<OrderLine> toDeliverContent = new HashSet<>();
//  private final HashSet<OrderLine> deliveredContent = new HashSet<>();
  private final Table table;

  private Order(Table table) {
    this.table = table;
  }

//  private void prepareOrderLine(OrderLine orderLineToPrepare) {
//    toCookContent.remove(orderLineToPrepare);
//    inPreparationContent.add(orderLineToPrepare);
//  }
//
//  private void markReadyOrderLine(OrderLine readyOrderLine) {
//    inPreparationContent.remove(readyOrderLine);
//    toDeliverContent.add(readyOrderLine);
//  }

  public void addNewOrderable(OrderableDescription description, short quantity) {
    Objects.requireNonNull(description);
    Objects.checkIndex(quantity, MAX_QUANTITY);
    var orderLine = new OrderLine(quantity, description);
    toCookContent.add(orderLine);
  }

  public List<OrderLine> orderLinesToCook() {
    return List.copyOf(toCookContent); // TODO A MODIF PAS BON
  }
}
