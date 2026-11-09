public class Meal extends MenuItem {

    private static final double UPSIZE_FEE = 20.0;

    private static final double SIDE_FEE = 12.0;

    private boolean upsized;

    private int extraSides;

    public Meal() {
        super();
        this.upsized = false;
        this.extraSides = 0;
    }

    public Meal(String name, double basePrice, String itemCode,
                boolean upsized, int extraSides) {
        super();
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
        setUpsized(upsized);
        setExtraSides(extraSides);
    }

    @Override
    public double computePrice() {
        double price = basePrice;
        // Upsizing adds a flat fee
        if (upsized) {
            price += UPSIZE_FEE;
        }
        return price + SIDE_FEE * extraSides;
    }

    @Override
    // Getter
    public String getDescription() {
        String sizeText;

        if (upsized) {
            sizeText = "Upsized";
        } else {
            sizeText = "Regular";
        }
        String sideText;

        if (extraSides == 1) {
            sideText = "side";
        } else {
            sideText = "sides";
        }
        return super.getDescription() + " " + sizeText + ", " + extraSides + " " + sideText;
    }

    public boolean isUpsized() {
        return upsized;
    }

    public int getExtraSides() {
        return extraSides;
    }
    // Setter
    public void setUpsized(boolean upsized) {
        this.upsized = upsized;
    }

    public void setExtraSides(int extraSides) {

        if (extraSides < 0) {
            System.out.println("Error: extra sides cannot be negative.");
        } else {
            this.extraSides = extraSides;
        }
    }
}
