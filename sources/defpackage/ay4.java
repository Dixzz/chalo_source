package defpackage;

/* renamed from: ay4  reason: default package */
public final class ay4<ResultT> {

    /* renamed from: a  reason: collision with root package name */
    public final ey4<ResultT> f348a = new ey4<>();

    public final void a(Exception exc) {
        ey4<ResultT> ey4 = this.f348a;
        synchronized (ey4.f1045a) {
            if (!ey4.c) {
                ey4.c = true;
                ey4.e = exc;
                ey4.b.b(ey4);
            }
        }
    }

    public final void b(ResultT resultt) {
        ey4<ResultT> ey4 = this.f348a;
        synchronized (ey4.f1045a) {
            if (!ey4.c) {
                ey4.c = true;
                ey4.d = resultt;
                ey4.b.b(ey4);
            }
        }
    }
}
