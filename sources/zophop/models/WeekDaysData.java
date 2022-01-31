package zophop.models;

import java.io.BufferedReader;
import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public class WeekDaysData implements Serializable {
    private static final long serialVersionUID = 1;
    public boolean friday;
    public boolean holiday;
    public boolean monday;
    public boolean saturday;
    public boolean sunday;
    public boolean thursday;
    public boolean tuesday;
    public boolean wednesday;

    public static HashMap<String, WeekDaysData> getWeekDaysDataMap(String str) throws Exception {
        BufferedReader p = ec6.p(str);
        HashMap<String, Integer> q = ec6.q(p.readLine());
        HashMap<String, WeekDaysData> hashMap = new HashMap<>();
        while (true) {
            String readLine = p.readLine();
            if (readLine == null) {
                return hashMap;
            }
            if (!StringUtils.isBlank(readLine)) {
                String[] split = readLine.split(",", -1);
                String str2 = split[q.get("service_id").intValue()];
                WeekDaysData weekDaysData = new WeekDaysData();
                weekDaysData.monday = isOne(split[q.get("monday").intValue()]);
                weekDaysData.tuesday = isOne(split[q.get("tuesday").intValue()]);
                weekDaysData.wednesday = isOne(split[q.get("wednesday").intValue()]);
                weekDaysData.thursday = isOne(split[q.get("thursday").intValue()]);
                weekDaysData.friday = isOne(split[q.get("friday").intValue()]);
                weekDaysData.saturday = isOne(split[q.get("saturday").intValue()]);
                weekDaysData.sunday = isOne(split[q.get("sunday").intValue()]);
                weekDaysData.holiday = isOne(split[q.get("holiday").intValue()]);
                hashMap.put(str2, weekDaysData);
            }
        }
    }

    public static boolean isOne(String str) {
        return str.equals("1");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WeekDaysData weekDaysData = (WeekDaysData) obj;
        return this.friday == weekDaysData.friday && this.holiday == weekDaysData.holiday && this.monday == weekDaysData.monday && this.saturday == weekDaysData.saturday && this.sunday == weekDaysData.sunday && this.thursday == weekDaysData.thursday && this.tuesday == weekDaysData.tuesday && this.wednesday == weekDaysData.wednesday;
    }

    public int hashCode() {
        int i = 1231;
        int i2 = ((((((((((((((this.friday ? 1231 : 1237) + 31) * 31) + (this.holiday ? 1231 : 1237)) * 31) + (this.monday ? 1231 : 1237)) * 31) + (this.saturday ? 1231 : 1237)) * 31) + (this.sunday ? 1231 : 1237)) * 31) + (this.thursday ? 1231 : 1237)) * 31) + (this.tuesday ? 1231 : 1237)) * 31;
        if (!this.wednesday) {
            i = 1237;
        }
        return i2 + i;
    }

    public boolean isOn(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("sunday")) {
            return this.sunday;
        }
        if (lowerCase.equals("monday")) {
            return this.monday;
        }
        if (lowerCase.equals("tuesday")) {
            return this.tuesday;
        }
        if (lowerCase.equals("wednesday")) {
            return this.wednesday;
        }
        if (lowerCase.equals("thursday")) {
            return this.thursday;
        }
        if (lowerCase.equals("friday")) {
            return this.friday;
        }
        if (lowerCase.equals("saturday")) {
            return this.saturday;
        }
        if (lowerCase.equals("holiday")) {
            return this.holiday;
        }
        return false;
    }
}
