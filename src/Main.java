public class Main {
    public static void main(String[] args) {

        ShoppingList list = new ShoppingList();
        list.add(
                ShoppingListEntry.of(6, "Eier", FoodType.PANTRY),
                ShoppingListEntry.of(1, Unit.l, "Hafermilch", FoodType.DAIRY),
                ShoppingListEntry.of(500, Unit.g, "Mehl", FoodType.PANTRY),
                ShoppingListEntry.of(1, Unit.pack, "Bananen", FoodType.FRUITS),
                ShoppingListEntry.of(1, Unit.glass, "Apfelmus",FoodType.PANTRY)
        );
        System.out.println(list.printOnly(e -> e.getCategory() == FoodType.PANTRY));
        list.add(ShoppingListEntry.of(1000, Unit.g,"mehl", FoodType.PANTRY));
        System.out.println(list.print());
    }
}