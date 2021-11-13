import java.util.Date;

/** 
 * Timing class is used to store in table class, order class and reservation class.
 * User can get information about the occupied time of a table in this class.
 * @author Hu Tianrun
 */
public class Timing {
    enum MealTime {BREAKFAST, LUNCH, DINNER};
    protected Date date;
    protected MealTime time;
    protected Timing next = null;

    Timing(Date date, MealTime time) {
        this.date = date;
        this.time = time;
    }

    
    /** 
     * Check whether two timing are equal
     * @param temp
     * @return boolean
     */
    public boolean equal(Timing temp) {
        boolean equal = true;
        if (temp.date.compareTo(this.date) != 0)
            equal = false;
        if (temp.time != this.time)
            equal = false;
        return equal;
    }

    
    /** 
     * Compare two timing
     * @param temp
     * @return boolean
     */
    public boolean smallerThan(Timing temp) {
        boolean smaller = true;
        if (this.date.compareTo(temp.date) > 0)
            smaller = false;
        if (this.date.compareTo(temp.date) == 0) {
            if (temp.time == MealTime.BREAKFAST && (this.time == MealTime.LUNCH || this.time == MealTime.DINNER))
                smaller = false;
            if (temp.time == MealTime.LUNCH && this.time == MealTime.DINNER)
                smaller = false;
        }
        return smaller;
    }
    
    /** 
     * Get date
     * @return Date
     */
    public Date getDate() {
        return date;
    }
    
    /** 
     * Get time
     * @return MealTime
     */
    public MealTime getTime() {
        return time;
    }
}
