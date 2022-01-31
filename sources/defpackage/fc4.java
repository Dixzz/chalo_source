package defpackage;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.Objects;

/* renamed from: fc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class fc4 implements Runnable {
    public final /* synthetic */ zzz f;
    public final /* synthetic */ ac4 g;

    public fc4(ac4 ac4, zzz zzz) {
        this.g = ac4;
        this.f = zzz;
    }

    public final void run() {
        this.g.f.R();
        if (this.f.h.l1() == null) {
            lg4 lg4 = this.g.f;
            zzz zzz = this.f;
            Objects.requireNonNull(lg4);
            zzn y = lg4.y(zzz.f);
            if (y != null) {
                lg4.F(zzz, y);
                return;
            }
            return;
        }
        lg4 lg42 = this.g.f;
        zzz zzz2 = this.f;
        Objects.requireNonNull(lg42);
        zzn y2 = lg42.y(zzz2.f);
        if (y2 != null) {
            lg42.p(zzz2, y2);
        }
    }
}
