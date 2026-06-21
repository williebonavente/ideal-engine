package tester;

import collection.BagAssertionRule;
import collection.BagInterface;

public class BagAddingNewItems<T> implements BagAssertionRule<T> {
    private final T addedEntry;

    /**
     *  Passing the added item through constructor in the bag.
     * @param addedEntry is the added item in the bag.
     */
    public BagAddingNewItems (T addedEntry) {
        this.addedEntry = addedEntry;
    }

    @Override
    public void verify(BagInterface<T> aBag, boolean expectedOutput) {
        if (!aBag.add(addedEntry)) {
            throw new AssertionError(System.out.printf(
                    "FAILURE: in add(): Expected %s but got %b", expectedOutput, aBag.add(addedEntry)
            ));
        }
        System.out.printf("PASSED: Bag added an item matches expectation (%b).%n", expectedOutput);
    }
}
