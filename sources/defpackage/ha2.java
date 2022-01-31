package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;

/* renamed from: ha2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ha2 extends u92 {
    public final IBinder g;
    public final /* synthetic */ w72 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ha2(w72 w72, int i, IBinder iBinder, Bundle bundle) {
        super(w72, i, bundle);
        this.h = w72;
        this.g = iBinder;
    }

    @Override // defpackage.u92
    public final boolean d() {
        try {
            IBinder iBinder = this.g;
            Objects.requireNonNull(iBinder, "null reference");
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.h.getServiceDescriptor().equals(interfaceDescriptor)) {
                String.valueOf(this.h.getServiceDescriptor()).length();
                String.valueOf(interfaceDescriptor).length();
                return false;
            }
            IInterface createServiceInterface = this.h.createServiceInterface(this.g);
            if (createServiceInterface == null) {
                return false;
            }
            if (!w72.zzl(this.h, 2, 4, createServiceInterface) && !w72.zzl(this.h, 3, 4, createServiceInterface)) {
                return false;
            }
            this.h.zzB = null;
            Bundle connectionHint = this.h.getConnectionHint();
            if (this.h.zzw != null) {
                this.h.zzw.L(connectionHint);
            }
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // defpackage.u92
    public final void e(ConnectionResult connectionResult) {
        if (this.h.zzx != null) {
            this.h.zzx.F(connectionResult);
        }
        this.h.onConnectionFailed(connectionResult);
    }
}
