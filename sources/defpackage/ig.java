package defpackage;

import android.app.Fragment;
import android.os.Build;

@Deprecated
/* renamed from: ig  reason: default package */
/* compiled from: FragmentCompat */
public class ig {

    /* renamed from: a  reason: collision with root package name */
    public static final e f1516a;

    /* renamed from: ig$a */
    /* compiled from: FragmentCompat */
    public static class a extends d {
        @Override // defpackage.ig.e
        public void a(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    /* renamed from: ig$b */
    /* compiled from: FragmentCompat */
    public static class b extends a {
    }

    /* renamed from: ig$c */
    /* compiled from: FragmentCompat */
    public static class c extends b {
        @Override // defpackage.ig.a, defpackage.ig.e
        public void a(Fragment fragment, boolean z) {
            fragment.setUserVisibleHint(z);
        }
    }

    /* renamed from: ig$d */
    /* compiled from: FragmentCompat */
    public static class d implements e {
    }

    /* renamed from: ig$e */
    /* compiled from: FragmentCompat */
    public interface e {
        void a(Fragment fragment, boolean z);
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            f1516a = new c();
        } else if (i >= 23) {
            f1516a = new b();
        } else {
            f1516a = new a();
        }
    }
}
