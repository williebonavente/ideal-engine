package dictionary;

public interface DictionaryCRUD {
    /**
     * Add word in the dictionary
     * @param word to be added in the dictionary
     * @param definition to be added in the dictionary
     * @return true if successfully added otherwise false
     */
    public boolean addWord(String word, String definition);

    /**
     * Remove existing word in the dictionary.
     * @param word to be removed
     * @return true if successfully removed otherwise false
     */
    public boolean removeWord(String word);

    /**
     * Update existing definition of the word in the dictionary.
     * @param word to be updated in the dictionary
     * @param definition to be updated in the dictionary
     * @return true if the word definition is successfully updated.
     */
    public boolean updateWord(String word, String definition);

}