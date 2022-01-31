package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: wq4  reason: default package */
public final /* synthetic */ class wq4 implements tv4 {

    /* renamed from: a  reason: collision with root package name */
    public static final tv4 f3827a = new wq4();

    @Override // defpackage.tv4
    public final Object a(IBinder iBinder) {
        int i = sw4.f;
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.play.core.appupdate.protocol.IAppUpdateService");
        return queryLocalInterface instanceof tw4 ? (tw4) queryLocalInterface : new rw4(iBinder);
    }
}
