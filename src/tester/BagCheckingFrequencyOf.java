package tester;

import collection.BagInterface;
import collection.BagAssertionRule;

public class BagCheckingFrequencyOf<T> implements BagAssertionRule<T> {
    private final T targetEntry;

    // We pass the item we want track through the constructor
    public BagCheckingFrequencyOf(T targetEntry) {
        this.targetEntry = targetEntry;
    }

    @Override
    public void verify(BagInterface<T> aBag, boolean expectedToExist) {
        int frequencyOf = aBag.getFrequencyOf(targetEntry);
        boolean exists = frequencyOf > 0;

        if (exists != expectedToExist) {
            throw new AssertionError(
                    String.format(
                            "Failure in getFrequencyOf(): Expected '%s' to exist=%b but count was %d",
                            targetEntry, expectedToExist, frequencyOf));
        }
        System.out.printf("PASSED: Entry '%s' frequency state is safe (Count: %d).%n", targetEntry, frequencyOf);
    }
}
