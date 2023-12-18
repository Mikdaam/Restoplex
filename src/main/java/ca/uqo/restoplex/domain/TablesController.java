package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.domain.model.Table;
import java.util.HashMap;
import java.util.List;

public final class TablesController {
  private final HashMap<Long, Table> tables = new HashMap<>(); // TODO init avec toutes les tables de la BD

  public TablesController() {
	  createTables();
  }

  private void updateTableState(long tableId, Table.TABLE_STATE newState) {
    if(tableId <= 0) {
      throw new IllegalArgumentException();
    }

    tables.computeIfPresent(tableId,
            (__, oldTable) -> new Table(tableId, oldTable.capacity(), newState) // TODO update table state dans DB ?????
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

  //Cr�ation des tables
  public void createTables() {
    List<Table> tableList = List.of(
        new Table(1L, (short)8),
        new Table(2L, (short)14),
        new Table(3L, (short)8),
        new Table(4L, (short)8),
        new Table(5L, (short)8),
        new Table(6L, (short)8),
        new Table(7L, (short)14),
        new Table(8L, (short)8),
        new Table(9L, (short)18),
        new Table(10L, (short)6),
        new Table(11L, (short)6),
        new Table(12L, (short)18),
        new Table(13L, (short)18),
        new Table(14L, (short)6),
        new Table(15L, (short)6),
        new Table(16L, (short)8),
        new Table(17L, (short)4),
        new Table(18L, (short)6),
        new Table(19L, (short)8),
        new Table(20L, (short)8),
        new Table(21L, (short)8),
        new Table(22L, (short)14),
        new Table(23L, (short)8),
        new Table(24L, (short)8)
    );

    tableList.forEach(table -> this.tables.put(table.id(), table));
  }
}
