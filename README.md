# 📦 sokoban

## 💡 풀이과정

### 문자열로 넘긴 맵 정보 읽기

입력되는 값이 유효하다는 가정으로 코드 작성 (유효성 검사 X)

- `Scanner` 클래스 사용
  - 오류를 해결하다가 `BufferedReader` 에 대해 알게 됐는데, 입력량이 제한되어 있고 많지 않아 그대로 `Scanner` 사용 결정
- 여러줄의 입력값 읽기
  - 개행(\n)을 기준으로 값을 읽는 `Scanner.readLine()` 특성 상 한 줄씩 읽어오도록 코드 작성
  - 맵 정보 저장 시 `Map` Collection에 한 줄씩 저장할 것이기 때문에 한 줄씩 읽어옴
  - `while(scanner.hasNext())`로 다음 값이 없을 때까지 값 읽어오도록 함
  - 단, 키드보 입력으로 값 입력 시 EOF character(^D)를 직접 입력해줘야 하는 문제 발생

### Stage, map 저장하는 클래스 생성

- `Map` 콜렉션 사용하여 맵 저장
  - key 값이 행 정보, 각 행에 저장된 `List` 내부 인덱스 값이 열 정보가 됨
- 맵 정보 저장하는 객체들 `List` 콜렉션으로 관리
  - 맵 정보 저장하는 객체들을 저장하는 클래스를 따로 만들까 고민했으나 추가할 기능이 없어서 객체에 맞지 않는다고 판단하여 `List`에 저장

### 기호-저장값 대응 정보 관리

- Enum으로 관리
  - 기호-저장값은 상수이므로 enum으로 관리
  - 코드 작성 시, 한 줄에 "." 사용이 많아진다는 문제 발생

---

## 👩‍🏫 코드설명

### 콘솔로 맵 정보 입력 받는 코드

    Scanner scanner = new Scanner(System.in);
    InputView inputView = new InputView(scanner);
    List<GameBoard> gameBoards = new ArrayList<>();
    while (scanner.hasNext()) {
        int stage = inputView.readStage();
        Map<Integer, String> map = inputView.readMap();
        gameBoards.add(new GameBoard(stage, map));
    }

다음 입력 값이 없을 때까지(`while(scanner.hasNext()`) 스테이지, 맵 정보 읽어와서 `GameBoard` 객체 생성 ➡ 생성된 `GameBoard` 객체 `List` Collection에 추가

    public Map<Integer, String> readMap() {
        Map<Integer, String> map = new HashMap<>();
        int key = 0;
        String input = "";
        while (!input.equals(SymbolTable.SEPARATOR.getSymbol()) && scanner.hasNext()) {
            input = scanner.nextLine();
            if (!input.equals(SymbolTable.SEPARATOR.getSymbol())) {
                map.put(key, input);
                key++;
            }
        }
        return map;
    }

`while()` 문: 입력값이 구분자이거나 추가 입력되는 값이 없을 때까지 값 읽어와서 `Map`에 추가

### 플레이어 위치 구하는 코드

    public Map<String, Integer> findPlayerPosition() {
        Map<String, Integer> position = new HashMap<>();
        for (int i = 0; i < map.size(); i++) {
            List<Integer> row = map.get(i);
            if (row.contains(SymbolTable.PLAYER.getValue())) {
                int index = row.indexOf(SymbolTable.PLAYER.getValue());
                position.put("column", i+1);
                position.put("row", index+1);
            }
        }
        return position;
    }

플레이어가 저장된 `List`의 `key`값과 `index` 값 찾아서 `Map`에 넣어 반환

  ```
  행 = 플레이어가 저장된 value(List)의 key+1
  열 = 플레이어가 저장된 value(List) 내부의 index+1
  ```

---

## 🚀 실행결과

```
Stage 1
#####
#OoP#
#####
=====
Stage 2
  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########
^D

> Task :Application.main()
Stage 1

#####
#OoP#
#####

가로크기: 5
세로크기: 3
구멍의 수: 1
공의 수: 1
플레이어의 위치: 2행 4열

Stage 2

  #######
###  O  ###
#    o    #
# Oo P oO #
###  o  ###
 #   O  # 
 ########

가로크기: 11
세로크기: 7
구멍의 수: 4
공의 수: 4
플레이어의 위치: 4행 6열
```
