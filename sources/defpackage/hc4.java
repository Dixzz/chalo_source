package defpackage;

import java.util.List;
import java.util.concurrent.Callable;

/* renamed from: hc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class hc4 implements Callable<List<vg4>> {
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ ac4 i;

    public hc4(ac4 ac4, String str, String str2, String str3) {
        this.i = ac4;
        this.f = str;
        this.g = str2;
        this.h = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<vg4> call() throws Exception {
        this.i.f.R();
        return this.i.f.K().D(this.f, this.g, this.h);
    }
}
