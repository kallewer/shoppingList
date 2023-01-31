import java.util.*;
import java.util.function.Predicate;

/**
 * Shopping List with ArrayList data structure and basic operations.
 *
 * @author Karl Werner
 * @version 1.0
 */
public class ShoppingList {
    private final List<ShoppingListEntry> shoppingList = new ArrayList<>();

    /**
     * Constructs shoppingList and adds given entries.
     */
    public ShoppingList(ShoppingListEntry...shoppingListEntries) {
        this.add(shoppingListEntries);
    }

    /**
     * Constructs shoppingList with no entries.
     */
    public ShoppingList() {}

    /**
     * Adds all entries in parameter list to list.
     * If list contains entry with same name multiple times, amounts will be added up to a single entry.
     *
     * @param shoppingListEntries entries to be added
     */
    public void add(ShoppingListEntry...shoppingListEntries) {
        shoppingList.addAll(Arrays.asList(shoppingListEntries));
        //fold duplicates by amount
        for (int i = 0; i < shoppingList.size(); i++) {
            for (int j = 0; j < shoppingList.size(); j++) {
                if (i != j && shoppingList.get(i).getName().equalsIgnoreCase(shoppingList.get(j).getName())) {
                    shoppingList.get(i).increaseAmountBy(shoppingList.get(j).getAmount());
                    shoppingList.remove(j);
                    if (j < i) i--;
                    j--;
                }
            }
        }
        sortByCategory();
    }

    /**
     * Removes entries matching given names from list.
     *
     * @param names the names of entries to be removed
     */
    public void remove(String...names) {
        Arrays.stream(names).forEach(name -> shoppingList.remove(getByName(name)));
    }

    /**
     * Removes all bought items from list.
     *
     * @return the new size of the list
     */
    private int removeBought() {
        shoppingList.removeAll(shoppingList.stream().filter(ShoppingListEntry::isBought).toList());
        return shoppingList.size();
    }

    /**
     * Buys all items matching a name in the param list.
     *
     * @param names the names of entries to be bought
     * @return true if size decrement matches amount of given names, i.e. all entries could be found
     */
    public boolean buy(String...names) {
        int prev = shoppingList.size();
        shoppingList.stream().filter(e -> Arrays.stream(names).anyMatch(name -> e.getName().equalsIgnoreCase(name)))
                .forEach(ShoppingListEntry::buy);
        return prev - removeBought() == names.length;
    }

    public boolean buyAllExcept(String...names) {
        int prev = shoppingList.size();
        shoppingList.stream().filter(e -> Arrays.stream(names).noneMatch(name -> e.getName().equalsIgnoreCase(name)))
                .forEach(ShoppingListEntry::buy);
        return removeBought() == names.length;
    }

    /**
     * Buys all items and removes bought.
     *
     * @return true if list is empty, i.e. it worked.
     */
    public boolean buyAll() {
        shoppingList.forEach(ShoppingListEntry::buy);
        return removeBought() == 0;
    }

    public void sortByCategory() {
        shoppingList.sort(Comparator.comparingInt(o -> o.getFoodType().ordinal()));
    }

    /**
     * Accepts a string and looks for the list entry with given string as name.
     *
     * @param name the name to search for
     * @return the ShoppingListEntry with given String as name
     * @throws RuntimeException if no such entry found
     */
    public ShoppingListEntry getByName(String name) throws RuntimeException {
        return shoppingList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(RuntimeException::new);
    }

    /**
     * Builds a string representation of only entries matching a given predicate.
     *
     * @param predicate the predicate that entries have to match to be printed
     * @return the string representation of the sublist
     */
    public String printOnly(Predicate<ShoppingListEntry> predicate) {
        StringBuilder sb = new StringBuilder();
        shoppingList.stream()
                .filter(predicate)
                .forEach(e -> sb.append(e.print()));
        return sb.toString();
    }

    /** Builds a string representation of the whole shopping list with print method of each entry.
     *
     * @return Built string of whole list with one entry per line.
     */
    public String print() {
        StringBuilder sb = new StringBuilder();
        shoppingList.forEach(e -> sb.append(e.print()));
        return sb.toString();
    }
}
