package defpackage;

import java.util.concurrent.Callable;

/* renamed from: fc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class fc2 extends gc2 {
    public final Callable<String> e;

    public /* synthetic */ fc2(Callable callable) {
        super(false, null, null);
        this.e = callable;
    }

    @Override // defpackage.gc2
    public final String a() {
        try {
            return this.e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
