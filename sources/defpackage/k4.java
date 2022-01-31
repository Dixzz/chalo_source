package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: k4  reason: default package */
/* compiled from: ConstraintHelper */
public abstract class k4 extends View {
    public int[] f;
    public int g;
    public Context h;
    public r3 i;
    public String j;
    public HashMap<Integer, String> k;

    public k4(Context context) {
        super(context);
        this.f = new int[32];
        this.k = new HashMap<>();
        this.h = context;
        e(null);
    }

    public final void a(String str) {
        if (str != null && str.length() != 0 && this.h != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            ConstraintLayout constraintLayout2 = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
            int i2 = 0;
            if (isInEditMode() && constraintLayout2 != null) {
                Object c = constraintLayout2.c(0, trim);
                if (c instanceof Integer) {
                    i2 = ((Integer) c).intValue();
                }
            }
            if (i2 == 0 && constraintLayout2 != null) {
                i2 = d(constraintLayout2, trim);
            }
            if (i2 == 0) {
                try {
                    i2 = R.id.class.getField(trim).getInt(null);
                } catch (Exception unused) {
                }
            }
            if (i2 == 0) {
                i2 = this.h.getResources().getIdentifier(trim, "id", this.h.getPackageName());
            }
            if (i2 != 0) {
                this.k.put(Integer.valueOf(i2), trim);
                b(i2);
            }
        }
    }

    public final void b(int i2) {
        if (i2 != getId()) {
            int i3 = this.g + 1;
            int[] iArr = this.f;
            if (i3 > iArr.length) {
                this.f = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f;
            int i4 = this.g;
            iArr2[i4] = i2;
            this.g = i4 + 1;
        }
    }

    public void c() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) parent;
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.g; i2++) {
                View d = constraintLayout.d(this.f[i2]);
                if (d != null) {
                    d.setVisibility(visibility);
                    if (elevation > 0.0f) {
                        d.setTranslationZ(d.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final int d(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.h.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.j = string;
                    setIds(string);
                }
            }
        }
    }

    public void f(n3 n3Var, boolean z) {
    }

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f, this.g);
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
        if (this.i != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.a) {
                ((ConstraintLayout.a) layoutParams).l0 = (n3) this.i;
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.j;
        if (str != null) {
            setIds(str);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(0, 0);
    }

    public void setIds(String str) {
        this.j = str;
        if (str != null) {
            int i2 = 0;
            this.g = 0;
            while (true) {
                int indexOf = str.indexOf(44, i2);
                if (indexOf == -1) {
                    a(str.substring(i2));
                    return;
                } else {
                    a(str.substring(i2, indexOf));
                    i2 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.j = null;
        this.g = 0;
        for (int i2 : iArr) {
            b(i2);
        }
    }

    public k4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new int[32];
        this.k = new HashMap<>();
        this.h = context;
        e(attributeSet);
    }
}
