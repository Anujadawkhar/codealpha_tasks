import java.util.Scanner;

public class HotelManagementDemo {

    // Admin menu display karto
    static void displayAdminMenu() {

        System.out.println("\n--- ADMIN MENU ---");
        System.out.println("1. Add Standard Room");
        System.out.println("2. Add Deluxe Room");
        System.out.println("3. Add Suite Room");
        System.out.println("4. View All Rooms");
        System.out.println("0. Exit");
    }

    // User menu display karto
    static void displayUserMenu() {

        System.out.println("\n--- USER MENU ---");
        System.out.println("1. View Available Rooms");
        System.out.println("2. Book a Room");
        System.out.println("3. Cancel Booking");
        System.out.println("4. View My Bookings");
        System.out.println("0. Exit");
    }

    // Admin dashboard logic
    static void adminDashboard(Hotel hotel) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            displayAdminMenu();
            choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter room number: ");
                    hotel.addRoom(new StanderdRoom(sc.nextInt()));
                    System.out.println("Standard Room added");
                    break;
                }

                case 2: {
                    System.out.print("Enter room number: ");
                    hotel.addRoom(new DeluxRoom(sc.nextInt()));
                    System.out.println("Deluxe Room added");
                    break;
                }

                case 3: {
                    System.out.print("Enter room number: ");
                    hotel.addRoom(new SuiteRoom(sc.nextInt()));
                    System.out.println("Suite Room added");
                    break;
                }

                case 4: {
                    if (hotel.rooms.isEmpty()) {
                        System.out.println("No rooms added yet");
                    } else {
                        for (Room r : hotel.rooms) {
                            System.out.println(
                                    "Room " + r.roomId +
                                    " | Price: " + r.price +
                                    " | Available: " + !r.isBooked
                            );
                        }
                    }
                    break;
                }

                case 0: {
                    System.out.println("Exiting Admin Menu");
                    break;
                }

                default: {
                    System.out.println("Invalid choice");
                }
            }

        } while (choice != 0);
    }

    // User dashboard logic
    static void userDashboard(Hotel hotel, User user) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            displayUserMenu();
            choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    if (hotel.getEmptyRoomsList().isEmpty()) {
                        System.out.println("No rooms available");
                    } else {
                        for (Room r : hotel.getEmptyRoomsList()) {
                            System.out.println(
                                    "Room " + r.roomId +
                                    " | Price: " + r.price
                            );
                        }
                    }
                }

                case 2 -> {
                    System.out.print("Enter room number to book: ");
                    int roomNo = sc.nextInt();

                    Room selectedRoom = null;

                    for (Room r : hotel.getEmptyRoomsList()) {
                        if (r.roomId == roomNo) {
                            selectedRoom = r;
                            break;
                        }
                    }

                    if (selectedRoom != null) {

                        Reservation reservation = new Reservation(selectedRoom);
                        selectedRoom.isBooked = true;
                        user.reservations.add(reservation);

                        System.out.println("Room booked successfully");

                    } else {
                        System.out.println("Room not available");
                    }
                }

                case 3 -> {
                    if (user.reservations.isEmpty()) {
                        System.out.println("No bookings to cancel");
                    } else {

                        System.out.println("Your Bookings:");

                        for (int i = 0; i < user.reservations.size(); i++) {
                            Reservation r = user.reservations.get(i);
                            System.out.println(
                                    (i + 1) + ". Room " +
                                    r.room.roomId +
                                    " | Status: " + r.status
                            );
                        }

                        System.out.print("Select booking number: ");
                        int index = sc.nextInt() - 1;

                        if (index >= 0 && index < user.reservations.size()) {
                            user.reservations.get(index).cancel();
                            System.out.println("Booking cancelled");
                        } else {
                            System.out.println("Invalid selection");
                        }
                    }
                }

                case 4 -> {
                    if (user.reservations.isEmpty()) {
                        System.out.println("No bookings found");
                    } else {
                        for (Reservation r : user.reservations) {
                            System.out.println(
                                    "Room " + r.room.roomId +
                                    " | Status: " + r.status
                            );
                        }
                    }
                }

                case 0 -> System.out.println("Exiting User Menu");

                default -> System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel("My Hotel");

        while (true) {

            System.out.println("\n--- HOTEL MANAGEMENT SYSTEM ---");
            System.out.println("1. Admin Dashboard");
            System.out.println("2. User Dashboard");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            OUTER:
            switch (choice) {

                case 1 -> adminDashboard(hotel);

                case 2 -> {
                    User user = new User("Pratham");
                    userDashboard(hotel, user);
                }

                case 0 -> {
                    System.out.println("System Closed");
                    break OUTER;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }
}
