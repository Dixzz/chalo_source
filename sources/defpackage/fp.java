package defpackage;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: fp  reason: default package */
/* compiled from: ScrollEventAdapter */
public final class fp extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    public ViewPager2.e f1153a;
    public final ViewPager2 b;
    public final RecyclerView c;
    public final LinearLayoutManager d;
    public int e;
    public int f;
    public a g = new a();
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    /* renamed from: fp$a */
    /* compiled from: ScrollEventAdapter */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1154a;
        public float b;
        public int c;

        public void a() {
            this.f1154a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    public fp(ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.o;
        this.c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        c();
    }

    public final void a(int i2) {
        ViewPager2.e eVar = this.f1153a;
        if (eVar != null) {
            eVar.c(i2);
        }
    }

    public final void b(int i2) {
        if ((this.e != 3 || this.f != 0) && this.f != i2) {
            this.f = i2;
            ViewPager2.e eVar = this.f1153a;
            if (eVar != null) {
                eVar.a(i2);
            }
        }
    }

    public final void c() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012d, code lost:
        if (r4[r2 - 1][1] >= r3) goto L_0x0130;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0157 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
        // Method dump skipped, instructions count: 393
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fp.d():void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        ViewPager2.e eVar;
        int i3 = this.e;
        boolean z = true;
        if (!(i3 == 1 && this.f == 1) && i2 == 1) {
            this.m = false;
            this.e = 1;
            int i4 = this.i;
            if (i4 != -1) {
                this.h = i4;
                this.i = -1;
            } else if (this.h == -1) {
                this.h = this.d.v1();
            }
            b(1);
            return;
        }
        if (!(i3 == 1 || i3 == 4) || i2 != 2) {
            if ((i3 == 1 || i3 == 4) && i2 == 0) {
                d();
                if (!this.k) {
                    int i5 = this.g.f1154a;
                    if (!(i5 == -1 || (eVar = this.f1153a) == null)) {
                        eVar.b(i5, 0.0f, 0);
                    }
                } else {
                    a aVar = this.g;
                    if (aVar.c == 0) {
                        int i6 = this.h;
                        int i7 = aVar.f1154a;
                        if (i6 != i7) {
                            a(i7);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    b(0);
                    c();
                }
            }
            if (this.e == 2 && i2 == 0 && this.l) {
                d();
                a aVar2 = this.g;
                if (aVar2.c == 0) {
                    int i8 = this.i;
                    int i9 = aVar2.f1154a;
                    if (i8 != i9) {
                        if (i9 == -1) {
                            i9 = 0;
                        }
                        a(i9);
                    }
                    b(0);
                    c();
                }
            }
        } else if (this.k) {
            b(2);
            this.j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r6 < 0) == r4.b.a()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.r
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fp.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
