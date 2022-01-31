package defpackage;

/* renamed from: ea2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class ea2<TListener> {

    /* renamed from: a  reason: collision with root package name */
    public TListener f948a;
    public boolean b = false;
    public final /* synthetic */ w72 c;

    public ea2(w72 w72, TListener tlistener) {
        this.c = w72;
        this.f948a = tlistener;
    }

    public abstract void a();

    public abstract void b(TListener tlistener);

    public final void c() {
        synchronized (this) {
            this.f948a = null;
        }
        synchronized (this.c.zzt) {
            this.c.zzt.remove(this);
        }
    }
}
