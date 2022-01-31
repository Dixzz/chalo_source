package defpackage;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: jp4  reason: default package */
/* compiled from: ClearTextEndIconDelegate */
public class jp4 extends vp4 {
    public final TextWatcher d = new a();
    public final View.OnFocusChangeListener e = new b();
    public final TextInputLayout.f f = new c();
    public final TextInputLayout.g g = new d();
    public AnimatorSet h;
    public ValueAnimator i;

    /* renamed from: jp4$a */
    /* compiled from: ClearTextEndIconDelegate */
    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (jp4.this.f3673a.getSuffixText() == null) {
                jp4.this.e(editable.length() > 0);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: jp4$b */
    /* compiled from: ClearTextEndIconDelegate */
    public class b implements View.OnFocusChangeListener {
        public b() {
        }

        public void onFocusChange(View view, boolean z) {
            boolean z2 = true;
            boolean z3 = !TextUtils.isEmpty(((EditText) view).getText());
            jp4 jp4 = jp4.this;
            if (!z3 || !z) {
                z2 = false;
            }
            jp4.e(z2);
        }
    }

    /* renamed from: jp4$c */
    /* compiled from: ClearTextEndIconDelegate */
    public class c implements TextInputLayout.f {
        public c() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
            if ((r0.getText().length() > 0) != false) goto L_0x001d;
         */
        @Override // com.google.android.material.textfield.TextInputLayout.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.google.android.material.textfield.TextInputLayout r5) {
            /*
                r4 = this;
                android.widget.EditText r0 = r5.getEditText()
                boolean r1 = r0.hasFocus()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L_0x001c
                android.text.Editable r1 = r0.getText()
                int r1 = r1.length()
                if (r1 <= 0) goto L_0x0018
                r1 = 1
                goto L_0x0019
            L_0x0018:
                r1 = 0
            L_0x0019:
                if (r1 == 0) goto L_0x001c
                goto L_0x001d
            L_0x001c:
                r2 = 0
            L_0x001d:
                r5.setEndIconVisible(r2)
                r5.setEndIconCheckable(r3)
                jp4 r5 = defpackage.jp4.this
                android.view.View$OnFocusChangeListener r5 = r5.e
                r0.setOnFocusChangeListener(r5)
                jp4 r5 = defpackage.jp4.this
                android.text.TextWatcher r5 = r5.d
                r0.removeTextChangedListener(r5)
                jp4 r5 = defpackage.jp4.this
                android.text.TextWatcher r5 = r5.d
                r0.addTextChangedListener(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.jp4.c.a(com.google.android.material.textfield.TextInputLayout):void");
        }
    }

    /* renamed from: jp4$d */
    /* compiled from: ClearTextEndIconDelegate */
    public class d implements TextInputLayout.g {

        /* renamed from: jp4$d$a */
        /* compiled from: ClearTextEndIconDelegate */
        public class a implements Runnable {
            public final /* synthetic */ EditText f;

            public a(EditText editText) {
                this.f = editText;
            }

            public void run() {
                this.f.removeTextChangedListener(jp4.this.d);
            }
        }

        public d() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 2) {
                editText.post(new a(editText));
                if (editText.getOnFocusChangeListener() == jp4.this.e) {
                    editText.setOnFocusChangeListener(null);
                }
            }
        }
    }

    /* renamed from: jp4$e */
    /* compiled from: ClearTextEndIconDelegate */
    public class e implements View.OnClickListener {
        public e() {
        }

        public void onClick(View view) {
            Editable text = jp4.this.f3673a.getEditText().getText();
            if (text != null) {
                text.clear();
            }
            jp4.this.f3673a.o();
        }
    }

    public jp4(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    @Override // defpackage.vp4
    public void a() {
        this.f3673a.setEndIconDrawable(u0.b(this.b, R.drawable.mtrl_ic_cancel));
        TextInputLayout textInputLayout = this.f3673a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f3673a.setEndIconOnClickListener(new e());
        this.f3673a.a(this.f);
        TextInputLayout textInputLayout2 = this.f3673a;
        textInputLayout2.k0.add(this.g);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(zj4.d);
        ofFloat.setDuration(150L);
        ofFloat.addUpdateListener(new np4(this));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = zj4.f4184a;
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(100L);
        ofFloat2.addUpdateListener(new mp4(this));
        AnimatorSet animatorSet = new AnimatorSet();
        this.h = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.h.addListener(new kp4(this));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(100L);
        ofFloat3.addUpdateListener(new mp4(this));
        this.i = ofFloat3;
        ofFloat3.addListener(new lp4(this));
    }

    @Override // defpackage.vp4
    public void c(boolean z) {
        if (this.f3673a.getSuffixText() != null) {
            e(z);
        }
    }

    public final void e(boolean z) {
        boolean z2 = this.f3673a.k() == z;
        if (z && !this.h.isRunning()) {
            this.i.cancel();
            this.h.start();
            if (z2) {
                this.h.end();
            }
        } else if (!z) {
            this.h.cancel();
            this.i.start();
            if (z2) {
                this.i.end();
            }
        }
    }
}
