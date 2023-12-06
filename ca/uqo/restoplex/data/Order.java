package ca.uqo.restoplex.data;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class Order {
  public record OrderLine(short quantity, Orderable orderable, Set<Cookable> associatedCookables) {}

  private static final short MAX_QUANTITY = 30;
  private final HashSet<OrderLine> toCookContent = new HashSet<>();
  private final HashSet<OrderLine> inPreparationContent = new HashSet<>();
  private final HashSet<OrderLine> toDeliverContent = new HashSet<>();
  private final HashSet<OrderLine> deliveredContent = new HashSet<>();
  private final Table table;

  private Order(Table table) {
    this.table = table;
  }

  private Set<Cookable> createCookables(short quantity, OrderableDescription description) {
    return switch (description) {
      case OrderableDescription.ItemDescription itemDescription -> Set.of(new Cookable(quantity, itemDescription, this));
      case OrderableDescription.MealDescription mealDescription -> Arrays.stream(mealDescription.items())
              .map(itemDescription -> new Cookable(quantity, itemDescription, this))
              .collect(Collectors.toUnmodifiableSet());
    };
  }

  private static OrderLine findOrderLineFromCookable(Cookable cookable, HashSet<OrderLine> contentToSearch) {
    return contentToSearch.stream()
            .filter(orderLine -> orderLine.associatedCookables.contains(cookable))
            .findFirst()
            .orElseThrow();
  }

  public void addNewOrderable(OrderableDescription description, short quantity) {
    Objects.requireNonNull(description);
    Objects.checkIndex(quantity, MAX_QUANTITY);
    var orderLine = new OrderLine(quantity, new Orderable(description), createCookables(quantity, description));
    toCookContent.add(orderLine);
  }

  public void prepareOrderLine(Cookable cookable) {
    Objects.requireNonNull(cookable);
    var orderLineToPrepare = findOrderLineFromCookable(cookable, toCookContent);
    toCookContent.remove(orderLineToPrepare);
    inPreparationContent.add(orderLineToPrepare);
  }

  public void markReadyOrderLine(Cookable cookable) {
    Objects.requireNonNull(cookable);
    var readyOrderLine = findOrderLineFromCookable(cookable, inPreparationContent);
    inPreparationContent.remove(readyOrderLine);
    toDeliverContent.add(readyOrderLine);
  }

  public List<OrderLine> orderLinesToCook() {
    return List.copyOf(toCookContent);
  }
}
