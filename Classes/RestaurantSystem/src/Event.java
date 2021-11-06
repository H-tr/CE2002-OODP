public abstract class Event {
    private Table table;
    private int pax;
    private String custName;

    
    /** 
     * get the pax of event
     * @author Ian Chan
     * @return int
     */
    public int getPax() {
        return pax;
    }

    
    /** 
     * set the pax
     * @author Ian Chan
     * @param pax
     */
    public void setPax(int pax) {
        this.pax = pax;
    }

    
    /** 
     * get customer name
     * @author Ian Chan
     * @return String
     */
    public String getCustName() {
        return custName;
    }

    
    /** 
     * set customer name
     * @author Ian Chan
     * @param custName
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    
    /** 
     * set table
     * @author Ian Chan
     * @param table
     */
    public void setTable(Table table) {
        this.table = table;
    }

    
    /** 
     * get table
     * @author Ian Chan
     * @return Table
     */
    public Table getTable() {
        return table;
    }

    /**
     * abstract class for order and reservation to return their type.
     * @author Ian Chan
     * @return
     */
    abstract public String returnType();

}
