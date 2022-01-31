package app.zophop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UpdateReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        jz5.b().g(hj1.l("App Updated", Long.MIN_VALUE, "version", "7.6.4"));
    }
}
