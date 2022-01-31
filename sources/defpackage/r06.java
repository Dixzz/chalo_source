package defpackage;

import android.os.SystemClock;
import android.util.Log;

/* renamed from: r06  reason: default package */
/* compiled from: TimingMetric */
public class r06 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3021a;
    public final boolean b;
    public long c;
    public long d;

    public r06(String str, String str2) {
        this.f3021a = str;
        this.b = !Log.isLoggable(str2, 2);
    }

    public synchronized void a() {
        if (!this.b) {
            if (this.d == 0) {
                this.d = SystemClock.elapsedRealtime() - this.c;
            }
        }
    }
}
