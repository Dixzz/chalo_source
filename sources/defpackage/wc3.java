package defpackage;

/* renamed from: wc3  reason: default package */
public enum wc3 {
    NONE,
    GZIP;

    public static wc3 zzaa(String str) {
        if ("GZIP".equalsIgnoreCase(str)) {
            return GZIP;
        }
        return NONE;
    }
}
