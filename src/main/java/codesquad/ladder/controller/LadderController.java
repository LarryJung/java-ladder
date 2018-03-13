package codesquad.ladder.controller;

import codesquad.ladder.view.InputView;
import codesquad.ladder.model.Ladder;
import codesquad.ladder.model.Player;
import codesquad.ladder.model.exceptions.InvalidSizeLadderException;

import java.util.ArrayList;
import java.util.Arrays;

public class LadderController {

    private static final int MIN_SIZE_LADDER = 1;

    private static final int MAX_SIZE_NAME = 5;

    private Ladder ladder;

    private ArrayList<Player> players;

    //생성자
    public LadderController() {
        this.players = initPlayers();
        int numPeople = this.players.size();
        int sizeLadder = initSizeLadder();
        this.ladder = new Ladder(numPeople, sizeLadder);
    }

    // player 리스트 최종 반환 메소드
    private ArrayList<Player> initPlayers() {
        System.out.println("Put player's name (separator, \",\") >>");
        try {
            return playerNameCheckReturn(InputView.getString());
        } catch (Exception e) {
            System.out.println("Input error, there is no same name & each length must be lower than 5");
            return initPlayers();
        }
    }

    // 문자열을 받아서 문자열 유효성 체크 하고 player리스트 반환
    private ArrayList<Player> playerNameCheckReturn(String[] playerNames) throws RuntimeException {
        ArrayList<String> names = new ArrayList<String>(Arrays.asList(playerNames));
        if (!nameFinalCheck(names)) {
            throw new RuntimeException();
        }
        return makePlayers(names);
    }

    // 사용자 이름 유효값(길이, 중복) 최종 체크
    private static boolean nameFinalCheck(ArrayList<String> names) throws NullPointerException{
        return nameMaxSizeCheck(names) && nameOverlapCheck(names);
    }

    // 사용자 이름 길이 최종 체크
    private static boolean nameMaxSizeCheck(ArrayList<String> names) throws RuntimeException {
        for (String name : names) return eachNameSizeCheck(name);
        return true;
    }

    // 사용자 이름 길이 단위 체크
    private static boolean eachNameSizeCheck(String name){
        if (name.length() > MAX_SIZE_NAME) throw new RuntimeException();
        return true;
    }

    // 사용자 이름 중복 최종 체크
    private static boolean nameOverlapCheck(ArrayList<String> names) {
        ArrayList<String> nameSet = new ArrayList<String>();
        for (String name : names) eachNameCheck(name, nameSet);
        return (nameSet.size() == names.size());
    }

    // 사용자 이름 중복 단위 체크
    private static void eachNameCheck(String name, ArrayList<String> nameSet) {
        if (!nameSet.contains(name)) nameSet.add(name);
    }

    // 문자열 받아서 player list로 변환
    private ArrayList<Player> makePlayers(ArrayList<String> names) {
        ArrayList<Player> players = new ArrayList<Player>();
        for (String name : names) players.add(new Player(name));
        return players;
    }

    // ladder size 최종 반환 메소드
    private int initSizeLadder() {
        System.out.println("Put size of Ladder\n>>");
        try {
            return sizeLadderValidCheck(InputView.getNumber());
        } catch (Exception e) {
            System.out.println("size of ladder must be over 2. try again");
            return initSizeLadder();
        }
    }

    // ladder 사이즈 길이 유효값 최종 체크
    private int sizeLadderValidCheck(int sizeLadder) throws InvalidSizeLadderException {
        if (sizeLadder < MIN_SIZE_LADDER) throw new InvalidSizeLadderException();
        return sizeLadder;
    }

    public Ladder getLadder() {
        return this.ladder;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

}
