package sokoban.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameBoard {
    private int stage;
    private Map<Integer, List<Integer>> map;

    public GameBoard(int stage, Map<Integer, String> symbolMap) {
        this.stage = stage;
        this.map = toValues(symbolMap);
    }

    private Map<Integer, List<Integer>> toValues(Map<Integer, String> symbolMap) {
        Map<Integer, List<Integer>> valueMap = new HashMap<>();
        for (int i = 0; i < symbolMap.size(); i++) {
            String symbols = symbolMap.get(i);
            List<Integer> values = toValue(symbols);
            valueMap.put(i, values);
        }
        return valueMap;
    }

    private List<Integer> toValue(String string) {
        String[] split = string.split("");
        List<Integer> values = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String symbol = split[i];
            if (symbol.equals(SymbolTable.SPACE.getSymbol())) {
                values.add(SymbolTable.SPACE.getValue());
            }
            if (symbol.equals(SymbolTable.HALL.getSymbol())) {
                values.add(SymbolTable.HALL.getValue());
            }
            if (symbol.equals(SymbolTable.BALL.getSymbol())) {
                values.add(SymbolTable.BALL.getValue());
            }
            if (symbol.equals(SymbolTable.PLAYER.getSymbol())) {
                values.add(SymbolTable.PLAYER.getValue());
            }
            if (symbol.equals(SymbolTable.WALL.getSymbol())) {
                values.add(SymbolTable.WALL.getValue());
            }
        }
        return values;
    }

    public int getStage() {
        return stage;
    }

    public Map<Integer, List<Integer>> getMap() {
        return map;
    }
}
