package app.zophop.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class SyncService extends Service {
    public static c90 f;
    public static final Object g = new Object();

    public IBinder onBind(Intent intent) {
        return f.getSyncAdapterBinder();
    }

    public void onCreate() {
        synchronized (g) {
            if (f == null) {
                f = new c90(getApplicationContext(), true);
            }
        }
    }
}
