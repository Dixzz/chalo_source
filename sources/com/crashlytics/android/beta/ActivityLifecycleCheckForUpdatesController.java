package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import defpackage.vz5;
import java.util.concurrent.ExecutorService;

@TargetApi(14)
public class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {
    private final vz5.b callbacks;
    private final ExecutorService executorService;

    public ActivityLifecycleCheckForUpdatesController(vz5 vz5, ExecutorService executorService2) {
        AnonymousClass1 r0 = new vz5.b() {
            /* class com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.AnonymousClass1 */

            @Override // defpackage.vz5.b
            public void onActivityStarted(Activity activity) {
                if (ActivityLifecycleCheckForUpdatesController.this.signalExternallyReady()) {
                    ActivityLifecycleCheckForUpdatesController.this.executorService.submit(new Runnable() {
                        /* class com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            ActivityLifecycleCheckForUpdatesController.this.checkForUpdates();
                        }
                    });
                }
            }
        };
        this.callbacks = r0;
        this.executorService = executorService2;
        vz5.a(r0);
    }

    @Override // com.crashlytics.android.beta.UpdatesController
    public boolean isActivityLifecycleTriggered() {
        return true;
    }
}
