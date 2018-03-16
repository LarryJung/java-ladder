
package codesquad.ladder.model;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player player = (Player) obj;
            if (name.equals(player.getName())) return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.name.hashCode();
    }

}
