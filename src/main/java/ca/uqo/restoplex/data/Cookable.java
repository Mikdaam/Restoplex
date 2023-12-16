package ca.uqo.restoplex.data;

public record Cookable(
        short quantity,
        OrderableDescription.ItemDescription description,
        Order.OrderLine associatedOrderLine
) {
  @Override
  public String toString() {
    var description = this.description;
    return description.data()
            + "\t|\tQuantity : " + quantity
            + "\nComposition : " + description.composition();
  }
}
