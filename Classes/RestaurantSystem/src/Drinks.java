public class Drinks extends Item {
    public Drinks(String name, String description, double price) {
        super(name, description, price);
    }

    public String getType() {
        return "Drinks";
    };
}
