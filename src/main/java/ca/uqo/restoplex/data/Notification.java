package src.main.java.ca.uqo.restoplex.data;

sealed interface Notification {
  Cookable dish();

  record ReadyDishNotification(Cookable dish) implements Notification {}
  record RefusedDishNotification(Cookable dish) implements Notification {}
}
