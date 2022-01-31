package defpackage;

import android.content.Context;
import android.os.PowerManager;
import java.util.WeakHashMap;

/* renamed from: it  reason: default package */
/* compiled from: WakeLocks */
public class it {

    /* renamed from: a  reason: collision with root package name */
    public static final String f1571a = tp.e("WakeLocks");
    public static final WeakHashMap<PowerManager.WakeLock, String> b = new WeakHashMap<>();

    public static PowerManager.WakeLock a(Context context, String str) {
        String S = hj1.S("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, S);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = b;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, S);
        }
        return newWakeLock;
    }
}
