/**    
 * This entity class provides all basic information from which the Order and Reservation entities can be extended from.
 * This basic information includes Customer Name, Pax, and Table.
 * Event class is an abstract class that requires returnType to be declared in any subclass (To identify between Order and Restaurant)
 * @author Ian Chan
 */

public abstract class Event {
    private Table table;
    private int pax;
    private String custName;

    
    /** 
     * get the pax of event
     * @return int
     */
    public int getPax() {
        return pax;
    }

    
    /** 
     * set the pax
     * @param pax
     */
    public void setPax(int pax) {
        this.pax = pax;
    }

    
    /** 
     * get customer name
     * @return String
     */
    public String getCustName() {
        return custName;
    }

    
    /** 
     * set customer name
     * @param custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    
    /** 
     * set table
     * @param table
     */
    public void setTable(Table table) {
        this.table = table;
    }

    
    /** 
     * get table
     * @return Table
     */
    public Table getTable() {
        return table;
    }

    /**
     * abstract class for order and reservation to return their type.
     * @return
     */
    abstract public String returnType();

}
