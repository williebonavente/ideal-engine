package dictionary;

public class WordEntry implements Comparable<WordEntry> {
    private final String word;
    private String definition;

    public WordEntry(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() { return word; }
    public String getDefinition() { return definition; }
    public void setNewDefinition(String updatedDefinition) { this.definition = updatedDefinition; }

    /**
     * Binary Search: Sorting WordEntry objects.
     */
    @Override
    public int compareTo(WordEntry other) {
        return this.word.compareToIgnoreCase(other.getWord());
    }
}
