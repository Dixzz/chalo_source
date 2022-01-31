package defpackage;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Locale;

/* renamed from: yp4  reason: default package */
/* compiled from: MaterialAutoCompleteTextView */
public class yp4 extends AppCompatAutoCompleteTextView {
    public final ListPopupWindow f;
    public final AccessibilityManager g;
    public final Rect h = new Rect();

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public yp4(android.content.Context r8, android.util.AttributeSet r9) {
        /*
            r7 = this;
            int r3 = com.google.android.material.R.attr.autoCompleteTextViewStyle
            r6 = 0
            android.content.Context r8 = defpackage.bq4.a(r8, r9, r3, r6)
            r7.<init>(r8, r9, r3)
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            r7.h = r8
            android.content.Context r8 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView
            int r4 = com.google.android.material.R.style.Widget_AppCompat_AutoCompleteTextView
            int[] r5 = new int[r6]
            r0 = r8
            r1 = r9
            android.content.res.TypedArray r9 = defpackage.mn4.d(r0, r1, r2, r3, r4, r5)
            int r0 = com.google.android.material.R.styleable.MaterialAutoCompleteTextView_android_inputType
            boolean r1 = r9.hasValue(r0)
            if (r1 == 0) goto L_0x0033
            int r0 = r9.getInt(r0, r6)
            if (r0 != 0) goto L_0x0033
            r0 = 0
            r7.setKeyListener(r0)
        L_0x0033:
            java.lang.String r0 = "accessibility"
            java.lang.Object r0 = r8.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r0 = (android.view.accessibility.AccessibilityManager) r0
            r7.g = r0
            androidx.appcompat.widget.ListPopupWindow r0 = new androidx.appcompat.widget.ListPopupWindow
            r0.<init>(r8)
            r7.f = r0
            r8 = 1
            r0.setModal(r8)
            r0.setAnchorView(r7)
            r8 = 2
            r0.setInputMethodMode(r8)
            android.widget.ListAdapter r8 = r7.getAdapter()
            r0.setAdapter(r8)
            xp4 r8 = new xp4
            r8.<init>(r7)
            r0.setOnItemClickListener(r8)
            r9.recycle()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yp4.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public static void a(yp4 yp4, Object obj) {
        yp4.setText(yp4.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    public CharSequence getHint() {
        TextInputLayout b = b();
        if (b == null || !b.F) {
            return super.getHint();
        }
        return b.getHint();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b = b();
        if (b != null && b.F && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b = b();
            int i3 = 0;
            if (!(adapter == null || b == null)) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                int min = Math.min(adapter.getCount(), Math.max(0, this.f.getSelectedItemPosition()) + 15);
                View view = null;
                int i4 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i3) {
                        view = null;
                        i3 = itemViewType;
                    }
                    view = adapter.getView(max, view, b);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i4 = Math.max(i4, view.getMeasuredWidth());
                }
                Drawable background = this.f.getBackground();
                if (background != null) {
                    background.getPadding(this.h);
                    Rect rect = this.h;
                    i4 += rect.left + rect.right;
                }
                i3 = b.getEndIconView().getMeasuredWidth() + i4;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i3), View.MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        this.f.setAdapter(getAdapter());
    }

    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.g;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f.show();
        }
    }
}
