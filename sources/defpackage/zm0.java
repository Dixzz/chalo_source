package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import java.util.Objects;

/* renamed from: zm0  reason: default package */
/* compiled from: RenewErrorDialog */
public class zm0 implements View.OnClickListener {
    public final /* synthetic */ an0 f;

    public zm0(an0 an0) {
        this.f = an0;
    }

    public void onClick(View view) {
        an0 an0 = this.f;
        Objects.requireNonNull(an0);
        Intent intent = new Intent(an0.getActivity(), ProductSelectionActivity.class);
        intent.putExtra("src", "renew_pass");
        intent.addFlags(268468224);
        jz5.b().g(new ed1("pass proof expired", Long.MIN_VALUE));
        an0.startActivity(intent);
        an0.dismiss();
    }
}
