package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* renamed from: fp4  reason: default package */
/* compiled from: TabIndicatorInterpolator */
public class fp4 {
    public static RectF a(TabLayout tabLayout, View view) {
        if (view == null) {
            return new RectF();
        }
        if (tabLayout.G || !(view instanceof TabLayout.i)) {
            return new RectF((float) view.getLeft(), (float) view.getTop(), (float) view.getRight(), (float) view.getBottom());
        }
        TabLayout.i iVar = (TabLayout.i) view;
        int contentWidth = iVar.getContentWidth();
        int contentHeight = iVar.getContentHeight();
        int K0 = (int) hd3.K0(iVar.getContext(), 24);
        if (contentWidth < K0) {
            contentWidth = K0;
        }
        int right = (iVar.getRight() + iVar.getLeft()) / 2;
        int bottom = (iVar.getBottom() + iVar.getTop()) / 2;
        int i = contentWidth / 2;
        return new RectF((float) (right - i), (float) (bottom - (contentHeight / 2)), (float) (i + right), (float) ((right / 2) + bottom));
    }

    public void b(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        RectF a2 = a(tabLayout, view);
        RectF a3 = a(tabLayout, view2);
        drawable.setBounds(zj4.a((int) a2.left, (int) a3.left, f), drawable.getBounds().top, zj4.a((int) a2.right, (int) a3.right, f), drawable.getBounds().bottom);
    }
}
