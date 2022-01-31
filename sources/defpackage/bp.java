package defpackage;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;

/* renamed from: bp  reason: default package */
/* compiled from: AnimateLayoutChangeDetector */
public final class bp {
    public static final ViewGroup.MarginLayoutParams b;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayoutManager f459a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public bp(LinearLayoutManager linearLayoutManager) {
        this.f459a = linearLayoutManager;
    }

    public static boolean a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
