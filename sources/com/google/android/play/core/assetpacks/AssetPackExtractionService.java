package com.google.android.play.core.assetpacks;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AssetPackExtractionService extends Service {
    public gs4 f;

    public final IBinder onBind(Intent intent) {
        return this.f;
    }

    public final void onCreate() {
        super.onCreate();
        this.f = mt4.h(getApplicationContext()).z.a();
    }
}
