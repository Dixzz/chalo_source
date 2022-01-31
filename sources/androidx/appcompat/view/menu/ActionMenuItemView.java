package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.TooltipCompat;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import defpackage.p1;
import defpackage.w1;

public class ActionMenuItemView extends AppCompatTextView implements w1.a, View.OnClickListener, ActionMenuView.ActionMenuChildView {
    public r1 f;
    public CharSequence g;
    public Drawable h;
    public p1.b i;
    public ForwardingListener j;
    public b k;
    public boolean l = c();
    public boolean m;
    public int n;
    public int o;
    public int p;

    public class a extends ForwardingListener {
        public a() {
            super(ActionMenuItemView.this);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public y1 getPopup() {
            b bVar = ActionMenuItemView.this.k;
            if (bVar != null) {
                return bVar.getPopup();
            }
            return null;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public boolean onForwardingStarted() {
            y1 popup;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            p1.b bVar = actionMenuItemView.i;
            if (bVar == null || !bVar.invokeItem(actionMenuItemView.f) || (popup = getPopup()) == null || !popup.isShowing()) {
                return false;
            }
            return true;
        }
    }

    public static abstract class b {
        public abstract y1 getPopup();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, 0, 0);
        this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.p = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.o = -1;
        setSaveEnabled(false);
    }

    @Override // defpackage.w1.a
    public void a(r1 r1Var, int i2) {
        this.f = r1Var;
        setIcon(r1Var.getIcon());
        setTitle(r1Var.getTitleCondensed());
        setId(r1Var.f3022a);
        setVisibility(r1Var.isVisible() ? 0 : 8);
        setEnabled(r1Var.isEnabled());
        if (r1Var.hasSubMenu() && this.j == null) {
            this.j = new a();
        }
    }

    public boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    public final boolean c() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        return i2 >= 480 || (i2 >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    public final void d() {
        CharSequence charSequence;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.g);
        if (this.h != null) {
            if (!((this.f.y & 4) == 4) || (!this.l && !this.m)) {
                z = false;
            }
        }
        boolean z3 = z2 & z;
        CharSequence charSequence2 = null;
        setText(z3 ? this.g : null);
        CharSequence charSequence3 = this.f.q;
        if (TextUtils.isEmpty(charSequence3)) {
            if (z3) {
                charSequence = null;
            } else {
                charSequence = this.f.e;
            }
            setContentDescription(charSequence);
        } else {
            setContentDescription(charSequence3);
        }
        CharSequence charSequence4 = this.f.r;
        if (TextUtils.isEmpty(charSequence4)) {
            if (!z3) {
                charSequence2 = this.f.e;
            }
            TooltipCompat.setTooltipText(this, charSequence2);
            return;
        }
        TooltipCompat.setTooltipText(this, charSequence4);
    }

    @Override // defpackage.w1.a
    public r1 getItemData() {
        return this.f;
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerAfter() {
        return b();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
    public boolean needsDividerBefore() {
        return b() && this.f.getIcon() == null;
    }

    public void onClick(View view) {
        p1.b bVar = this.i;
        if (bVar != null) {
            bVar.invokeItem(this.f);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.l = c();
        d();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        boolean b2 = b();
        if (b2 && (i5 = this.o) >= 0) {
            super.setPadding(i5, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i4 = Math.min(size, this.n);
        } else {
            i4 = this.n;
        }
        if (mode != 1073741824 && this.n > 0 && measuredWidth < i4) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, CommonUtils.BYTES_IN_A_GIGABYTE), i3);
        }
        if (!b2 && this.h != null) {
            super.setPadding((getMeasuredWidth() - this.h.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ForwardingListener forwardingListener;
        if (!this.f.hasSubMenu() || (forwardingListener = this.j) == null || !forwardingListener.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.m != z) {
            this.m = z;
            r1 r1Var = this.f;
            if (r1Var != null) {
                r1Var.n.p();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.h = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i2 = this.p;
            if (intrinsicWidth > i2) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i2) / ((float) intrinsicWidth)));
                intrinsicWidth = i2;
            }
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
            } else {
                i2 = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i2);
        }
        setCompoundDrawables(drawable, null, null, null);
        d();
    }

    public void setItemInvoker(p1.b bVar) {
        this.i = bVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        this.o = i2;
        super.setPadding(i2, i3, i4, i5);
    }

    public void setPopupCallback(b bVar) {
        this.k = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.g = charSequence;
        d();
    }
}
