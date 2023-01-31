import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        ShoppingList list = new ShoppingList();
        list.add(
                //add entries here, using ShoppingListEntry.of(...) method...
        );
        //opt. buy here...

        //repeat...

        //Do not change the following
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