package defpackage;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

/* renamed from: aq4  reason: default package */
/* compiled from: PasswordToggleEndIconDelegate */
public class aq4 extends vp4 {
    public final TextWatcher d = new a();
    public final TextInputLayout.f e = new b();
    public final TextInputLayout.g f = new c();

    /* renamed from: aq4$a */
    /* compiled from: PasswordToggleEndIconDelegate */
    public class a extends ln4 {
        public a() {
        }

        @Override // defpackage.ln4
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            aq4 aq4 = aq4.this;
            aq4.c.setChecked(!aq4.e(aq4));
        }
    }

    /* renamed from: aq4$b */
    /* compiled from: PasswordToggleEndIconDelegate */
    public class b implements TextInputLayout.f {
        public b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            aq4 aq4 = aq4.this;
            aq4.c.setChecked(!aq4.e(aq4));
            editText.removeTextChangedListener(aq4.this.d);
            editText.addTextChangedListener(aq4.this.d);
        }
    }

    /* renamed from: aq4$c */
    /* compiled from: PasswordToggleEndIconDelegate */
    public class c implements TextInputLayout.g {

        /* renamed from: aq4$c$a */
        /* compiled from: PasswordToggleEndIconDelegate */
        public class a implements Runnable {
            public final /* synthetic */ EditText f;

            public a(EditText editText) {
                this.f = editText;
            }

            public void run() {
                this.f.removeTextChangedListener(aq4.this.d);
            }
        }

        public c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i) {
            EditText editText = textInputLayout.getEditText();
            if (editText != null && i == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new a(editText));
            }
        }
    }

    /* renamed from: aq4$d */
    /* compiled from: PasswordToggleEndIconDelegate */
    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            EditText editText = aq4.this.f3673a.getEditText();
            if (editText != null) {
                int selectionEnd = editText.getSelectionEnd();
                if (aq4.e(aq4.this)) {
                    editText.setTransformationMethod(null);
                } else {
                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                if (selectionEnd >= 0) {
                    editText.setSelection(selectionEnd);
                }
                aq4.this.f3673a.o();
            }
        }
    }

    public aq4(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    public static boolean e(aq4 aq4) {
        EditText editText = aq4.f3673a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    @Override // defpackage.vp4
    public void a() {
        this.f3673a.setEndIconDrawable(u0.b(this.b, R.drawable.design_password_eye));
        TextInputLayout textInputLayout = this.f3673a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.password_toggle_content_description));
        this.f3673a.setEndIconOnClickListener(new d());
        this.f3673a.a(this.e);
        this.f3673a.k0.add(this.f);
        EditText editText = this.f3673a.getEditText();
        if (editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
