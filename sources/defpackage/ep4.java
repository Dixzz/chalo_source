package defpackage;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* renamed from: ep4  reason: default package */
/* compiled from: ElasticTabIndicatorInterpolator */
public class ep4 extends fp4 {
    public static float c(float f) {
        return (float) (1.0d - Math.cos((((double) f) * 3.141592653589793d) / 2.0d));
    }

    @Override // defpackage.fp4
    public void b(TabLayout tabLayout, View view, View view2, float f, Drawable drawable) {
        float f2;
        float f3;
        RectF a2 = fp4.a(tabLayout, view);
        RectF a3 = fp4.a(tabLayout, view2);
        if (a2.left < a3.left) {
            f3 = c(f);
            f2 = (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
        } else {
            f3 = (float) Math.sin((((double) f) * 3.141592653589793d) / 2.0d);
            f2 = c(f);
        }
        drawable.setBounds(zj4.a((int) a2.left, (int) a3.left, f3), drawable.getBounds().top, zj4.a((int) a2.right, (int) a3.right, f2), drawable.getBounds().bottom);
    }
}
