package app.zophop.utilities.ui.views.sliding_tabs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.models.TransitMode;
import app.zophop.utilities.R;
import java.util.Objects;

public class HorizontalTabScroll extends HorizontalScrollView {
    public int f;
    public int g;
    public int h;
    public boolean i;
    public View j = null;
    public int k = 0;
    public zf1 l;
    public SparseArray<String> m = new SparseArray<>();
    public final vg1 n;
    public int o;
    public int p;

    public class a implements View.OnClickListener {
        public a(tg1 tg1) {
        }

        public void onClick(View view) {
            for (int i = 0; i < HorizontalTabScroll.this.n.getChildCount(); i++) {
                if (view == HorizontalTabScroll.this.n.getChildAt(i)) {
                    HorizontalTabScroll horizontalTabScroll = HorizontalTabScroll.this;
                    horizontalTabScroll.k = i;
                    horizontalTabScroll.a(i, 0);
                    TextView textView = (TextView) HorizontalTabScroll.this.n.getChildAt(i).findViewById(HorizontalTabScroll.this.h);
                    ik0 ik0 = (ik0) HorizontalTabScroll.this.l;
                    ci1<TransitMode> ci1 = ik0.e;
                    if (ci1 != null) {
                        ci1.a(ik0.d.get(i));
                        return;
                    }
                    return;
                }
            }
        }
    }

    public HorizontalTabScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalTabScrollWithViewPager, 0, 0);
        this.o = obtainStyledAttributes.getColor(R.styleable.HorizontalTabScrollWithViewPager_tab_unselected, getResources().getColor(R.color.tab_unselected_color));
        this.p = obtainStyledAttributes.getColor(R.styleable.HorizontalTabScrollWithViewPager_tab_selected, -1);
        obtainStyledAttributes.recycle();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f = (int) (getResources().getDisplayMetrics().density * 24.0f);
        vg1 vg1 = new vg1(context);
        this.n = vg1;
        addView(vg1, -2, -2);
    }

    public final void a(int i2, int i3) {
        TextView textView;
        int childCount = this.n.getChildCount();
        if (childCount != 0 && i2 >= 0 && i2 < childCount) {
            vg1 vg1 = this.n;
            vg1.j = i2;
            vg1.k = 0.0f;
            vg1.invalidate();
            int i4 = 0;
            while (i4 < this.n.getChildCount()) {
                this.n.getChildAt(i4).setSelected(i2 == i4);
                boolean z = i2 == i4;
                if (this.h != 0) {
                    textView = (TextView) this.n.getChildAt(i4).findViewById(this.h);
                } else {
                    textView = (TextView) this.n.getChildAt(i4);
                }
                Objects.requireNonNull(this.l);
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                textView.setTextSize(14.0f);
                if (z) {
                    textView.setTextColor(this.p);
                } else {
                    textView.setTextColor(this.o);
                }
                i4++;
            }
            View childAt = this.n.getChildAt(i2);
            if (childAt != null) {
                if (i3 == 0 && childAt != this.j) {
                    childAt.setSelected(true);
                    View view = this.j;
                    if (view != null) {
                        view.setSelected(false);
                    }
                    this.j = childAt;
                    this.k = i2;
                }
                int left = childAt.getLeft() + i3;
                if (i2 > 0 || i3 > 0) {
                    left -= this.f;
                }
                scrollTo(left, 0);
            }
        }
    }

    public zf1 getAdapter() {
        return this.l;
    }

    public int getSelectedPosition() {
        return this.k;
    }

    public void setAdapter(zf1 zf1) {
        TextView textView;
        TextView textView2;
        this.n.removeAllViews();
        this.l = zf1;
        if (zf1 != null) {
            View view = this.j;
            if (view != null) {
                view.setSelected(false);
            }
            this.j = null;
            zf1 zf12 = this.l;
            a aVar = new a(null);
            for (int i2 = 0; i2 < zf12.d(); i2++) {
                if (this.g != 0) {
                    textView2 = LayoutInflater.from(getContext()).inflate(this.g, (ViewGroup) this.n, false);
                    textView = (TextView) textView2.findViewById(this.h);
                } else {
                    textView2 = null;
                    textView = null;
                }
                if (textView2 == null) {
                    TextView textView3 = new TextView(getContext());
                    textView3.setGravity(17);
                    textView3.setTextSize(2, 12.0f);
                    textView3.setTypeface(Typeface.DEFAULT_BOLD);
                    textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    getContext().getTheme().resolveAttribute(16843534, new TypedValue(), true);
                    textView3.setAllCaps(true);
                    int i3 = (int) (getResources().getDisplayMetrics().density * 16.0f);
                    textView3.setPadding(i3, i3, i3, i3);
                    textView2 = textView3;
                }
                if (textView == null && (textView2 instanceof TextView)) {
                    textView = (TextView) textView2;
                }
                textView.setText(zf12.e(i2));
                textView2.setOnClickListener(aVar);
                String str = this.m.get(i2, null);
                if (str != null) {
                    textView2.setContentDescription(str);
                }
                this.n.addView(textView2);
                if (i2 == this.k) {
                    textView2.setSelected(true);
                }
            }
            postDelayed(new tg1(this), 1000);
        }
    }

    public void setCustomTabColorizer(bg1 bg1) {
        this.n.setCustomTabColorizer(bg1);
    }

    public void setDistributeEvenly(boolean z) {
        this.i = z;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.n.setSelectedIndicatorColors(iArr);
    }
}
