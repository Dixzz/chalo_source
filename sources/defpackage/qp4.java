package defpackage;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import defpackage.ho4;
import defpackage.ko4;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: qp4  reason: default package */
/* compiled from: DropdownMenuEndIconDelegate */
public class qp4 extends vp4 {
    public final TextWatcher d = new a();
    public final View.OnFocusChangeListener e = new b();
    public final TextInputLayout.e f = new c(this.f3673a);
    public final TextInputLayout.f g = new d();
    @SuppressLint({"ClickableViewAccessibility"})
    public final TextInputLayout.g h = new e();
    public boolean i = false;
    public boolean j = false;
    public long k = Long.MAX_VALUE;
    public StateListDrawable l;
    public ho4 m;
    public AccessibilityManager n;
    public ValueAnimator o;
    public ValueAnimator p;

    /* renamed from: qp4$a */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class a extends ln4 {

        /* renamed from: qp4$a$a  reason: collision with other inner class name */
        /* compiled from: DropdownMenuEndIconDelegate */
        public class RunnableC0049a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView f;

            public RunnableC0049a(AutoCompleteTextView autoCompleteTextView) {
                this.f = autoCompleteTextView;
            }

            public void run() {
                boolean isPopupShowing = this.f.isPopupShowing();
                qp4.g(qp4.this, isPopupShowing);
                qp4.this.i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // defpackage.ln4
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView e = qp4.e(qp4.this.f3673a.getEditText());
            if (qp4.this.n.isTouchExplorationEnabled() && qp4.f(e) && !qp4.this.c.hasFocus()) {
                e.dismissDropDown();
            }
            e.post(new RunnableC0049a(e));
        }
    }

    /* renamed from: qp4$b */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            qp4.this.f3673a.setEndIconActivated(z);
            if (!z) {
                qp4.g(qp4.this, false);
                qp4.this.i = false;
            }
        }
    }

    /* renamed from: qp4$c */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class c extends TextInputLayout.e {
        public c(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, defpackage.z7
        public void d(View view, e9 e9Var) {
            boolean z;
            super.d(view, e9Var);
            if (!qp4.f(qp4.this.f3673a.getEditText())) {
                e9Var.f942a.setClassName(Spinner.class.getName());
            }
            if (Build.VERSION.SDK_INT >= 26) {
                z = e9Var.f942a.isShowingHintText();
            } else {
                Bundle h = e9Var.h();
                z = h != null && (h.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & 4) == 4;
            }
            if (z) {
                e9Var.o(null);
            }
        }

        @Override // defpackage.z7
        public void e(View view, AccessibilityEvent accessibilityEvent) {
            this.f4141a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView e2 = qp4.e(qp4.this.f3673a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && qp4.this.n.isTouchExplorationEnabled() && !qp4.f(qp4.this.f3673a.getEditText())) {
                qp4.h(qp4.this, e2);
            }
        }
    }

    /* renamed from: qp4$d */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class d implements TextInputLayout.f {
        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            AutoCompleteTextView e = qp4.e(textInputLayout.getEditText());
            qp4 qp4 = qp4.this;
            int boxBackgroundMode = qp4.f3673a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                e.setDropDownBackgroundDrawable(qp4.m);
            } else if (boxBackgroundMode == 1) {
                e.setDropDownBackgroundDrawable(qp4.l);
            }
            qp4 qp42 = qp4.this;
            Objects.requireNonNull(qp42);
            boolean z = false;
            if (!(e.getKeyListener() != null)) {
                int boxBackgroundMode2 = qp42.f3673a.getBoxBackgroundMode();
                ho4 boxBackground = qp42.f3673a.getBoxBackground();
                int g1 = hd3.g1(e, R.attr.colorControlHighlight);
                int[][] iArr = {new int[]{16842919}, new int[0]};
                if (boxBackgroundMode2 == 2) {
                    int g12 = hd3.g1(e, R.attr.colorSurface);
                    ho4 ho4 = new ho4(boxBackground.f.f1403a);
                    int Z1 = hd3.Z1(g1, g12, 0.1f);
                    ho4.q(new ColorStateList(iArr, new int[]{Z1, 0}));
                    ho4.setTint(g12);
                    ColorStateList colorStateList = new ColorStateList(iArr, new int[]{Z1, g12});
                    ho4 ho42 = new ho4(boxBackground.f.f1403a);
                    ho42.setTint(-1);
                    LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, ho4, ho42), boxBackground});
                    AtomicInteger atomicInteger = r8.f3055a;
                    e.setBackground(layerDrawable);
                } else if (boxBackgroundMode2 == 1) {
                    int boxBackgroundColor = qp42.f3673a.getBoxBackgroundColor();
                    RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(iArr, new int[]{hd3.Z1(g1, boxBackgroundColor, 0.1f), boxBackgroundColor}), boxBackground, boxBackground);
                    AtomicInteger atomicInteger2 = r8.f3055a;
                    e.setBackground(rippleDrawable);
                }
            }
            qp4 qp43 = qp4.this;
            Objects.requireNonNull(qp43);
            e.setOnTouchListener(new sp4(qp43, e));
            e.setOnFocusChangeListener(qp43.e);
            e.setOnDismissListener(new tp4(qp43));
            e.setThreshold(0);
            e.removeTextChangedListener(qp4.this.d);
            e.addTextChangedListener(qp4.this.d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (e.getKeyListener() != null) {
                z = true;
            }
            if (!z) {
                CheckableImageButton checkableImageButton = qp4.this.c;
                AtomicInteger atomicInteger3 = r8.f3055a;
                checkableImageButton.setImportantForAccessibility(2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(qp4.this.f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* renamed from: qp4$e */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class e implements TextInputLayout.g {

        /* renamed from: qp4$e$a */
        /* compiled from: DropdownMenuEndIconDelegate */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView f;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.f = autoCompleteTextView;
            }

            public void run() {
                this.f.removeTextChangedListener(qp4.this.d);
            }
        }

        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView != null && i == 3) {
                autoCompleteTextView.post(new a(autoCompleteTextView));
                if (autoCompleteTextView.getOnFocusChangeListener() == qp4.this.e) {
                    autoCompleteTextView.setOnFocusChangeListener(null);
                }
                autoCompleteTextView.setOnTouchListener(null);
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* renamed from: qp4$f */
    /* compiled from: DropdownMenuEndIconDelegate */
    public class f implements View.OnClickListener {
        public f() {
        }

        public void onClick(View view) {
            qp4.h(qp4.this, (AutoCompleteTextView) qp4.this.f3673a.getEditText());
        }
    }

    public qp4(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static AutoCompleteTextView e(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    public static boolean f(EditText editText) {
        return editText.getKeyListener() != null;
    }

    public static void g(qp4 qp4, boolean z) {
        if (qp4.j != z) {
            qp4.j = z;
            qp4.p.cancel();
            qp4.o.start();
        }
    }

    public static void h(qp4 qp4, AutoCompleteTextView autoCompleteTextView) {
        Objects.requireNonNull(qp4);
        if (autoCompleteTextView != null) {
            if (qp4.j()) {
                qp4.i = false;
            }
            if (!qp4.i) {
                boolean z = qp4.j;
                boolean z2 = !z;
                if (z != z2) {
                    qp4.j = z2;
                    qp4.p.cancel();
                    qp4.o.start();
                }
                if (qp4.j) {
                    autoCompleteTextView.requestFocus();
                    autoCompleteTextView.showDropDown();
                    return;
                }
                autoCompleteTextView.dismissDropDown();
                return;
            }
            qp4.i = false;
        }
    }

    @Override // defpackage.vp4
    public void a() {
        float dimensionPixelOffset = (float) this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = (float) this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        ho4 i2 = i(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        ho4 i3 = i(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.m = i2;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, i2);
        this.l.addState(new int[0], i3);
        this.f3673a.setEndIconDrawable(u0.b(this.b, R.drawable.mtrl_dropdown_arrow));
        TextInputLayout textInputLayout = this.f3673a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.f3673a.setEndIconOnClickListener(new f());
        this.f3673a.a(this.g);
        TextInputLayout textInputLayout2 = this.f3673a;
        textInputLayout2.k0.add(this.h);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = zj4.f4184a;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration((long) 67);
        ofFloat.addUpdateListener(new rp4(this));
        this.p = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration((long) 50);
        ofFloat2.addUpdateListener(new rp4(this));
        this.o = ofFloat2;
        ofFloat2.addListener(new up4(this));
        this.n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    @Override // defpackage.vp4
    public boolean b(int i2) {
        return i2 != 0;
    }

    @Override // defpackage.vp4
    public boolean d() {
        return true;
    }

    public final ho4 i(float f2, float f3, float f4, int i2) {
        ko4.b bVar = new ko4.b();
        bVar.e = new bo4(f2);
        bVar.f = new bo4(f2);
        bVar.h = new bo4(f3);
        bVar.g = new bo4(f3);
        ko4 a2 = bVar.a();
        Context context = this.b;
        String str = ho4.B;
        int G2 = hd3.G2(context, R.attr.colorSurface, ho4.class.getSimpleName());
        ho4 ho4 = new ho4();
        ho4.f.b = new tm4(context);
        ho4.y();
        ho4.q(ColorStateList.valueOf(G2));
        ho4.b bVar2 = ho4.f;
        if (bVar2.o != f4) {
            bVar2.o = f4;
            ho4.y();
        }
        ho4.f.f1403a = a2;
        ho4.invalidateSelf();
        ho4.b bVar3 = ho4.f;
        if (bVar3.i == null) {
            bVar3.i = new Rect();
        }
        ho4.f.i.set(0, i2, 0, i2);
        ho4.invalidateSelf();
        return ho4;
    }

    public final boolean j() {
        long currentTimeMillis = System.currentTimeMillis() - this.k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }
}
