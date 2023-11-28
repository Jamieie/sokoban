package sokoban.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GameBoardTest {
    private GameBoard game;

    private Map<Integer, String> symbolMap1 = Map.of(
            0, "#####",
            1, "#OoP#",
            2, "#####");

    private Map<Integer, String> symbolMap2 = Map.of(
            0, "  #######",
            1, "###  O  ###",
            2, "#    o    #",
            3, "# Oo P oO #",
            4, "###  o  ###",
            5, " #   O  #",
            6, " ########");

    @DisplayName("입력 기호를 숫자로 변환하여 맵 저장하는 기능")
    @Test
    void toValues1() {
        game = new GameBoard(1, symbolMap1);
        Map<Integer, List<Integer>> map = game.getMap();
        assertThat(map.get(0)).isEqualTo(Arrays.asList(4, 4, 4, 4, 4));
        assertThat(map.get(1)).isEqualTo(Arrays.asList(4, 1, 2, 3, 4));
        assertThat(map.get(2)).isEqualTo(Arrays.asList(4, 4, 4, 4, 4));
    }

    @DisplayName("입력 기호를 숫자로 변환하여 맵 저장하는 기능")
    @Test
    void toValues2() {
        game = new GameBoard(2, symbolMap2);
        Map<Integer, List<Integer>> map = game.getMap();
        assertThat(map.get(0)).isEqualTo(Arrays.asList(0, 0, 4, 4, 4, 4, 4, 4, 4));
        assertThat(map.get(1)).isEqualTo(Arrays.asList(4, 4, 4, 0, 0, 1, 0, 0, 4, 4, 4));
        assertThat(map.get(2)).isEqualTo(Arrays.asList(4, 0, 0, 0, 0, 2, 0, 0, 0, 0, 4));
        assertThat(map.get(3)).isEqualTo(Arrays.asList(4, 0, 1, 2, 0, 3, 0, 2, 1, 0, 4));
        assertThat(map.get(4)).isEqualTo(Arrays.asList(4, 4, 4, 0, 0, 2, 0, 0, 4, 4, 4));
        assertThat(map.get(5)).isEqualTo(Arrays.asList(0, 4, 0, 0, 0, 1, 0, 0, 4));
        assertThat(map.get(6)).isEqualTo(Arrays.asList(0, 4, 4, 4, 4, 4, 4, 4, 4));
    }

    @DisplayName("map의 가로 길이 구하는 기능")
    @Test
    void getWidth() {
        game = new GameBoard(2, symbolMap2);
        int width = game.getWidth();
        assertThat(width).isEqualTo(11);
    }

    @DisplayName("map의 세로 길이 구하는 기능")
    @Test
    void getLength() {
        game = new GameBoard(2, symbolMap2);
        int length = game.getLength();
        assertThat(length).isEqualTo(7);
    }
}