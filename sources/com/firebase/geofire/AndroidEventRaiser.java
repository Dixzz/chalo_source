package com.firebase.geofire;

import android.os.Handler;
import android.os.Looper;

public class AndroidEventRaiser implements EventRaiser {
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    @Override // com.firebase.geofire.EventRaiser
    public void raiseEvent(Runnable runnable) {
        this.mainThreadHandler.post(runnable);
    }
}
