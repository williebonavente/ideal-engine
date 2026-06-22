package dictionary;

public enum Commands {
    ADD("A"),
    UPDATE("U"),
    SEARCH("S"),
    DELETE("D"),
    TRAVERSE_ALL("T"),
    MEMORY_DIAGNOSTIC("M"),
    SHUTDOWN("Q"),
    INVALID("INVALID_CODE");

    private final String query;

    Commands(String command) {
        this.query = command;
    }

    public String getQuery() {
        return query;
    }
}

