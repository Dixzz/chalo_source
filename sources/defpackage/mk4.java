package defpackage;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.g9;

/* renamed from: mk4  reason: default package */
/* compiled from: AppBarLayout */
public class mk4 implements g9 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f2391a;
    public final /* synthetic */ AppBarLayout b;
    public final /* synthetic */ View c;
    public final /* synthetic */ int d;
    public final /* synthetic */ AppBarLayout.BaseBehavior e;

    public mk4(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i) {
        this.e = baseBehavior;
        this.f2391a = coordinatorLayout;
        this.b = appBarLayout;
        this.c = view;
        this.d = i;
    }

    @Override // defpackage.g9
    public boolean a(View view, g9.a aVar) {
        this.e.K(this.f2391a, this.b, this.c, this.d, new int[]{0, 0});
        return true;
    }
}
