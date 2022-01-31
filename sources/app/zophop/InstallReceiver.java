package app.zophop;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class InstallReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new ic5().onReceive(context, intent);
        String stringExtra = intent.getStringExtra("referrer");
        if (stringExtra != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
            edit.putString("install_referrer", stringExtra);
            edit.commit();
        }
    }
}
