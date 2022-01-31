package defpackage;

import android.view.View;

/* renamed from: dl  reason: default package */
/* compiled from: ViewBoundsCheck */
public class dl {

    /* renamed from: a  reason: collision with root package name */
    public final b f850a;
    public a b = new a();

    /* renamed from: dl$a */
    /* compiled from: ViewBoundsCheck */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f851a = 0;
        public int b;
        public int c;
        public int d;
        public int e;

        public boolean a() {
            int i = this.f851a;
            if ((i & 7) != 0 && (i & (b(this.d, this.b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f851a;
            if ((i2 & 112) != 0 && (i2 & (b(this.d, this.c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f851a;
            if ((i3 & 1792) != 0 && (i3 & (b(this.e, this.b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f851a;
            if ((i4 & 28672) == 0 || (i4 & (b(this.e, this.c) << 12)) != 0) {
                return true;
            }
            return false;
        }

        public int b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    /* renamed from: dl$b */
    /* compiled from: ViewBoundsCheck */
    public interface b {
        int a(View view);

        int b();

        int c();

        View d(int i);

        int e(View view);
    }

    public dl(b bVar) {
        this.f850a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int b2 = this.f850a.b();
        int c = this.f850a.c();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View d = this.f850a.d(i);
            int a2 = this.f850a.a(d);
            int e = this.f850a.e(d);
            a aVar = this.b;
            aVar.b = b2;
            aVar.c = c;
            aVar.d = a2;
            aVar.e = e;
            if (i3 != 0) {
                aVar.f851a = 0;
                aVar.f851a = i3 | 0;
                if (aVar.a()) {
                    return d;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.b;
                aVar2.f851a = 0;
                aVar2.f851a = i4 | 0;
                if (aVar2.a()) {
                    view = d;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean b(View view, int i) {
        a aVar = this.b;
        int b2 = this.f850a.b();
        int c = this.f850a.c();
        int a2 = this.f850a.a(view);
        int e = this.f850a.e(view);
        aVar.b = b2;
        aVar.c = c;
        aVar.d = a2;
        aVar.e = e;
        if (i == 0) {
            return false;
        }
        a aVar2 = this.b;
        aVar2.f851a = 0;
        aVar2.f851a = 0 | i;
        return aVar2.a();
    }
}
