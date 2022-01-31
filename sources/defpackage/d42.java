package defpackage;

import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.Feature;
import defpackage.x22;
import defpackage.x22.b;

/* renamed from: d42  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class d42<A extends x22.b, ResultT> {
    private final Feature[] zaa;
    private final boolean zab;
    private final int zac;

    /* renamed from: d42$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static class a<A extends x22.b, ResultT> {

        /* renamed from: a  reason: collision with root package name */
        public z32<A, zi4<ResultT>> f784a;
        public boolean b = true;
        public Feature[] c;

        @RecentlyNonNull
        public d42<A, ResultT> a() {
            gj1.c(this.f784a != null, "execute parameter required");
            return new j62(this, this.c, this.b, 0);
        }
    }

    @Deprecated
    public d42() {
        this.zaa = null;
        this.zab = false;
        this.zac = 0;
    }

    public d42(Feature[] featureArr, boolean z, int i) {
        this.zaa = featureArr;
        boolean z2 = false;
        if (featureArr != null && z) {
            z2 = true;
        }
        this.zab = z2;
        this.zac = i;
    }

    @RecentlyNonNull
    public static <A extends x22.b, ResultT> a<A, ResultT> builder() {
        return new a<>();
    }

    public abstract void doExecute(@RecentlyNonNull A a2, @RecentlyNonNull zi4<ResultT> zi4) throws RemoteException;

    public boolean shouldAutoResolveMissingFeatures() {
        return this.zab;
    }

    @RecentlyNullable
    public final Feature[] zaa() {
        return this.zaa;
    }

    public final int zab() {
        return this.zac;
    }
}
