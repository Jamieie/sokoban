package sokoban.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public int readStage() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.trim().split(" ");
        return Integer.parseInt(split[1]);
    }
}
