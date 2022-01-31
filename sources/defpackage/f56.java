package defpackage;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* renamed from: f56  reason: default package */
/* compiled from: Yeast */
public final class f56 {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f1093a;
    public static int b;
    public static int c = 0;
    public static String d;
    public static Map<Character, Integer> e = new HashMap(b);

    static {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_".toCharArray();
        f1093a = charArray;
        b = charArray.length;
        for (int i = 0; i < b; i++) {
            e.put(Character.valueOf(f1093a[i]), Integer.valueOf(i));
        }
    }

    public static String a(long j) {
        StringBuilder sb = new StringBuilder();
        do {
            sb.insert(0, f1093a[(int) (j % ((long) b))]);
            j /= (long) b;
        } while (j > 0);
        return sb.toString();
    }

    public static String b() {
        String a2 = a(new Date().getTime());
        if (!a2.equals(d)) {
            c = 0;
            d = a2;
            return a2;
        }
        StringBuilder k0 = hj1.k0(a2, ".");
        int i = c;
        c = i + 1;
        k0.append(a((long) i));
        return k0.toString();
    }
}
