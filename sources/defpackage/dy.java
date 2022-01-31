package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.ui.views.MapCustomMyLocation;
import com.google.android.material.appbar.MaterialToolbar;

/* renamed from: dy  reason: default package */
/* compiled from: HomeScreenMapActivityBinding */
public final class dy implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f902a;
    public final MapCustomMyLocation b;
    public final MaterialToolbar c;

    public dy(ConstraintLayout constraintLayout, MapCustomMyLocation mapCustomMyLocation, FrameLayout frameLayout, MaterialToolbar materialToolbar) {
        this.f902a = constraintLayout;
        this.b = mapCustomMyLocation;
        this.c = materialToolbar;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f902a;
    }
}
