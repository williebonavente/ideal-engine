package tester;

import collection.BagInterface;
import collection.BagAssertionRule;
import java.util.List;
import java.util.ArrayList;

public class TestSuiteLauncher<T> {
    private final BagInterface<T> bagUnderTest;
    private final List<BagAssertionRule<T>> rulesPipelines = new ArrayList<>();

    public TestSuiteLauncher(BagInterface<T> bagUnderTest) {
        this.bagUnderTest = bagUnderTest;
    }

    // Add a single-responsibility rule to our automation pipeline
    public TestSuiteLauncher<T> registerRule(BagAssertionRule<T> rule) {
        rulesPipelines.add(rule);
        return this;
    }

    // Fires all the validation logic sequentially
    public void executePipeline(boolean expectedStateOutcome) {
        System.out.println("EXECUTING TESTING PIPELINE");
        for (BagAssertionRule<T> rule : rulesPipelines) {
            try {
                rule.verify(bagUnderTest, expectedStateOutcome);
            } catch (AssertionError e ) {
                System.err.println(e.getMessage());
            }
        }
    }

}
