package defpackage;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: ip  reason: default package */
/* compiled from: ViewPager2 */
public class ip implements RecyclerView.o {
    public ip(ViewPager2 viewPager2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void a(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void b(View view) {
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) nVar).width != -1 || ((ViewGroup.MarginLayoutParams) nVar).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }
}
