package codesquad.ladder;

public class Player {

    private String name;

    private int length;

    public Player(String name) {
        this.name = name;
        this.length = name.length();
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return length;
    }
}
