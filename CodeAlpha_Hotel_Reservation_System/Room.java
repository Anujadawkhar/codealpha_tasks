
public class Room 
{
    int roomId;
    String roomType = "basic";
    double price;
    boolean isBooked = false;

    public Room(int roomId, double price) {
        this.roomId = roomId;
        this.price = price;
    }

    public void bookRoom()
    {
        this.isBooked = true;
    }

    public void freeRoom()
    {
        this.isBooked = false;
    }

    public boolean isRoomBooked()
    {
        return this.isBooked;
    }


    public String showDetails()
    {
        return "----------------------------------------------" + "\n" + "| roomId: " + this.roomId +"Room Type"+ this.roomType+ "| price: " + this.price + "| isBooked: " + this.isBooked + " |" + "\n" +"----------------------------------------------" ;
        
    }





    
}

