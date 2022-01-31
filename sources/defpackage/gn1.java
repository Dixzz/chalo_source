package defpackage;

/* renamed from: gn1  reason: default package */
/* compiled from: DiskCacheStrategy */
public abstract class gn1 {

    /* renamed from: a  reason: collision with root package name */
    public static final gn1 f1286a = new a();
    public static final gn1 b = new b();
    public static final gn1 c = new c();

    /* renamed from: gn1$a */
    /* compiled from: DiskCacheStrategy */
    public static class a extends gn1 {
        @Override // defpackage.gn1
        public boolean a() {
            return false;
        }

        @Override // defpackage.gn1
        public boolean b() {
            return false;
        }

        @Override // defpackage.gn1
        public boolean c(xl1 xl1) {
            return false;
        }

        @Override // defpackage.gn1
        public boolean d(boolean z, xl1 xl1, zl1 zl1) {
            return false;
        }
    }

    /* renamed from: gn1$b */
    /* compiled from: DiskCacheStrategy */
    public static class b extends gn1 {
        @Override // defpackage.gn1
        public boolean a() {
            return true;
        }

        @Override // defpackage.gn1
        public boolean b() {
            return false;
        }

        @Override // defpackage.gn1
        public boolean c(xl1 xl1) {
            return (xl1 == xl1.DATA_DISK_CACHE || xl1 == xl1.MEMORY_CACHE) ? false : true;
        }

        @Override // defpackage.gn1
        public boolean d(boolean z, xl1 xl1, zl1 zl1) {
            return false;
        }
    }

    /* renamed from: gn1$c */
    /* compiled from: DiskCacheStrategy */
    public static class c extends gn1 {
        @Override // defpackage.gn1
        public boolean a() {
            return true;
        }

        @Override // defpackage.gn1
        public boolean b() {
            return true;
        }

        @Override // defpackage.gn1
        public boolean c(xl1 xl1) {
            return xl1 == xl1.REMOTE;
        }

        @Override // defpackage.gn1
        public boolean d(boolean z, xl1 xl1, zl1 zl1) {
            return ((z && xl1 == xl1.DATA_DISK_CACHE) || xl1 == xl1.LOCAL) && zl1 == zl1.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(xl1 xl1);

    public abstract boolean d(boolean z, xl1 xl1, zl1 zl1);
}
