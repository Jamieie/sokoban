package sokoban;

import sokoban.domain.GameBoard;
import sokoban.view.InputView;
import sokoban.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        List<GameBoard> gameBoards = new ArrayList<>();
        while (scanner.hasNext()) {
            int stage = inputView.readStage();
            Map<Integer, String> map = inputView.readMap();
            gameBoards.add(new GameBoard(stage, map));
        }

        OutputView outputView = new OutputView();
        for (GameBoard game : gameBoards) {
            int stage = game.getStage();
            Map<Integer, List<Integer>> map = game.getMap();
            outputView.printMap(stage, map);
            outputView.printMapInfo(game.getWidth(), game.getLength(), game.findHalls(), game.findBalls(), game.findPlayerPosition());
            System.out.println();
        }
    }
}