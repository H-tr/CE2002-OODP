public class Drinks extends Item {
    public Drinks(String name, String description, double price) {
        super(name, description, price);
    }

    
    /** 
     * @auther HuTianrun
     * @return String
     */
    public String getType() {
        return "Drinks";
    };
}
