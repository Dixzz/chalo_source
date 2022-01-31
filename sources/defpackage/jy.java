package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: jy  reason: default package */
/* compiled from: LanguageChangeSplashBinding */
public final class jy implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final CoordinatorLayout f1994a;
    public final xw b;
    public final RecyclerView c;
    public final LinearLayout d;
    public final Toolbar e;

    public jy(CoordinatorLayout coordinatorLayout, xw xwVar, RecyclerView recyclerView, LinearLayout linearLayout, Toolbar toolbar, ImageView imageView) {
        this.f1994a = coordinatorLayout;
        this.b = xwVar;
        this.c = recyclerView;
        this.d = linearLayout;
        this.e = toolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f1994a;
    }
}
