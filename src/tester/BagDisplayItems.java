    package tester;

    import collection.BagInterface;
    import java.util.function.Predicate;

    public class BagDisplayItems<T> {
        private final BagInterface<T> aBag;
        private Predicate<Object> filterCondition = item -> true; // Default pass everything
        private int maxDisplayLimit = Integer.MAX_VALUE;

        public BagDisplayItems(BagInterface<T> aBag) {
           this.aBag = aBag;
        }

        // Builder method for a filter rule
        public BagDisplayItems<T> filterBy(Predicate<Object> condition) {
            this.filterCondition = condition;
            return this;
        }

        // Builder method for a limit rule
        public BagDisplayItems<T> limitTo(int maxEntries) {
            this.maxDisplayLimit = maxEntries;
            return this;
        }

        public void render() {
            System.out.println("--- Filtered Bag View ---");
            Object[] items = aBag.toArray();
            int printedCount = 0;

            for (Object item : items) {
                if (printedCount >= maxDisplayLimit) break;

                // Check if the item matches our superhero filter predicate rule
                if (filterCondition.test(item)) {
                    System.out.println(item + " ");
                    printedCount++;
                }
            }
            System.out.println();
        }

        public void displayAll() {
            System.out.println("Displaying all Bag Items");
            Object[] items = aBag.toArray();
            for (Object item : items ) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
