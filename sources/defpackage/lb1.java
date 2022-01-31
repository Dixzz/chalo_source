package defpackage;

import android.view.View;
import android.widget.EditText;
import app.zophop.ui.views.PassDurationFormInput;
import java.util.Objects;

/* renamed from: lb1  reason: default package */
/* compiled from: PassDurationFormInput */
public class lb1 implements View.OnClickListener {
    public final /* synthetic */ PassDurationFormInput f;

    public lb1(PassDurationFormInput passDurationFormInput) {
        this.f = passDurationFormInput;
    }

    public void onClick(View view) {
        PassDurationFormInput passDurationFormInput = this.f;
        int i = PassDurationFormInput.p;
        Objects.requireNonNull(passDurationFormInput);
        PassDurationFormInput passDurationFormInput2 = this.f;
        if (passDurationFormInput2.k) {
            passDurationFormInput2.h.setVisibility(0);
            this.f.f.setVisibility(0);
            this.f.f.requestFocus();
            if (this.f.f.getText() != null) {
                EditText editText = this.f.f;
                editText.setSelection(editText.getText().length());
            }
            this.f.requestLayout();
            this.f.invalidate();
        }
    }
}
