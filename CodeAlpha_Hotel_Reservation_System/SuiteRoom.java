

public class SuiteRoom extends Room {

    private static int count = 0;
    private final String roomType = "SuiteRoom";


    public SuiteRoom(int roomId) {
        super(roomId + count, 4000);
        count++;
    }

}
