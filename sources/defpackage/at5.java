package defpackage;

import android.graphics.Outline;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewOutlineProvider;

/* renamed from: at5  reason: default package */
/* compiled from: ClippableViewDelegate */
public class at5 {

    /* renamed from: at5$a */
    /* compiled from: ClippableViewDelegate */
    public class a extends ViewOutlineProvider {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ float f330a;

        public a(at5 at5, float f) {
            this.f330a = f;
        }

        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getRight() - view.getLeft(), view.getBottom() - view.getTop(), this.f330a);
        }
    }

    public void a(View view, float f) {
        float applyDimension = TypedValue.applyDimension(1, f, view.getResources().getDisplayMetrics());
        if (applyDimension == 0.0f) {
            view.setClipToOutline(false);
            view.setOutlineProvider(ViewOutlineProvider.BOUNDS);
            return;
        }
        view.setClipToOutline(true);
        view.setOutlineProvider(new a(this, applyDimension));
    }
}
