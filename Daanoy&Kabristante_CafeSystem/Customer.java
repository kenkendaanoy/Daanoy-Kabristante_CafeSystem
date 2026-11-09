public class Customer {

    private static final double PESOS_PER_POINT = 50.0;

    private String name;
    private boolean student;
    private int loyaltyPoints;

    public Customer() {
        this.name = "Guest";
        this.student = false;
        this.loyaltyPoints = 0;
    }

    public Customer(String name) {
        this();
        setName(name);
    }

    public Customer(String name, boolean student) {
        setName(name);
        setStudent(student);
        setLoyaltyPoints(0);
    }

    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        } else {
            System.out.println("Error: points to add must be positive.");
        }
    }

    public void addPoints(double amountSpent) {
        int earned = (int) (amountSpent / PESOS_PER_POINT);
        if (earned > 0) {
            loyaltyPoints += earned;
        }
    }

    // Getter
    public String getName() {
        return name;
    }

    public boolean isStudent() {
        return student;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    // Setter
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints < 0) {
            System.out.println("Error: loyalty points cannot be negative.");
        } else {
            this.loyaltyPoints = loyaltyPoints;
        }
    }
}
