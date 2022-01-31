package com.google.android.material.button;

import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import defpackage.e9;
import defpackage.ko4;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MaterialButtonToggleGroup extends LinearLayout {
    public static final String p = MaterialButtonToggleGroup.class.getSimpleName();
    public static final int q = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    public final List<d> f = new ArrayList();
    public final c g = new c(null);
    public final f h = new f(null);
    public final LinkedHashSet<e> i = new LinkedHashSet<>();
    public final Comparator<MaterialButton> j = new a();
    public Integer[] k;
    public boolean l = false;
    public boolean m;
    public boolean n;
    public int o;

    public class a implements Comparator<MaterialButton>, j$.util.Comparator {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            MaterialButton materialButton3 = materialButton;
            MaterialButton materialButton4 = materialButton2;
            int compareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton3)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton4)));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<MaterialButton> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<MaterialButton> thenComparing(java.util.Comparator<? super MaterialButton> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public class b extends z7 {
        public b() {
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            String str = MaterialButtonToggleGroup.p;
            Objects.requireNonNull(materialButtonToggleGroup);
            int i = -1;
            if (view instanceof MaterialButton) {
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    if (i2 >= materialButtonToggleGroup.getChildCount()) {
                        break;
                    } else if (materialButtonToggleGroup.getChildAt(i2) == view) {
                        i = i3;
                        break;
                    } else {
                        if ((materialButtonToggleGroup.getChildAt(i2) instanceof MaterialButton) && materialButtonToggleGroup.d(i2)) {
                            i3++;
                        }
                        i2++;
                    }
                }
            }
            e9Var.n(e9.c.a(0, 1, i, 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    public class c implements MaterialButton.a {
        public c(a aVar) {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
            if (!materialButtonToggleGroup.l) {
                if (materialButtonToggleGroup.m) {
                    materialButtonToggleGroup.o = z ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.f(materialButton.getId(), z)) {
                    MaterialButtonToggleGroup.this.b(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }
    }

    public static class d {
        public static final do4 e = new bo4(0.0f);

        /* renamed from: a  reason: collision with root package name */
        public do4 f620a;
        public do4 b;
        public do4 c;
        public do4 d;

        public d(do4 do4, do4 do42, do4 do43, do4 do44) {
            this.f620a = do4;
            this.b = do43;
            this.c = do44;
            this.d = do42;
        }
    }

    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z);
    }

    public class f implements MaterialButton.b {
        public f(a aVar) {
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaterialButtonToggleGroup(android.content.Context r7, android.util.AttributeSet r8) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (d(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (d(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && d(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setCheckedId(int i2) {
        this.o = i2;
        b(i2, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            AtomicInteger atomicInteger = r8.f3055a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.g.add(this.g);
        materialButton.setOnPressedChangeListenerInternal(this.h);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        LinearLayout.LayoutParams layoutParams;
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
                MaterialButton c2 = c(i2);
                int min = Math.min(c2.getStrokeWidth(), c(i2 - 1).getStrokeWidth());
                ViewGroup.LayoutParams layoutParams2 = c2.getLayoutParams();
                if (layoutParams2 instanceof LinearLayout.LayoutParams) {
                    layoutParams = (LinearLayout.LayoutParams) layoutParams2;
                } else {
                    layoutParams = new LinearLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                }
                if (getOrientation() == 0) {
                    layoutParams.setMarginEnd(0);
                    layoutParams.setMarginStart(-min);
                    layoutParams.topMargin = 0;
                } else {
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = -min;
                    layoutParams.setMarginStart(0);
                }
                c2.setLayoutParams(layoutParams);
            }
            if (!(getChildCount() == 0 || firstVisibleChildIndex == -1)) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
                if (getOrientation() == 1) {
                    layoutParams3.topMargin = 0;
                    layoutParams3.bottomMargin = 0;
                    return;
                }
                layoutParams3.setMarginEnd(0);
                layoutParams3.setMarginStart(0);
                layoutParams3.leftMargin = 0;
                layoutParams3.rightMargin = 0;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof MaterialButton) {
            super.addView(view, i2, layoutParams);
            MaterialButton materialButton = (MaterialButton) view;
            setGeneratedIdIfNeeded(materialButton);
            setupButtonChild(materialButton);
            if (materialButton.isChecked()) {
                f(materialButton.getId(), true);
                setCheckedId(materialButton.getId());
            }
            ko4 shapeAppearanceModel = materialButton.getShapeAppearanceModel();
            this.f.add(new d(shapeAppearanceModel.e, shapeAppearanceModel.h, shapeAppearanceModel.f, shapeAppearanceModel.g));
            r8.v(materialButton, new b());
        }
    }

    public final void b(int i2, boolean z) {
        Iterator<e> it = this.i.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    public final MaterialButton c(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public final boolean d(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.j);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(c(i2), Integer.valueOf(i2));
        }
        this.k = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e(int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.l = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.l = false;
        }
    }

    public final boolean f(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.n || !checkedButtonIds.isEmpty()) {
            if (z && this.m) {
                checkedButtonIds.remove(Integer.valueOf(i2));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    e(intValue, false);
                    b(intValue, false);
                }
            }
            return true;
        }
        e(i2, true);
        this.o = i2;
        return false;
    }

    public void g() {
        d dVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton c2 = c(i2);
            if (c2.getVisibility() != 8) {
                ko4 shapeAppearanceModel = c2.getShapeAppearanceModel();
                Objects.requireNonNull(shapeAppearanceModel);
                ko4.b bVar = new ko4.b(shapeAppearanceModel);
                do4 do4 = d.e;
                d dVar2 = this.f.get(i2);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    if (i2 == firstVisibleChildIndex) {
                        if (!z) {
                            dVar = new d(dVar2.f620a, do4, dVar2.b, do4);
                        } else if (hd3.M1(this)) {
                            dVar = new d(do4, do4, dVar2.b, dVar2.c);
                        } else {
                            dVar = new d(dVar2.f620a, dVar2.d, do4, do4);
                        }
                    } else if (i2 != lastVisibleChildIndex) {
                        dVar2 = null;
                    } else if (!z) {
                        dVar = new d(do4, dVar2.d, do4, dVar2.c);
                    } else if (hd3.M1(this)) {
                        dVar = new d(dVar2.f620a, dVar2.d, do4, do4);
                    } else {
                        dVar = new d(do4, do4, dVar2.b, dVar2.c);
                    }
                    dVar2 = dVar;
                }
                if (dVar2 == null) {
                    bVar.c(0.0f);
                } else {
                    bVar.e = dVar2.f620a;
                    bVar.h = dVar2.d;
                    bVar.f = dVar2.b;
                    bVar.g = dVar2.c;
                }
                c2.setShapeAppearanceModel(bVar.a());
            }
        }
    }

    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.m) {
            return this.o;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton c2 = c(i2);
            if (c2.isChecked()) {
                arrayList.add(Integer.valueOf(c2.getId()));
            }
        }
        return arrayList;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.k;
        return (numArr == null || i3 >= numArr.length) ? i3 : numArr[i3].intValue();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.o;
        if (i2 != -1) {
            e(i2, true);
            f(i2, true);
            setCheckedId(i2);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) e9.b.a(1, getVisibleButtonCount(), false, this.m ? 1 : 2).f944a);
    }

    public void onMeasure(int i2, int i3) {
        g();
        a();
        super.onMeasure(i2, i3);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.g.remove(this.g);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f.remove(indexOfChild);
        }
        g();
        a();
    }

    public void setSelectionRequired(boolean z) {
        this.n = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.m != z) {
            this.m = z;
            this.l = true;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                MaterialButton c2 = c(i2);
                c2.setChecked(false);
                b(c2.getId(), false);
            }
            this.l = false;
            setCheckedId(-1);
        }
    }

    public void setSingleSelection(int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
