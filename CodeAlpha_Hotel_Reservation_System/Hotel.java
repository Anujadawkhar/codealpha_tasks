

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    List<Room> rooms = new ArrayList<>();


    public Hotel (String name)
    {
        this.name = name;
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
    }


    //room avaibable aahe ke nhi cheak karysathi 
    // isbook cha variable use karu shakto 
    // jar aapan navin list return keli ter chael like 

    //list return karu shakto aapan 

    public List<Room> getEmptyRoomsList()
    {
        List<Room> avaiableRoom = new ArrayList<>();

        for(Room r : rooms)
        {
            if(!r.isRoomBooked())
            {
                avaiableRoom.add(r);
            }

        }
        return avaiableRoom;
    }
}
