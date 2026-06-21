package tester;

import collection.BagAssertionRule;
import collection.BagInterface;

public class BagIsContains<T> implements BagAssertionRule<T> {
    private final T addEntry;

    /**
     * Passing the item through constructor that is to be searched in the bag.
     * @param addEntry is the item to be searched in the bag.
     */
    public BagIsContains(T addEntry) {
        this.addEntry = addEntry;
    }

    /**
     * Verify that method contains work as expected
     * @param aBag implementation under test
     * @param expectedOutput A boolean flag indicating whether what state we expect to see
     */
    @Override
    public void verify(BagInterface<T> aBag, boolean expectedOutput) {
        if (!aBag.contains(addEntry) && expectedOutput) {
            throw new AssertionError(
                    (System.out.printf(
                            "Failure contains(): Expected %s but got %b",expectedOutput, aBag.contains(addEntry)
                    ))
            );
        }
        System.out.printf("PASSED: Bag contains an item that matches the expectation (%b).%n", expectedOutput);
    }
}
