package defpackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import app.zophop.R;
import app.zophop.ui.activities.CardActivity;

/* renamed from: jd0  reason: default package */
/* compiled from: CardActivity */
public class jd0 implements TextWatcher {
    public final /* synthetic */ EditText f;
    public final /* synthetic */ CardActivity g;

    public jd0(CardActivity cardActivity, EditText editText) {
        this.g = cardActivity;
        this.f = editText;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f.getText().length() == 1) {
            this.g.findViewById(R.id.saved_cvv_error).setVisibility(8);
        }
    }
}
