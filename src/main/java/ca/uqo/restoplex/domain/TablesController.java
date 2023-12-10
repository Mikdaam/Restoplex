package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.data.Table;
import java.util.HashMap;
import java.util.List;

public final class TablesController {
  private final HashMap<Long, Table> tables = new HashMap<>(); // TODO init avec toutes les tables de la BD

  TablesController() {}

  private void updateTableState(long tableId, Table.TABLE_STATE newState) {
    if(tableId <= 0) {
      throw new IllegalArgumentException();
    }

    tables.computeIfPresent(tableId,
            (__, oldTable) -> new Table(tableId, oldTable.capacity(), newState)
    );
  }

  void takeOrderForTable(long tableId) {
    updateTableState(tableId, Table.TABLE_STATE.OCCUPIED);
  }

  void freeTable(long tableId) {
    updateTableState(tableId, Table.TABLE_STATE.FREE);
  }

  public void lockTable(long tableId) {
    updateTableState(tableId, Table.TABLE_STATE.ORDERING);
  }

  public List<Table> tables() {
    return List.copyOf(tables.values());
  }
}
