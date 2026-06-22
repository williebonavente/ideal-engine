package dictionary;

import java.util.List;

public interface DictionaryDisplayerInterface {
    /**
     * Display the title in the terminal.
     * @param title text that must display
     */
    void displayTitleHeader(String title);

    /**
     * Utility method that display the current physical and logical capacity.
     * @param searchCounter active counter on how many words the user searches on duration of the program.
     * @param physicalCapacity the program
     */
    void displayStatusHeader(int searchCounter, int physicalCapacity);

    /**
     * Method that will let user input String in the program.
     * @param results  that will be displayed in the result pane.
     */
    void displayResultPane(List<String> results);

    /**
     * Shows the list of the commands.
     */
    void displayOperationalManual();

    /**
     * Functions that will let user execute a commands throughout the program.
     * @return a corresponding command that will be used to execute certain commands.
     */
    CommandResponse captureUserChoice();

    /**
     * Captures text input when a user is adding, searching, or updating a word.
     */
    String captureTextInput(String promptMessage);

    /**
     *
     *
     * ================================================================================
     * 📔 ARCHITECT DICTIONARY ENGINE v1.0 [ArrayList-Backed]
     * ================================================================================
     *  [Active Counter: 3 Words]              [Physical Capacity: 4 Slots (75% Full)]
     * ================================================================================
     *
     *  Search Word: [ app_______________________________________________________ ]
     *                🔍 [Run Exact Match Lookup]   ⚡ [Run Dynamic Prefix Autocomplete] // TODO: To be implemented
     *
     * --------------------------------------------------------------------------------
     *  📂 RECENT SEARCH / AUTOCOMPLETE RESULTS:
     * --------------------------------------------------------------------------------
     *   -> [1] APPLE   : (n.) A round fruit with red, green, or yellow skin.
     *   -> [2] APPLIED : (adj.) Put to practical use as opposed to being theoretical.
     *
     *   (2 matching entries shifted into view from the sorted backend array)
     *
     * ================================================================================
     *  🛠️ ENGINE OPERATIONS MANUAL:
     * ================================================================================
     *   [A] Add New Word Entry      (Triggers boundary check -> Inserts & Shifts Right)
     *   [U] Update Definition       (Triggers binary search  -> Overwrites value)
     *   [D] Deprecate/Delete Word   (Triggers binary search  -> Removes & Shifts Left)
     *   [T] Print Full Traversal    (Iterates from Index 0 to (numberOfEntries - 1))
     *   [M] Memory Diagnostics      (Exposes underlying physical array slots)
     *   [Q] Shutdown System
     *
     *  Select Operation (A/U/D/T/M/Q): [ _ ]
     * ================================================================================
     */
}
