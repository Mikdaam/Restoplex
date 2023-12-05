package ca.uqo.restoplex.data;
import java.util.ArrayList;
import java.util.List;

public final class Command {
  private enum COMMAND_LINE_STATE {TO_COOK, COOKING, TO_DELIVER, DELIVERED}
  private record CommandLine(short quantity, COMMAND_LINE_STATE curentState, Orderable orderable) {}

  private final ArrayList<CommandLine> contentList = new ArrayList<>();
  private final Table table;

  private Command(Table table) {
    this.table = table;
  }

  public List<Cookable> extractCookables() {
    return List.of(); // TODO ICIICIC
  }
}
