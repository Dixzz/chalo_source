package defpackage;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: jk4  reason: default package */
/* compiled from: AppBarLayout */
public class jk4 implements m8 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f1948a;

    public jk4(AppBarLayout appBarLayout) {
        this.f1948a = appBarLayout;
    }

    @Override // defpackage.m8
    public c9 a(View view, c9 c9Var) {
        AppBarLayout appBarLayout = this.f1948a;
        Objects.requireNonNull(appBarLayout);
        AtomicInteger atomicInteger = r8.f3055a;
        c9 c9Var2 = appBarLayout.getFitsSystemWindows() ? c9Var : null;
        if (!Objects.equals(appBarLayout.l, c9Var2)) {
            appBarLayout.l = c9Var2;
            appBarLayout.g();
            appBarLayout.requestLayout();
        }
        return c9Var;
    }
}
