package sokoban.view;

import sokoban.domain.SymbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readStage() {
        String input = scanner.nextLine();
        String[] split = input.trim().split(" ");
        return Integer.parseInt(split[1]);
    }

    public Map<Integer, String> readMap() {
        Map<Integer, String> map = new HashMap<>();
        int key = 0;
        String input = "";
        while (!input.equals(SymbolTable.SEPARATOR.getSymbol())) {
            input = scanner.nextLine();
            map.put(key, input);
            key++;
        }
        return map;
    }
}
