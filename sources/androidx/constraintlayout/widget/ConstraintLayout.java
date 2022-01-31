package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.x3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ConstraintLayout extends ViewGroup {
    public SparseArray<View> f = new SparseArray<>();
    public ArrayList<k4> g = new ArrayList<>(4);
    public o3 h = new o3();
    public int i = 0;
    public int j = 0;
    public int k = Integer.MAX_VALUE;
    public int l = Integer.MAX_VALUE;
    public boolean m = true;
    public int n = 263;
    public m4 o = null;
    public l4 p = null;
    public int q = -1;
    public HashMap<String, Integer> r = new HashMap<>();
    public int s = -1;
    public int t = -1;
    public SparseArray<n3> u = new SparseArray<>();
    public b v = new b(this, this);

    public class b implements x3.b {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintLayout f199a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        public b(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
            this.f199a = constraintLayout2;
        }

        /* JADX WARNING: Removed duplicated region for block: B:104:0x016c  */
        /* JADX WARNING: Removed duplicated region for block: B:109:0x0177  */
        /* JADX WARNING: Removed duplicated region for block: B:115:0x018a A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x01a3  */
        /* JADX WARNING: Removed duplicated region for block: B:130:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:131:0x01cd  */
        /* JADX WARNING: Removed duplicated region for block: B:133:0x01d9  */
        /* JADX WARNING: Removed duplicated region for block: B:134:0x01e3  */
        /* JADX WARNING: Removed duplicated region for block: B:137:0x01f0  */
        /* JADX WARNING: Removed duplicated region for block: B:138:0x01f5  */
        /* JADX WARNING: Removed duplicated region for block: B:141:0x01fa  */
        /* JADX WARNING: Removed duplicated region for block: B:144:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x0207  */
        /* JADX WARNING: Removed duplicated region for block: B:148:0x020c  */
        /* JADX WARNING: Removed duplicated region for block: B:151:0x0214 A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:161:0x0233  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x0239  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x024f  */
        /* JADX WARNING: Removed duplicated region for block: B:167:0x0251  */
        /* JADX WARNING: Removed duplicated region for block: B:170:0x0256  */
        /* JADX WARNING: Removed duplicated region for block: B:176:0x0264  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:83:0x0138  */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x014b  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x014d  */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0150  */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x0152  */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0157  */
        /* JADX WARNING: Removed duplicated region for block: B:98:0x0161  */
        @android.annotation.SuppressLint({"WrongCall"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(defpackage.n3 r22, defpackage.x3.a r23) {
            /*
            // Method dump skipped, instructions count: 634
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.a(n3, x3$a):void");
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
    }

    /* renamed from: b */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    public Object c(int i2, Object obj) {
        if (i2 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.r;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.r.get(str);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public View d(int i2) {
        return this.f.get(i2);
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<k4> arrayList = this.g;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                this.g.get(i2).i();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = (float) getWidth();
            float height = (float) getHeight();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i4 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i5 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = (float) i4;
                        float f3 = (float) i5;
                        float f4 = (float) (i4 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float parseInt4 = (float) (i5 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        canvas.drawLine(f4, f3, f4, parseInt4, paint);
                        canvas.drawLine(f4, parseInt4, f2, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, parseInt4, paint);
                        canvas.drawLine(f2, parseInt4, f4, f3, paint);
                    }
                }
            }
        }
    }

    public final n3 e(View view) {
        if (view == this) {
            return this.h;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).l0;
    }

    public final void f(AttributeSet attributeSet, int i2, int i3) {
        o3 o3Var = this.h;
        o3Var.W = this;
        b bVar = this.v;
        o3Var.h0 = bVar;
        o3Var.g0.f = bVar;
        this.f.put(getId(), this);
        this.o = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i2, i3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i4 = 0; i4 < indexCount; i4++) {
                int index = obtainStyledAttributes.getIndex(i4);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.i = obtainStyledAttributes.getDimensionPixelOffset(index, this.i);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.j = obtainStyledAttributes.getDimensionPixelOffset(index, this.j);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.k = obtainStyledAttributes.getDimensionPixelOffset(index, this.k);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.l = obtainStyledAttributes.getDimensionPixelOffset(index, this.l);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.n = obtainStyledAttributes.getInt(index, this.n);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            this.p = new l4(getContext(), this, resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.p = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        m4 m4Var = new m4();
                        this.o = m4Var;
                        m4Var.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.o = null;
                    }
                    this.q = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.h.O(this.n);
    }

    public void forceLayout() {
        this.m = true;
        this.s = -1;
        this.t = -1;
        super.forceLayout();
    }

    public boolean g() {
        if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.l;
    }

    public int getMaxWidth() {
        return this.k;
    }

    public int getMinHeight() {
        return this.j;
    }

    public int getMinWidth() {
        return this.i;
    }

    public int getOptimizationLevel() {
        return this.h.q0;
    }

    public void h(int i2, Object obj, Object obj2) {
        if (i2 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.r == null) {
                this.r = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(ConnectionFactory.DEFAULT_VHOST);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.r.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:256:0x051c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i() {
        /*
        // Method dump skipped, instructions count: 1419
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i():boolean");
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            a aVar = (a) childAt.getLayoutParams();
            n3 n3Var = aVar.l0;
            if ((childAt.getVisibility() != 8 || aVar.Y || aVar.Z || isInEditMode) && !aVar.a0) {
                int r2 = n3Var.r();
                int s2 = n3Var.s();
                int q2 = n3Var.q() + r2;
                int k2 = n3Var.k() + s2;
                childAt.layout(r2, s2, q2, k2);
                if ((childAt instanceof p4) && (content = ((p4) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(r2, s2, q2, k2);
                }
            }
        }
        int size = this.g.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                this.g.get(i7).g(this);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0216 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x04ba  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x04c7  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0559  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x055f  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x0563  */
    /* JADX WARNING: Removed duplicated region for block: B:346:0x0746  */
    /* JADX WARNING: Removed duplicated region for block: B:348:0x0749  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01af  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01bd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r25, int r26) {
        /*
        // Method dump skipped, instructions count: 1874
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        n3 e = e(view);
        if ((view instanceof Guideline) && !(e instanceof q3)) {
            a aVar = (a) view.getLayoutParams();
            q3 q3Var = new q3();
            aVar.l0 = q3Var;
            aVar.Y = true;
            q3Var.J(aVar.R);
        }
        if (view instanceof k4) {
            k4 k4Var = (k4) view;
            k4Var.j();
            ((a) view.getLayoutParams()).Z = true;
            if (!this.g.contains(k4Var)) {
                this.g.add(k4Var);
            }
        }
        this.f.put(view.getId(), view);
        this.m = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f.remove(view.getId());
        n3 e = e(view);
        this.h.e0.remove(e);
        e.K = null;
        this.g.remove(view);
        this.m = true;
    }

    public void removeView(View view) {
        super.removeView(view);
    }

    public void requestLayout() {
        this.m = true;
        this.s = -1;
        this.t = -1;
        super.requestLayout();
    }

    public void setConstraintSet(m4 m4Var) {
        this.o = m4Var;
    }

    public void setId(int i2) {
        this.f.remove(getId());
        super.setId(i2);
        this.f.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 != this.l) {
            this.l = i2;
            requestLayout();
        }
    }

    public void setMaxWidth(int i2) {
        if (i2 != this.k) {
            this.k = i2;
            requestLayout();
        }
    }

    public void setMinHeight(int i2) {
        if (i2 != this.j) {
            this.j = i2;
            requestLayout();
        }
    }

    public void setMinWidth(int i2) {
        if (i2 != this.i) {
            this.i = i2;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(o4 o4Var) {
        l4 l4Var = this.p;
        if (l4Var != null) {
            Objects.requireNonNull(l4Var);
        }
    }

    public void setOptimizationLevel(int i2) {
        this.n = i2;
        this.h.q0 = i2;
        f3.p = t3.a(i2, 256);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        f(attributeSet, i2, 0);
    }

    public static class a extends ViewGroup.MarginLayoutParams {
        public float A = 0.5f;
        public String B = null;
        public int C = 1;
        public float D = -1.0f;
        public float E = -1.0f;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public float N = 1.0f;
        public float O = 1.0f;
        public int P = -1;
        public int Q = -1;
        public int R = -1;
        public boolean S = false;
        public boolean T = false;
        public String U = null;
        public boolean V = true;
        public boolean W = true;
        public boolean X = false;
        public boolean Y = false;
        public boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f197a = -1;
        public boolean a0 = false;
        public int b = -1;
        public int b0 = -1;
        public float c = -1.0f;
        public int c0 = -1;
        public int d = -1;
        public int d0 = -1;
        public int e = -1;
        public int e0 = -1;
        public int f = -1;
        public int f0 = -1;
        public int g = -1;
        public int g0 = -1;
        public int h = -1;
        public float h0 = 0.5f;
        public int i = -1;
        public int i0;
        public int j = -1;
        public int j0;
        public int k = -1;
        public float k0;
        public int l = -1;
        public n3 l0 = new n3();
        public int m = -1;
        public int n = 0;
        public float o = 0.0f;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public int w = -1;
        public int x = -1;
        public int y = -1;
        public float z = 0.5f;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a  reason: collision with other inner class name */
        public static class C0001a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f198a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f198a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                f198a.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i2;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                int i4 = C0001a.f198a.get(index);
                switch (i4) {
                    case 1:
                        this.R = obtainStyledAttributes.getInt(index, this.R);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.m);
                        this.m = resourceId;
                        if (resourceId == -1) {
                            this.m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.n = obtainStyledAttributes.getDimensionPixelSize(index, this.n);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.o) % 360.0f;
                        this.o = f2;
                        if (f2 < 0.0f) {
                            this.o = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f197a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f197a);
                        break;
                    case 6:
                        this.b = obtainStyledAttributes.getDimensionPixelOffset(index, this.b);
                        break;
                    case 7:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.d);
                        this.d = resourceId2;
                        if (resourceId2 == -1) {
                            this.d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.e);
                        this.e = resourceId3;
                        if (resourceId3 == -1) {
                            this.e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f);
                        this.f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.g);
                        this.g = resourceId5;
                        if (resourceId5 == -1) {
                            this.g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.h);
                        this.h = resourceId6;
                        if (resourceId6 == -1) {
                            this.h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.i);
                        this.i = resourceId7;
                        if (resourceId7 == -1) {
                            this.i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId9;
                        if (resourceId9 == -1) {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.l);
                        this.l = resourceId10;
                        if (resourceId10 == -1) {
                            this.l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 == -1) {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 == -1) {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 == -1) {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 == -1) {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.S = obtainStyledAttributes.getBoolean(index, this.S);
                        break;
                    case 28:
                        this.T = obtainStyledAttributes.getBoolean(index, this.T);
                        break;
                    case 29:
                        this.z = obtainStyledAttributes.getFloat(index, this.z);
                        break;
                    case 30:
                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                        break;
                    case 31:
                        this.H = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.I = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.J) == -2) {
                                this.J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.L) == -2) {
                                this.L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.N));
                        this.H = 2;
                        break;
                    case 36:
                        try {
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.K) == -2) {
                                this.K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.M) == -2) {
                                this.M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.O));
                        this.I = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.B = string;
                                this.C = -1;
                                if (string == null) {
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i2 = 0;
                                    } else {
                                        String substring = this.B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.C = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.C = 1;
                                        }
                                        i2 = indexOf + 1;
                                    }
                                    int indexOf2 = this.B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.B.substring(i2, indexOf2);
                                        String substring3 = this.B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.C == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.B.substring(i2);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            Float.parseFloat(substring4);
                                            continue;
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.D = obtainStyledAttributes.getFloat(index, this.D);
                                continue;
                            case 46:
                                this.E = obtainStyledAttributes.getFloat(index, this.E);
                                continue;
                            case 47:
                                this.F = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.P = obtainStyledAttributes.getDimensionPixelOffset(index, this.P);
                                continue;
                            case 50:
                                this.Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.Q);
                                continue;
                            case 51:
                                this.U = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.Y = false;
            this.V = true;
            this.W = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.S) {
                this.V = false;
                if (this.H == 0) {
                    this.H = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.T) {
                this.W = false;
                if (this.I == 0) {
                    this.I = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.V = false;
                if (i2 == 0 && this.H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.S = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.W = false;
                if (i3 == 0 && this.I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.T = true;
                }
            }
            if (this.c != -1.0f || this.f197a != -1 || this.b != -1) {
                this.Y = true;
                this.V = true;
                this.W = true;
                if (!(this.l0 instanceof q3)) {
                    this.l0 = new q3();
                }
                ((q3) this.l0).J(this.R);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x0080  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r10) {
            /*
            // Method dump skipped, instructions count: 257
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.resolveLayoutDirection(int):void");
        }

        public a(int i2, int i3) {
            super(i2, i3);
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
