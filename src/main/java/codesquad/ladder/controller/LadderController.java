package codesquad.ladder.controller;

import codesquad.ladder.model.Prize;
import codesquad.ladder.model.Tracker;
import codesquad.ladder.model.exceptions.DuplicetedNameException;
import codesquad.ladder.model.exceptions.InvalidNameSizeException;
import codesquad.ladder.model.exceptions.InvalidNamesException;
import codesquad.ladder.view.InputView;
import codesquad.ladder.model.Ladder;
import codesquad.ladder.model.Player;
import codesquad.ladder.model.exceptions.InvalidSizeLadderException;


import java.util.*;

public class LadderController {

    private static final int MIN_SIZE_LADDER = 1;

    private static final int MAX_SIZE_NAME = 5;

    private Ladder ladder;

    private ArrayList<Player> players;

    private ArrayList<Prize> prizes;

    private HashMap<Player, Prize> map = new HashMap<>();

    // 결과물 리스트 최종 반환 메소드
    private void initPrizes() {
        try {
            System.out.println("Put Prizes what you want. (separator, \",\") \n>>");
            ArrayList<String> prizeNames = new ArrayList<String>(namesCheckReturn(InputView.getString().split(",")));
            this.prizes = makePrizes(prizeNames);
        } catch (InvalidNamesException e) {
            initPrizes();
        }
    }

    // player 리스트 최종 반환 메소드
    private void initPlayers() {
        try {
            System.out.println("Put player's name (separator, \",\") \n>>");
            ArrayList<String> playerNames = new ArrayList<String>(namesCheckReturn(InputView.getString().split(",")));
            this.players = makePlayers(playerNames);
        } catch (InvalidNamesException e) {
            initPlayers();
        }
    }

    // 문자열을 받아서 문자열 유효성 체크 하고 스트링 ArrayList 반환
    static ArrayList<String> namesCheckReturn(String[] playerNames) {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        if (!nameFinalCheck(names)) {
            throw new InvalidNamesException();
        }
        return names;
    }

    // 사용자 이름 유효값(길이, 중복) 최종 체크
    static boolean nameFinalCheck(ArrayList<String> names) throws InvalidNamesException {
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

    // 문자열 받아서 prize list로 변환
    static ArrayList<Prize> makePrizes(ArrayList<String> names) {
        ArrayList<Prize> prizes = new ArrayList<Prize>();
        for (String name : names) prizes.add(new Prize(name));
        return prizes;
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

    public HashMap<Player, Prize> getMap() {
        return this.map;
    }

    private void makeLadder(int numPeople, int sizeLadder) {
        this.ladder = new Ladder(numPeople, sizeLadder);
    }

    public void ladderGameStart() {
        initPlayers();
        initPrizes();
        int ladderSize = initSizeLadder();
        makeLadder(this.players.size(), ladderSize);
    }

    public void matchTotalResult() {
        for (int i = 0; i < this.players.size(); i++) {
            map.put(this.players.get(i), this.prizes.get(ladder.trace(i)));
        }
    }

    public ArrayList<Prize> getPrizes() {
        return this.prizes;
    }
}
