package ca.uqo.restoplex.domain;
import ca.uqo.restoplex.data.Table;
import java.util.HashMap;
import java.util.List;

public final class TablesController {
  private final HashMap<Long, Table> tables = new HashMap<>(); // TODO init avec toutes les tables de la BD

  TablesController() {
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
    Table table1 = new Table(1L, (short)8);
    Table table2 = new Table(2L, (short)14);
    Table table3 = new Table(3L, (short)8);
    Table table4 = new Table(4L, (short)8);
    Table table5 = new Table(5L, (short)8);
    Table table6 = new Table(6L, (short)8);
    Table table7 = new Table(7L, (short)14);
    Table table8 = new Table(8L, (short)8);
    Table table9 = new Table(9L, (short)18);
    
    Table table10 = new Table(10L, (short)6);
    Table table11 = new Table(11L, (short)6);
    Table table12 = new Table(12L, (short)18);
    Table table13 = new Table(13L, (short)18);
    Table table14 = new Table(14L, (short)6);
    Table table15 = new Table(15L, (short)6);
    Table table16 = new Table(16L, (short)8);
    Table table17 = new Table(17L, (short)4);
    Table table18 = new Table(18L, (short)6);
    
    Table table19 = new Table(19L, (short)8);
    Table table20 = new Table(20L, (short)8);
    Table table21 = new Table(21L, (short)8);
    Table table22 = new Table(22L, (short)14);
    Table table23 = new Table(23L, (short)8);
    Table table24 = new Table(24L, (short)8);
    
    

    // Ajouter les tables � la collection
    tables.put(table1.id(), table1);
    tables.put(table2.id(), table2);
    tables.put(table3.id(), table3);
    tables.put(table4.id(), table4);
    tables.put(table5.id(), table5);
    tables.put(table6.id(), table6);
    tables.put(table7.id(), table7);
    tables.put(table8.id(), table8);
    tables.put(table9.id(), table9);
    tables.put(table10.id(), table10);
    tables.put(table11.id(), table11);
    tables.put(table12.id(), table12);
    tables.put(table13.id(), table13);
    tables.put(table14.id(), table14);
    tables.put(table15.id(), table15);
    tables.put(table16.id(), table16);
    tables.put(table17.id(), table17);
    tables.put(table18.id(), table18);
    tables.put(table19.id(), table19);
    tables.put(table20.id(), table20);
    tables.put(table21.id(), table21);
    tables.put(table22.id(), table22);
    tables.put(table23.id(), table23);
    tables.put(table24.id(), table24);
  }
}
