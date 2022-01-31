package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.ValidationScreen;

/* renamed from: oh0  reason: default package */
/* compiled from: ValidationScreen */
public class oh0 implements View.OnClickListener {
    public final /* synthetic */ ValidationScreen f;

    public oh0(ValidationScreen validationScreen) {
        this.f = validationScreen;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("activation duration expired dialog ok clicked", Long.MIN_VALUE));
        Intent intent = new Intent(this.f, HomeActivity.class);
        intent.setFlags(268468224);
        this.f.startActivity(intent);
    }
}
