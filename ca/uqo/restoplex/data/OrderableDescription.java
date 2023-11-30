package ca.uqo.restoplex.data;

sealed interface OrderableDescription {
  long id();
  String name();
  boolean available();
  double price();

  record ItemDescription(long id, String name, boolean available, double price) implements OrderableDescription {}
  record MealDescription(long id, String name, boolean available, double price) implements OrderableDescription {}
}
