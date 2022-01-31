package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.dp4;

public class Snackbar extends BaseTransientBottomBar<Snackbar> {
    public static final int[] t = {R.attr.snackbarButtonStyle, R.attr.snackbarTextViewStyle};
    public final AccessibilityManager r;
    public boolean s;

    public static final class SnackbarLayout extends BaseTransientBottomBar.i {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, CommonUtils.BYTES_IN_A_GIGABYTE), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), CommonUtils.BYTES_IN_A_GIGABYTE));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.i
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    public class a implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener f;

        public a(View.OnClickListener onClickListener) {
            this.f = onClickListener;
        }

        public void onClick(View view) {
            this.f.onClick(view);
            Snackbar.this.b(1);
        }
    }

    public Snackbar(Context context, ViewGroup viewGroup, View view, cp4 cp4) {
        super(context, viewGroup, view, cp4);
        this.r = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    public static Snackbar j(View view, CharSequence charSequence, int i) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (!(view instanceof CoordinatorLayout)) {
                if (view instanceof FrameLayout) {
                    if (view.getId() == 16908290) {
                        viewGroup = (ViewGroup) view;
                        break;
                    }
                    viewGroup2 = (ViewGroup) view;
                }
                if (view != null) {
                    ViewParent parent = view.getParent();
                    if (parent instanceof View) {
                        view = (View) parent;
                        continue;
                    } else {
                        view = null;
                        continue;
                    }
                }
                if (view == null) {
                    viewGroup = viewGroup2;
                    break;
                }
            } else {
                viewGroup = (ViewGroup) view;
                break;
            }
        }
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(t);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            boolean z = true;
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId == -1 || resourceId2 == -1) {
                z = false;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(z ? R.layout.mtrl_layout_snackbar_include : R.layout.design_layout_snackbar_include, viewGroup, false);
            Snackbar snackbar = new Snackbar(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
            ((SnackbarContentLayout) snackbar.c.getChildAt(0)).getMessageView().setText(charSequence);
            snackbar.e = i;
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void a() {
        b(3);
    }

    public int i() {
        int i = this.e;
        if (i == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.r.getRecommendedTimeoutMillis(i, (this.s ? 4 : 0) | 1 | 2);
        } else if (!this.s || !this.r.isTouchExplorationEnabled()) {
            return i;
        } else {
            return -2;
        }
    }

    public Snackbar k(CharSequence charSequence, View.OnClickListener onClickListener) {
        Button actionView = ((SnackbarContentLayout) this.c.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            this.s = false;
        } else {
            this.s = true;
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new a(onClickListener));
        }
        return this;
    }

    public Snackbar l(int i) {
        ((SnackbarContentLayout) this.c.getChildAt(0)).getActionView().setTextColor(i);
        return this;
    }

    public void m() {
        dp4 b = dp4.b();
        int i = i();
        dp4.b bVar = this.n;
        synchronized (b.f875a) {
            if (b.c(bVar)) {
                dp4.c cVar = b.c;
                cVar.b = i;
                b.b.removeCallbacksAndMessages(cVar);
                b.g(b.c);
                return;
            }
            if (b.d(bVar)) {
                b.d.b = i;
            } else {
                b.d = new dp4.c(i, bVar);
            }
            dp4.c cVar2 = b.c;
            if (cVar2 == null || !b.a(cVar2, 4)) {
                b.c = null;
                b.h();
            }
        }
    }
}
