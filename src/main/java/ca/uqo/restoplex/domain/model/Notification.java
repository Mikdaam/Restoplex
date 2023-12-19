package ca.uqo.restoplex.domain.model;

sealed interface Notification {
  Cookable dish();

  record ReadyDishNotification(Cookable dish) implements Notification {}
  record RefusedDishNotification(Cookable dish) implements Notification {}
}
