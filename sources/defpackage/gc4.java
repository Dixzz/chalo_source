package defpackage;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: gc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class gc4 implements Callable<List<zzz>> {
    public final /* synthetic */ zzn f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ ac4 i;

    public gc4(ac4 ac4, zzn zzn, String str, String str2) {
        this.i = ac4;
        this.f = zzn;
        this.g = str;
        this.h = str2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzz> call() throws Exception {
        this.i.f.R();
        return this.i.f.K().T(this.f.f, this.g, this.h);
    }
}
