import java.util.Date;

public class Timing {
    enum MealTime {BREAKFAST, LAUNCH, DINNER};
    public Date date;
    public MealTime time;
    public Timing next = null;

    Timing(Date date, MealTime time) {
        this.date = date;
        this.time = time;
    }

    public boolean equal(Timing temp) {
        boolean equal = true;
        if (temp.date.compareTo(this.date) != 0)
            equal = false;
        if (temp.time != this.time)
            equal = false;
        return equal;
    }

    public boolean smallerThan(Timing temp) {
        boolean smaller = true;
        if (this.date.compareTo(temp.date) > 0)
            smaller = false;
        if (this.date.compareTo(temp.date) == 0) {
            if (temp.time == MealTime.BREAKFAST && (this.time == MealTime.LAUNCH || this.time == MealTime.DINNER))
                smaller = false;
            if (temp.time == MealTime.LAUNCH && this.time == MealTime.DINNER)
                smaller = false;
        }
        return smaller;
    }
}
