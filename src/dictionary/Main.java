package dictionary;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<WordEntry> dictionary = new ArrayList<>();
        ArrayDictionaryCRUD dictionaryCRUD = new ArrayDictionaryCRUD(dictionary);
        ArrayDictionarySearcher dictionarySearcher = new ArrayDictionarySearcher(dictionary);

//        dictionaryCRUD.addWord("test", "ai generated nonsense");
//        dictionaryCRUD.addWord("to be removed object", "what a sensible thing to do");
//        dictionaryCRUD.addWord("apple", "a fruit");
//        dictionaryCRUD.addWord("banana", "monkey's favorite");
//        dictionaryCRUD.removeWord("to be removed object");
//        dictionaryCRUD.updateWord("test", "ai have some sense now");
        dictionaryCRUD.displayAllEntries();
    }


    /**
     *
     * ================================================================================
     * 📔 ARCHITECT DICTIONARY ENGINE v1.0 [ArrayList-Backed]
     * ================================================================================
     *  [Active Counter: 3 Words]              [Physical Capacity: 4 Slots (75% Full)]
     * ================================================================================
     *
     *  Search Word: [ app_______________________________________________________ ]
     *                🔍 [Run Exact Match Lookup]   ⚡ [Run Dynamic Prefix Autocomplete]
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
