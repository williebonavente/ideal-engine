package dictionary;

import java.util.List;

public class ArrayDictionarySearcher implements DictionarySearcher {

    private final List<WordEntry> dictionaryReference;

    /**
     * THE Bridge Constructor
     */
    public ArrayDictionarySearcher(List<WordEntry> sharedDictionary) {
        this.dictionaryReference = sharedDictionary;
    }

    @Override
    public String matchLookUp(String word) {
        // TODO: To be implemented
        return word + "nothing to return";
    }

    @Override
    public List<String> prefixSearch(String word) {
        // TODO: To be implemented
    }

    @Override
    public List<WordEntry> fullSearch() {
        // TODO: To be implemented
    }


}
