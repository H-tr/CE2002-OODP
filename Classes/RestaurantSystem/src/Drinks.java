public class Drinks extends Item {
    public Drinks(String name, String description, double price) {
        super(name, description, price);
    }

    
    /** 
     * return the type of this class
     * @author HuTianrun
     * @return String
     */
    public String getType() {
        return "Drinks";
    };
}
