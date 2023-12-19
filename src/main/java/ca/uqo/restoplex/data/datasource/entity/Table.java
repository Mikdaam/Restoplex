package ca.uqo.restoplex.data.datasource.entity;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "tables")
public class Table {
	@DatabaseField(generatedId = true)
	private long tableId;

	@DatabaseField
	private int capacity;

	public Table() {}

	public long getTableId() {
		return tableId;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
