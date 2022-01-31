package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.HashMap;
import java.util.Map;

/* renamed from: ni1  reason: default package */
/* compiled from: TimeLoggerUtil.kt */
public final class ni1 {

    /* renamed from: a  reason: collision with root package name */
    public long f2559a;
    public long b;
    public final HashMap<String, String> c = new HashMap<>();

    public final int a(long j) {
        double currentTimeMillis = ((double) (System.currentTimeMillis() - j)) / 100.0d;
        if (!Double.isNaN(currentTimeMillis)) {
            int i = Integer.MAX_VALUE;
            if (currentTimeMillis <= ((double) Integer.MAX_VALUE)) {
                i = currentTimeMillis < ((double) RtlSpacingHelper.UNDEFINED) ? RtlSpacingHelper.UNDEFINED : (int) Math.round(currentTimeMillis);
            }
            return i * 100;
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }

    public final void b(String str, Map<String, String> map) {
        n86.e(str, "eventName");
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            ed1.a(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, String> entry2 : this.c.entrySet()) {
            ed1.a(entry2.getKey(), entry2.getValue());
        }
        jz5.b().g(ed1);
    }
}
