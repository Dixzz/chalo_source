package defpackage;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* renamed from: hp4  reason: default package */
/* compiled from: TabLayout */
public class hp4 implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ View f1409a;
    public final /* synthetic */ TabLayout.i b;

    public hp4(TabLayout.i iVar, View view) {
        this.b = iVar;
        this.f1409a = view;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f1409a.getVisibility() == 0) {
            TabLayout.i iVar = this.b;
            View view2 = this.f1409a;
            int i9 = TabLayout.i.q;
            iVar.e(view2);
        }
    }
}
