package src.main.java.ca.uqo.restoplex.data;

import java.util.List;

public sealed interface OrderableDescription {
  final class OrderableDescriptionData { // TODO A REMPLACER PAR LE DTO OrderableDescriptionData
    private final long id;
    private final String name;
    private final double price;
    private boolean available;

    public OrderableDescriptionData(long id, String name, double price) {
      this.id = id;
      this.name = name;
      this.price = price;
    }

    public void hide() {
      available = false;
    }
    
    public void reveal() {
      available = true;
    }

    @Override
    public String toString() {
      return name;
    }
  }

  enum ITEM_CATEGORY {STARTER, DISH, DESSERT, DRINK}

  OrderableDescriptionData data();

  record ItemDescription(OrderableDescriptionData data, ITEM_CATEGORY category, String composition) implements OrderableDescription {} // TODO illustration

  record MealDescription(OrderableDescriptionData data, List<ItemDescription> items) implements OrderableDescription {}
}
