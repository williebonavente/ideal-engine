import collection.BagInterface;
import tester.*;

public class ArrayBagDemo2 {

    public static void main(String[] args) {
        /**
         * TODO: Methods to be tested
         *      boolean contains()
         *      void clear()
         *      T remove()
         *     boolean remove(T anEntry)
         *
         */
        BagInterface<String> dictionary = new ArrayBag<>(13);
        dictionary.add("B");
        dictionary.add("T");
        dictionary.add("#");
        dictionary.add("Testing");

        dictionary.remove();

        TestSuiteLauncher<String> launcher = new TestSuiteLauncher<>(dictionary);
        launcher
                .registerRule(new BagRemoveItem<>())
                .registerRule(new BagIsContains<>("Testing"))
                .registerRule(new BagIsEmpty<>());

        launcher.executePipeline(false);


        new BagRemoveItem<String>().verify(dictionary, true);
        new BagIsContains<>("Testing").verify(dictionary, false);

        dictionary.clear();

        new BagIsEmpty<String>().verify(dictionary, true);

    }
}
