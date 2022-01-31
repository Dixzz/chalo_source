package defpackage;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* renamed from: qr4  reason: default package */
public final class qr4 extends pr4<ParcelFileDescriptor> {
    public qr4(ur4 ur4, ay4<ParcelFileDescriptor> ay4) {
        super(ur4, ay4);
    }

    @Override // defpackage.pr4, defpackage.ax4
    public final void O2(Bundle bundle, Bundle bundle2) throws RemoteException {
        this.g.c.b();
        ur4.f.b(4, "onGetChunkFileDescriptor", new Object[0]);
        this.f.b((ParcelFileDescriptor) bundle.getParcelable("chunk_file_descriptor"));
    }
}
