package ca.uqo.restoplex.data;

public sealed interface OrderableDescription {
  final class OrderableDescriptionData { // TODO A REMPLACER PAR LE DTO OrderableDescriptionData
    private final long id;
    private final String name;
    private final double price;
    private boolean available;

    private OrderableDescriptionData(long id, String name, double price) {
      this.id = id;
      this.name = name;
      this.price = price;
    }

    void hide() {
      available = false;
    }
    void reveal() {
      available = true;
    }
  }

  enum ITEM_CATEGORY {STARTER, DISH, DESSERT}

  OrderableDescriptionData data();

  record ItemDescription(OrderableDescriptionData data, ITEM_CATEGORY category, String composition) implements OrderableDescription {} // TODO illustration

  record MealDescription(OrderableDescriptionData data, ItemDescription...items) implements OrderableDescription {}
}

record Orderable(OrderableDescription description) {}
