package codesquad.ladder.model;

public class Player {

    private String name;

    public int resultOrder;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setResultOrder(int resultOrder) {
        this.resultOrder = resultOrder;
    }
}