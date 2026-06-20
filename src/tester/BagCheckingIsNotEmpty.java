package tester;

import collection.BagAssertionRule;
import collection.BagInterface;

public class BagCheckingIsNotEmpty<T> implements BagAssertionRule<T> {

    @Override
    public void verify(BagInterface<T> aBag, boolean expectedNotEmpty) {
        if (aBag.isEmpty() == expectedNotEmpty) {
            throw new AssertionError(String.format("FAILURE in isEmpty(): Expected empty=%b, but got %b",
                    expectedNotEmpty, aBag.isEmpty()
            ));
        }
        System.out.printf("PASSED: Bag is not empty matches expectation (%b).%n", expectedNotEmpty);
    }
}
