package codesquad.ladder;

import codesquad.ladder.exceptions.InvalidSizeLadderException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderController {

    private Ladder ladder;

    private ArrayList<Player> players;

    //생성자
    public LadderController() {
        this.players = setPlayers();
        int numPeople = this.players.size();
        int lineSize = setLineSize(players);
        int sizeLadder = setSizeLadder();
        this.ladder = new Ladder(numPeople, sizeLadder, lineSize);
    }

    private int setSizeLadder() {
        System.out.println("Put size of Ladder\n>>");
        try {
            return sizeLadderValidCheck(InputView.getNumber());
        } catch (Exception e) {
            System.out.println("size of ladder must be over 2. try again");
            return setSizeLadder();
        }
    }

    // 이름에 따라서 사다리 라인 사이즈 결정
    private int setLineSize(ArrayList<Player> players) {
        int[] playerNameLengths = new int[players.size()];
        for (int i = 0; i < players.size(); i++) {
            playerNameLengths[i] = players.get(i).getName().length();
        }
        Arrays.sort(playerNameLengths);
        return playerNameLengths[players.size() - 1];
    }

    // player 리스트 최종 반환 메소드
    private ArrayList<Player> setPlayers() {
        System.out.println("Put player's name (separator, \",\") >>");
        try {
            return playerNameCheckReturn(InputView.getString());
        } catch (Exception e) {
            System.out.println("getPlayers return");
            return setPlayers();
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
    private static boolean nameOverlapCheck(ArrayList<String> list) {
        ArrayList<String> setlist = new ArrayList<String>();
        for (String str : list) {
            eachNameCheck(str, setlist);
        }
        return (setlist.size() == list.size());
    }

    private static void eachNameCheck(String str, List<String> list) {
        if (!list.contains(str)) {
            list.add(str);
        }
    }

    private int sizeLadderValidCheck(int sizeLadder) throws InvalidSizeLadderException {
        int MIN_SIZE_LADDER = 2;
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
