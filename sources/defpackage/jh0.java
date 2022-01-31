package defpackage;

import android.view.View;
import app.zophop.ui.activities.ValidationScreen;

/* renamed from: jh0  reason: default package */
/* compiled from: ValidationScreen */
public class jh0 implements View.OnClickListener {
    public final /* synthetic */ ValidationScreen f;

    public jh0(ValidationScreen validationScreen) {
        this.f = validationScreen;
    }

    public void onClick(View view) {
        this.f.onBackPressed();
    }
}
