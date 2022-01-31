package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: ww4  reason: default package */
public final class ww4 extends ow4 implements yw4 {
    public ww4(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void V(String str, Bundle bundle, Bundle bundle2, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeInt(1);
        bundle2.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(7, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void W(String str, List<Bundle> list, Bundle bundle, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        C.writeTypedList(list);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(14, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void Z2(String str, Bundle bundle, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(5, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void f1(String str, Bundle bundle, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(10, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void h1(String str, Bundle bundle, Bundle bundle2, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeInt(1);
        bundle2.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(11, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void r3(String str, Bundle bundle, Bundle bundle2, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeInt(1);
        bundle2.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(6, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: ax4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.yw4
    public final void t0(String str, Bundle bundle, Bundle bundle2, ax4 ax4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeInt(1);
        bundle2.writeToParcel(C, 0);
        C.writeStrongBinder(ax4);
        F(9, C);
    }
}
