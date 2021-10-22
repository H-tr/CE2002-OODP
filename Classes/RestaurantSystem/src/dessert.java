public class Dessert extends Item {
    public Dessert(String name, String description, double price) {
        super(name, description, price);
    }

    public String getType() {
        return "Dessert";
    };
}