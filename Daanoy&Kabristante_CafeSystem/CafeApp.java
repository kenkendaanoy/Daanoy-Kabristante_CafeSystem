public class CafeApp {

    public static void main(String[] args) {

        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // ---------- Order 1001: Ana (student) ----------
        // Parameterized constructors
        Beverage icedLatte = new Beverage("Iced Latte", 95.0, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.0, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110.0, "M-01", true, 1);

        // Default constructor filled in with setters
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(35.0);
        cookie.setItemCode("P-02");

        Order order1 = new Order("1001", ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);
        order1.addItem(cookie);
        order1.printReceipt();

        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        hotChocolate.setItemCode("B-02");
        hotChocolate.setBasePrice(-5.0);
        hotChocolate.setBasePrice(80.0);
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setItemCode("M-02");
        beefTapa.setBasePrice(130.0);

        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        order2.printReceipt(20.0);
    }
}
