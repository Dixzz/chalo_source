package j$.time;

import j$.time.zone.c;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

public abstract class ZoneId implements Serializable {
    static {
        HashMap hashMap = new HashMap(64);
        hashMap.put("ACT", "Australia/Darwin");
        hashMap.put("AET", "Australia/Sydney");
        hashMap.put("AGT", "America/Argentina/Buenos_Aires");
        hashMap.put("ART", "Africa/Cairo");
        hashMap.put("AST", "America/Anchorage");
        hashMap.put("BET", "America/Sao_Paulo");
        hashMap.put("BST", "Asia/Dhaka");
        hashMap.put("CAT", "Africa/Harare");
        hashMap.put("CNT", "America/St_Johns");
        hashMap.put("CST", "America/Chicago");
        hashMap.put("CTT", "Asia/Shanghai");
        hashMap.put("EAT", "Africa/Addis_Ababa");
        hashMap.put("ECT", "Europe/Paris");
        hashMap.put("IET", "America/Indiana/Indianapolis");
        hashMap.put("IST", "Asia/Kolkata");
        hashMap.put("JST", "Asia/Tokyo");
        hashMap.put("MIT", "Pacific/Apia");
        hashMap.put("NET", "Asia/Yerevan");
        hashMap.put("NST", "Pacific/Auckland");
        hashMap.put("PLT", "Asia/Karachi");
        hashMap.put("PNT", "America/Phoenix");
        hashMap.put("PRT", "America/Puerto_Rico");
        hashMap.put("PST", "America/Los_Angeles");
        hashMap.put("SST", "Pacific/Guadalcanal");
        hashMap.put("VST", "Asia/Ho_Chi_Minh");
        hashMap.put("EST", "-05:00");
        hashMap.put("MST", "-07:00");
        hashMap.put("HST", "-10:00");
        Collections.unmodifiableMap(hashMap);
    }

    ZoneId() {
        if (getClass() != h.class && getClass() != i.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public static ZoneId of(String str) {
        int i;
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return h.y(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            i = 3;
        } else if (!str.startsWith("UT")) {
            return i.x(str, true);
        } else {
            i = 2;
        }
        return w(str, i, true);
    }

    public static ZoneId v(String str, h hVar) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(hVar, "offset");
        if (str.length() == 0) {
            return hVar;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (hVar.x() != 0) {
                str = str.concat(hVar.g());
            }
            return new i(str, c.e(hVar));
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: " + str);
    }

    private static ZoneId w(String str, int i, boolean z) {
        String substring = str.substring(0, i);
        if (str.length() == i) {
            return v(substring, h.e);
        }
        if (str.charAt(i) != '+' && str.charAt(i) != '-') {
            return i.x(str, z);
        }
        try {
            h y = h.y(str.substring(i));
            return y == h.e ? v(substring, y) : v(substring, y);
        } catch (b e) {
            throw new b("Invalid ID for offset-based ZoneId: " + str, e);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return g().equals(((ZoneId) obj).g());
        }
        return false;
    }

    public abstract String g();

    public int hashCode() {
        return g().hashCode();
    }

    public abstract c t();

    public String toString() {
        return g();
    }
}
