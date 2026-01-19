import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    List<Reservation> reservations = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }
}
