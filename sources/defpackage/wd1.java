package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import defpackage.d8;

/* renamed from: wd1  reason: default package */
/* compiled from: TouchableWrapper */
public class wd1 extends FrameLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    public long f = 0;
    public a g;
    public d8 h;

    /* renamed from: wd1$a */
    /* compiled from: TouchableWrapper */
    public interface a {
        void b0();

        void c0();
    }

    public wd1(Context context) {
        super(context);
        try {
            this.g = (a) context;
            d8 d8Var = new d8(context, this);
            this.h = d8Var;
            ((d8.b) d8Var.f806a).f807a.setOnDoubleTapListener(this);
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement UpdateMapAfterUserInterection");
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ((d8.b) this.h.f806a).f807a.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f = SystemClock.uptimeMillis();
        } else if (action != 1) {
            if (action == 2) {
                this.g.c0();
            }
        } else if (SystemClock.uptimeMillis() - this.f > 0) {
            this.g.c0();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        this.g.b0();
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }
}
