package dictionary;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<WordEntry> dictionary = new ArrayList<>();
        ArrayDictionaryCRUD dictionaryCRUD = new ArrayDictionaryCRUD(dictionary);
        ArrayDictionarySearcher dictionarySearcher = new ArrayDictionarySearcher(dictionary);
        DictionaryDisplayerTerminal showDictionary = new DictionaryDisplayerTerminal(dictionary);
        DictionaryOperations operations = new DictionaryOperations(showDictionary, dictionaryCRUD);

        showDictionary.displayTitleHeader("ARCHITECT DICTIONARY ENGINE [ArrayList-Backed]");
        /**
         * TODO: To be implemented
         */

        dictionaryCRUD.addWord("test", "ai generated nonsense");
        dictionaryCRUD.addWord("to be removed object", "what a sensible thing to do");
        dictionaryCRUD.addWord("apple", "a fruit");
        dictionaryCRUD.addWord("banana", "monkey's favorite");
        dictionaryCRUD.removeWord("to be removed object");
        dictionaryCRUD.updateWord("test", "ai have some sense now");

//        showDictionary.displayStatusHeader(2, 1);
//
//        String userInput = showDictionary.captureTextInput("Search Word: ");
//        showDictionary.displayResultPane(dictionarySearcher.prefixSearch(userInput));

        showDictionary.displayOperationalManual();

        CommandResponse userQuery = showDictionary.captureUserChoice();
        String userInput = userQuery.rawInput();

        switch (userInput) {
            case "A":
                operations.wordAddition();
                System.out.println(clearScreen());
                System.out.println(dictionarySearcher.fullSearch());
                break;
            default:
                System.out.println();
                System.out.println("  " + userInput + " is invalid command.");
                break;
        }



    }
    public static boolean clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Executes the native Windows 'cls' command inside the active shell
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Executes the native Unix 'clear' command inside the active shell
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Fallback option if process invocation fails
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        return false;
    }

}

class DictionaryOperations {
    private final DictionaryDisplayerTerminal showDictionary;
    private final ArrayDictionaryCRUD dictionaryCRUD;

    public DictionaryOperations(DictionaryDisplayerTerminal sd,
                                ArrayDictionaryCRUD crud) {
        this.showDictionary = sd;
        this.dictionaryCRUD = crud;

    }
    public void wordAddition() {
        String addedWord = showDictionary.captureTextInput("Add a word: ");
        String addedDefinition = showDictionary.captureTextInput("Word definition: ");
        dictionaryCRUD.addWord(addedWord, addedDefinition);
        System.out.println(addedWord + " is added in to dictionary");
        Main.clearScreen();

    }

    public void wordUpdate() {
        String updatingWord = showDictionary.captureTextInput("Enter the word to be updated: ");
        String updatingDefinition = showDictionary.captureTextInput("Enter the updated definition: ");
        dictionaryCRUD.updateWord(updatingWord, updatingDefinition);
        System.out.println("The word " + updatingWord + " is updated");
    }

    public void wordDelete() {
        String deletingWord = showDictionary.captureTextInput("Enter the word to be deleted: ");
        dictionaryCRUD.removeWord(deletingWord);
        System.out.println(deletingWord + " is out in the dictionary!");
    }
}
