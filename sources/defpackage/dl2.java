package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* renamed from: dl2  reason: default package */
public class dl2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Uri f853a = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri b = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    public static final AtomicBoolean e = new AtomicBoolean();
    public static HashMap<String, String> f;
    public static final HashMap<String, Boolean> g = new HashMap<>();
    public static final HashMap<String, Integer> h = new HashMap<>();
    public static final HashMap<String, Long> i = new HashMap<>();
    public static final HashMap<String, Float> j = new HashMap<>();
    public static Object k;
    public static boolean l;
    public static String[] m = new String[0];

    public static <T> T a(HashMap<String, T> hashMap, String str, T t) {
        synchronized (dl2.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            T t2 = hashMap.get(str);
            if (t2 != null) {
                t = t2;
            }
            return t;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008a, code lost:
        r14 = r14.query(defpackage.dl2.f853a, null, null, new java.lang.String[]{r15}, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0098, code lost:
        if (r14 == null) goto L_0x00b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009e, code lost:
        if (r14.moveToFirst() != false) goto L_0x00a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a1, code lost:
        r0 = r14.getString(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a5, code lost:
        if (r0 == null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ab, code lost:
        if (r0.equals(null) == false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ad, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ae, code lost:
        d(r1, r15, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b1, code lost:
        if (r0 == null) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00b3, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00b4, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00b7, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00b8, code lost:
        d(r1, r15, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00bb, code lost:
        if (r14 == null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00bd, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c0, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00c1, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c2, code lost:
        if (r14 != null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
        r14.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00c7, code lost:
        throw r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(android.content.ContentResolver r14, java.lang.String r15) {
        /*
        // Method dump skipped, instructions count: 203
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dl2.b(android.content.ContentResolver, java.lang.String):java.lang.String");
    }

    public static void c(ContentResolver contentResolver) {
        if (f == null) {
            e.set(false);
            f = new HashMap<>();
            k = new Object();
            l = false;
            contentResolver.registerContentObserver(f853a, true, new el2());
        } else if (e.getAndSet(false)) {
            f.clear();
            g.clear();
            h.clear();
            i.clear();
            j.clear();
            k = new Object();
            l = false;
        }
    }

    public static void d(Object obj, String str, String str2) {
        synchronized (dl2.class) {
            if (obj == k) {
                f.put(str, str2);
            }
        }
    }

    public static <T> void e(Object obj, HashMap<String, T> hashMap, String str, T t) {
        synchronized (dl2.class) {
            if (obj == k) {
                hashMap.put(str, t);
                f.remove(str);
            }
        }
    }
}
