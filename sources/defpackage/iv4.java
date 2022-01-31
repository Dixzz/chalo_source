package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: iv4  reason: default package */
public final class iv4 extends ow4 implements kv4 {
    public iv4(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: mv4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.kv4
    public final void t2(String str, Bundle bundle, mv4 mv4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeStrongBinder(mv4);
        F(2, C);
    }
}
