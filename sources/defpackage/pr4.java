package defpackage;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.List;

/* renamed from: pr4  reason: default package */
public class pr4<T> extends zw4 {
    public final ay4<T> f;
    public final /* synthetic */ ur4 g;

    public pr4(ur4 ur4, ay4<T> ay4) {
        this.g = ur4;
        this.f = ay4;
    }

    public pr4(ur4 ur4, ay4 ay4, byte[] bArr) {
        this.g = ur4;
        this.f = ay4;
    }

    @Override // defpackage.ax4
    public void J2(Bundle bundle) {
        this.g.c.b();
        int i = bundle.getInt("error_code");
        ur4.f.b(6, "onError(%d)", new Object[]{Integer.valueOf(i)});
        this.f.a(new ir4(i));
    }

    @Override // defpackage.ax4
    public void O2(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.g.c.b();
        ur4.f.b(4, "onGetChunkFileDescriptor", new Object[0]);
    }

    @Override // defpackage.ax4
    public void b3(List<Bundle> list) {
        this.g.c.b();
        ur4.f.b(4, "onGetSessionStates", new Object[0]);
    }

    @Override // defpackage.ax4
    public void w2(Bundle bundle, Bundle bundle2) {
        this.g.d.b();
        ur4.f.b(4, "onKeepAlive(%b)", new Object[]{Boolean.valueOf(bundle.getBoolean("keep_alive"))});
    }

    public pr4(ur4 ur4, ay4 ay4, char[] cArr) {
        this.g = ur4;
        this.f = ay4;
    }

    public pr4(ur4 ur4, ay4 ay4, int[] iArr) {
        this.g = ur4;
        this.f = ay4;
    }
}
