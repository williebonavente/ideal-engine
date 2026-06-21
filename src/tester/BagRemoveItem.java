package tester;

import collection.BagAssertionRule;
import collection.BagInterface;

public class BagRemoveItem<T> implements BagAssertionRule<T> {

    public BagRemoveItem() { }

    @Override
    public void verify(BagInterface<T> aBag, boolean expectedState) {
        T[] items = aBag.toArray();
        if (aBag.remove().equals(items.length - 1)) {
            throw new AssertionError(System.out.printf(
                    "FAILURE: in remove(): Expected %s but got %b", expectedState, aBag.remove()
            ));
        }
        System.out.printf("PASSED: removed an item matches an expectation (%b).%n", expectedState);
    }
}
