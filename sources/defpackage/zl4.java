package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;

/* renamed from: zl4  reason: default package */
/* compiled from: MaterialCalendar */
public class zl4 extends RecyclerView.r {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ km4 f4187a;
    public final /* synthetic */ MaterialButton b;
    public final /* synthetic */ wl4 c;

    public zl4(wl4 wl4, km4 km4, MaterialButton materialButton) {
        this.c = wl4;
        this.f4187a = km4;
        this.b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        int i3;
        if (i < 0) {
            i3 = this.c.e().v1();
        } else {
            i3 = this.c.e().w1();
        }
        this.c.j = this.f4187a.c(i3);
        MaterialButton materialButton = this.b;
        km4 km4 = this.f4187a;
        materialButton.setText(km4.b.f.l(i3).j(km4.f2079a));
    }
}
