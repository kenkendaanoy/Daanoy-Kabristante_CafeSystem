public abstract class MenuItem {

    protected String name;

    protected double basePrice;

    private String itemCode;

    public MenuItem() {
        this.name = "Unnamed Item";
        setBasePrice(0.0);
        this.itemCode = "N/A";
    }

    public MenuItem(String name, double basePrice, String itemCode) {
        this();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    public abstract double computePrice();

    // Getter
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    public String getName() {
        return name;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public String getItemCode() {
        return itemCode;
    }

    // Setter
    public void setName(String name) {

        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: name cannot be empty.");
        }
    }

    public void setBasePrice(double basePrice) {

        if (basePrice < 0) {
            System.out.println("Error: base price cannot be negative.");
        } else {
            this.basePrice = basePrice;
        }
    }

    public void setItemCode(String itemCode) {

        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode;
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}
