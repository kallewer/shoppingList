public class ShoppingListEntry {
    private int amount;

    private Unit unit;
    private String name;
    private final FoodType category;
    private boolean bought = false;

    public ShoppingListEntry(int amount, String name, FoodType category) {
        this.amount = amount;
        this.name = name;
        this.category = category;
    }

    public ShoppingListEntry(int amount, Unit unit, String name, FoodType category) {
        this.amount = amount;
        this.unit = unit;
        this.name = name;
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }

    public FoodType getCategory() {
        return category;
    }

    public void increaseAmountBy(int increment) {
        amount += increment;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBought() {
        return bought;
    }

    public String print() {
        return unit == null ?
                amount + " " + name + ", in " + category.name().toLowerCase() + ".\n" :
                amount + " " + unit.name() + " " + name + ", in " + category.name().toLowerCase() + ".\n";
    }

    public void buy() throws RuntimeException {
        if (isBought()) throw new RuntimeException("Article has already been bought!");
        else bought = true;
    }
}
