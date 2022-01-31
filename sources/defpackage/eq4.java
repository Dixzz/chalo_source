package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import defpackage.ko4;
import defpackage.m4;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: eq4  reason: default package */
/* compiled from: RadialViewGroup */
public class eq4 extends ConstraintLayout {
    public final Runnable w;
    public int x;
    public ho4 y;

    /* renamed from: eq4$a */
    /* compiled from: RadialViewGroup */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            eq4.this.j();
        }
    }

    public eq4(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (view.getId() == -1) {
            AtomicInteger atomicInteger = r8.f3055a;
            view.setId(View.generateViewId());
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.w);
            handler.post(this.w);
        }
    }

    public void j() {
        int childCount = getChildCount();
        int i = 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            if ("skip".equals(getChildAt(i2).getTag())) {
                i++;
            }
        }
        m4 m4Var = new m4();
        m4Var.b(this);
        float f = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id = childAt.getId();
            int i4 = R.id.circle_center;
            if (id != i4 && !"skip".equals(childAt.getTag())) {
                int id2 = childAt.getId();
                int i5 = this.x;
                if (!m4Var.c.containsKey(Integer.valueOf(id2))) {
                    m4Var.c.put(Integer.valueOf(id2), new m4.a());
                }
                m4.b bVar = m4Var.c.get(Integer.valueOf(id2)).d;
                bVar.x = i4;
                bVar.y = i5;
                bVar.z = f;
                f = (360.0f / ((float) (childCount - i))) + f;
            }
        }
        m4Var.a(this, true);
        setConstraintSet(null);
        requestLayout();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        j();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.w);
            handler.post(this.w);
        }
    }

    public void setBackgroundColor(int i) {
        this.y.q(ColorStateList.valueOf(i));
    }

    public eq4(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.material_radial_view_group, this);
        ho4 ho4 = new ho4();
        this.y = ho4;
        io4 io4 = new io4(0.5f);
        ko4 ko4 = ho4.f.f1403a;
        Objects.requireNonNull(ko4);
        ko4.b bVar = new ko4.b(ko4);
        bVar.e = io4;
        bVar.f = io4;
        bVar.g = io4;
        bVar.h = io4;
        ho4.f.f1403a = bVar.a();
        ho4.invalidateSelf();
        this.y.q(ColorStateList.valueOf(-1));
        ho4 ho42 = this.y;
        AtomicInteger atomicInteger = r8.f3055a;
        setBackground(ho42);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RadialViewGroup, i, 0);
        this.x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RadialViewGroup_materialCircleRadius, 0);
        this.w = new a();
        obtainStyledAttributes.recycle();
    }
}
