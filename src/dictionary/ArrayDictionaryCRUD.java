package dictionary;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Collections;

public class ArrayDictionaryCRUD implements DictionaryCRUD {

    private List<WordEntry> dictionary;

    /**
     * Initializing empty dictionary
     * @param initDict the empty list client must pass
     */
    public ArrayDictionaryCRUD(List<WordEntry> initDict) {
        this.dictionary = initDict;
    }

    /**
     * Add new word in the dictionary.
     * @param word to be added in a dictionary.
     * @param definition to be added in a dictionary.
     * @return a new word in a dictionary.
     */
    @Override
    public boolean addWord(String word, String definition) {
        if (getIndexOf(word) != -1)
            return false; // Reject the duplication immediately

        // Wrap the data into single cohesive object
        String normalizedWord = word.trim().toLowerCase();
        WordEntry newWord = new WordEntry(word, definition);
        dictionary.add(newWord);
        Collections.sort(dictionary);
        return true;
    }

    /**
     * Getting the index of the target word
     * @param targetWord getting the index of.
     * @return index position of the word being searched, else, -1 that the word does not exist.
     */
    private int getIndexOf(String targetWord) {
        WordEntry searchKey = new WordEntry(targetWord, "");
        int index = Collections.binarySearch(dictionary, searchKey);
        // Make sure the word exists
        return (index >= 0) ? index : -1;
    }

    /**
     * Remove the word in the dictionary
     * @param word to be removed
     * @return true if successfully removed the word otherwise false
     */

    @Override
    public boolean removeWord(String word) {
        int index = getIndexOf(word);
        if (index == -1) { return false; }
        dictionary.remove(index);
        return true;
    }

    /**
     * Method that will let the user update the definition of the word.
     * @param word to be updated in the dictionary
     * @return true if the update is successful otherwise false
     */

    @Override
    public boolean updateWord(String word, String definition) {
        int targetIndex = getIndexOf(word);
        if (targetIndex == -1) return false;
        WordEntry targetWord = dictionary.get(targetIndex);
        targetWord.setNewDefinition(definition);
        return true;
    }

    public void displayAllEntries() {
        System.out.println("\n === CURRENT DICTIONARY ENTRIES ===");

        if (dictionary.isEmpty()) {
            System.out.println(" [The dictionary is currently empty]");
            System.out.println("==================\n");
            return;
        }

        for (int i = 0; i < dictionary.size(); i++) {
            // 1. Grab the custom capsule at the current index
            WordEntry entry = dictionary.get(i);
            System.out.printf("[%d] %s : %s%n", i,
                        entry.getWord().toUpperCase(), entry.getDefinition());
        }
        System.out.println("==========================\n");
    }
}
