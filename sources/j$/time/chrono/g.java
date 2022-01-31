package j$.time.chrono;

import j$.time.ZoneId;
import j$.time.chrono.c;
import j$.time.e;
import j$.time.h;

public interface g<D extends c> extends Object, Comparable<g<?>> {

    /* access modifiers changed from: package-private */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1594a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                j$.time.temporal.h.values()
                r0 = 30
                int[] r0 = new int[r0]
                j$.time.chrono.g.a.f1594a = r0
                j$.time.temporal.h r1 = j$.time.temporal.h.INSTANT_SECONDS     // Catch:{ NoSuchFieldError -> 0x0010 }
                r1 = 28
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                int[] r0 = j$.time.chrono.g.a.f1594a     // Catch:{ NoSuchFieldError -> 0x0019 }
                j$.time.temporal.h r1 = j$.time.temporal.h.OFFSET_SECONDS     // Catch:{ NoSuchFieldError -> 0x0019 }
                r1 = 29
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.g.a.<clinit>():void");
        }
    }

    i a();

    e b();

    c c();

    h f();

    ZoneId k();

    d q();

    long u();
}
