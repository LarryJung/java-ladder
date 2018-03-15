package codesquad.ladder.controller;

import codesquad.ladder.model.Line;
import codesquad.ladder.model.exceptions.DuplicetedNameException;
import codesquad.ladder.model.exceptions.InvalidNameSizeException;
import codesquad.ladder.model.exceptions.InvalidPlayerNameException;
import codesquad.ladder.view.InputView;
import codesquad.ladder.model.Ladder;
import codesquad.ladder.model.Player;
import codesquad.ladder.model.exceptions.InvalidSizeLadderException;
import codesquad.ladder.view.ResultView;

import java.util.*;

public class LadderController {

    private static final int MIN_SIZE_LADDER = 1;

    private static final int MAX_SIZE_NAME = 5;

    private Ladder ladder;

    private ArrayList<Player> players;

    private HashMap<Player, Integer> map = new HashMap<>();

    // player 리스트 최종 반환 메소드
    private void initPlayers() {
        try {
            System.out.println("Put player's name (separator, \",\") \n>>");
            ArrayList<String> playerNames = new ArrayList<String>(playerNameCheckReturn(InputView.getString()));
            this.players = makePlayers(playerNames);
        } catch (InvalidPlayerNameException e) {
            initPlayers();
        }
    }

    // 문자열을 받아서 문자열 유효성 체크 하고 스트링 ArrayList 반환
    static ArrayList<String> playerNameCheckReturn(String[] playerNames) {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        if (!nameFinalCheck(names)) {
            throw new InvalidPlayerNameException();
        }
        return names;
    }

    // 사용자 이름 유효값(길이, 중복) 최종 체크
    static boolean nameFinalCheck(ArrayList<String> names) throws InvalidPlayerNameException {
        return nameMaxSizeCheck(names) && duplicatedNameCheck(names);
    }

    // 사용자 이름 길이 최종 체크
    static boolean nameMaxSizeCheck(ArrayList<String> names) {
        for (String name : names) eachNameSizeCheck(name);
        return true;
    }

    // 사용자 이름 길이 단위 체크
    static boolean eachNameSizeCheck(String name) {
        if (name.length() > MAX_SIZE_NAME) {
            System.out.println("each name length must be lower than 5");
            throw new InvalidNameSizeException();
        }
        return true;
    }

    // 사용자 이름 중복 최종 체크
    static boolean duplicatedNameCheck(ArrayList<String> names) {
        Set<String> nameSet = new HashSet<String>();
        nameSet.addAll(names);
        if (nameSet.size() != names.size()) {
            System.out.println("there are duplicated names.");
            throw new DuplicetedNameException();
        }
        return true;
    }

    // 문자열 받아서 player list로 변환
    static ArrayList<Player> makePlayers(ArrayList<String> names) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (String name : names) players.add(new Player(name));
        return players;
    }

    // ladder size 최종 반환 메소드
    private int initSizeLadder() {
        try {
            System.out.println("Put ladder size \n>>");
            return sizeLadderValidCheckReturn(InputView.getNumber());
        } catch (InvalidSizeLadderException e) {
            System.out.println("size of ladder must be over 2. try again");
            return initSizeLadder();
        }
    }

    // ladder 사이즈 길이 유효값 최종 체크
    static int sizeLadderValidCheckReturn(int sizeLadder) {
        if (sizeLadder < MIN_SIZE_LADDER) throw new InvalidSizeLadderException();
        return sizeLadder;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public HashMap<Player, Integer> getMap() {
        return this.map;
    }


    private void makeLadder(int numPeople, int sizeLadder) {
        this.ladder = new Ladder(numPeople, sizeLadder);
    }

    public void ladderGameStart() {
        initPlayers();
        int ladderSize = initSizeLadder();
        makeLadder(this.players.size(), ladderSize);
    }

    public void matchTotalResult() {
        for (int i = 0; i < this.players.size(); i++) {
            map.put(this.players.get(i), matchEachResult(i, this.ladder.getLadderForm()));
        }
    }

    static int matchEachResult(int index, ArrayList<Line> ladderForm) {
        int x = 0; // row index
        int y = index; // column index
        int maxRightIndex = ladderForm.get(1).getPoints().size();
        String direction = "down"; // initialize
        while (x < ladderForm.size()) {
            switch (direction) {
                case "down":
                    if (y == 0) {
                        if (ladderForm.get(x).getPoints().get(y)) {
                            y = y + 1;
                            direction = "right";
                            break;
                        }
                        if (!ladderForm.get(x).getPoints().get(y)) {
                            x = x + 1;
                            direction = "down";
                            break;
                        }
                    }
                    if (y == maxRightIndex) {
                        if (ladderForm.get(x).getPoints().get(y - 1)) {
                            y = y - 1;
                            direction = "left";
                            break;
                        }
                        if (!ladderForm.get(x).getPoints().get(y - 1)) {
                            x = x + 1;
                            direction = "down";
                            break;
                        }
                    }
                    if (ladderForm.get(x).getPoints().get(y - 1)) {
                        y = y - 1;
                        direction = "left";
                        break;
                    }
                    if (ladderForm.get(x).getPoints().get(y)) {
                        y = y + 1;
                        direction = "right";
                        break;
                    }
                    if (((ladderForm.get(x).getPoints().get(y - 1) && ladderForm.get(x).getPoints().get(y)))) {
                        x = x + 1;
                        direction = "down";
                        break;
                    }

                case "left":
                    if (y == 0) { x = x + 1; direction = "down"; break; }
                    if (ladderForm.get(x).getPoints().get(y - 1)) { y = y - 1; direction = "left"; break; }
                    if (!ladderForm.get(x).getPoints().get(y - 1)) { x = x + 1; direction = "down"; break; }

                case "right":
                    if (y == maxRightIndex) { x = x + 1; direction = "down"; break; }
                    if (ladderForm.get(x).getPoints().get(y)) { y = y + 1; direction = "right"; break; }
                    if (!ladderForm.get(x).getPoints().get(y)) { x = x + 1; direction = "down"; break; }
                    break;
            }
        }
        System.out.println(index+"번째 : "+y);
        return y;
    }
}
