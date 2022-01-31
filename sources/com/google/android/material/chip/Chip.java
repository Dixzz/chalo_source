package com.google.android.material.chip;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.RtlSpacingHelper;
import butterknife.internal.ButterKnifeProcessor;
import com.google.android.material.R;
import defpackage.e9;
import defpackage.ho4;
import defpackage.ml4;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Chip extends AppCompatCheckBox implements ml4.a, oo4 {
    public static final int v = R.style.Widget_MaterialComponents_Chip_Action;
    public static final Rect w = new Rect();
    public static final int[] x = {16842913};
    public static final int[] y = {16842911};
    public ml4 f;
    public InsetDrawable g;
    public RippleDrawable h;
    public View.OnClickListener i;
    public CompoundButton.OnCheckedChangeListener j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public int q;
    public final b r;
    public final Rect s = new Rect();
    public final RectF t = new RectF();
    public final xn4 u = new a();

    public class a extends xn4 {
        public a() {
        }

        @Override // defpackage.xn4
        public void a(int i) {
        }

        @Override // defpackage.xn4
        public void b(Typeface typeface, boolean z) {
            CharSequence charSequence;
            Chip chip = Chip.this;
            ml4 ml4 = chip.f;
            if (ml4.J0) {
                charSequence = ml4.K;
            } else {
                charSequence = chip.getText();
            }
            chip.setText(charSequence);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    public class b extends aa {
        public b(Chip chip) {
            super(chip);
        }

        @Override // defpackage.aa
        public int n(float f, float f2) {
            Chip chip = Chip.this;
            int i = Chip.v;
            return (!chip.e() || !Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 0 : 1;
        }

        @Override // defpackage.aa
        public void o(List<Integer> list) {
            boolean z = false;
            list.add(0);
            Chip chip = Chip.this;
            int i = Chip.v;
            if (chip.e()) {
                Chip chip2 = Chip.this;
                ml4 ml4 = chip2.f;
                if (ml4 != null && ml4.Q) {
                    z = true;
                }
                if (z && chip2.i != null) {
                    list.add(1);
                }
            }
        }

        @Override // defpackage.aa
        public boolean r(int i, int i2, Bundle bundle) {
            boolean z = false;
            if (i2 == 16) {
                if (i == 0) {
                    return Chip.this.performClick();
                }
                if (i == 1) {
                    Chip chip = Chip.this;
                    chip.playSoundEffect(0);
                    View.OnClickListener onClickListener = chip.i;
                    if (onClickListener != null) {
                        onClickListener.onClick(chip);
                        z = true;
                    }
                    chip.r.w(1, 1);
                }
            }
            return z;
        }

        @Override // defpackage.aa
        public void s(e9 e9Var) {
            e9Var.f942a.setCheckable(Chip.this.f());
            e9Var.f942a.setClickable(Chip.this.isClickable());
            if (Chip.this.f() || Chip.this.isClickable()) {
                e9Var.f942a.setClassName(Chip.this.f() ? "android.widget.CompoundButton" : "android.widget.Button");
            } else {
                e9Var.f942a.setClassName(ButterKnifeProcessor.VIEW_TYPE);
            }
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                e9Var.f942a.setText(text);
            } else {
                e9Var.f942a.setContentDescription(text);
            }
        }

        @Override // defpackage.aa
        public void t(int i, e9 e9Var) {
            String str = "";
            if (i == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    e9Var.f942a.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        str = text;
                    }
                    objArr[0] = str;
                    e9Var.f942a.setContentDescription(context.getString(i2, objArr).trim());
                }
                e9Var.f942a.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                e9Var.a(e9.a.g);
                e9Var.f942a.setEnabled(Chip.this.isEnabled());
                return;
            }
            e9Var.f942a.setContentDescription(str);
            e9Var.f942a.setBoundsInParent(Chip.w);
        }

        @Override // defpackage.aa
        public void u(int i, boolean z) {
            if (i == 1) {
                Chip chip = Chip.this;
                chip.n = z;
                chip.refreshDrawableState();
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Chip(android.content.Context r18, android.util.AttributeSet r19) {
        /*
        // Method dump skipped, instructions count: 870
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private RectF getCloseIconTouchBounds() {
        this.t.setEmpty();
        if (e() && this.i != null) {
            ml4 ml4 = this.f;
            ml4.D(ml4.getBounds(), this.t);
        }
        return this.t;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.s.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.s;
    }

    private vn4 getTextAppearance() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.q0.f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z) {
        if (this.m != z) {
            this.m = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.l != z) {
            this.l = z;
            refreshDrawableState();
        }
    }

    @Override // defpackage.ml4.a
    public void a() {
        d(this.q);
        requestLayout();
        invalidateOutline();
    }

    public boolean d(int i2) {
        this.q = i2;
        if (!this.o) {
            if (this.g != null) {
                g();
            } else {
                int[] iArr = yn4.f4071a;
                i();
            }
            return false;
        }
        int max = Math.max(0, i2 - ((int) this.f.F));
        int max2 = Math.max(0, i2 - this.f.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i3 = max2 > 0 ? max2 / 2 : 0;
            int i4 = max > 0 ? max / 2 : 0;
            if (this.g != null) {
                Rect rect = new Rect();
                this.g.getPadding(rect);
                if (rect.top == i4 && rect.bottom == i4 && rect.left == i3 && rect.right == i3) {
                    int[] iArr2 = yn4.f4071a;
                    i();
                    return true;
                }
            }
            if (getMinHeight() != i2) {
                setMinHeight(i2);
            }
            if (getMinWidth() != i2) {
                setMinWidth(i2);
            }
            this.g = new InsetDrawable((Drawable) this.f, i3, i4, i3, i4);
            int[] iArr3 = yn4.f4071a;
            i();
            return true;
        }
        if (this.g != null) {
            g();
        } else {
            int[] iArr4 = yn4.f4071a;
            i();
        }
        return false;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        boolean z;
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = aa.class.getDeclaredField("m");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.r)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = aa.class.getDeclaredMethod("x", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.r, Integer.valueOf((int) RtlSpacingHelper.UNDEFINED));
                    z = true;
                    if (!z || this.r.m(motionEvent) || super.dispatchHoverEvent(motionEvent)) {
                        return true;
                    }
                    return false;
                }
            } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException unused) {
            }
        }
        z = false;
        return !z ? true : true;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        b bVar = this.r;
        Objects.requireNonNull(bVar);
        boolean z = false;
        int i2 = 0;
        z = false;
        z = false;
        z = false;
        z = false;
        z = false;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                int i3 = 66;
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                if (keyCode == 19) {
                                    i3 = 33;
                                } else if (keyCode == 21) {
                                    i3 = 17;
                                } else if (keyCode != 22) {
                                    i3 = 130;
                                }
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z2 = false;
                                while (i2 < repeatCount && bVar.p(i3, null)) {
                                    i2++;
                                    z2 = true;
                                }
                                z = z2;
                                break;
                            }
                            break;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    int i4 = bVar.l;
                    if (i4 != Integer.MIN_VALUE) {
                        bVar.r(i4, 16, null);
                    }
                    z = true;
                }
            } else if (keyEvent.hasNoModifiers()) {
                z = bVar.p(2, null);
            } else if (keyEvent.hasModifiers(1)) {
                z = bVar.p(1, null);
            }
        }
        if (!z || this.r.l == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // androidx.appcompat.widget.AppCompatCheckBox
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void drawableStateChanged() {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.drawableStateChanged():void");
    }

    public final boolean e() {
        ml4 ml4 = this.f;
        return (ml4 == null || ml4.G() == null) ? false : true;
    }

    public boolean f() {
        ml4 ml4 = this.f;
        return ml4 != null && ml4.W;
    }

    public final void g() {
        if (this.g != null) {
            this.g = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            int[] iArr = yn4.f4071a;
            i();
        }
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.g;
        return insetDrawable == null ? this.f : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.Y;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.Z;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.E;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return Math.max(0.0f, ml4.F());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f;
    }

    public float getChipEndPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.j0;
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        Drawable drawable;
        ml4 ml4 = this.f;
        if (ml4 == null || (drawable = ml4.M) == null) {
            return null;
        }
        return h.E0(drawable);
    }

    public float getChipIconSize() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.O;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.N;
        }
        return null;
    }

    public float getChipMinHeight() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.F;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.c0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.H;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.I;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.G();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.V;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.i0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.U;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.h0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.T;
        }
        return null;
    }

    public TextUtils.TruncateAt getEllipsize() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.I0;
        }
        return null;
    }

    public void getFocusedRect(Rect rect) {
        b bVar = this.r;
        if (bVar.l == 1 || bVar.k == 1) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    public fk4 getHideMotionSpec() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.b0;
        }
        return null;
    }

    public float getIconEndPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.e0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.d0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.J;
        }
        return null;
    }

    public ko4 getShapeAppearanceModel() {
        return this.f.f.f1403a;
    }

    public fk4 getShowMotionSpec() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.a0;
        }
        return null;
    }

    public float getTextEndPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.g0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            return ml4.f0;
        }
        return 0.0f;
    }

    public final void h() {
        if (e()) {
            ml4 ml4 = this.f;
            if ((ml4 != null && ml4.Q) && this.i != null) {
                r8.v(this, this.r);
                return;
            }
        }
        r8.v(this, null);
    }

    public final void i() {
        this.h = new RippleDrawable(yn4.b(this.f.J), getBackgroundDrawable(), null);
        this.f.o0(false);
        RippleDrawable rippleDrawable = this.h;
        AtomicInteger atomicInteger = r8.f3055a;
        setBackground(rippleDrawable);
        j();
    }

    public final void j() {
        ml4 ml4;
        if (!TextUtils.isEmpty(getText()) && (ml4 = this.f) != null) {
            int E = (int) (ml4.E() + ml4.j0 + ml4.g0);
            ml4 ml42 = this.f;
            int B = (int) (ml42.B() + ml42.c0 + ml42.f0);
            if (this.g != null) {
                Rect rect = new Rect();
                this.g.getPadding(rect);
                B += rect.left;
                E += rect.right;
            }
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            AtomicInteger atomicInteger = r8.f3055a;
            setPaddingRelative(B, paddingTop, E, paddingBottom);
        }
    }

    public final void k() {
        TextPaint paint = getPaint();
        ml4 ml4 = this.f;
        if (ml4 != null) {
            paint.drawableState = ml4.getState();
        }
        vn4 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.c(getContext(), paint, this.u);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        hd3.N2(this, this.f);
    }

    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, x);
        }
        if (f()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, y);
        }
        return onCreateDrawableState;
    }

    public void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        b bVar = this.r;
        int i3 = bVar.l;
        if (i3 != Integer.MIN_VALUE) {
            bVar.k(i3);
        }
        if (z) {
            bVar.p(i2, rect);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i2;
        int i3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (f() || isClickable()) {
            accessibilityNodeInfo.setClassName(f() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            accessibilityNodeInfo.setClassName(ButterKnifeProcessor.VIEW_TYPE);
        }
        accessibilityNodeInfo.setCheckable(f());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.h) {
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    if (i4 >= chipGroup.getChildCount()) {
                        i5 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i4) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i4)) == this) {
                            break;
                        }
                        i5++;
                    }
                    i4++;
                }
                i2 = i5;
            } else {
                i2 = -1;
            }
            Object tag = getTag(R.id.row_index_key);
            if (!(tag instanceof Integer)) {
                i3 = -1;
            } else {
                i3 = ((Integer) tag).intValue();
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) e9.c.a(i3, 1, i2, 1, false, isChecked()).f945a);
        }
    }

    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i2) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @TargetApi(17)
    public void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        if (this.p != i2) {
            this.p = i2;
            j();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r0 != 3) goto L_0x004c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004f  */
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0045
            if (r0 == r3) goto L_0x002b
            r4 = 2
            if (r0 == r4) goto L_0x0021
            r1 = 3
            if (r0 == r1) goto L_0x0040
            goto L_0x004c
        L_0x0021:
            boolean r0 = r5.l
            if (r0 == 0) goto L_0x004c
            if (r1 != 0) goto L_0x004a
            r5.setCloseIconPressed(r2)
            goto L_0x004a
        L_0x002b:
            boolean r0 = r5.l
            if (r0 == 0) goto L_0x0040
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.i
            if (r0 == 0) goto L_0x0039
            r0.onClick(r5)
        L_0x0039:
            com.google.android.material.chip.Chip$b r0 = r5.r
            r0.w(r3, r3)
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            r5.setCloseIconPressed(r2)
            goto L_0x004d
        L_0x0045:
            if (r1 == 0) goto L_0x004c
            r5.setCloseIconPressed(r3)
        L_0x004a:
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            if (r0 != 0) goto L_0x0055
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L_0x0056
        L_0x0055:
            r2 = 1
        L_0x0056:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackground(drawable);
        }
    }

    public void setBackgroundColor(int i2) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.h) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setBackgroundResource(int i2) {
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.M(z);
        }
    }

    public void setCheckableResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.M(ml4.k0.getResources().getBoolean(i2));
        }
    }

    public void setChecked(boolean z) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        ml4 ml4 = this.f;
        if (ml4 == null) {
            this.k = z;
        } else if (ml4.W) {
            boolean isChecked = isChecked();
            super.setChecked(z);
            if (isChecked != z && (onCheckedChangeListener = this.j) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.N(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i2) {
        setCheckedIconVisible(i2);
    }

    public void setCheckedIconResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.N(u0.b(ml4.k0, i2));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.O(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.O(u0.a(ml4.k0, i2));
        }
    }

    public void setCheckedIconVisible(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.P(ml4.k0.getResources().getBoolean(i2));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.E != colorStateList) {
            ml4.E = colorStateList;
            ml4.onStateChange(ml4.getState());
        }
    }

    public void setChipBackgroundColorResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.Q(u0.a(ml4.k0, i2));
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.R(f2);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.R(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setChipDrawable(ml4 ml4) {
        ml4 ml42 = this.f;
        if (ml42 != ml4) {
            if (ml42 != null) {
                ml42.H0 = new WeakReference<>(null);
            }
            this.f = ml4;
            ml4.J0 = false;
            Objects.requireNonNull(ml4);
            ml4.H0 = new WeakReference<>(this);
            d(this.q);
        }
    }

    public void setChipEndPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.j0 != f2) {
            ml4.j0 = f2;
            ml4.invalidateSelf();
            ml4.K();
        }
    }

    public void setChipEndPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.S(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setChipIcon(Drawable drawable) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.T(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i2) {
        setChipIconVisible(i2);
    }

    public void setChipIconResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.T(u0.b(ml4.k0, i2));
        }
    }

    public void setChipIconSize(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.U(f2);
        }
    }

    public void setChipIconSizeResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.U(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.V(colorStateList);
        }
    }

    public void setChipIconTintResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.V(u0.a(ml4.k0, i2));
        }
    }

    public void setChipIconVisible(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.W(ml4.k0.getResources().getBoolean(i2));
        }
    }

    public void setChipMinHeight(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.F != f2) {
            ml4.F = f2;
            ml4.invalidateSelf();
            ml4.K();
        }
    }

    public void setChipMinHeightResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.X(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setChipStartPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.c0 != f2) {
            ml4.c0 = f2;
            ml4.invalidateSelf();
            ml4.K();
        }
    }

    public void setChipStartPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.Y(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.Z(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.Z(u0.a(ml4.k0, i2));
        }
    }

    public void setChipStrokeWidth(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.a0(f2);
        }
    }

    public void setChipStrokeWidthResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.a0(ml4.k0.getResources().getDimension(i2));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i2) {
        setText(getResources().getString(i2));
    }

    public void setCloseIcon(Drawable drawable) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.b0(drawable);
        }
        h();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.V != charSequence) {
            o7 c = o7.c();
            ml4.V = c.d(charSequence, c.c, true);
            ml4.invalidateSelf();
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i2) {
        setCloseIconVisible(i2);
    }

    public void setCloseIconEndPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.c0(f2);
        }
    }

    public void setCloseIconEndPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.c0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.b0(u0.b(ml4.k0, i2));
        }
        h();
    }

    public void setCloseIconSize(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.d0(f2);
        }
    }

    public void setCloseIconSizeResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.d0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconStartPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.e0(f2);
        }
    }

    public void setCloseIconStartPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.e0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.g0(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.g0(u0.a(ml4.k0, i2));
        }
    }

    public void setCloseIconVisible(int i2) {
        setCloseIconVisible(getResources().getBoolean(i2));
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i2, int i3, int i4, int i5) {
        if (i2 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i4 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i2, i3, i4, i5);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    public void setElevation(float f2) {
        super.setElevation(f2);
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ho4.b bVar = ml4.f;
            if (bVar.o != f2) {
                bVar.o = f2;
                ml4.y();
            }
        }
    }

    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                ml4 ml4 = this.f;
                if (ml4 != null) {
                    ml4.I0 = truncateAt;
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        this.o = z;
        d(this.q);
    }

    public void setGravity(int i2) {
        if (i2 == 8388627) {
            super.setGravity(i2);
        }
    }

    public void setHideMotionSpec(fk4 fk4) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.b0 = fk4;
        }
    }

    public void setHideMotionSpecResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.b0 = fk4.b(ml4.k0, i2);
        }
    }

    public void setIconEndPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.i0(f2);
        }
    }

    public void setIconEndPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.i0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setIconStartPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.j0(f2);
        }
    }

    public void setIconStartPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.j0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setLayoutDirection(int i2) {
        if (this.f != null) {
            super.setLayoutDirection(i2);
        }
    }

    public void setLines(int i2) {
        if (i2 <= 1) {
            super.setLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int i2) {
        if (i2 <= 1) {
            super.setMaxLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int i2) {
        super.setMaxWidth(i2);
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.K0 = i2;
        }
    }

    public void setMinLines(int i2) {
        if (i2 <= 1) {
            super.setMinLines(i2);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.j = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.i = onClickListener;
        h();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.k0(colorStateList);
        }
        if (!this.f.F0) {
            i();
        }
    }

    public void setRippleColorResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.k0(u0.a(ml4.k0, i2));
            if (!this.f.F0) {
                i();
            }
        }
    }

    @Override // defpackage.oo4
    public void setShapeAppearanceModel(ko4 ko4) {
        ml4 ml4 = this.f;
        ml4.f.f1403a = ko4;
        ml4.invalidateSelf();
    }

    public void setShowMotionSpec(fk4 fk4) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.a0 = fk4;
        }
    }

    public void setShowMotionSpecResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.a0 = fk4.b(ml4.k0, i2);
        }
    }

    public void setSingleLine(boolean z) {
        if (z) {
            super.setSingleLine(z);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(ml4.J0 ? null : charSequence, bufferType);
            ml4 ml42 = this.f;
            if (ml42 != null) {
                ml42.l0(charSequence);
            }
        }
    }

    public void setTextAppearance(vn4 vn4) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.q0.b(vn4, ml4.k0);
        }
        k();
    }

    public void setTextAppearanceResource(int i2) {
        setTextAppearance(getContext(), i2);
    }

    public void setTextEndPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.g0 != f2) {
            ml4.g0 = f2;
            ml4.invalidateSelf();
            ml4.K();
        }
    }

    public void setTextEndPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.m0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setTextStartPadding(float f2) {
        ml4 ml4 = this.f;
        if (ml4 != null && ml4.f0 != f2) {
            ml4.f0 = f2;
            ml4.invalidateSelf();
            ml4.K();
        }
    }

    public void setTextStartPaddingResource(int i2) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.n0(ml4.k0.getResources().getDimension(i2));
        }
    }

    public void setCloseIconVisible(boolean z) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.h0(z);
        }
        h();
    }

    public void setCheckedIconVisible(boolean z) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.P(z);
        }
    }

    public void setChipIconVisible(boolean z) {
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.W(z);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.q0.b(new vn4(ml4.k0, i2), ml4.k0);
        }
        k();
    }

    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
        ml4 ml4 = this.f;
        if (ml4 != null) {
            ml4.q0.b(new vn4(ml4.k0, i2), ml4.k0);
        }
        k();
    }
}
