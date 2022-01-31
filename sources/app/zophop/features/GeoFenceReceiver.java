package app.zophop.features;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.firebase.perf.util.Constants;

public class GeoFenceReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int i = GeoFenceService.p;
        a5.a(context, GeoFenceService.class, Constants.MAX_URL_LENGTH, intent);
    }
}
