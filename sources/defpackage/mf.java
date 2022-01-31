package defpackage;

import androidx.fragment.app.Fragment;
import defpackage.zg;
import java.util.ArrayList;

/* renamed from: mf  reason: default package */
/* compiled from: FragmentTransaction */
public abstract class mf {

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<a> f2365a = new ArrayList<>();
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public boolean h = true;
    public String i;
    public int j;
    public CharSequence k;
    public int l;
    public CharSequence m;
    public ArrayList<String> n;
    public ArrayList<String> o;
    public boolean p = false;

    /* renamed from: mf$a */
    /* compiled from: FragmentTransaction */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f2366a;
        public Fragment b;
        public int c;
        public int d;
        public int e;
        public int f;
        public zg.b g;
        public zg.b h;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.f2366a = i;
            this.b = fragment;
            zg.b bVar = zg.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }

        public a(int i, Fragment fragment, zg.b bVar) {
            this.f2366a = i;
            this.b = fragment;
            this.g = fragment.mMaxState;
            this.h = bVar;
        }
    }

    public mf(df dfVar, ClassLoader classLoader) {
    }

    public void b(a aVar) {
        this.f2365a.add(aVar);
        aVar.c = this.b;
        aVar.d = this.c;
        aVar.e = this.d;
        aVar.f = this.e;
    }

    public mf c(String str) {
        if (this.h) {
            this.g = true;
            this.i = str;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    public abstract int d();

    public abstract void e();

    public abstract void f(int i2, Fragment fragment, String str, int i3);

    public mf g(int i2, Fragment fragment, String str) {
        if (i2 != 0) {
            f(i2, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }
}
