package ca.uqo.restoplex.data;

import java.util.List;
import java.util.Objects;

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
    public boolean equals(Object o) {
      return o instanceof OrderableDescriptionData data
              && data.id == id
              && data.name.equals(name)
              && data.price == price
              && data.available == available;
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
