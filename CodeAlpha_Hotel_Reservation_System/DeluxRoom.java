public class DeluxRoom extends Room {

    private static int count = 0;
    private final String roomType = "DeluxRoom";

    public DeluxRoom(int roomId) {
        super(roomId + count, 3000);
        count++;
    }

}
