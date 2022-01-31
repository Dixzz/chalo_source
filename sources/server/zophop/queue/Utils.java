package server.zophop.queue;

import java.util.Calendar;
import server.zophop.models.SimpleLogger;

public class Utils {
    public static void print(String str) {
        Calendar instance = Calendar.getInstance();
        instance.get(1);
        instance.get(2);
        instance.get(5);
        int i = instance.get(11);
        int i2 = instance.get(12);
        int i3 = instance.get(13);
        int i4 = instance.get(14);
        SimpleLogger.info(String.format(Thread.currentThread().getName() + "   %02d:%02d:%02d:%03d  " + str + "\n", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
    }
}
