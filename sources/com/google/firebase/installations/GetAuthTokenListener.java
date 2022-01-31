package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

public class GetAuthTokenListener implements StateListener {
    private final zi4<InstallationTokenResult> resultTaskCompletionSource;
    private final Utils utils;

    public GetAuthTokenListener(Utils utils2, zi4<InstallationTokenResult> zi4) {
        this.utils = utils2;
        this.resultTaskCompletionSource = zi4;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exc) {
        this.resultTaskCompletionSource.a(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isRegistered() || this.utils.isAuthTokenExpired(persistedInstallationEntry)) {
            return false;
        }
        zi4<InstallationTokenResult> zi4 = this.resultTaskCompletionSource;
        zi4.f4178a.t(InstallationTokenResult.builder().setToken(persistedInstallationEntry.getAuthToken()).setTokenExpirationTimestamp(persistedInstallationEntry.getExpiresInSecs()).setTokenCreationTimestamp(persistedInstallationEntry.getTokenCreationEpochInSecs()).build());
        return true;
    }
}
