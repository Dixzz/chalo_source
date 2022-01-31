package defpackage;

import android.os.RemoteException;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import defpackage.i12;

/* renamed from: rk2  reason: default package */
public final class rk2 extends l32<Status, vk2> {
    public final zze q;

    public rk2(zze zze, a32 a32) {
        super(i12.o, a32);
        this.q = zze;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ f32 d(Status status) {
        return status;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final /* synthetic */ void l(vk2 vk2) throws RemoteException {
        vk2 vk22 = vk2;
        uk2 uk2 = new uk2(this);
        try {
            zze zze = this.q;
            i12.c cVar = zze.o;
            if (cVar != null) {
                sk2 sk2 = zze.n;
                if (sk2.m.length == 0) {
                    sk2.m = cVar.zza();
                }
            }
            sk2 sk22 = zze.n;
            int c = sk22.c();
            byte[] bArr = new byte[c];
            ek2.b(sk22, bArr, c);
            zze.g = bArr;
            ((yk2) vk22.getService()).B0(uk2, this.q);
        } catch (RuntimeException unused) {
            n(new Status(10, "MessageProducer"));
        }
    }
}
