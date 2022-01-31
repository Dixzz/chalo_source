package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class TextInputLayout extends LinearLayout {
    public static final int O0 = R.style.Widget_Design_TextInputLayout;
    public final TextView A;
    public int A0;
    public CharSequence B;
    public ColorStateList B0;
    public final TextView C;
    public int C0;
    public boolean D;
    public int D0;
    public CharSequence E;
    public int E0;
    public boolean F;
    public int F0;
    public ho4 G;
    public int G0;
    public ho4 H;
    public boolean H0;
    public ko4 I;
    public final en4 I0;
    public final int J;
    public boolean J0;
    public int K;
    public boolean K0;
    public int L;
    public ValueAnimator L0;
    public int M;
    public boolean M0;
    public int N;
    public boolean N0;
    public int O;
    public int P;
    public int Q;
    public final Rect R = new Rect();
    public final Rect S = new Rect();
    public final RectF T = new RectF();
    public Typeface U;
    public final CheckableImageButton V;
    public ColorStateList W;
    public boolean a0;
    public PorterDuff.Mode b0;
    public boolean c0;
    public Drawable d0;
    public int e0;
    public final FrameLayout f;
    public View.OnLongClickListener f0;
    public final LinearLayout g;
    public final LinkedHashSet<f> g0 = new LinkedHashSet<>();
    public final LinearLayout h;
    public int h0 = 0;
    public final FrameLayout i;
    public final SparseArray<vp4> i0 = new SparseArray<>();
    public EditText j;
    public final CheckableImageButton j0;
    public CharSequence k;
    public final LinkedHashSet<g> k0 = new LinkedHashSet<>();
    public final wp4 l = new wp4(this);
    public ColorStateList l0;
    public boolean m;
    public boolean m0;
    public int n;
    public PorterDuff.Mode n0;
    public boolean o;
    public boolean o0;
    public TextView p;
    public Drawable p0;
    public int q;
    public int q0;
    public int r;
    public Drawable r0;
    public CharSequence s;
    public View.OnLongClickListener s0;
    public boolean t;
    public View.OnLongClickListener t0;
    public TextView u;
    public final CheckableImageButton u0;
    public ColorStateList v;
    public ColorStateList v0;
    public int w;
    public ColorStateList w0;
    public ColorStateList x;
    public ColorStateList x0;
    public ColorStateList y;
    public int y0;
    public CharSequence z;
    public int z0;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public CharSequence f;
        public boolean g;
        public CharSequence h;
        public CharSequence i;
        public CharSequence j;

        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("TextInputLayout.SavedState{");
            i0.append(Integer.toHexString(System.identityHashCode(this)));
            i0.append(" error=");
            i0.append((Object) this.f);
            i0.append(" hint=");
            i0.append((Object) this.h);
            i0.append(" helperText=");
            i0.append((Object) this.i);
            i0.append(" placeholderText=");
            i0.append((Object) this.j);
            i0.append("}");
            return i0.toString();
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f, parcel, i2);
            parcel.writeInt(this.g ? 1 : 0);
            TextUtils.writeToParcel(this.h, parcel, i2);
            TextUtils.writeToParcel(this.i, parcel, i2);
            TextUtils.writeToParcel(this.j, parcel, i2);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.g = parcel.readInt() != 1 ? false : true;
            this.h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.j = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            TextInputLayout textInputLayout = TextInputLayout.this;
            textInputLayout.y(!textInputLayout.N0, false);
            TextInputLayout textInputLayout2 = TextInputLayout.this;
            if (textInputLayout2.m) {
                textInputLayout2.t(editable.length());
            }
            TextInputLayout textInputLayout3 = TextInputLayout.this;
            if (textInputLayout3.t) {
                textInputLayout3.z(editable.length());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            TextInputLayout.this.j0.performClick();
            TextInputLayout.this.j0.jumpDrawablesToCurrentState();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            TextInputLayout.this.j.requestLayout();
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TextInputLayout.this.I0.w(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static class e extends z7 {
        public final TextInputLayout d;

        public e(TextInputLayout textInputLayout) {
            this.d = textInputLayout;
        }

        @Override // defpackage.z7
        public void d(View view, e9 e9Var) {
            this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
            EditText editText = this.d.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.d.getHint();
            CharSequence error = this.d.getError();
            CharSequence placeholderText = this.d.getPlaceholderText();
            int counterMaxLength = this.d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.d.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.d.H0;
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                e9Var.f942a.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                e9Var.f942a.setText(charSequence);
                if (z3 && placeholderText != null) {
                    e9Var.f942a.setText(charSequence + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                e9Var.f942a.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                int i = Build.VERSION.SDK_INT;
                if (i >= 26) {
                    e9Var.o(charSequence);
                } else {
                    if (z) {
                        charSequence = ((Object) text) + ", " + charSequence;
                    }
                    e9Var.f942a.setText(charSequence);
                }
                boolean z6 = !z;
                if (i >= 26) {
                    e9Var.f942a.setShowingHintText(z6);
                } else {
                    e9Var.l(4, z6);
                }
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            e9Var.f942a.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                e9Var.f942a.setError(error);
            }
            if (editText != null) {
                editText.setLabelFor(R.id.textinput_helper_text);
            }
        }
    }

    public interface f {
        void a(TextInputLayout textInputLayout);
    }

    public interface g {
        void a(TextInputLayout textInputLayout, int i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v13, resolved type: androidx.appcompat.widget.TintTypedArray */
    /* JADX DEBUG: Multi-variable search result rejected for r7v3, resolved type: android.view.LayoutInflater */
    /* JADX DEBUG: Multi-variable search result rejected for r10v11, resolved type: android.view.ViewGroup$MarginLayoutParams */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v44, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v156 */
    /* JADX WARN: Type inference failed for: r2v157 */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r24, android.util.AttributeSet r25) {
        /*
        // Method dump skipped, instructions count: 1570
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    private vp4 getEndIconDelegate() {
        vp4 vp4 = this.i0.get(this.h0);
        return vp4 != null ? vp4 : this.i0.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.u0.getVisibility() == 0) {
            return this.u0;
        }
        if (!j() || !k()) {
            return null;
        }
        return this.j0;
    }

    public static void n(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                n((ViewGroup) childAt, z2);
            }
        }
    }

    public static void q(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        AtomicInteger atomicInteger = r8.f3055a;
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (hasOnClickListeners || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        checkableImageButton.setImportantForAccessibility(i2);
    }

    private void setEditText(EditText editText) {
        if (this.j == null) {
            if (this.h0 != 3) {
                boolean z2 = editText instanceof TextInputEditText;
            }
            this.j = editText;
            l();
            setTextInputAccessibilityDelegate(new e(this));
            this.I0.A(this.j.getTypeface());
            en4 en4 = this.I0;
            float textSize = this.j.getTextSize();
            if (en4.i != textSize) {
                en4.i = textSize;
                en4.m();
            }
            int gravity = this.j.getGravity();
            this.I0.q((gravity & -113) | 48);
            this.I0.u(gravity);
            this.j.addTextChangedListener(new a());
            if (this.w0 == null) {
                this.w0 = this.j.getHintTextColors();
            }
            if (this.D) {
                if (TextUtils.isEmpty(this.E)) {
                    CharSequence hint = this.j.getHint();
                    this.k = hint;
                    setHint(hint);
                    this.j.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.p != null) {
                t(this.j.getText().length());
            }
            w();
            this.l.b();
            this.g.bringToFront();
            this.h.bringToFront();
            this.i.bringToFront();
            this.u0.bringToFront();
            Iterator<f> it = this.g0.iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
            A();
            D();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            y(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.u0.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.i;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        D();
        if (!j()) {
            v();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.E)) {
            this.E = charSequence;
            this.I0.z(charSequence);
            if (!this.H0) {
                m();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.t != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.u = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_placeholder);
                TextView textView = this.u;
                AtomicInteger atomicInteger = r8.f3055a;
                textView.setAccessibilityLiveRegion(1);
                setPlaceholderTextAppearance(this.w);
                setPlaceholderTextColor(this.v);
                TextView textView2 = this.u;
                if (textView2 != null) {
                    this.f.addView(textView2);
                    this.u.setVisibility(0);
                }
            } else {
                TextView textView3 = this.u;
                if (textView3 != null) {
                    textView3.setVisibility(8);
                }
                this.u = null;
            }
            this.t = z2;
        }
    }

    public final void A() {
        if (this.j != null) {
            int i2 = 0;
            if (!(this.V.getVisibility() == 0)) {
                EditText editText = this.j;
                AtomicInteger atomicInteger = r8.f3055a;
                i2 = editText.getPaddingStart();
            }
            TextView textView = this.A;
            int compoundPaddingTop = this.j.getCompoundPaddingTop();
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
            int compoundPaddingBottom = this.j.getCompoundPaddingBottom();
            AtomicInteger atomicInteger2 = r8.f3055a;
            textView.setPaddingRelative(i2, compoundPaddingTop, dimensionPixelSize, compoundPaddingBottom);
        }
    }

    public final void B() {
        this.A.setVisibility((this.z == null || this.H0) ? 8 : 0);
        v();
    }

    public final void C(boolean z2, boolean z3) {
        int defaultColor = this.B0.getDefaultColor();
        int colorForState = this.B0.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.B0.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.P = colorForState2;
        } else if (z3) {
            this.P = colorForState;
        } else {
            this.P = defaultColor;
        }
    }

    public final void D() {
        if (this.j != null) {
            int i2 = 0;
            if (!k()) {
                if (!(this.u0.getVisibility() == 0)) {
                    EditText editText = this.j;
                    AtomicInteger atomicInteger = r8.f3055a;
                    i2 = editText.getPaddingEnd();
                }
            }
            TextView textView = this.C;
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
            int paddingTop = this.j.getPaddingTop();
            int paddingBottom = this.j.getPaddingBottom();
            AtomicInteger atomicInteger2 = r8.f3055a;
            textView.setPaddingRelative(dimensionPixelSize, paddingTop, i2, paddingBottom);
        }
    }

    public final void E() {
        int visibility = this.C.getVisibility();
        int i2 = 0;
        boolean z2 = this.B != null && !this.H0;
        TextView textView = this.C;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.C.getVisibility()) {
            getEndIconDelegate().c(z2);
        }
        v();
    }

    public void F() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G != null && this.K != 0) {
            boolean z2 = false;
            boolean z3 = isFocused() || ((editText2 = this.j) != null && editText2.hasFocus());
            boolean z4 = isHovered() || ((editText = this.j) != null && editText.isHovered());
            if (!isEnabled()) {
                this.P = this.G0;
            } else if (this.l.e()) {
                if (this.B0 != null) {
                    C(z3, z4);
                } else {
                    this.P = this.l.g();
                }
            } else if (!this.o || (textView = this.p) == null) {
                if (z3) {
                    this.P = this.A0;
                } else if (z4) {
                    this.P = this.z0;
                } else {
                    this.P = this.y0;
                }
            } else if (this.B0 != null) {
                C(z3, z4);
            } else {
                this.P = textView.getCurrentTextColor();
            }
            if (getErrorIconDrawable() != null) {
                wp4 wp4 = this.l;
                if (wp4.k && wp4.e()) {
                    z2 = true;
                }
            }
            setErrorIconVisible(z2);
            p(this.u0, this.v0);
            p(this.V, this.W);
            o();
            if (getEndIconDelegate().d()) {
                if (!this.l.e() || getEndIconDrawable() == null) {
                    d();
                } else {
                    Drawable mutate = h.H0(getEndIconDrawable()).mutate();
                    mutate.setTint(this.l.g());
                    this.j0.setImageDrawable(mutate);
                }
            }
            if (!z3 || !isEnabled()) {
                this.M = this.N;
            } else {
                this.M = this.O;
            }
            if (this.K == 1) {
                if (!isEnabled()) {
                    this.Q = this.D0;
                } else if (z4 && !z3) {
                    this.Q = this.F0;
                } else if (z3) {
                    this.Q = this.E0;
                } else {
                    this.Q = this.C0;
                }
            }
            c();
        }
    }

    public void a(f fVar) {
        this.g0.add(fVar);
        if (this.j != null) {
            fVar.a(this);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f.addView(view, layoutParams2);
            this.f.setLayoutParams(layoutParams);
            x();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public void b(float f2) {
        if (this.I0.c != f2) {
            if (this.L0 == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.L0 = valueAnimator;
                valueAnimator.setInterpolator(zj4.b);
                this.L0.setDuration(167L);
                this.L0.addUpdateListener(new d());
            }
            this.L0.setFloatValues(this.I0.c, f2);
            this.L0.start();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.c():void");
    }

    public final void d() {
        e(this.j0, this.m0, this.l0, this.o0, this.n0);
    }

    @TargetApi(26)
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.j;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.k != null) {
            boolean z2 = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.j.setHint(this.k);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.j.setHint(hint);
                this.F = z2;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.f.getChildCount());
            for (int i3 = 0; i3 < this.f.getChildCount(); i3++) {
                View childAt = this.f.getChildAt(i3);
                ViewStructure newChild = viewStructure.newChild(i3);
                childAt.dispatchProvideAutofillStructure(newChild, i2);
                if (childAt == this.j) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.N0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.N0 = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.D) {
            this.I0.g(canvas);
        }
        ho4 ho4 = this.H;
        if (ho4 != null) {
            Rect bounds = ho4.getBounds();
            bounds.top = bounds.bottom - this.M;
            this.H.draw(canvas);
        }
    }

    public void drawableStateChanged() {
        if (!this.M0) {
            boolean z2 = true;
            this.M0 = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            en4 en4 = this.I0;
            boolean y2 = en4 != null ? en4.y(drawableState) | false : false;
            if (this.j != null) {
                AtomicInteger atomicInteger = r8.f3055a;
                if (!isLaidOut() || !isEnabled()) {
                    z2 = false;
                }
                y(z2, false);
            }
            w();
            F();
            if (y2) {
                invalidate();
            }
            this.M0 = false;
        }
    }

    public final void e(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = h.H0(drawable).mutate();
            if (z2) {
                drawable.setTintList(colorStateList);
            }
            if (z3) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public final int f() {
        float h2;
        if (!this.D) {
            return 0;
        }
        int i2 = this.K;
        if (i2 == 0 || i2 == 1) {
            h2 = this.I0.h();
        } else if (i2 != 2) {
            return 0;
        } else {
            h2 = this.I0.h() / 2.0f;
        }
        return (int) h2;
    }

    public final boolean g() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof pp4);
    }

    public int getBaseline() {
        EditText editText = this.j;
        if (editText == null) {
            return super.getBaseline();
        }
        return f() + getPaddingTop() + editText.getBaseline();
    }

    public ho4 getBoxBackground() {
        int i2 = this.K;
        if (i2 == 1 || i2 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.Q;
    }

    public int getBoxBackgroundMode() {
        return this.K;
    }

    public float getBoxCornerRadiusBottomEnd() {
        ho4 ho4 = this.G;
        return ho4.f.f1403a.h.a(ho4.h());
    }

    public float getBoxCornerRadiusBottomStart() {
        ho4 ho4 = this.G;
        return ho4.f.f1403a.g.a(ho4.h());
    }

    public float getBoxCornerRadiusTopEnd() {
        ho4 ho4 = this.G;
        return ho4.f.f1403a.f.a(ho4.h());
    }

    public float getBoxCornerRadiusTopStart() {
        return this.G.l();
    }

    public int getBoxStrokeColor() {
        return this.A0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.B0;
    }

    public int getBoxStrokeWidth() {
        return this.N;
    }

    public int getBoxStrokeWidthFocused() {
        return this.O;
    }

    public int getCounterMaxLength() {
        return this.n;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.m || !this.o || (textView = this.p) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.x;
    }

    public ColorStateList getCounterTextColor() {
        return this.x;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.w0;
    }

    public EditText getEditText() {
        return this.j;
    }

    public CharSequence getEndIconContentDescription() {
        return this.j0.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.j0.getDrawable();
    }

    public int getEndIconMode() {
        return this.h0;
    }

    public CheckableImageButton getEndIconView() {
        return this.j0;
    }

    public CharSequence getError() {
        wp4 wp4 = this.l;
        if (wp4.k) {
            return wp4.j;
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.l.m;
    }

    public int getErrorCurrentTextColors() {
        return this.l.g();
    }

    public Drawable getErrorIconDrawable() {
        return this.u0.getDrawable();
    }

    public final int getErrorTextCurrentColor() {
        return this.l.g();
    }

    public CharSequence getHelperText() {
        wp4 wp4 = this.l;
        if (wp4.q) {
            return wp4.p;
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        TextView textView = this.l.r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    public final float getHintCollapsedTextHeight() {
        return this.I0.h();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.I0.i();
    }

    public ColorStateList getHintTextColor() {
        return this.x0;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.j0.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.j0.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.t) {
            return this.s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.v;
    }

    public CharSequence getPrefixText() {
        return this.z;
    }

    public ColorStateList getPrefixTextColor() {
        return this.A.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.A;
    }

    public CharSequence getStartIconContentDescription() {
        return this.V.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.V.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.B;
    }

    public ColorStateList getSuffixTextColor() {
        return this.C.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.C;
    }

    public Typeface getTypeface() {
        return this.U;
    }

    public final int h(int i2, boolean z2) {
        int compoundPaddingLeft = this.j.getCompoundPaddingLeft() + i2;
        return (this.z == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.A.getMeasuredWidth()) + this.A.getPaddingLeft();
    }

    public final int i(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.j.getCompoundPaddingRight();
        return (this.z == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.A.getMeasuredWidth() - this.A.getPaddingRight());
    }

    public final boolean j() {
        return this.h0 != 0;
    }

    public boolean k() {
        return this.i.getVisibility() == 0 && this.j0.getVisibility() == 0;
    }

    public final void l() {
        int i2 = this.K;
        if (i2 == 0) {
            this.G = null;
            this.H = null;
        } else if (i2 == 1) {
            this.G = new ho4(this.I);
            this.H = new ho4();
        } else if (i2 == 2) {
            if (!this.D || (this.G instanceof pp4)) {
                this.G = new ho4(this.I);
            } else {
                this.G = new pp4(this.I);
            }
            this.H = null;
        } else {
            throw new IllegalArgumentException(hj1.X(new StringBuilder(), this.K, " is illegal; only @BoxBackgroundMode constants are supported."));
        }
        EditText editText = this.j;
        if ((editText == null || this.G == null || editText.getBackground() != null || this.K == 0) ? false : true) {
            EditText editText2 = this.j;
            ho4 ho4 = this.G;
            AtomicInteger atomicInteger = r8.f3055a;
            editText2.setBackground(ho4);
        }
        F();
        if (this.K == 1) {
            if (hd3.K1(getContext())) {
                this.L = getResources().getDimensionPixelSize(R.dimen.material_font_2_0_box_collapsed_padding_top);
            } else if (hd3.J1(getContext())) {
                this.L = getResources().getDimensionPixelSize(R.dimen.material_font_1_3_box_collapsed_padding_top);
            }
        }
        if (this.j != null && this.K == 1) {
            if (hd3.K1(getContext())) {
                EditText editText3 = this.j;
                AtomicInteger atomicInteger2 = r8.f3055a;
                editText3.setPaddingRelative(editText3.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top), this.j.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_bottom));
            } else if (hd3.J1(getContext())) {
                EditText editText4 = this.j;
                AtomicInteger atomicInteger3 = r8.f3055a;
                editText4.setPaddingRelative(editText4.getPaddingStart(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top), this.j.getPaddingEnd(), getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_bottom));
            }
        }
        if (this.K != 0) {
            x();
        }
    }

    public final void m() {
        float f2;
        float f3;
        int i2;
        float f4;
        float f5;
        float f6;
        int i3;
        if (g()) {
            RectF rectF = this.T;
            en4 en4 = this.I0;
            int width = this.j.getWidth();
            int gravity = this.j.getGravity();
            boolean c2 = en4.c(en4.x);
            en4.z = c2;
            if (gravity == 17 || (gravity & 7) == 1) {
                f6 = ((float) width) / 2.0f;
                f5 = en4.b() / 2.0f;
            } else {
                if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                    if (c2) {
                        i3 = en4.e.left;
                    } else {
                        f6 = (float) en4.e.right;
                        f5 = en4.b();
                    }
                } else if (c2) {
                    f6 = (float) en4.e.right;
                    f5 = en4.b();
                } else {
                    i3 = en4.e.left;
                }
                f2 = (float) i3;
                rectF.left = f2;
                Rect rect = en4.e;
                rectF.top = (float) rect.top;
                if (gravity != 17 || (gravity & 7) == 1) {
                    f3 = (((float) width) / 2.0f) + (en4.b() / 2.0f);
                } else {
                    if ((gravity & 8388613) == 8388613 || (gravity & 5) == 5) {
                        if (en4.z) {
                            f4 = en4.b();
                        } else {
                            i2 = rect.right;
                            f3 = (float) i2;
                        }
                    } else if (en4.z) {
                        i2 = rect.right;
                        f3 = (float) i2;
                    } else {
                        f4 = en4.b();
                    }
                    f3 = f4 + f2;
                }
                rectF.right = f3;
                float h2 = en4.h() + ((float) en4.e.top);
                rectF.bottom = h2;
                float f7 = rectF.left;
                float f8 = (float) this.J;
                rectF.left = f7 - f8;
                rectF.top -= f8;
                rectF.right += f8;
                rectF.bottom = h2 + f8;
                rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
                pp4 pp4 = (pp4) this.G;
                Objects.requireNonNull(pp4);
                pp4.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
            }
            f2 = f6 - f5;
            rectF.left = f2;
            Rect rect2 = en4.e;
            rectF.top = (float) rect2.top;
            if (gravity != 17) {
            }
            f3 = (((float) width) / 2.0f) + (en4.b() / 2.0f);
            rectF.right = f3;
            float h22 = en4.h() + ((float) en4.e.top);
            rectF.bottom = h22;
            float f72 = rectF.left;
            float f82 = (float) this.J;
            rectF.left = f72 - f82;
            rectF.top -= f82;
            rectF.right += f82;
            rectF.bottom = h22 + f82;
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            pp4 pp42 = (pp4) this.G;
            Objects.requireNonNull(pp42);
            pp42.z(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void o() {
        p(this.j0, this.l0);
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.j;
        if (editText != null) {
            Rect rect = this.R;
            fn4.a(this, editText, rect);
            ho4 ho4 = this.H;
            if (ho4 != null) {
                int i8 = rect.bottom;
                ho4.setBounds(rect.left, i8 - this.O, rect.right, i8);
            }
            if (this.D) {
                en4 en4 = this.I0;
                float textSize = this.j.getTextSize();
                if (en4.i != textSize) {
                    en4.i = textSize;
                    en4.m();
                }
                int gravity = this.j.getGravity();
                this.I0.q((gravity & -113) | 48);
                this.I0.u(gravity);
                en4 en42 = this.I0;
                if (this.j != null) {
                    Rect rect2 = this.S;
                    AtomicInteger atomicInteger = r8.f3055a;
                    boolean z3 = false;
                    boolean z4 = getLayoutDirection() == 1;
                    rect2.bottom = rect.bottom;
                    int i9 = this.K;
                    if (i9 == 1) {
                        rect2.left = h(rect.left, z4);
                        rect2.top = rect.top + this.L;
                        rect2.right = i(rect.right, z4);
                    } else if (i9 != 2) {
                        rect2.left = h(rect.left, z4);
                        rect2.top = getPaddingTop();
                        rect2.right = i(rect.right, z4);
                    } else {
                        rect2.left = this.j.getPaddingLeft() + rect.left;
                        rect2.top = rect.top - f();
                        rect2.right = rect.right - this.j.getPaddingRight();
                    }
                    Objects.requireNonNull(en42);
                    int i10 = rect2.left;
                    int i11 = rect2.top;
                    int i12 = rect2.right;
                    int i13 = rect2.bottom;
                    if (!en4.n(en42.e, i10, i11, i12, i13)) {
                        en42.e.set(i10, i11, i12, i13);
                        en42.E = true;
                        en42.l();
                    }
                    en4 en43 = this.I0;
                    if (this.j != null) {
                        Rect rect3 = this.S;
                        TextPaint textPaint = en43.G;
                        textPaint.setTextSize(en43.i);
                        textPaint.setTypeface(en43.t);
                        textPaint.setLetterSpacing(en43.S);
                        float f2 = -en43.G.ascent();
                        rect3.left = this.j.getCompoundPaddingLeft() + rect.left;
                        if (this.K == 1 && this.j.getMinLines() <= 1) {
                            i6 = (int) (((float) rect.centerY()) - (f2 / 2.0f));
                        } else {
                            i6 = rect.top + this.j.getCompoundPaddingTop();
                        }
                        rect3.top = i6;
                        rect3.right = rect.right - this.j.getCompoundPaddingRight();
                        if (this.K == 1 && this.j.getMinLines() <= 1) {
                            z3 = true;
                        }
                        if (z3) {
                            i7 = (int) (((float) rect3.top) + f2);
                        } else {
                            i7 = rect.bottom - this.j.getCompoundPaddingBottom();
                        }
                        rect3.bottom = i7;
                        int i14 = rect3.left;
                        int i15 = rect3.top;
                        int i16 = rect3.right;
                        if (!en4.n(en43.d, i14, i15, i16, i7)) {
                            en43.d.set(i14, i15, i16, i7);
                            en43.E = true;
                            en43.l();
                        }
                        this.I0.m();
                        if (g() && !this.H0) {
                            m();
                            return;
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        EditText editText;
        int max;
        super.onMeasure(i2, i3);
        boolean z2 = false;
        if (this.j != null && this.j.getMeasuredHeight() < (max = Math.max(this.h.getMeasuredHeight(), this.g.getMeasuredHeight()))) {
            this.j.setMinimumHeight(max);
            z2 = true;
        }
        boolean v2 = v();
        if (z2 || v2) {
            this.j.post(new c());
        }
        if (!(this.u == null || (editText = this.j) == null)) {
            this.u.setGravity(editText.getGravity());
            this.u.setPadding(this.j.getCompoundPaddingLeft(), this.j.getCompoundPaddingTop(), this.j.getCompoundPaddingRight(), this.j.getCompoundPaddingBottom());
        }
        A();
        D();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f);
        if (savedState.g) {
            this.j0.post(new b());
        }
        setHint(savedState.h);
        setHelperText(savedState.i);
        setPlaceholderText(savedState.j);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.l.e()) {
            savedState.f = getError();
        }
        savedState.g = j() && this.j0.isChecked();
        savedState.h = getHint();
        savedState.i = getHelperText();
        savedState.j = getPlaceholderText();
        return savedState;
    }

    public final void p(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int[] drawableState = getDrawableState();
            int[] drawableState2 = checkableImageButton.getDrawableState();
            int length = drawableState.length;
            int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
            System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
            int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
            Drawable mutate = h.H0(drawable).mutate();
            mutate.setTintList(ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    public void r(TextView textView, int i2) {
        boolean z2 = true;
        try {
            h.w0(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            h.w0(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(q5.b(getContext(), R.color.design_error));
        }
    }

    public final void s() {
        if (this.p != null) {
            EditText editText = this.j;
            t(editText == null ? 0 : editText.getText().length());
        }
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.Q != i2) {
            this.Q = i2;
            this.C0 = i2;
            this.E0 = i2;
            this.F0 = i2;
            c();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(q5.b(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.C0 = defaultColor;
        this.Q = defaultColor;
        this.D0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.E0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.F0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        c();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.K) {
            this.K = i2;
            if (this.j != null) {
                l();
            }
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.A0 != i2) {
            this.A0 = i2;
            F();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.y0 = colorStateList.getDefaultColor();
            this.G0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.z0 = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            this.A0 = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else if (this.A0 != colorStateList.getDefaultColor()) {
            this.A0 = colorStateList.getDefaultColor();
        }
        F();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.B0 != colorStateList) {
            this.B0 = colorStateList;
            F();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.N = i2;
        F();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.O = i2;
        F();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.m != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.p = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.U;
                if (typeface != null) {
                    this.p.setTypeface(typeface);
                }
                this.p.setMaxLines(1);
                this.l.a(this.p, 2);
                ((ViewGroup.MarginLayoutParams) this.p.getLayoutParams()).setMarginStart(getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                u();
                s();
            } else {
                this.l.j(this.p, 2);
                this.p = null;
            }
            this.m = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.n != i2) {
            if (i2 > 0) {
                this.n = i2;
            } else {
                this.n = -1;
            }
            if (this.m) {
                s();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.q != i2) {
            this.q = i2;
            u();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.y != colorStateList) {
            this.y = colorStateList;
            u();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.r != i2) {
            this.r = i2;
            u();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.x != colorStateList) {
            this.x = colorStateList;
            u();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.w0 = colorStateList;
        this.x0 = colorStateList;
        if (this.j != null) {
            y(false, false);
        }
    }

    public void setEnabled(boolean z2) {
        n(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.j0.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.j0.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? u0.b(getContext(), i2) : null);
    }

    public void setEndIconMode(int i2) {
        int i3 = this.h0;
        this.h0 = i2;
        Iterator<g> it = this.k0.iterator();
        while (it.hasNext()) {
            it.next().a(this, i3);
        }
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().b(this.K)) {
            getEndIconDelegate().a();
            d();
            return;
        }
        StringBuilder i02 = hj1.i0("The current box background mode ");
        i02.append(this.K);
        i02.append(" is not supported by the end icon mode ");
        i02.append(i2);
        throw new IllegalStateException(i02.toString());
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.j0;
        View.OnLongClickListener onLongClickListener = this.s0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.s0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.j0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.l0 != colorStateList) {
            this.l0 = colorStateList;
            this.m0 = true;
            d();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.n0 != mode) {
            this.n0 = mode;
            this.o0 = true;
            d();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (k() != z2) {
            this.j0.setVisibility(z2 ? 0 : 8);
            D();
            v();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.l.k) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            wp4 wp4 = this.l;
            wp4.c();
            wp4.j = charSequence;
            wp4.l.setText(charSequence);
            int i2 = wp4.h;
            if (i2 != 1) {
                wp4.i = 1;
            }
            wp4.l(i2, wp4.i, wp4.k(wp4.l, charSequence));
            return;
        }
        this.l.i();
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        wp4 wp4 = this.l;
        wp4.m = charSequence;
        TextView textView = wp4.l;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void setErrorEnabled(boolean z2) {
        wp4 wp4 = this.l;
        if (wp4.k != z2) {
            wp4.c();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(wp4.f3823a);
                wp4.l = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_error);
                wp4.l.setTextAlignment(5);
                Typeface typeface = wp4.u;
                if (typeface != null) {
                    wp4.l.setTypeface(typeface);
                }
                int i2 = wp4.n;
                wp4.n = i2;
                TextView textView = wp4.l;
                if (textView != null) {
                    wp4.b.r(textView, i2);
                }
                ColorStateList colorStateList = wp4.o;
                wp4.o = colorStateList;
                TextView textView2 = wp4.l;
                if (!(textView2 == null || colorStateList == null)) {
                    textView2.setTextColor(colorStateList);
                }
                CharSequence charSequence = wp4.m;
                wp4.m = charSequence;
                TextView textView3 = wp4.l;
                if (textView3 != null) {
                    textView3.setContentDescription(charSequence);
                }
                wp4.l.setVisibility(4);
                TextView textView4 = wp4.l;
                AtomicInteger atomicInteger = r8.f3055a;
                textView4.setAccessibilityLiveRegion(1);
                wp4.a(wp4.l, 0);
            } else {
                wp4.i();
                wp4.j(wp4.l, 0);
                wp4.l = null;
                wp4.b.w();
                wp4.b.F();
            }
            wp4.k = z2;
        }
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? u0.b(getContext(), i2) : null);
        p(this.u0, this.v0);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.u0;
        View.OnLongClickListener onLongClickListener = this.t0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.t0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.u0;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.v0 = colorStateList;
        Drawable drawable = this.u0.getDrawable();
        if (drawable != null) {
            drawable = h.H0(drawable).mutate();
            drawable.setTintList(colorStateList);
        }
        if (this.u0.getDrawable() != drawable) {
            this.u0.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.u0.getDrawable();
        if (drawable != null) {
            drawable = h.H0(drawable).mutate();
            drawable.setTintMode(mode);
        }
        if (this.u0.getDrawable() != drawable) {
            this.u0.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        wp4 wp4 = this.l;
        wp4.n = i2;
        TextView textView = wp4.l;
        if (textView != null) {
            wp4.b.r(textView, i2);
        }
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        wp4 wp4 = this.l;
        wp4.o = colorStateList;
        TextView textView = wp4.l;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.J0 != z2) {
            this.J0 = z2;
            y(false, false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!this.l.q) {
                setHelperTextEnabled(true);
            }
            wp4 wp4 = this.l;
            wp4.c();
            wp4.p = charSequence;
            wp4.r.setText(charSequence);
            int i2 = wp4.h;
            if (i2 != 2) {
                wp4.i = 2;
            }
            wp4.l(i2, wp4.i, wp4.k(wp4.r, charSequence));
        } else if (this.l.q) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        wp4 wp4 = this.l;
        wp4.t = colorStateList;
        TextView textView = wp4.r;
        if (textView != null && colorStateList != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextEnabled(boolean z2) {
        wp4 wp4 = this.l;
        if (wp4.q != z2) {
            wp4.c();
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(wp4.f3823a);
                wp4.r = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_helper_text);
                wp4.r.setTextAlignment(5);
                Typeface typeface = wp4.u;
                if (typeface != null) {
                    wp4.r.setTypeface(typeface);
                }
                wp4.r.setVisibility(4);
                TextView textView = wp4.r;
                AtomicInteger atomicInteger = r8.f3055a;
                textView.setAccessibilityLiveRegion(1);
                int i2 = wp4.s;
                wp4.s = i2;
                TextView textView2 = wp4.r;
                if (textView2 != null) {
                    h.w0(textView2, i2);
                }
                ColorStateList colorStateList = wp4.t;
                wp4.t = colorStateList;
                TextView textView3 = wp4.r;
                if (!(textView3 == null || colorStateList == null)) {
                    textView3.setTextColor(colorStateList);
                }
                wp4.a(wp4.r, 1);
            } else {
                wp4.c();
                int i3 = wp4.h;
                if (i3 == 2) {
                    wp4.i = 0;
                }
                wp4.l(i3, wp4.i, wp4.k(wp4.r, null));
                wp4.j(wp4.r, 1);
                wp4.r = null;
                wp4.b.w();
                wp4.b.F();
            }
            wp4.q = z2;
        }
    }

    public void setHelperTextTextAppearance(int i2) {
        wp4 wp4 = this.l;
        wp4.s = i2;
        TextView textView = wp4.r;
        if (textView != null) {
            h.w0(textView, i2);
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.K0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.D) {
            this.D = z2;
            if (!z2) {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.j.getHint())) {
                    this.j.setHint(this.E);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.j.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.j.setHint((CharSequence) null);
                }
                this.F = true;
            }
            if (this.j != null) {
                x();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.I0.o(i2);
        this.x0 = this.I0.l;
        if (this.j != null) {
            y(false, false);
            x();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.x0 != colorStateList) {
            if (this.w0 == null) {
                en4 en4 = this.I0;
                if (en4.l != colorStateList) {
                    en4.l = colorStateList;
                    en4.m();
                }
            }
            this.x0 = colorStateList;
            if (this.j != null) {
                y(false, false);
            }
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? u0.b(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.h0 != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.l0 = colorStateList;
        this.m0 = true;
        d();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.n0 = mode;
        this.o0 = true;
        d();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        int i2 = 0;
        if (!this.t || !TextUtils.isEmpty(charSequence)) {
            if (!this.t) {
                setPlaceholderTextEnabled(true);
            }
            this.s = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        EditText editText = this.j;
        if (editText != null) {
            i2 = editText.getText().length();
        }
        z(i2);
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.w = i2;
        TextView textView = this.u;
        if (textView != null) {
            h.w0(textView, i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.v != colorStateList) {
            this.v = colorStateList;
            TextView textView = this.u;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.z = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.A.setText(charSequence);
        B();
    }

    public void setPrefixTextAppearance(int i2) {
        h.w0(this.A, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.A.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.V.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? u0.b(getContext(), i2) : null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        CheckableImageButton checkableImageButton = this.V;
        View.OnLongClickListener onLongClickListener = this.f0;
        checkableImageButton.setOnClickListener(onClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f0 = onLongClickListener;
        CheckableImageButton checkableImageButton = this.V;
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        q(checkableImageButton, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            this.a0 = true;
            e(this.V, true, colorStateList, this.c0, this.b0);
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.b0 != mode) {
            this.b0 = mode;
            this.c0 = true;
            e(this.V, this.a0, this.W, true, mode);
        }
    }

    public void setStartIconVisible(boolean z2) {
        int i2 = 0;
        if ((this.V.getVisibility() == 0) != z2) {
            CheckableImageButton checkableImageButton = this.V;
            if (!z2) {
                i2 = 8;
            }
            checkableImageButton.setVisibility(i2);
            A();
            v();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.B = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.C.setText(charSequence);
        E();
    }

    public void setSuffixTextAppearance(int i2) {
        h.w0(this.C, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.C.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(e eVar) {
        EditText editText = this.j;
        if (editText != null) {
            r8.v(editText, eVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.U) {
            this.U = typeface;
            this.I0.A(typeface);
            wp4 wp4 = this.l;
            if (typeface != wp4.u) {
                wp4.u = typeface;
                TextView textView = wp4.l;
                if (textView != null) {
                    textView.setTypeface(typeface);
                }
                TextView textView2 = wp4.r;
                if (textView2 != null) {
                    textView2.setTypeface(typeface);
                }
            }
            TextView textView3 = this.p;
            if (textView3 != null) {
                textView3.setTypeface(typeface);
            }
        }
    }

    public void t(int i2) {
        boolean z2 = this.o;
        int i3 = this.n;
        String str = null;
        if (i3 == -1) {
            this.p.setText(String.valueOf(i2));
            this.p.setContentDescription(null);
            this.o = false;
        } else {
            this.o = i2 > i3;
            Context context = getContext();
            this.p.setContentDescription(context.getString(this.o ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, Integer.valueOf(i2), Integer.valueOf(this.n)));
            if (z2 != this.o) {
                u();
            }
            o7 c2 = o7.c();
            TextView textView = this.p;
            String string = getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i2), Integer.valueOf(this.n));
            q7 q7Var = c2.c;
            if (string != null) {
                str = c2.d(string, q7Var, true).toString();
            }
            textView.setText(str);
        }
        if (this.j != null && z2 != this.o) {
            y(false, false);
            F();
            w();
        }
    }

    public final void u() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.p;
        if (textView != null) {
            r(textView, this.o ? this.q : this.r);
            if (!this.o && (colorStateList2 = this.x) != null) {
                this.p.setTextColor(colorStateList2);
            }
            if (this.o && (colorStateList = this.y) != null) {
                this.p.setTextColor(colorStateList);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean v() {
        /*
        // Method dump skipped, instructions count: 295
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.v():boolean");
    }

    public void w() {
        Drawable background;
        TextView textView;
        EditText editText = this.j;
        if (editText != null && this.K == 0 && (background = editText.getBackground()) != null) {
            if (DrawableUtils.canSafelyMutateDrawable(background)) {
                background = background.mutate();
            }
            if (this.l.e()) {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(this.l.g(), PorterDuff.Mode.SRC_IN));
            } else if (!this.o || (textView = this.p) == null) {
                h.s(background);
                this.j.refreshDrawableState();
            } else {
                background.setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    public final void x() {
        if (this.K != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f.getLayoutParams();
            int f2 = f();
            if (f2 != layoutParams.topMargin) {
                layoutParams.topMargin = f2;
                this.f.requestLayout();
            }
        }
    }

    public final void y(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.j;
        int i2 = 0;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.j;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean e2 = this.l.e();
        ColorStateList colorStateList2 = this.w0;
        if (colorStateList2 != null) {
            this.I0.p(colorStateList2);
            this.I0.t(this.w0);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.w0;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.G0) : this.G0;
            this.I0.p(ColorStateList.valueOf(colorForState));
            this.I0.t(ColorStateList.valueOf(colorForState));
        } else if (e2) {
            en4 en4 = this.I0;
            TextView textView2 = this.l.l;
            en4.p(textView2 != null ? textView2.getTextColors() : null);
        } else if (this.o && (textView = this.p) != null) {
            this.I0.p(textView.getTextColors());
        } else if (z5 && (colorStateList = this.x0) != null) {
            this.I0.p(colorStateList);
        }
        if (z4 || !this.J0 || (isEnabled() && z5)) {
            if (z3 || this.H0) {
                ValueAnimator valueAnimator = this.L0;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.L0.cancel();
                }
                if (!z2 || !this.K0) {
                    this.I0.w(1.0f);
                } else {
                    b(1.0f);
                }
                this.H0 = false;
                if (g()) {
                    m();
                }
                EditText editText3 = this.j;
                if (editText3 != null) {
                    i2 = editText3.getText().length();
                }
                z(i2);
                B();
                E();
            }
        } else if (z3 || !this.H0) {
            ValueAnimator valueAnimator2 = this.L0;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.L0.cancel();
            }
            if (!z2 || !this.K0) {
                this.I0.w(0.0f);
            } else {
                b(0.0f);
            }
            if (g() && (!((pp4) this.G).E.isEmpty()) && g()) {
                ((pp4) this.G).z(0.0f, 0.0f, 0.0f, 0.0f);
            }
            this.H0 = true;
            TextView textView3 = this.u;
            if (textView3 != null && this.t) {
                textView3.setText((CharSequence) null);
                this.u.setVisibility(4);
            }
            B();
            E();
        }
    }

    public final void z(int i2) {
        if (i2 != 0 || this.H0) {
            TextView textView = this.u;
            if (textView != null && this.t) {
                textView.setText((CharSequence) null);
                this.u.setVisibility(4);
                return;
            }
            return;
        }
        TextView textView2 = this.u;
        if (textView2 != null && this.t) {
            textView2.setText(this.s);
            this.u.setVisibility(0);
            this.u.bringToFront();
        }
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.j0.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.j0.setImageDrawable(drawable);
        o();
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.V.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.V.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            p(this.V, this.W);
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener(null);
        setStartIconOnLongClickListener(null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.u0.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.l.k);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.j0.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.j0.setImageDrawable(drawable);
    }

    public void setHint(int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }
}
