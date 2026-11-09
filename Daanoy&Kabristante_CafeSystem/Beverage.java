public class Beverage extends MenuItem {

    private static final double MEDIUM_FEE = 15.0;

    private static final double LARGE_FEE = 25.0;

    private String size;

    public Beverage() {
        super();
        setSize(size);
    }

    public Beverage(String name, double basePrice, String itemCode, String size) {
        super();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
        setSize(size);
    }

    @Override
    public double computePrice() {

        if (size.equals("L")) {
            return basePrice + LARGE_FEE;
        } else if (size.equals("M")) {
            return basePrice + MEDIUM_FEE;
        } else {
            return basePrice;
        }
    }

    @Override
    // Getter
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    public String getSize() {
        return size;
    }

    // Setter
    public void setSize(String size) {

        if (size != null && (size.equalsIgnoreCase("S")
                || size.equalsIgnoreCase("M")
                || size.equalsIgnoreCase("L"))) {
            this.size = size.toUpperCase();
        } else {
            System.out.println("Error: size must be S, M, or L.");
        }
    }
}
