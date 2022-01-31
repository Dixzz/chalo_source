package defpackage;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: cn0  reason: default package */
/* compiled from: ReportProblemDialog */
public class cn0 implements TextWatcher {
    public final /* synthetic */ gn0 f;

    public cn0(gn0 gn0) {
        this.f = gn0;
    }

    public void afterTextChanged(Editable editable) {
        this.f.a();
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
