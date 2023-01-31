Hello,

1. Use ShoppingListEntry.of(int amount, Unit unit, String name, FoodType category) method to add entries to your shopping list.
- Unit is optional
- List will automatically be sorted by category, resembling a super market as good as possible

2. Replace the example list entries in Main with your list.
- leave the print block as is

3. List will be printed in a text file in ShoppingList folder.

4. You can "buy" items, using buy(), buyAll(), or buyAllExcept()
- buy accepts a list of String names to be removed
- buyAll buys all
- buyAllExcept buys all except String names in param list
- each method removes bought items from list and returns true if each removal worked correctly, i.e. size
  of list decremented as expected
