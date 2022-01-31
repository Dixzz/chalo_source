package com.crashlytics.android.beta;

import android.content.Context;

public interface UpdatesController {
    void initialize(Context context, Beta beta, o06 o06, z16 z16, BuildProperties buildProperties, w16 w16, l06 l06, r16 r16);

    boolean isActivityLifecycleTriggered();
}
