package ca.uqo.restoplex.utils;

import ca.uqo.restoplex.data.datasource.entity.FoodItem;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.Date;
import java.util.Random;

public class DatabaseSetup {

    private static final int NUM_OF_DATA_TO_GENERATE = 20;

    private static final String[] FOOD_NAMES = {"Burger", "Pizza", "Pasta", "Salad", "Steak", "Sushi", "Soup", "Sandwich", "Taco", "Fried Chicken", "Dessert", "Coffee", "Smoothie", "Juice", "Ice Cream"};
    private static final String[] CATEGORIES = {"Appetizer", "Main Course", "Dessert", "Beverage"};

    public static void setUp(ConnectionSource connectionSource) throws SQLException {
        // Create tables
        createTables(connectionSource);

        // Insert generated data
        insertGeneratedData(connectionSource);
    }

    private static void createTables(ConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, FoodItem.class);
        // Add other tables as needed
    }

    private static void insertGeneratedData(ConnectionSource connectionSource) throws SQLException {
        var foodItemDao = DaoManager.createDao(connectionSource, FoodItem.class);

        // Insert generated data for FoodItem
        for (int i = 0; i < NUM_OF_DATA_TO_GENERATE; i++) {
            var foodItem = generateRandomFoodItem();
            foodItemDao.create(foodItem);
        }
    }

    private static FoodItem generateRandomFoodItem() {
        FoodItem foodItem = new FoodItem();
        Random random = new Random();

        // Generate random values for the fields
        foodItem.setName(getRandomElement(FOOD_NAMES));
        foodItem.setDescription("Description for " + foodItem.getName());
        foodItem.setPrice(random.nextInt(2000) + 500); // Random price between 5 and 25
        foodItem.setCategory(getRandomElement(CATEGORIES));
        foodItem.setAddedAt(new Date()); // Current timestamp

        return foodItem;
    }

    private static <T> T getRandomElement(T[] array) {
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
}
