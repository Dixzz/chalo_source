package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.OverScroller;
import android.widget.ScrollView;
import app.zophop.R;
import java.util.List;

/* renamed from: ec1  reason: default package */
/* compiled from: CollapseOnScrollView */
public abstract class ec1 extends ScrollView {
    public static final /* synthetic */ int r = 0;
    public View f;
    public float g;
    public GestureDetector h = new GestureDetector(getContext(), new cc1(this));
    public a i = new a();
    public int j = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    public View k;
    public int l;
    public View m;
    public View n;
    public int o;
    public boolean p = true;
    public List<l90> q;

    /* renamed from: ec1$a */
    /* compiled from: CollapseOnScrollView */
    public class a implements Runnable {
        public final OverScroller f;
        public float g;

        public a() {
            this.f = new OverScroller(ec1.this.getContext());
        }

        public void run() {
            if (!this.f.isFinished()) {
                this.f.computeScrollOffset();
                float currY = this.g - ((float) this.f.getCurrY());
                int i = ec1.r;
                ec1.this.c((int) currY, false);
                this.g = (float) this.f.getCurrY();
                ec1.this.postOnAnimation(this);
            }
        }
    }

    public ec1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setVerticalScrollBarEnabled(false);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CollapseOnScrollView);
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        int resourceId3 = obtainStyledAttributes.getResourceId(2, -1);
        int resourceId4 = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        getViewTreeObserver().addOnGlobalLayoutListener(new dc1(this, resourceId, resourceId2, resourceId3, resourceId4));
    }

    public final boolean a() {
        if (this.n == null) {
            if (getScrollY() >= this.m.getBottom()) {
                return true;
            }
            return false;
        } else if (getScrollY() >= this.n.getTop()) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean b() {
        return getScrollY() <= 0;
    }

    public final void c(int i2, boolean z) {
        int i3;
        int i4;
        View view = this.k;
        if (view != null && z) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (i2 > 0 && (i4 = layoutParams.height) > 0) {
                int i5 = i4 - i2;
                layoutParams.height = i5;
                if (i5 < 0) {
                    i2 = -i5;
                    layoutParams.height = 0;
                } else {
                    i2 = 0;
                }
                this.k.setLayoutParams(layoutParams);
            } else if (i2 < 0 && layoutParams.height < this.l && b()) {
                ScrollView scrollView = getScrollView();
                this.f = scrollView;
                boolean z2 = true;
                if (!(scrollView == null || scrollView.getChildAt(0) == null || ((ScrollView) this.f).getChildAt(0).getTop() == 0)) {
                    z2 = false;
                }
                if (z2) {
                    int i6 = layoutParams.height - i2;
                    layoutParams.height = i6;
                    int i7 = this.l;
                    if (i6 > i7) {
                        layoutParams.height = i7;
                        i2 = -(i6 - i7);
                    } else {
                        i2 = 0;
                    }
                    this.k.setLayoutParams(layoutParams);
                }
            }
        }
        int scrollY = getScrollY();
        scrollBy(0, i2);
        if (a()) {
            View view2 = this.n;
            if (view2 == null) {
                scrollTo(0, this.m.getBottom());
            } else {
                scrollTo(0, view2.getTop());
            }
            i3 = (i2 + scrollY) - getScrollY();
        } else {
            i3 = b() ? i2 + scrollY : 0;
        }
        ScrollView scrollView2 = getScrollView();
        this.f = scrollView2;
        if (scrollView2 != null) {
            scrollView2.scrollTo(0, scrollView2.getScrollY() + i3);
        }
    }

    public boolean canScrollVertically(int i2) {
        if (i2 < 0) {
            return a();
        }
        return b();
    }

    public List<l90> getResultTabItems() {
        return this.q;
    }

    public abstract ScrollView getScrollView();

    public void onFinishInflate() {
        super.onFinishInflate();
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.p) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        if (action == 0) {
            this.g = y;
            if (!this.i.f.isFinished()) {
                this.i.f.forceFinished(true);
                return false;
            }
        } else if (action == 2 && Math.abs(this.g - y) > ((float) this.j)) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.p || this.h.onTouchEvent(motionEvent)) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.g = motionEvent.getY();
            return true;
        }
        if (motionEvent.getAction() == 2) {
            c(Math.round(this.g - motionEvent.getY()), true);
            this.g = motionEvent.getY();
        }
        return true;
    }

    public void setResultTabItems(List<l90> list) {
        this.q = list;
    }

    public void setScrollable(boolean z) {
        this.p = z;
    }
}
