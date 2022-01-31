package defpackage;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;

/* renamed from: e71  reason: default package */
/* compiled from: ViewUtilsKT.kt */
public final class e71 implements TextWatcher {
    public String f = "";
    public final ca6 g;

    public e71() {
        f71 f71 = f71.f1097a;
        this.g = f71.b;
    }

    public void afterTextChanged(Editable editable) {
        n86.e(editable, "s");
        if (!n86.a(editable.toString(), this.f)) {
            String b = this.g.b(editable.toString(), "");
            if (b.length() <= 16) {
                StringBuilder sb = new StringBuilder();
                int length = b.length() - 1;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        int i2 = i + 1;
                        if (i == 2 || i == 6 || i == 10) {
                            sb.append(' ');
                        }
                        sb.append(b.charAt(i));
                        if (i2 > length) {
                            break;
                        }
                        i = i2;
                    }
                }
                String sb2 = sb.toString();
                n86.d(sb2, "StringBuilder().apply(builderAction).toString()");
                this.f = sb2;
                editable.setFilters(new InputFilter[0]);
            }
            int length2 = editable.length();
            String str = this.f;
            editable.replace(0, length2, str, 0, str.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        n86.e(charSequence, "s");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        n86.e(charSequence, "s");
    }
}
