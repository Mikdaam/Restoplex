package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.data.Command;
import ca.uqo.restoplex.data.Cookable;
import java.util.ArrayDeque;

final class Kouizine {
  private final ArrayDeque<Cookable> toCookQueue = new ArrayDeque<>();
  private final ArrayDeque<Cookable> inPreparationQueue = new ArrayDeque<>();

  void sendNewCommand(Command command) {
    // .....
    // command -> crer cookables + ajoute dans toCook
  }
}
