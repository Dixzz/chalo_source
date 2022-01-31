package defpackage;

import android.os.Looper;
import com.urbanairship.UAirship;

/* renamed from: lk5  reason: default package */
/* compiled from: UAirship */
public final class lk5 extends uj5 {
    public final /* synthetic */ UAirship.c m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public lk5(Looper looper, UAirship.c cVar) {
        super(looper);
        this.m = cVar;
    }

    @Override // defpackage.uj5
    public void d() {
        UAirship.c cVar = this.m;
        if (cVar != null) {
            cVar.a(UAirship.l());
        }
    }
}
