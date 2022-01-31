package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.ValidationScreen;

/* renamed from: mh0  reason: default package */
/* compiled from: ValidationScreen */
public class mh0 implements View.OnClickListener {
    public final /* synthetic */ du0 f;
    public final /* synthetic */ ValidationScreen g;

    public mh0(ValidationScreen validationScreen, du0 du0) {
        this.g = validationScreen;
        this.f = du0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        this.f.f = true;
        Intent intent = new Intent(this.g, HomeActivity.class);
        intent.setFlags(268468224);
        this.g.startActivity(intent);
    }
}
