package collection;

public interface BagAssertionRule<T> {

    /**
     * Executes a specific assertion logic against a given bag.
     * @param aBag implementation under test
     * @param expectedState A boolean flag indicating whether what state we expect to see
     */
    void verify(BagInterface<T> aBag, boolean expectedState);

}
