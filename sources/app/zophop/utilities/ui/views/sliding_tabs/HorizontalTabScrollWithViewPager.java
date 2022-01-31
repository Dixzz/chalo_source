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
import androidx.viewpager.widget.ViewPager;
import app.zophop.utilities.R;
import java.util.Objects;

public class HorizontalTabScrollWithViewPager extends HorizontalScrollView {
    public static final /* synthetic */ int s = 0;
    public int f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k = -1;
    public ViewPager l;
    public xf1 m;
    public SparseArray<String> n = new SparseArray<>();
    public ViewPager.i o;
    public final vg1 p;
    public int q;
    public int r;

    public class a implements ViewPager.i {

        /* renamed from: a  reason: collision with root package name */
        public int f319a;

        public a(ug1 ug1) {
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void a(int i, float f, int i2) {
            HorizontalTabScrollWithViewPager horizontalTabScrollWithViewPager = HorizontalTabScrollWithViewPager.this;
            int i3 = HorizontalTabScrollWithViewPager.s;
            Objects.requireNonNull(horizontalTabScrollWithViewPager);
            int childCount = HorizontalTabScrollWithViewPager.this.p.getChildCount();
            if (childCount != 0 && i >= 0 && i < childCount) {
                vg1 vg1 = HorizontalTabScrollWithViewPager.this.p;
                vg1.j = i;
                vg1.k = f;
                vg1.invalidate();
                View childAt = HorizontalTabScrollWithViewPager.this.p.getChildAt(i);
                HorizontalTabScrollWithViewPager.this.b(i, childAt != null ? (int) (((float) childAt.getWidth()) * f) : 0);
                ViewPager.i iVar = HorizontalTabScrollWithViewPager.this.o;
                if (iVar != null) {
                    iVar.a(i, f, i2);
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void b(int i) {
            this.f319a = i;
            ViewPager.i iVar = HorizontalTabScrollWithViewPager.this.o;
            if (iVar != null) {
                iVar.b(i);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.i
        public void c(int i) {
            HorizontalTabScrollWithViewPager horizontalTabScrollWithViewPager = HorizontalTabScrollWithViewPager.this;
            int i2 = HorizontalTabScrollWithViewPager.s;
            Objects.requireNonNull(horizontalTabScrollWithViewPager);
            if (this.f319a == 0) {
                vg1 vg1 = HorizontalTabScrollWithViewPager.this.p;
                vg1.j = i;
                vg1.k = 0.0f;
                vg1.invalidate();
                HorizontalTabScrollWithViewPager.this.b(i, 0);
            }
            int i3 = 0;
            while (i3 < HorizontalTabScrollWithViewPager.this.p.getChildCount()) {
                HorizontalTabScrollWithViewPager.this.p.getChildAt(i3).setSelected(i == i3);
                i3++;
            }
            ViewPager.i iVar = HorizontalTabScrollWithViewPager.this.o;
            if (iVar != null) {
                iVar.c(i);
            }
            jz5.b().i(new rd1());
        }
    }

    public class b implements View.OnClickListener {
        public b(ug1 ug1) {
        }

        public void onClick(View view) {
            for (int i = 0; i < HorizontalTabScrollWithViewPager.this.p.getChildCount(); i++) {
                if (view == HorizontalTabScrollWithViewPager.this.p.getChildAt(i)) {
                    HorizontalTabScrollWithViewPager.this.l.setCurrentItem(i);
                    return;
                }
            }
        }
    }

    public HorizontalTabScrollWithViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setDistributeEvenly(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HorizontalTabScrollWithViewPager, 0, 0);
        this.q = obtainStyledAttributes.getColor(R.styleable.HorizontalTabScrollWithViewPager_tab_unselected, getResources().getColor(R.color.tab_unselected_color));
        this.r = obtainStyledAttributes.getColor(R.styleable.HorizontalTabScrollWithViewPager_tab_selected, -1);
        obtainStyledAttributes.recycle();
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        this.f = (int) (getResources().getDisplayMetrics().density * 24.0f);
        vg1 vg1 = new vg1(context);
        this.p = vg1;
        addView(vg1, -2, -2);
    }

    public final void a() {
        View childAt;
        TextView textView;
        int i2 = this.k;
        if (i2 != -1 && (childAt = this.p.getChildAt(i2)) != null) {
            int i3 = this.h;
            if (i3 != 0) {
                textView = (TextView) childAt.findViewById(i3);
            } else {
                textView = (TextView) childAt;
            }
            textView.setSelected(false);
            textView.setTextColor(this.q);
            textView.setCompoundDrawablesWithIntrinsicBounds(this.m.a(this.k, false), 0, 0, 0);
        }
    }

    public final void b(int i2, int i3) {
        TextView textView;
        int childCount = this.p.getChildCount();
        if (childCount != 0 && i2 >= 0 && i2 < childCount) {
            View childAt = this.p.getChildAt(i2);
            View view = null;
            int i4 = this.k;
            if (i4 != -1) {
                view = this.p.getChildAt(i4);
            }
            if (childAt != null) {
                if (i3 == 0 && childAt != view) {
                    a();
                    this.k = i2;
                    View childAt2 = this.p.getChildAt(i2);
                    if (childAt2 != null) {
                        int i5 = this.h;
                        if (i5 != 0) {
                            textView = (TextView) childAt2.findViewById(i5);
                        } else {
                            textView = (TextView) childAt2;
                        }
                        textView.setSelected(true);
                        textView.setTextColor(this.r);
                        textView.setCompoundDrawablesWithIntrinsicBounds(this.m.a(this.k, true), 0, 0, 0);
                    }
                }
                int left = childAt.getLeft() + i3;
                if (i2 > 0 || i3 > 0) {
                    left -= this.f;
                }
                scrollTo(left, 0);
            }
        }
    }

    public void c(int i2, int i3) {
        this.g = i2;
        this.h = i3;
        setDistributeEvenly(true);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewPager viewPager = this.l;
        if (viewPager != null) {
            b(viewPager.getCurrentItem(), 0);
        }
    }

    public void setCustomTabColorizer(bg1 bg1) {
        this.p.setCustomTabColorizer(bg1);
    }

    public void setDistributeEvenly(boolean z) {
        this.i = z;
    }

    public void setDistributeSkewed(boolean z) {
        this.j = z;
    }

    public void setOnPageChangeListener(ViewPager.i iVar) {
        this.o = iVar;
    }

    public void setSelectedIndicatorColors(int... iArr) {
        this.p.setSelectedIndicatorColors(iArr);
    }

    public void setViewPager(ViewPager viewPager) {
        TextView textView;
        TextView textView2;
        this.p.removeAllViews();
        this.l = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new a(null));
            this.m = (xf1) viewPager.getAdapter();
            a();
            this.k = -1;
            ro adapter = this.l.getAdapter();
            b bVar = new b(null);
            for (int i2 = 0; i2 < adapter.d(); i2++) {
                if (this.g != 0) {
                    textView2 = LayoutInflater.from(getContext()).inflate(this.g, (ViewGroup) this.p, false);
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
                if (this.j) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView2.getLayoutParams();
                    layoutParams.width = 0;
                    if (i2 == 0) {
                        layoutParams.weight = 2.0f;
                    } else {
                        layoutParams.weight = 1.0f;
                    }
                }
                textView.setText(adapter.e(i2));
                textView.setCompoundDrawablesWithIntrinsicBounds(this.m.a(i2, false), 0, 0, 0);
                textView2.setOnClickListener(bVar);
                String str = this.n.get(i2, null);
                if (str != null) {
                    textView2.setContentDescription(str);
                }
                this.p.addView(textView2);
                if (i2 == this.l.getCurrentItem()) {
                    textView2.setSelected(true);
                }
            }
            postDelayed(new ug1(this), 1000);
            return;
        }
        this.m = null;
    }
}
