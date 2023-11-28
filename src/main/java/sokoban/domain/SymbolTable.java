package sokoban.domain;

public enum SymbolTable {
    SPACE(" ", 0),
    HALL("O", 1),
    BALL("o", 2),
    PLAYER("P", 3),
    WALL("#", 4),
    SEPARATOR("=====", -1);

    private String symbol;
    private int value;

    SymbolTable(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }
}
