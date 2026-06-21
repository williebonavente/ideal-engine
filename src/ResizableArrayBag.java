import collection.BagInterface;

import java.util.Arrays;

/**
 * A class of bags whose entries are stored in a fixed-size array.
 *
 */

public class ResizableArrayBag<T> implements BagInterface<T>  {

    private T[] bag;
    private static final int DEFAULT_CAPACITY = 1000;
    private int numberOfEntries;

    // Creates an empty bag whose initial capacity is 25.
    // Default Constructor
    public ResizableArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given initial capacity.
     *
     * @param capacity the integer capacity desired.
     */
    public ResizableArrayBag(int capacity) {
        numberOfEntries = 0;
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[]) new Object[capacity];
        bag = tempBag;
    }

    /**
     *
     * Adds a new entry to this bag.
     * @param newEntry the object to be added as a new entry
     * @return true if the addition is successful, or false if not
     */
    public boolean add(T newEntry) {
        ensureCapacity();
        bag[numberOfEntries] = newEntry;
        numberOfEntries++;
        return true;
    }

    /**
     * Doubles the size of hte array bag if it is full.
     */
    private void ensureCapacity() {
        if (numberOfEntries == bag.length) {
            int newLength = 2 * bag.length;
            // Safety guard against the 0 initialization
            if (newLength == 0) newLength = DEFAULT_CAPACITY;
            bag = Arrays.copyOf(bag, newLength);
        }
    }

    /**
     * Shrink the size of the bag after it hits the threshold of less than 25% of the allocated array.
     */
    private void shrinkCapacity() {
        // safeguard against the smaller initial capacity
        if (numberOfEntries > 0 && numberOfEntries <= bag.length / 4 && bag.length > DEFAULT_CAPACITY) {
            int newLength = bag.length / 2;
            bag = Arrays.copyOf(bag, newLength);
        }
    }
    /**
     * Sees whether this bag is full.
     * @return true if the bag is full, or false if not
    */
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    /**
     * Sees whether this bag is empty.
     * @return true if the bag is empty, or false if not
     */
    public boolean isEmpty() { return numberOfEntries == 0; }

    /**
     * Retrieves all entries that are in this bag.
     * @return a newly allocated array of all elements in the bag
     */
    public T[] toArray() {
        // the case is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // unchecked cast
        System.arraycopy(bag, 0, result, 0, numberOfEntries);
        return result;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return either the removed entry, if the removal successful,
     * or null otherwise.
     */
    public T remove() {
        return removeEntry(numberOfEntries - 1);
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     * @param anEntry the entry to be removed
     * @return true if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

    /**
     * Removes and returns the entry at a given index within the array bag.
     * If no such entry exists, returns null.
     */
    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex]; // entry to remove
            numberOfEntries--;
            bag[givenIndex] = bag[numberOfEntries]; // replace entry with last entry
            bag[numberOfEntries] = null; // remove last entry

            // Check if we should scale DOWN after a successful deletion
            shrinkCapacity();
        }
        return result;
    }

    /**
     * Locates a given entry within the array bag.
     * Returns the index of the entry, if located, or -1 otherwise.
     */
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean stillLooking = true ;

        for (int index = 0; stillLooking && (index < numberOfEntries); index++) {
            if (anEntry.equals(bag[index])) {
                stillLooking = false;
                where = index;
            }
        }
        // Assertion: If where > -1, anEntry is in the array bag, and it
        // equals bag[where]; otherwise, anEntry is not in the array
        return where;
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry the entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    public int getFrequencyOf(T anEntry) {
       int counter = 0;
       for (int index = 0; index < numberOfEntries; index++) {
           if (anEntry.equals(bag[index])) {
               counter++;
           }
       }
       return counter;
    }

    /**
     * Test whether this bag contains a given entry
     * @param anEntry the entry to locate
     * @return true if the bag contains anEntry, or false otherwise
     */
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }

    /**
     * Remove all entries from this bag.
     */
    public void clear() {
        while (!isEmpty()) { remove(); }
    }

    /**
     * Gets the current number of entries in the bag.
     * @return the integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }
}
