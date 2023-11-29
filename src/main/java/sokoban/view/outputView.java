package sokoban.view;

import sokoban.domain.SymbolTable;

import java.util.List;
import java.util.Map;

public class outputView {
    public void printMap(int stage, Map<Integer, List<Integer>> map) {
        System.out.println("Stage " + stage);
        System.out.println();

        for (int i = 0; i < map.size(); i++) {
            List<Integer> values = map.get(i);
            for (Integer value : values) {
                if (value.equals(SymbolTable.SPACE.getValue())) {
                    System.out.print(SymbolTable.SPACE.getSymbol());
                }
                if (value.equals(SymbolTable.HALL.getValue())) {
                    System.out.print(SymbolTable.HALL.getSymbol());
                }
                if (value.equals(SymbolTable.BALL.getValue())) {
                    System.out.print(SymbolTable.BALL.getSymbol());
                }
                if (value.equals(SymbolTable.PLAYER.getValue())) {
                    System.out.print(SymbolTable.PLAYER.getSymbol());
                }
                if (value.equals(SymbolTable.WALL.getValue())) {
                    System.out.print(SymbolTable.WALL.getSymbol());
                }
                System.out.println();
            }
            System.out.println();
        }
    }



}
