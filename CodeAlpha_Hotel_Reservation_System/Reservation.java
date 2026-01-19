public class Reservation {
    User user;
    Room room;
    Payment payment;
    String status;

    public Reservation(Room room) {
        this.user = user;
        this.room = room;
        this.status = "CONFIRMED";

        room.bookRoom();               // change room state
        payment = new Payment(room.price);
    }

    public void cancel() {
        status = "CANCELLED";
        room.freeRoom();
        payment.refund();
    }
}
