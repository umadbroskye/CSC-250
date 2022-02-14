public class Player {

    private final String name;
    private final Room currentRoom;

    public Player(String name) {
        this.name = name;
        this.currentRoom = null;
    }

    public String getName() {
        return name;
    }
}
