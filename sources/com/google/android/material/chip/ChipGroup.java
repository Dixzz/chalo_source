package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import com.google.android.material.R;
import defpackage.e9;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ChipGroup extends gn4 {
    public static final int s = R.style.Widget_MaterialComponents_ChipGroup;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public d n;
    public final b o = new b(null);
    public e p = new e(null);
    public int q = -1;
    public boolean r = false;

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b(a aVar) {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ChipGroup chipGroup = ChipGroup.this;
            if (!chipGroup.r) {
                if (chipGroup.getCheckedChipIds().isEmpty()) {
                    ChipGroup chipGroup2 = ChipGroup.this;
                    if (chipGroup2.m) {
                        chipGroup2.d(compoundButton.getId(), true);
                        ChipGroup chipGroup3 = ChipGroup.this;
                        chipGroup3.q = compoundButton.getId();
                        d dVar = chipGroup3.n;
                        return;
                    }
                }
                int id = compoundButton.getId();
                if (z) {
                    ChipGroup chipGroup4 = ChipGroup.this;
                    int i = chipGroup4.q;
                    if (!(i == -1 || i == id || !chipGroup4.l)) {
                        chipGroup4.d(i, false);
                    }
                    ChipGroup.this.setCheckedId(id);
                    return;
                }
                ChipGroup chipGroup5 = ChipGroup.this;
                if (chipGroup5.q == id) {
                    chipGroup5.setCheckedId(-1);
                }
            }
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(int i, int i2) {
            super(i, i2);
        }
    }

    public interface d {
        void a(ChipGroup chipGroup, int i);
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public ViewGroup.OnHierarchyChangeListener f;

        public e(a aVar) {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    AtomicInteger atomicInteger = r8.f3055a;
                    view2.setId(View.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).c(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.o);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9) {
        /*
        // Method dump skipped, instructions count: 121
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private int getChipCount() {
        int i = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            if (getChildAt(i2) instanceof Chip) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void setCheckedId(int i) {
        this.q = i;
        d dVar = this.n;
        if (dVar != null && this.l) {
            dVar.a(this, i);
        }
    }

    @Override // defpackage.gn4
    public boolean a() {
        return this.h;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i2 = this.q;
                if (i2 != -1 && this.l) {
                    d(i2, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void c(int i) {
        int i2 = this.q;
        if (i != i2) {
            if (i2 != -1 && this.l) {
                d(i2, false);
            }
            if (i != -1) {
                d(i, true);
            }
            setCheckedId(i);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    public final void d(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById instanceof Chip) {
            this.r = true;
            ((Chip) findViewById).setChecked(z);
            this.r = false;
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.l) {
            return this.q;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.l) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.j;
    }

    public int getChipSpacingVertical() {
        return this.k;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.q;
        if (i != -1) {
            d(i, true);
            setCheckedId(this.q);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) e9.b.a(getRowCount(), this.h ? getChipCount() : -1, false, this.l ? 1 : 2).f944a);
    }

    public void setChipSpacing(int i) {
        setChipSpacingHorizontal(i);
        setChipSpacingVertical(i);
    }

    public void setChipSpacingHorizontal(int i) {
        if (this.j != i) {
            this.j = i;
            setItemSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingResource(int i) {
        setChipSpacing(getResources().getDimensionPixelOffset(i));
    }

    public void setChipSpacingVertical(int i) {
        if (this.k != i) {
            this.k = i;
            setLineSpacing(i);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.n = dVar;
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.p.f = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.m = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // defpackage.gn4
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        if (this.l != z) {
            this.l = z;
            this.r = true;
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.r = false;
            setCheckedId(-1);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public void setSingleLine(int i) {
        setSingleLine(getResources().getBoolean(i));
    }

    public void setSingleSelection(int i) {
        setSingleSelection(getResources().getBoolean(i));
    }
}
