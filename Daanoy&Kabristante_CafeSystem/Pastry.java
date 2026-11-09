public class Pastry extends MenuItem {

    private static final double WARMING_FEE = 10.0;

    private boolean warmed;

    public Pastry() {
        super();
        this.warmed = false;
    }

    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
        setWarmed(warmed);
    }

    @Override
    public double computePrice() {
        double price = basePrice;
        // Warming adds a flat fee
        if (warmed) {
            price += WARMING_FEE;
        }
        return price;
    }

    @Override
    // Getter
    public String getDescription() {
        // Only mention warming when it applies
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    // Getter
    public boolean isWarmed() {
        return warmed;
    }

    // Setter
    public void setWarmed(boolean warmed) {
        this.warmed = warmed;
    }
}
