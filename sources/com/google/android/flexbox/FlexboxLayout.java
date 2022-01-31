package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import defpackage.ry1;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FlexboxLayout extends ViewGroup implements py1 {
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k = -1;
    public Drawable l;
    public Drawable m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int[] r;
    public SparseIntArray s;
    public ry1 t = new ry1(this);
    public List<qy1> u = new ArrayList();
    public ry1.b v = new ry1.b();

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, 0, 0);
        this.f = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.g = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.h = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.i = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 4);
        this.j = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 5);
        this.k = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i2 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i2 != 0) {
            this.o = i2;
            this.n = i2;
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i3 != 0) {
            this.o = i3;
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i4 != 0) {
            this.n = i4;
        }
        obtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.u.size();
        for (int i6 = 0; i6 < size; i6++) {
            qy1 qy1 = this.u.get(i6);
            for (int i7 = 0; i7 < qy1.h; i7++) {
                int i8 = qy1.o + i7;
                View o2 = o(i8);
                if (!(o2 == null || o2.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) o2.getLayoutParams();
                    if (p(i8, i7)) {
                        if (z) {
                            i5 = o2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            i5 = (o2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.q;
                        }
                        n(canvas, i5, qy1.b, qy1.g);
                    }
                    if (i7 == qy1.h - 1 && (this.o & 4) > 0) {
                        if (z) {
                            i4 = (o2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.q;
                        } else {
                            i4 = o2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        n(canvas, i4, qy1.b, qy1.g);
                    }
                }
            }
            if (q(i6)) {
                if (z2) {
                    i3 = qy1.d;
                } else {
                    i3 = qy1.b - this.p;
                }
                m(canvas, paddingLeft, i3, max);
            }
            if (r(i6) && (this.n & 4) > 0) {
                if (z2) {
                    i2 = qy1.b - this.p;
                } else {
                    i2 = qy1.d;
                }
                m(canvas, paddingLeft, i2, max);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.s == null) {
            this.s = new SparseIntArray(getChildCount());
        }
        ry1 ry1 = this.t;
        SparseIntArray sparseIntArray = this.s;
        int flexItemCount = ry1.f3149a.getFlexItemCount();
        List<ry1.c> f2 = ry1.f(flexItemCount);
        ry1.c cVar = new ry1.c(null);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            cVar.g = 1;
        } else {
            cVar.g = ((FlexItem) layoutParams).getOrder();
        }
        if (i2 == -1 || i2 == flexItemCount) {
            cVar.f = flexItemCount;
        } else if (i2 < ry1.f3149a.getFlexItemCount()) {
            cVar.f = i2;
            for (int i3 = i2; i3 < flexItemCount; i3++) {
                ((ry1.c) ((ArrayList) f2).get(i3)).f++;
            }
        } else {
            cVar.f = flexItemCount;
        }
        ((ArrayList) f2).add(cVar);
        this.r = ry1.x(flexItemCount + 1, f2, sparseIntArray);
        super.addView(view, i2, layoutParams);
    }

    @Override // defpackage.py1
    public void b(View view, int i2, int i3, qy1 qy1) {
        if (!p(i2, i3)) {
            return;
        }
        if (j()) {
            int i4 = qy1.e;
            int i5 = this.q;
            qy1.e = i4 + i5;
            qy1.f += i5;
            return;
        }
        int i6 = qy1.e;
        int i7 = this.p;
        qy1.e = i6 + i7;
        qy1.f += i7;
    }

    @Override // defpackage.py1
    public void c(qy1 qy1) {
        if (j()) {
            if ((this.o & 4) > 0) {
                int i2 = qy1.e;
                int i3 = this.q;
                qy1.e = i2 + i3;
                qy1.f += i3;
            }
        } else if ((this.n & 4) > 0) {
            int i4 = qy1.e;
            int i5 = this.p;
            qy1.e = i4 + i5;
            qy1.f += i5;
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // defpackage.py1
    public View d(int i2) {
        return o(i2);
    }

    @Override // defpackage.py1
    public int e(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // defpackage.py1
    public void f(int i2, View view) {
    }

    @Override // defpackage.py1
    public View g(int i2) {
        return getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // defpackage.py1
    public int getAlignContent() {
        return this.j;
    }

    @Override // defpackage.py1
    public int getAlignItems() {
        return this.i;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.l;
    }

    public Drawable getDividerDrawableVertical() {
        return this.m;
    }

    @Override // defpackage.py1
    public int getFlexDirection() {
        return this.f;
    }

    @Override // defpackage.py1
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<qy1> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.u.size());
        for (qy1 qy1 : this.u) {
            if (qy1.a() != 0) {
                arrayList.add(qy1);
            }
        }
        return arrayList;
    }

    @Override // defpackage.py1
    public List<qy1> getFlexLinesInternal() {
        return this.u;
    }

    @Override // defpackage.py1
    public int getFlexWrap() {
        return this.g;
    }

    public int getJustifyContent() {
        return this.h;
    }

    @Override // defpackage.py1
    public int getLargestMainSize() {
        int i2 = RtlSpacingHelper.UNDEFINED;
        for (qy1 qy1 : this.u) {
            i2 = Math.max(i2, qy1.e);
        }
        return i2;
    }

    @Override // defpackage.py1
    public int getMaxLine() {
        return this.k;
    }

    public int getShowDividerHorizontal() {
        return this.n;
    }

    public int getShowDividerVertical() {
        return this.o;
    }

    @Override // defpackage.py1
    public int getSumOfCrossSize() {
        int i2;
        int i3;
        int size = this.u.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            qy1 qy1 = this.u.get(i5);
            if (q(i5)) {
                if (j()) {
                    i3 = this.p;
                } else {
                    i3 = this.q;
                }
                i4 += i3;
            }
            if (r(i5)) {
                if (j()) {
                    i2 = this.p;
                } else {
                    i2 = this.q;
                }
                i4 += i2;
            }
            i4 += qy1.g;
        }
        return i4;
    }

    @Override // defpackage.py1
    public int h(View view, int i2, int i3) {
        int i4;
        int i5 = 0;
        if (j()) {
            if (p(i2, i3)) {
                i5 = 0 + this.q;
            }
            if ((this.o & 4) <= 0) {
                return i5;
            }
            i4 = this.q;
        } else {
            if (p(i2, i3)) {
                i5 = 0 + this.p;
            }
            if ((this.n & 4) <= 0) {
                return i5;
            }
            i4 = this.p;
        }
        return i5 + i4;
    }

    @Override // defpackage.py1
    public int i(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // defpackage.py1
    public boolean j() {
        int i2 = this.f;
        return i2 == 0 || i2 == 1;
    }

    @Override // defpackage.py1
    public int k(View view) {
        return 0;
    }

    public final void l(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.u.size();
        for (int i6 = 0; i6 < size; i6++) {
            qy1 qy1 = this.u.get(i6);
            for (int i7 = 0; i7 < qy1.h; i7++) {
                int i8 = qy1.o + i7;
                View o2 = o(i8);
                if (!(o2 == null || o2.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) o2.getLayoutParams();
                    if (p(i8, i7)) {
                        if (z2) {
                            i5 = o2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            i5 = (o2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.p;
                        }
                        m(canvas, qy1.f3006a, i5, qy1.g);
                    }
                    if (i7 == qy1.h - 1 && (this.n & 4) > 0) {
                        if (z2) {
                            i4 = (o2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.p;
                        } else {
                            i4 = o2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        m(canvas, qy1.f3006a, i4, qy1.g);
                    }
                }
            }
            if (q(i6)) {
                if (z) {
                    i3 = qy1.c;
                } else {
                    i3 = qy1.f3006a - this.q;
                }
                n(canvas, i3, paddingTop, max);
            }
            if (r(i6) && (this.o & 4) > 0) {
                if (z) {
                    i2 = qy1.f3006a - this.q;
                } else {
                    i2 = qy1.c;
                }
                n(canvas, i2, paddingTop, max);
            }
        }
    }

    public final void m(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.l;
        if (drawable != null) {
            drawable.setBounds(i2, i3, i4 + i2, this.p + i3);
            this.l.draw(canvas);
        }
    }

    public final void n(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.m;
        if (drawable != null) {
            drawable.setBounds(i2, i3, this.q + i2, i4 + i3);
            this.m.draw(canvas);
        }
    }

    public View o(int i2) {
        if (i2 < 0) {
            return null;
        }
        int[] iArr = this.r;
        if (i2 >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i2]);
    }

    public void onDraw(Canvas canvas) {
        if (this.m != null || this.l != null) {
            if (this.n != 0 || this.o != 0) {
                AtomicInteger atomicInteger = r8.f3055a;
                int layoutDirection = getLayoutDirection();
                int i2 = this.f;
                boolean z = false;
                boolean z2 = true;
                if (i2 == 0) {
                    boolean z3 = layoutDirection == 1;
                    if (this.g == 2) {
                        z = true;
                    }
                    a(canvas, z3, z);
                } else if (i2 == 1) {
                    boolean z4 = layoutDirection != 1;
                    if (this.g == 2) {
                        z = true;
                    }
                    a(canvas, z4, z);
                } else if (i2 == 2) {
                    if (layoutDirection != 1) {
                        z2 = false;
                    }
                    if (this.g == 2) {
                        z2 = !z2;
                    }
                    l(canvas, z2, false);
                } else if (i2 == 3) {
                    if (layoutDirection == 1) {
                        z = true;
                    }
                    if (this.g == 2) {
                        z = !z;
                    }
                    l(canvas, z, true);
                }
            }
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AtomicInteger atomicInteger = r8.f3055a;
        int layoutDirection = getLayoutDirection();
        int i6 = this.f;
        boolean z2 = false;
        if (i6 == 0) {
            s(layoutDirection == 1, i2, i3, i4, i5);
        } else if (i6 == 1) {
            s(layoutDirection != 1, i2, i3, i4, i5);
        } else if (i6 == 2) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            if (this.g == 2) {
                z2 = !z2;
            }
            t(z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            if (layoutDirection == 1) {
                z2 = true;
            }
            if (this.g == 2) {
                z2 = !z2;
            }
            t(z2, true, i2, i3, i4, i5);
        } else {
            StringBuilder i0 = hj1.i0("Invalid flex direction is set: ");
            i0.append(this.f);
            throw new IllegalStateException(i0.toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r15, int r16) {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.onMeasure(int, int):void");
    }

    public final boolean p(int i2, int i3) {
        boolean z;
        int i4 = 1;
        while (true) {
            if (i4 > i3) {
                z = true;
                break;
            }
            View o2 = o(i2 - i4);
            if (o2 != null && o2.getVisibility() != 8) {
                z = false;
                break;
            }
            i4++;
        }
        if (z) {
            if (j()) {
                if ((this.o & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.n & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (j()) {
            if ((this.o & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.n & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean q(int i2) {
        boolean z;
        if (i2 < 0 || i2 >= this.u.size()) {
            return false;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                z = true;
                break;
            } else if (this.u.get(i3).a() > 0) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        if (z) {
            if (j()) {
                if ((this.n & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.o & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (j()) {
            if ((this.n & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.o & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean r(int i2) {
        if (i2 < 0 || i2 >= this.u.size()) {
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.u.size(); i3++) {
            if (this.u.get(i3).a() > 0) {
                return false;
            }
        }
        if (j()) {
            if ((this.n & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.o & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s(boolean r26, int r27, int r28, int r29, int r30) {
        /*
        // Method dump skipped, instructions count: 522
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.s(boolean, int, int, int, int):void");
    }

    public void setAlignContent(int i2) {
        if (this.j != i2) {
            this.j = i2;
            requestLayout();
        }
    }

    public void setAlignItems(int i2) {
        if (this.i != i2) {
            this.i = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable != this.l) {
            this.l = drawable;
            if (drawable != null) {
                this.p = drawable.getIntrinsicHeight();
            } else {
                this.p = 0;
            }
            if (this.l == null && this.m == null) {
                setWillNotDraw(true);
            } else {
                setWillNotDraw(false);
            }
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable != this.m) {
            this.m = drawable;
            if (drawable != null) {
                this.q = drawable.getIntrinsicWidth();
            } else {
                this.q = 0;
            }
            if (this.l == null && this.m == null) {
                setWillNotDraw(true);
            } else {
                setWillNotDraw(false);
            }
            requestLayout();
        }
    }

    public void setFlexDirection(int i2) {
        if (this.f != i2) {
            this.f = i2;
            requestLayout();
        }
    }

    @Override // defpackage.py1
    public void setFlexLines(List<qy1> list) {
        this.u = list;
    }

    public void setFlexWrap(int i2) {
        if (this.g != i2) {
            this.g = i2;
            requestLayout();
        }
    }

    public void setJustifyContent(int i2) {
        if (this.h != i2) {
            this.h = i2;
            requestLayout();
        }
    }

    public void setMaxLine(int i2) {
        if (this.k != i2) {
            this.k = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.n) {
            this.n = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.o) {
            this.o = i2;
            requestLayout();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(boolean r28, boolean r29, int r30, int r31, int r32, int r33) {
        /*
        // Method dump skipped, instructions count: 514
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.t(boolean, boolean, int, int, int, int):void");
    }

    public final void u(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            i6 = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            i7 = getLargestMainSize();
        } else if (i2 == 2 || i2 == 3) {
            i6 = getLargestMainSize();
            i7 = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        } else {
            throw new IllegalArgumentException(hj1.I("Invalid flex direction: ", i2));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = i7;
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            i8 = View.resolveSizeAndState(i7, i3, i5);
        } else if (mode == 1073741824) {
            if (size < i7) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            i8 = View.resolveSizeAndState(size, i3, i5);
        } else {
            throw new IllegalStateException(hj1.I("Unknown width mode is set: ", mode));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, 256);
            } else {
                size2 = i6;
            }
            i9 = View.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            i9 = View.resolveSizeAndState(i6, i4, i5);
        } else if (mode2 == 1073741824) {
            if (size2 < i6) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            i9 = View.resolveSizeAndState(size2, i4, i5);
        } else {
            throw new IllegalStateException(hj1.I("Unknown height mode is set: ", mode2));
        }
        setMeasuredDimension(i8, i9);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        public int f = 1;
        public float g = 0.0f;
        public float h = 1.0f;
        public int i = -1;
        public float j = -1.0f;
        public int k;
        public int l;
        public int m = 16777215;
        public int n = 16777215;
        public boolean o;

        public static class a implements Parcelable.Creator<LayoutParams> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.f = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.g = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.h = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.i = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.j = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.k = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, 0);
            this.l = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, 0);
            this.m = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.n = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.o = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        public float C0() {
            return this.j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int O0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int P() {
            return this.i;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int R0() {
            return this.l;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float T() {
            return this.h;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean W0() {
            return this.o;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int a0() {
            return this.k;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int b1() {
            return this.n;
        }

        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int g0() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int i0() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int i1() {
            return this.m;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int k() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int q0() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float w0() {
            return this.g;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f);
            parcel.writeFloat(this.g);
            parcel.writeFloat(this.h);
            parcel.writeInt(this.i);
            parcel.writeFloat(this.j);
            parcel.writeInt(this.k);
            parcel.writeInt(this.l);
            parcel.writeInt(this.m);
            parcel.writeInt(this.n);
            parcel.writeByte(this.o ? (byte) 1 : 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f = layoutParams.f;
            this.g = layoutParams.g;
            this.h = layoutParams.h;
            this.i = layoutParams.i;
            this.j = layoutParams.j;
            this.k = layoutParams.k;
            this.l = layoutParams.l;
            this.m = layoutParams.m;
            this.n = layoutParams.n;
            this.o = layoutParams.o;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z = false;
            this.f = parcel.readInt();
            this.g = parcel.readFloat();
            this.h = parcel.readFloat();
            this.i = parcel.readInt();
            this.j = parcel.readFloat();
            this.k = parcel.readInt();
            this.l = parcel.readInt();
            this.m = parcel.readInt();
            this.n = parcel.readInt();
            this.o = parcel.readByte() != 0 ? true : z;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
