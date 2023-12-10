package ca.uqo.restoplex.data;

public record Cookable(
        long id,
        short quantity,
        OrderableDescription.ItemDescription description,
        Order.OrderLine associatedOrderLine
) {}
