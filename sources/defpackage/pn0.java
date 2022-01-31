package defpackage;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.pubsub.eventbus.events.FavoriteAddedEvent;
import defpackage.ig1;
import java.util.Objects;

/* renamed from: pn0  reason: default package */
/* compiled from: ZophopFavoriteDialog */
public class pn0 extends ig1 {
    public static final String k = pn0.class.getSimpleName();

    public static void c(FragmentManager fragmentManager, mf1 mf1, ig1.a aVar) {
        if (mf1 != null && mf1.b != null) {
            pn0 pn0 = new pn0();
            Bundle bundle = new Bundle();
            bundle.putString("descriptive_location_key", mf1.b());
            bundle.putString("favorite_dialog_trigger_origin", aVar.name());
            pn0.setArguments(bundle);
            pn0.show(fragmentManager, k);
        }
    }

    @Override // defpackage.ig1
    public void a(View view, mf1 mf1) {
        if (this.i.getCheckedRadioButtonId() == R.id.radio_home) {
            mf1.c = "Home";
            b(xt.f3961a.Y().m(mf1, "Home", "home"));
        } else if (this.i.getCheckedRadioButtonId() == R.id.radio_work) {
            mf1.c = "Work";
            b(xt.f3961a.Y().m(mf1, "Work", "work"));
        } else if (this.i.getCheckedRadioButtonId() == R.id.radio_other) {
            String obj = this.h.getText().toString();
            boolean z = false;
            if (obj.length() > 0) {
                mf1.c = obj;
                b60 Y = xt.f3961a.Y();
                Objects.requireNonNull(Y);
                if (mf1.b != null) {
                    if (mf1.c.equals("Home")) {
                        Y.m(mf1, "Home", "home");
                        Y.l(mf1);
                    } else if (mf1.c.equals("Work")) {
                        Y.m(mf1, "Work", "work");
                        Y.l(mf1);
                    } else {
                        Y.c(mf1);
                        Y.f().j(mf1.b, mf1.b());
                        Y.l(mf1);
                        z = true;
                    }
                }
                b(z);
                return;
            }
            Toast.makeText(view.getContext(), getString(R.string.enter_favorite_title_toast), 0).show();
        }
    }

    public final void b(boolean z) {
        jz5.b().i(new FavoriteAddedEvent(z));
        dismiss();
    }
}
