package com.google.firebase.installations;

import com.google.firebase.installations.local.PersistedInstallationEntry;

public class GetIdListener implements StateListener {
    public final zi4<String> taskCompletionSource;

    public GetIdListener(zi4<String> zi4) {
        this.taskCompletionSource = zi4;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onException(Exception exc) {
        return false;
    }

    @Override // com.google.firebase.installations.StateListener
    public boolean onStateReached(PersistedInstallationEntry persistedInstallationEntry) {
        if (!persistedInstallationEntry.isUnregistered() && !persistedInstallationEntry.isRegistered() && !persistedInstallationEntry.isErrored()) {
            return false;
        }
        this.taskCompletionSource.b(persistedInstallationEntry.getFirebaseInstallationId());
        return true;
    }
}
