package defpackage;

import com.urbanairship.UAirship;
import java.util.concurrent.Callable;

/* renamed from: dy5  reason: default package */
/* compiled from: AirshipComponentUtils */
public final class dy5 implements Callable<T> {
    public final /* synthetic */ Class f;

    public dy5(Class cls) {
        this.f = cls;
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        return UAirship.l().k(this.f);
    }
}
