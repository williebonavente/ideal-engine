import collection.BagInterface;

/**
 * A test of the methods add, toArray, and isFull, as defined
 * in the first draft of the class ArrayBag.
*/

public class ArrayBagDemo1 {

    public static void main(String[] args) {
        // a bag that is not full
        BagInterface<String> aBag = new ArrayBag<String>();

        // tests on an empty bag
        testIsFull(aBag, false);

        // adding strings
        String[] contentsOfBAg1 = {"A", "A", "B", "A", "C", "A"};
        testAdd(aBag, contentsOfBAg1);
        testIsFull(aBag, false);

        // a bag that will be full
        aBag = new ArrayBag<String>(7);
        System.out.println("\nA new empty bag: ");

        // tests on an empty bag
        testIsFull(aBag, false);

        // adding strings
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D"};
        testAdd(aBag, contentsOfBag2);
        testIsFull(aBag, true);
        System.out.println("Length of the bag2: " + contentsOfBag2.length);

    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        System.out.println("Adding to the bag: ");
        for (String s : content) {
            aBag.add(s);
            System.out.print(s + " ");
        }
        System.out.println();
        displayBag(aBag);
    }

    private static void testIsFull(BagInterface<String> aBag, boolean correctResult) {
        System.out.print("\nTesting the method isFull with ");
        if (correctResult) System.out.println("a full bag: ");
        else System.out.println("a bag that is not full: ");

        System.out.println("isFull finds the bag ");

        if (correctResult && aBag.isFull()) System.out.println("full: OK.");
        else if (correctResult) System.out.println("not full, but it is full: ERROR.");
        else if (aBag.isFull()) System.out.println("full, but it is not full: ERROR");
        else System.out.println("not full: OK.");
    }

    private static void displayBag(BagInterface<String> aBag) {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++) {
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();
    }
}