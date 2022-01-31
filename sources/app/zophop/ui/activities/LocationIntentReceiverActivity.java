package app.zophop.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class LocationIntentReceiverActivity extends au {
    public static final String k = LocationIntentReceiverActivity.class.getName();

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        if (xt.f3961a.k().d() == null) {
            Intent intent = new Intent(this, SplashScreen.class);
            intent.putExtra("source", LocationIntentReceiverActivity.class.getName());
            startActivity(intent);
            finish();
            return;
        }
        h0(getIntent());
    }

    public final void h0(Intent intent) {
        mf1 mf1;
        qf1 qf1 = new qf1(intent);
        if (!qf1.d || (mf1 = qf1.e) == null) {
            Toast.makeText(this, "Location Data Not Available", 1).show();
            finish();
            return;
        }
        ed1 ed1 = new ed1("location received", Long.MIN_VALUE);
        ed1.a("locationName", mf1.c);
        ed1.a("locationLatLng", String.valueOf(mf1.f2368a));
        jz5.b().g(ed1);
        TripPlanningActivity.m0(this, null, mf1, false);
        finish();
    }

    @Override // defpackage.ve
    public void onNewIntent(Intent intent) {
        h0(intent);
    }
}
