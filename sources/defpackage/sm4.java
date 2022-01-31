package defpackage;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: sm4  reason: default package */
/* compiled from: InsetDialogOnTouchListener */
public class sm4 implements View.OnTouchListener {
    public final Dialog f;
    public final int g;
    public final int h;
    public final int i;

    public sm4(Dialog dialog, Rect rect) {
        this.f = dialog;
        this.g = rect.left;
        this.h = rect.top;
        this.i = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = findViewById.getLeft() + this.g;
        int width = findViewById.getWidth() + left;
        int top = findViewById.getTop() + this.h;
        if (new RectF((float) left, (float) top, (float) width, (float) (findViewById.getHeight() + top)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i2 = this.i;
            obtain.setLocation((float) ((-i2) - 1), (float) ((-i2) - 1));
        }
        view.performClick();
        return this.f.onTouchEvent(obtain);
    }
}
