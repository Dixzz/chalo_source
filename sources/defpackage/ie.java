package defpackage;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* renamed from: ie  reason: default package */
/* compiled from: DrawerLayout */
public class ie implements View.OnApplyWindowInsetsListener {
    public ie(DrawerLayout drawerLayout) {
    }

    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        boolean z = true;
        boolean z2 = windowInsets.getSystemWindowInsetTop() > 0;
        drawerLayout.C = windowInsets;
        drawerLayout.D = z2;
        if (z2 || drawerLayout.getBackground() != null) {
            z = false;
        }
        drawerLayout.setWillNotDraw(z);
        drawerLayout.requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }
}
