package defpackage;

import android.view.View;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ok4  reason: default package */
/* compiled from: CollapsingToolbarLayout */
public class ok4 implements m8 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollapsingToolbarLayout f2705a;

    public ok4(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.f2705a = collapsingToolbarLayout;
    }

    @Override // defpackage.m8
    public c9 a(View view, c9 c9Var) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.f2705a;
        Objects.requireNonNull(collapsingToolbarLayout);
        AtomicInteger atomicInteger = r8.f3055a;
        c9 c9Var2 = collapsingToolbarLayout.getFitsSystemWindows() ? c9Var : null;
        if (!Objects.equals(collapsingToolbarLayout.B, c9Var2)) {
            collapsingToolbarLayout.B = c9Var2;
            collapsingToolbarLayout.requestLayout();
        }
        return c9Var.a();
    }
}
