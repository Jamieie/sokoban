package sokoban.view;

import sokoban.domain.SymbolTable;

import java.util.List;
import java.util.Map;

public class OutputView {
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

    public void printMapInfo(int width, int length, int halls, int balls, Map<String, Integer> position) {
        System.out.println("가로크기: " + width);
        System.out.println("세로크기: " + length);
        System.out.println("구멍의 수: " + halls);
        System.out.println("공의 수: " + balls);
        Integer column = position.get("column");
        Integer row = position.get("row");
        System.out.println("플레이어의 위치: " + column + "행 " + row + "열");
    }
}
