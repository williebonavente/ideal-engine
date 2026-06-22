package dictionary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayDictionarySearcher implements DictionarySearcher {

    private final List<WordEntry> dictionaryReference;

    /**
     * THE Bridge Constructor
     */
    public ArrayDictionarySearcher(List<WordEntry> sharedDictionary) {
        this.dictionaryReference = sharedDictionary;
    }

    /**
     * Method that returns the  definition of the word being search.
     * @param word is the word to be searched with.
     * @return the word definition being queried.
     */
    @Override
    public String matchLookUp(String word) {
        // Normalize the input
        String normalizedWord = word.trim().toLowerCase();
        int targetIndex = getIndexOf(normalizedWord);
        if (targetIndex == -1) { return "Word does not exist."; }
        WordEntry fetchDefinition = dictionaryReference.get(targetIndex);
        return fetchDefinition.getDefinition();
    }

    private int getIndexOf(String targetWord) {
        WordEntry searchKey = new WordEntry(targetWord, "");
        int index = Collections.binarySearch(dictionaryReference, searchKey);
        return (index >= 0) ? index : -1;
    }

    @Override
    public List<String> prefixSearch(String word) {
        List<String> searchList = new ArrayList<>();
        String normalizedWord = word.trim().toLowerCase();
        WordEntry searchKey = new WordEntry(normalizedWord, "");
        if (normalizedWord.equalsIgnoreCase("")) { return searchList; }
        int tracker = Collections.binarySearch(dictionaryReference, searchKey);
        // Convert a negative insertion signal into real starting index
        if (tracker < 0) { tracker = -tracker - 1;}
        while (tracker < dictionaryReference.size() &&
                dictionaryReference.get(tracker).getWord().startsWith(normalizedWord)
        ) {
            String wordGetter = dictionaryReference.get(tracker).getWord();
            String definitionGetter = dictionaryReference.get(tracker).getDefinition();
            searchList.add(wordGetter + " : " + definitionGetter);
            tracker++;
        }
        return searchList;
    }

    /**
     *
     * @return all the list of the words in the dictionary.
     */
    @Override
    public List<WordEntry> fullSearch() {
        List<WordEntry> testing = new ArrayList<>();
        if (dictionaryReference.isEmpty()) {
           return testing;
        }
        // Defensive Bulk Copy
        testing.addAll(dictionaryReference);
        return testing;
    }
}
