package dictionary;

import java.util.List;

public interface DictionarySearcher {
    /**
     * Searches for a word and returns its exact description
     * @param word is the word to be searched with.
     * @return the exact definition of the word.
     */
    String matchLookUp(String word);

    /**
     * Shows a list of a word corresponding to the word that the user is typing.
     * @param word is associated with the terms that must show to the screen.
     * render autocomplete suggestions on the screen as separate components..
     */
    List<String> prefixSearch(String word);

    /**
     * Method that shows all the words in the dictionary.
     * @return all the words in the dictionary.
     */
    List<WordEntry> fullSearch();
}


