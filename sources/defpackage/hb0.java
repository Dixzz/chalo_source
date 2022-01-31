package defpackage;

import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import app.zophop.R;
import app.zophop.ui.activities.AccountLoginActivity;

/* renamed from: hb0  reason: default package */
/* compiled from: AccountLoginActivity */
public class hb0 implements TextWatcher {
    public final /* synthetic */ AccountLoginActivity f;

    public hb0(AccountLoginActivity accountLoginActivity) {
        this.f = accountLoginActivity;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AccountLoginActivity accountLoginActivity = this.f;
        if (!accountLoginActivity.x0(accountLoginActivity._mobileTextInput.getText().toString())) {
            this.f._errorView.setVisibility(0);
            this.f._mobileTextInput.getBackground().setColorFilter(this.f.getResources().getColor(R.color.dark_red_color), PorterDuff.Mode.SRC_IN);
            return;
        }
        this.f._errorView.setVisibility(8);
        this.f._mobileTextInput.getBackground().setColorFilter(this.f.getResources().getColor(R.color.orange_primary), PorterDuff.Mode.SRC_IN);
    }
}
