package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.TooltipCompat;
import com.google.android.material.R;
import defpackage.w1;
import java.util.concurrent.atomic.AtomicInteger;

public class NavigationMenuItemView extends hn4 implements w1.a {
    public static final int[] v = {16842912};
    public int l;
    public boolean m;
    public boolean n;
    public final CheckedTextView o;
    public FrameLayout p;
    public r1 q;
    public ColorStateList r;
    public boolean s;
    public Drawable t;
    public final z7 u;

    public class a extends z7 {
        public a() {
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            e9Var.f942a.setCheckable(NavigationMenuItemView.this.n);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.u = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R.id.design_menu_item_text);
        this.o = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        r8.v(checkedTextView, aVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.p == null) {
                this.p = (FrameLayout) ((ViewStub) findViewById(R.id.design_menu_item_action_area_stub)).inflate();
            }
            this.p.removeAllViews();
            this.p.addView(view);
        }
    }

    @Override // defpackage.w1.a
    public void a(r1 r1Var, int i) {
        StateListDrawable stateListDrawable;
        this.q = r1Var;
        int i2 = r1Var.f3022a;
        if (i2 > 0) {
            setId(i2);
        }
        setVisibility(r1Var.isVisible() ? 0 : 8);
        boolean z = true;
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(v, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            AtomicInteger atomicInteger = r8.f3055a;
            setBackground(stateListDrawable);
        }
        setCheckable(r1Var.isCheckable());
        setChecked(r1Var.isChecked());
        setEnabled(r1Var.isEnabled());
        setTitle(r1Var.e);
        setIcon(r1Var.getIcon());
        setActionView(r1Var.getActionView());
        setContentDescription(r1Var.q);
        TooltipCompat.setTooltipText(this, r1Var.r);
        r1 r1Var2 = this.q;
        if (!(r1Var2.e == null && r1Var2.getIcon() == null && this.q.getActionView() != null)) {
            z = false;
        }
        if (z) {
            this.o.setVisibility(8);
            FrameLayout frameLayout = this.p;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).width = -1;
                this.p.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.o.setVisibility(0);
        FrameLayout frameLayout2 = this.p;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) layoutParams2).width = -2;
            this.p.setLayoutParams(layoutParams2);
        }
    }

    @Override // defpackage.w1.a
    public r1 getItemData() {
        return this.q;
    }

    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        r1 r1Var = this.q;
        if (r1Var != null && r1Var.isCheckable() && this.q.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, v);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.n != z) {
            this.n = z;
            this.u.h(this.o, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.o.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.s) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = h.H0(drawable).mutate();
                drawable.setTintList(this.r);
            }
            int i = this.l;
            drawable.setBounds(0, 0, i, i);
        } else if (this.m) {
            if (this.t == null) {
                Resources resources = getResources();
                int i2 = R.drawable.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal<TypedValue> threadLocal = y5.f3999a;
                Drawable drawable2 = resources.getDrawable(i2, theme);
                this.t = drawable2;
                if (drawable2 != null) {
                    int i3 = this.l;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.t;
        }
        this.o.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.o.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.l = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.r = colorStateList;
        this.s = colorStateList != null;
        r1 r1Var = this.q;
        if (r1Var != null) {
            setIcon(r1Var.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.o.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.m = z;
    }

    public void setTextAppearance(int i) {
        h.w0(this.o, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.o.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.o.setText(charSequence);
    }
}
