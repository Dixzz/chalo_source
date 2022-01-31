package defpackage;

import com.google.android.gms.measurement.internal.zzn;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: oc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class oc4 implements Callable<List<vg4>> {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ ac4 g;

    public oc4(ac4 ac4, zzn zzn) {
        this.g = ac4;
        this.f = zzn;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<vg4> call() throws Exception {
        this.g.f.R();
        return this.g.f.K().B(this.f.f);
    }
}
