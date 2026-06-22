package dictionary;

import java.util.List;
import java.util.Scanner;

/**
 * A front-end class that will display the menu.
 */
public class DictionaryDisplayerTerminal implements DictionaryDisplayerInterface {

    /**
     * Reference to the existing dictionary
     */
    private List<WordEntry> dictionaryReference;

    public DictionaryDisplayerTerminal(List<WordEntry> ref) {
        this.dictionaryReference = ref;
    }

    public static Scanner input = new Scanner(System.in);

    @Override
    public void displayTitleHeader(String title) {
        System.out.println("================================================================================");
        System.out.println(title);
        System.out.println("================================================================================");
    }

    @Override
    public void displayStatusHeader(int searchCounter, int physicalCapacity) {
        System.out.print("[Active Counter: "  + searchCounter + " Words" + " ] ");
        System.out.print("              ");
        /**
         * TODO: implement the percentage later in another version
         */
        System.out.println("[Physical Capacity: " + physicalCapacity + " ] ");
    }

    @Override
    public String captureTextInput(String promptMessage) {
        System.out.print(promptMessage);
        return input.nextLine();
    }


    @Override
    public CommandResponse captureUserChoice() {
        String userInput = input.nextLine().trim().toUpperCase();
        for (Commands command : Commands.values()) {
            if (command.getQuery().equals(userInput)) {
                return new CommandResponse(command, userInput);
            }
        }
        return new CommandResponse(Commands.INVALID, userInput);
    }


    @Override
    public void displayResultPane(List<String> results) {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("   RECENT SEARCH / AUTOCOMPLETE RESULTS:");

        if (results.isEmpty()) {
            System.out.println("[  No recent search or autocomplete records found. ]");
        } else {
            int i;
            for (i = 0; i < results.size(); i++) {
                System.out.println(" -> [" + (i + 1) + "] " + results);
            }
            System.out.println();
            System.out.println("(" + (i) + ") "+ " matching entries shifted into view from the sorted backend array.");
        }
    }


    @Override
    public void displayOperationalManual() {
        System.out.println("================================================================================");
        System.out.println("     ENGINE OPERATIONS MANUAL:");
        System.out.println("================================================================================");
        System.out.println("   [A] Add New Word Entry      (Triggers boundary check -> Inserts & Shifts Right)");
        System.out.println("   [U] Update Definition       (Triggers binary search  -> Overwrites value)");
        System.out.println("   [D] Deprecate/Delete Word   (Triggers binary search  -> Removes & Shifts Left)");
        System.out.println("   [T] Print Full Traversal    (Iterates from Index 0 to (numberOfEntries - 1))");
        System.out.println("   [M] Memory Diagnostics      (Exposes underlying physical array slots)");
        System.out.println("   [Q] Shutdown System");

        System.out.println();
        System.out.print("   Select Operation (A/U/D/T/M/Q): ");
    }
}
