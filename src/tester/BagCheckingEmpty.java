package tester;

import collection.BagAssertionRule;
import collection.BagInterface;

public class BagCheckingEmpty<T> implements BagAssertionRule<T> {

    @Override
    public void verify(BagInterface<T> aBag, boolean expectedEmpty) {
        if (aBag.isEmpty() != expectedEmpty) {
            throw new AssertionError(String.format("Failure in isEmpty(): Expected empty=%b, but got %b",
                    expectedEmpty, aBag.isEmpty()
            ));
        }
        System.out.printf("PASSED: Bag emptiness matches expectation (%b).%n", expectedEmpty);
    }
}
