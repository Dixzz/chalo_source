package defpackage;

import android.view.View;
import android.widget.CheckBox;
import app.zophop.ui.activities.CardActivity;

/* renamed from: kd0  reason: default package */
/* compiled from: CardActivity */
public class kd0 implements View.OnClickListener {
    public final /* synthetic */ CheckBox f;

    public kd0(CardActivity cardActivity, CheckBox checkBox) {
        this.f = checkBox;
    }

    public void onClick(View view) {
        if (this.f.isChecked()) {
            this.f.setChecked(false);
        } else {
            this.f.setChecked(true);
        }
    }
}
