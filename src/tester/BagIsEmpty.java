package tester;

import collection.BagAssertionRule;
import collection.BagInterface;

public class BagIsEmpty<T> implements BagAssertionRule<T> {

    public BagIsEmpty() { }

    /**
     * Method that returns true when the bag is empty otherwise false.
     * @return true or false.
     */
    private boolean isBagEmpty(BagInterface<T> aBag) {
        return aBag.isEmpty();
    }

    @Override
    public void verify(BagInterface<T> aBag, boolean expectedEmpty) {
        if (!isBagEmpty(aBag) == expectedEmpty) {
            throw new AssertionError(String.format("Failure in isEmpty(): Expected empty=%b, but got %b",
                    expectedEmpty, aBag.isEmpty()
            ));
        }
        System.out.printf("PASSED: Bag emptiness matches expectation (%b).%n", expectedEmpty);
    }
}
