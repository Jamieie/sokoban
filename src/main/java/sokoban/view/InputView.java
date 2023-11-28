package sokoban.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InputView {
    private final String SEPARATOR = "=====";
    private Scanner scanner;

    public int readStage() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.trim().split(" ");
        return Integer.parseInt(split[1]);
    }

    public Map<Integer, String> readMap() {
        scanner = new Scanner(System.in);
        Map<Integer, String> map = new HashMap<>();
        int key = 0;
        String input = "";
        while (!input.equals(SEPARATOR)) {
            input = scanner.nextLine();
            map.put(key, input);
            key++;
        }
        return map;
    }
}
