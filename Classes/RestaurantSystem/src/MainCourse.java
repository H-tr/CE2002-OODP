public class MainCourse extends Item {
    public MainCourse(String name, String description, double price) {
        super(name, description, price);
    }

    
    /** 
     * @auther HuTianrun
     * @return String
     */
    public String getType() {
        return "Main Course";
    };
}
