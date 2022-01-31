package defpackage;

import android.view.View;
import com.google.android.material.appbar.AppBarLayout;
import defpackage.g9;

/* renamed from: nk4  reason: default package */
/* compiled from: AppBarLayout */
public class nk4 implements g9 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f2568a;
    public final /* synthetic */ boolean b;

    public nk4(AppBarLayout.BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z) {
        this.f2568a = appBarLayout;
        this.b = z;
    }

    @Override // defpackage.g9
    public boolean a(View view, g9.a aVar) {
        this.f2568a.setExpanded(this.b);
        return true;
    }
}
