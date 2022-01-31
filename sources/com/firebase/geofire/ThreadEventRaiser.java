package com.firebase.geofire;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadEventRaiser implements EventRaiser {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    @Override // com.firebase.geofire.EventRaiser
    public void raiseEvent(Runnable runnable) {
        this.executorService.submit(runnable);
    }
}
