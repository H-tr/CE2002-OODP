public class Dessert extends Item {
    public Dessert(String name, String description, double price) {
        super(name, description, price);
    }

    
    /** 
     * return the type this item class
     * @auther HuTianrun
     * @return String
     */
    public String getType() {
        return "Dessert";
    };
}
