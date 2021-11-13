/**
 * Dessert is a subclass derived from Item class. It contain the getType memthod that could return the type of current item
 * @author Hu Tianrun
 */

public class Dessert extends Item {
    public Dessert(String name, String description, double price) {
        super(name, description, price);
    }

    
    /** 
     * return the type of this class
     * @return String
     */
    public String getType() {
        return "Dessert";
    };
}
