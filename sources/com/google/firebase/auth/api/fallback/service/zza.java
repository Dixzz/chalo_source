package com.google.firebase.auth.api.fallback.service;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.GetServiceRequest;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zza extends y72 {
    public final /* synthetic */ FirebaseAuthFallbackService zza;

    public zza(FirebaseAuthFallbackService firebaseAuthFallbackService, Context context) {
        this.zza = firebaseAuthFallbackService;
    }

    @Override // defpackage.e82
    public final void getService(d82 d82, GetServiceRequest getServiceRequest) throws RemoteException {
        Bundle bundle = getServiceRequest.l;
        if (bundle != null) {
            String string = bundle.getString("com.google.firebase.auth.API_KEY");
            if (!TextUtils.isEmpty(string)) {
                d82.J1(0, new x43(this.zza, string), null);
                return;
            }
            throw new IllegalArgumentException("ApiKey must not be empty.");
        }
        throw new IllegalArgumentException("ExtraArgs is null.");
    }
}
