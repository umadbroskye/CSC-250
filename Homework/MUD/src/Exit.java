public class Exit {
    private final Room destination1;
    private final Room destination2;
    private final String directionLeadingToDest1;
    private final String directionLeadingToDest2;

    public Exit(Room destination1, String directionLeadingToDest1, Room destination2, String directionLeadingToDest2) {
        this.destination1 = destination1;
        this.destination2 = destination2;
        this.directionLeadingToDest1 = directionLeadingToDest1;
        this.directionLeadingToDest2 = directionLeadingToDest2;
    }

    public String getDirectionStringLeadingAwayFromRoom(Room r) {
        return this.destination1 == r ? this.directionLeadingToDest2 : this.directionLeadingToDest1;
    }
}
