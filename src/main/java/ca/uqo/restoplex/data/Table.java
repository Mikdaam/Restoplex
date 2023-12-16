package src.main.java.ca.uqo.restoplex.data;

public record Table(long id, short capacity, TABLE_STATE state) {
  public enum TABLE_STATE {FREE, ORDERING, OCCUPIED}

  public Table(long id, short capacity) {
    this(id, capacity, TABLE_STATE.FREE);
  }
}
