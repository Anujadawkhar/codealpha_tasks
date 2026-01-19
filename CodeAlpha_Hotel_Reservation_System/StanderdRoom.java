public class StanderdRoom extends Room
{

    private static int count = 0;
    private final String roomType = "StanderdRoom";
    
    public StanderdRoom(int roomId) {
        super(roomId + count ,2000);
        count++;
    }

    
}
