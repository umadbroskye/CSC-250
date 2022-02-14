import java.util.ArrayList;

public class Room {
    private final ArrayList<Exit> theExits;
    private final String name;
    private Player currentPlayer;

    public Room(String name) {
        this.name = name;
        this.theExits = new ArrayList<Exit>();
        this.currentPlayer = null;
    }

    public void display() {
        System.out.println("Room: " + this.name);
        System.out.print("Also here: ");
        if (this.currentPlayer != null) {
            System.out.println(this.currentPlayer.getName());
        } else {
            System.out.println();
        }
        System.out.print("Obvious Exits: ");
        StringBuilder exitDirections = new StringBuilder();
        for (Exit exit : theExits) {
            exitDirections.append(exit.getDirectionStringLeadingAwayFromRoom(this)).append(" ");
        }
        System.out.println(exitDirections);
    }

    public Player getPlayer() {
        return currentPlayer;
    }

    public void addPlayer(Player p) {
        currentPlayer = p;
    }

    public void addExit(Exit e) {
        theExits.add(e);
    }


}
