package defpackage;

import android.os.DeadObjectException;
import android.os.IInterface;

/* renamed from: en3  reason: default package */
public final class en3 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dn3 f1004a;

    public en3(dn3 dn3) {
        this.f1004a = dn3;
    }

    public final IInterface a() throws DeadObjectException {
        return (jm3) this.f1004a.getService();
    }
}
