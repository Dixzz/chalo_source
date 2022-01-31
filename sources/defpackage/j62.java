package defpackage;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import defpackage.d42;
import defpackage.x22;

/* renamed from: j62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class j62 extends d42 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d42.a f1883a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j62(d42.a aVar, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.f1883a = aVar;
    }

    @Override // defpackage.d42
    public final void doExecute(x22.b bVar, zi4 zi4) throws RemoteException {
        this.f1883a.f784a.accept(bVar, zi4);
    }
}
