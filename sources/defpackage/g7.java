package defpackage;

import android.content.Context;
import defpackage.i7;
import java.util.concurrent.Callable;

/* renamed from: g7  reason: default package */
/* compiled from: FontRequestWorker */
public class g7 implements Callable<i7.a> {
    public final /* synthetic */ String f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ d7 h;
    public final /* synthetic */ int i;

    public g7(String str, Context context, d7 d7Var, int i2) {
        this.f = str;
        this.g = context;
        this.h = d7Var;
        this.i = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public i7.a call() throws Exception {
        return i7.a(this.f, this.g, this.h, this.i);
    }
}
