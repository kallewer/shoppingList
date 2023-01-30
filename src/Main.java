import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ShoppingList list = new ShoppingList();
        list.add(
                ShoppingListEntry.of(240, Unit.ml, "Weißer Balsamico", FoodType.OILS),
                ShoppingListEntry.of(70, Unit.g, "Gelbe Senfsaat", FoodType.SPICES),
                ShoppingListEntry.of(1, Unit.pack, "Zucker", FoodType.PANTRY),
                ShoppingListEntry.of(1, Unit.pack, "Senfblaetter", FoodType.SPICES),
                ShoppingListEntry.of(1, Unit.pack, "Senfsaat", FoodType.SPICES),
                ShoppingListEntry.of(1, Unit.pack, "Piment", FoodType.SPICES),
                ShoppingListEntry.of(1, Unit.pack, "Weißer Pfeffer", FoodType.SPICES),
                ShoppingListEntry.of(1, Unit.pack, "Schwarzer Pfeffer", FoodType.SPICES),
                ShoppingListEntry.of(1, Unit.pack, "Koriandersaat", FoodType.SPICES),
                ShoppingListEntry.of(300, Unit.ml, "Weißwein", FoodType.BEVERAGES),
                ShoppingListEntry.of(240, Unit.ml, "Weißer Balsamico", FoodType.OILS),
                ShoppingListEntry.of(200, Unit.g, "Silberzwiebeln", FoodType.VEGETABLES)
        );
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("shoppingList.txt"));
            writer.write(list.print());
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}