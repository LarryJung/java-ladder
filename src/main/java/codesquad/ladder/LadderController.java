package codesquad.ladder;

import codesquad.ladder.exceptions.InvalidSizeLadderException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderController {

    private Ladder ladder;

    private static final int MIN_SIZE_LADDER = 2;

    private ArrayList<Player> players;

    //생성자
    public LadderController() {
        this.players = initPlayers();
        int numPeople = this.players.size();
        int lineHorizonLength = initLineHorizonLength(players); // 이름 길이에 따라서 사다리 가로 유닛 길이 결정
        int sizeLadder = initSizeLadder();
        this.ladder = new Ladder(numPeople, sizeLadder, lineHorizonLength);
    }

    private int initSizeLadder() {
        System.out.println("Put size of Ladder\n>>");
        try {
            return sizeLadderValidCheck(InputView.getNumber());
        } catch (Exception e) {
            System.out.println("size of ladder must be over 2. try again");
            return initSizeLadder();
        }
    }

    // 이름 길이에 따라서 사다리 가로길이 사이즈 결정
    private int initLineHorizonLength(ArrayList<Player> players) {
        int[] playerNameLengths = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerNameLengths[i] = players.get(i).getLength();
        }
        Arrays.sort(playerNameLengths);
        return playerNameLengths[players.size() - 1];
    }

    // player 리스트 최종 반환 메소드
    private ArrayList<Player> initPlayers() {
        System.out.println("Put player's name (separator, \",\") >>");
        try {
            return playerNameCheckReturn(InputView.getString());
        } catch (Exception e) {
            System.out.println("getPlayers return");
            return initPlayers();
        }
    }

    // 문자열을 받아서 문자열 유효성 체크 하고 player리스트 반환
    private ArrayList<Player> playerNameCheckReturn(String[] playerNames) throws Exception {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        if (!nameFinalCheck(names)) {
            throw new Exception();
        }
        return makePlayers(names);
    }

    // 문자열 받아서 player list로 변환
    private ArrayList<Player> makePlayers(ArrayList<String> names) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (String name : names) {
            players.add(new Player(name));
        }
        return players;
    }

    // 문자열 받아서 중복 및 null 검사.
    private static boolean nameFinalCheck(ArrayList<String> names) {
        try {
            return nameOverlapCheck(names);
        } catch (NullPointerException e) {
            System.out.println(" ,(쉼표) 로 구분된 값을 넣어 주세요.");
            return false;
        }
    }

    // 문자열 받아서 중복된 이름이 있는지 검사
    private static boolean nameOverlapCheck(ArrayList<String> names) {
        ArrayList<String> nameSet = new ArrayList<String>();
        for (String str : names) {
            eachNameCheck(str, nameSet);
        }
        return (nameSet.size() == names.size());
    }

    private static void eachNameCheck(String name, ArrayList<String> names) {
        if (!names.contains(name)) {
            names.add(name);
        }
    }

    private int sizeLadderValidCheck(int sizeLadder) throws InvalidSizeLadderException {
        if (sizeLadder < MIN_SIZE_LADDER) {
            throw new InvalidSizeLadderException();
        }
        return sizeLadder;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

}
