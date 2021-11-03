import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.*;

public class OrderTest {
    public static void main(String[] args) throws IOException {

        Calendar cal = Calendar.getInstance();
		cal.set(2021, 5, 30);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
        System.out.println(date);

    }


}
