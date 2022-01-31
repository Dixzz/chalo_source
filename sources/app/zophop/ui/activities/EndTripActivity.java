package app.zophop.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import app.zophop.service.LocationTrackingService;

public class EndTripActivity extends Activity {

    public enum a {
        END_TRIP
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String string = getIntent().getExtras().getString("real_Action");
        if (string != null && string.equals(a.END_TRIP.name())) {
            LocationTrackingService.b();
            finish();
            Intent intent = new Intent(this, HomeActivity.class);
            intent.setFlags(603979776);
            startActivity(intent);
        }
    }
}
