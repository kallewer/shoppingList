import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Objects represent a list entry with amount, unit, name and food type attributes.
 *
 * @author Karl Werner
 * @version 1.0
 */
public class ShoppingListEntry {
    private double amount;

    private Unit unit;
    private String name;
    private final FoodType foodType;
    private boolean bought = false;

    /**
     * Constructs a list entry, given an amount, a name and a food type, no unit.
     *
     * @param amount the amount of the product
     * @param name the name of the product
     * @param foodType the food type of the product
     */
    public ShoppingListEntry(double amount, String name, FoodType foodType) {
        this.amount = amount;
        this.name = name;
        this.foodType = foodType;
    }

    /**
     * Constructs a list entry, given an amount, a unit, a name and a food type.
     *
     * @param amount the amount of the product
     * @param unit the unit, the amount represents
     * @param name the name of the product
     * @param foodType the food type of the product
     */
    public ShoppingListEntry(double amount, Unit unit, String name, FoodType foodType) {
        this.amount = amount;
        this.unit = unit;
        this.name = name;
        this.foodType = foodType;
    }

    /**
     * Gets amount of list entry.
     *
     * @return the amount as a double
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets Unit of list entry.
     *
     * @return the unit
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Gets name of list entry.
     *
     * @return the name as a String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets food type of list entry.
     *
     * @return the food type
     */
    public FoodType getFoodType() {
        return foodType;
    }

    /**
     * Increases amount by a given increment.
     *
     * @param increment the increment
     */
    public void increaseAmountBy(double increment) {
        amount += increment;
    }

    /**
     * Sets unit to given unit.
     *
     * @param unit the new unit
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Changes name to given name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns boolean value representing whether item has been bought.
     *
     * @return true if bought, false otherwise.
     */
    public boolean isBought() {
        return bought;
    }

    /**
     * Creates a string representation of the entry containing relevant attributes.
     *
     * @return the string representation
     */
    public String print() {
        return unit == null ?
                amount + " " + name + " (" + foodType.name().toLowerCase() + ")\n" :
                amount + " " + unit.name() + " " + name + " (" + foodType.name().toLowerCase() + ")\n";
    }

    /**
     * Sets bought to true, representing the act of buying an item.
     *
     * @throws RuntimeException if item already bought
     */
    public void buy() throws RuntimeException {
        if (isBought()) throw new RuntimeException("Item already bought!");
        else bought = true;
    }

    /**
     * Class method to quickly create a new list entry with given parameters as attributes, including unit.
     */
    @Contract(value = "_, _, _, _ -> new", pure = true)
    public static @NotNull ShoppingListEntry of(double amount, Unit unit, String name, FoodType foodType) {
        return new ShoppingListEntry(amount, unit, name, foodType);
    }

    /**
     * Class method to quickly create a new list entry with given parameters as attributes, without unit.
     */
    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull ShoppingListEntry of(double amount, String name, FoodType foodType) {
        return new ShoppingListEntry(amount, name, foodType);
    }
}
