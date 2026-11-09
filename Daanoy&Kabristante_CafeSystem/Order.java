public class Order {

    private static final double STUDENT_DISCOUNT_RATE = 0.10;

    private static final int MAX_ITEMS = 3;

    private static final int RECEIPT_WIDTH = 42;

    private String orderId;

    private Customer customer;

    private MenuItem item1;

    private MenuItem item2;

    private MenuItem item3;

    private int itemCount;

    private boolean pointsAwarded;

    public Order(String orderId, Customer customer) {
        setOrderId(orderId);
        setCustomer(customer);
        this.pointsAwarded = false;
    }

    public boolean addItem(MenuItem item) {

        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add " + item.getDescription() + ".");
            return false;
        }
        itemCount++;
        return true;
    }

    public double computeSubtotal() {
        double subtotal = 0.0;
        // Skip empty slots
        if (item1 != null) {
            subtotal += item1.computePrice();
        }
        if (item2 != null) {
            subtotal += item2.computePrice();
        }
        if (item3 != null) {
            subtotal += item3.computePrice();
        }
        return subtotal;
    }

    public double computeDiscount() {

        if (customer.isStudent()) {
            return computeSubtotal() * STUDENT_DISCOUNT_RATE;
        } else {
            return 0.0;
        }
    }

    public double computeTotal() {
        return computeSubtotal() - computeDiscount();
    }

    public double computeTotal(double voucher) {
        double total = computeTotal() - voucher;

        if (total < 0) {
            return 0.0;
        } else {
            return total;
        }
    }

    public void printReceipt() {
        printReceipt(0.0);
    }

    public void printReceipt(double voucher) {
        String status = "";

        if (customer.isStudent()) {
            status = " (Student)";
        }
        System.out.println("Order #" + orderId + " - " + customer.getName() + status);

        printLine(item1);
        printLine(item2);
        printLine(item3);

        System.out.println(String.format("  Subtotal: %.2f", computeSubtotal()));

        if (customer.isStudent()) {
            System.out.println(String.format("  Student discount (10%%): -%.2f", computeDiscount()));
        }

        if (voucher > 0) {
            System.out.println(String.format("  Voucher: -%.2f", voucher));
        }
        double total = computeTotal(voucher);
        System.out.println(String.format("  TOTAL: %.2f", total));

        if (!pointsAwarded) {
            customer.addPoints(total);
            pointsAwarded = true;
        }
        System.out.println("  Loyalty points: " + customer.getLoyaltyPoints());
        System.out.println();
    }

    private void printLine(MenuItem item) {

        if (item == null) {
            return;
        }
        StringBuilder line = new StringBuilder("  " + item.getDescription() + " ");

        while (line.length() < RECEIPT_WIDTH) {
            line.append('.');
        }
        System.out.println(line + " " + String.format("%7.2f", item.computePrice()));
    }

    // Getter
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getItemCount() {
        return itemCount;
    }

    // Setter
    public void setOrderId(String orderId) {

        if (orderId != null && !orderId.trim().isEmpty()) {
            this.orderId = orderId;
        } else {
            System.out.println("Error: order id cannot be empty.");
        }
    }

    public void setCustomer(Customer customer) {
        if (customer != null) {
            this.customer = customer;
        } else {
            System.out.println("Error: customer cannot be null.");
        }
    }
}
