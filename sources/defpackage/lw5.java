package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import java.net.URL;
import java.util.concurrent.Callable;

/* renamed from: lw5  reason: default package */
/* compiled from: NotificationUtils */
public final class lw5 implements Callable<Bitmap> {
    public final /* synthetic */ Context f;
    public final /* synthetic */ URL g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;

    public lw5(Context context, URL url, int i2, int i3) {
        this.f = context;
        this.g = url;
        this.h = i2;
        this.i = i3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Bitmap call() throws Exception {
        return qy5.d(this.f, this.g, this.h, this.i);
    }
}
