import java.util.*;
import java.util.function.Predicate;

public class ShoppingList {
    private final List<ShoppingListEntry> shoppingList = new ArrayList<>();

    public ShoppingList(ShoppingListEntry...shoppingListEntries) {
        shoppingList.addAll(Arrays.asList(shoppingListEntries));
    }

    public ShoppingList() {}

    public void add(ShoppingListEntry...shoppingListEntries) {
        Arrays.stream(shoppingListEntries)
                .filter(e -> shoppingList.stream().anyMatch(entry -> e.getName().equalsIgnoreCase(entry.getName())))
                .forEach(
                        e -> getByName(e.getName()).increaseAmountBy(e.getAmount())
                );
        shoppingList.addAll(Arrays.stream(shoppingListEntries)
                .filter(e -> shoppingList.stream().noneMatch(entry -> e.getName().equalsIgnoreCase(entry.getName())))
                .toList());
        sortByCategory();
    }

    public void remove(String...names) {
        shoppingList.removeAll(
                shoppingList.stream()
                        .filter(e -> Arrays.stream(names).anyMatch(name -> name.equalsIgnoreCase(e.getName())))
                        .toList());
    }

    public void sortByCategory() {
        shoppingList.sort(Comparator.comparingInt(o -> o.getCategory().ordinal()));
    }

    public ShoppingListEntry getByName(String name) throws RuntimeException {
        return shoppingList.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .findFirst().orElseThrow(RuntimeException::new);
    }

    public String printOnly(Predicate<ShoppingListEntry> predicate) {
        StringBuilder sb = new StringBuilder();
        shoppingList.stream()
                .filter(predicate)
                .forEach(e -> sb.append(e.print()));
        return sb.toString();
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        shoppingList.forEach(e -> sb.append(e.print()));
        return sb.toString();
    }
}
