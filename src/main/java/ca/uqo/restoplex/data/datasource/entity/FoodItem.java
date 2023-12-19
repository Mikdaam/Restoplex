package ca.uqo.restoplex.data.datasource.entity;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

@DatabaseTable(tableName = "food_items")
public class FoodItem {

	@DatabaseField(generatedId = true)
	private long id;

	@DatabaseField
	private String name;

	@DatabaseField
	private String description;

	@DatabaseField
	private long price; // in cents

	@DatabaseField
	private String category;

	@DatabaseField(columnName = "added_at", dataType = DataType.DATE_STRING)
	private Date addedAt;

	// Required no-arg constructor for ORMLite
	public FoodItem() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getAddedAt() {
		return addedAt;
	}

	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}
}
