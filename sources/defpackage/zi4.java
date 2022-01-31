package defpackage;

import androidx.annotation.RecentlyNonNull;
import java.util.Objects;

/* renamed from: zi4  reason: default package */
/* compiled from: com.google.android.gms:play-services-tasks@@17.2.1 */
public class zi4<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final wj4<TResult> f4178a = new wj4<>();

    public boolean a(@RecentlyNonNull Exception exc) {
        wj4<TResult> wj4 = this.f4178a;
        Objects.requireNonNull(wj4);
        gj1.l(exc, "Exception must not be null");
        synchronized (wj4.f3791a) {
            if (wj4.c) {
                return false;
            }
            wj4.c = true;
            wj4.f = exc;
            wj4.b.b(wj4);
            return true;
        }
    }

    public boolean b(TResult tresult) {
        wj4<TResult> wj4 = this.f4178a;
        synchronized (wj4.f3791a) {
            if (wj4.c) {
                return false;
            }
            wj4.c = true;
            wj4.e = tresult;
            wj4.b.b(wj4);
            return true;
        }
    }
}
