package com.google.firebase.installations;

import com.google.firebase.annotations.DeferredApi;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;

public interface FirebaseInstallationsApi {
    yi4<Void> delete();

    yi4<String> getId();

    yi4<InstallationTokenResult> getToken(boolean z);

    @DeferredApi
    FidListenerHandle registerFidListener(FidListener fidListener);
}
