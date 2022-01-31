package app.zophop.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AuthenticatorService extends Service {
    public b90 f;

    public IBinder onBind(Intent intent) {
        return this.f.getIBinder();
    }

    public void onCreate() {
        this.f = new b90(this);
    }
}
