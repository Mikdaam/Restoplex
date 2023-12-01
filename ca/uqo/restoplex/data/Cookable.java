package ca.uqo.restoplex.data;

public record Cookable(short quantity, OrderableDescription.ItemDescription description, Table tableToDeliver) {}
