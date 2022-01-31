package defpackage;

import android.content.Context;

/* renamed from: wr  reason: default package */
/* compiled from: Trackers */
public class wr {
    public static wr e;

    /* renamed from: a  reason: collision with root package name */
    public qr f3829a;
    public rr b;
    public ur c;
    public vr d;

    public wr(Context context, pt ptVar) {
        Context applicationContext = context.getApplicationContext();
        this.f3829a = new qr(applicationContext, ptVar);
        this.b = new rr(applicationContext, ptVar);
        this.c = new ur(applicationContext, ptVar);
        this.d = new vr(applicationContext, ptVar);
    }

    public static synchronized wr a(Context context, pt ptVar) {
        wr wrVar;
        synchronized (wr.class) {
            if (e == null) {
                e = new wr(context, ptVar);
            }
            wrVar = e;
        }
        return wrVar;
    }
}
