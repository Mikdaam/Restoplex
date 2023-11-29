package ca.uqo.restoplex.data;

public sealed interface OrderableDescription {
  Long id(); // on garde Long car les ORM gèrent pas les types primitifs
  String name();
  boolean available();
  double price();

  record ItemDescription(Long id, String name, boolean available, double price) implements OrderableDescription {}
  record MealDescription(Long id, String name, boolean available, double price) implements OrderableDescription {}
}
