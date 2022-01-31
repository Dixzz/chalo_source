package defpackage;

/* renamed from: vt1  reason: default package */
/* compiled from: StateVerifier */
public abstract class vt1 {

    /* renamed from: vt1$b */
    /* compiled from: StateVerifier */
    public static class b extends vt1 {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f3681a;

        public b() {
            super(null);
        }

        @Override // defpackage.vt1
        public void a() {
            if (this.f3681a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public vt1(a aVar) {
    }

    public abstract void a();
}
