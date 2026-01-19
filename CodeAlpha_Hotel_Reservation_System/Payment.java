public class Payment {
    double amount;
    String status;

    public Payment(double amount) {
        this.amount = amount;
        this.status = "SUCCESS";
    }

    public void refund() {
        status = "REFUNDED";
    }
}
