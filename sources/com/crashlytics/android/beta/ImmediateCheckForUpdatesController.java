package com.crashlytics.android.beta;

public class ImmediateCheckForUpdatesController extends AbstractCheckForUpdatesController {
    public ImmediateCheckForUpdatesController() {
        super(true);
    }

    @Override // com.crashlytics.android.beta.UpdatesController
    public boolean isActivityLifecycleTriggered() {
        return false;
    }
}
