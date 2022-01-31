package com.google.firebase.auth;

import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.FirebaseApp;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public yi4<Void> delete() {
        return FirebaseAuth.getInstance(zzd()).zzy(this);
    }

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getDisplayName();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getEmail();

    public yi4<GetTokenResult> getIdToken(boolean z) {
        return FirebaseAuth.getInstance(zzd()).zzh(this, z);
    }

    public abstract FirebaseUserMetadata getMetadata();

    public abstract MultiFactor getMultiFactor();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getPhoneNumber();

    @Override // com.google.firebase.auth.UserInfo
    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getProviderId();

    public abstract String getTenantId();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getUid();

    public abstract boolean isAnonymous();

    public yi4<AuthResult> linkWithCredential(AuthCredential authCredential) {
        Objects.requireNonNull(authCredential, "null reference");
        return FirebaseAuth.getInstance(zzd()).zzn(this, authCredential);
    }

    public yi4<Void> reauthenticate(AuthCredential authCredential) {
        Objects.requireNonNull(authCredential, "null reference");
        return FirebaseAuth.getInstance(zzd()).zzi(this, authCredential);
    }

    public yi4<AuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) {
        Objects.requireNonNull(authCredential, "null reference");
        return FirebaseAuth.getInstance(zzd()).zzj(this, authCredential);
    }

    public yi4<Void> reload() {
        FirebaseAuth instance = FirebaseAuth.getInstance(zzd());
        return instance.zzm(this, new zzt(instance));
    }

    public yi4<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zzd()).zzh(this, false).j(new zzw(this));
    }

    public yi4<AuthResult> startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Objects.requireNonNull(activity, "null reference");
        Objects.requireNonNull(federatedAuthProvider, "null reference");
        return FirebaseAuth.getInstance(zzd()).zzw(activity, federatedAuthProvider, this);
    }

    public yi4<AuthResult> startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        Objects.requireNonNull(activity, "null reference");
        Objects.requireNonNull(federatedAuthProvider, "null reference");
        return FirebaseAuth.getInstance(zzd()).zzx(activity, federatedAuthProvider, this);
    }

    public yi4<AuthResult> unlink(String str) {
        gj1.j(str);
        return FirebaseAuth.getInstance(zzd()).zzo(this, str);
    }

    public yi4<Void> updateEmail(String str) {
        gj1.j(str);
        return FirebaseAuth.getInstance(zzd()).zzq(this, str);
    }

    public yi4<Void> updatePassword(String str) {
        gj1.j(str);
        return FirebaseAuth.getInstance(zzd()).zzs(this, str);
    }

    public yi4<Void> updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zzd()).zzr(this, phoneAuthCredential);
    }

    public yi4<Void> updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        Objects.requireNonNull(userProfileChangeRequest, "null reference");
        return FirebaseAuth.getInstance(zzd()).zzp(this, userProfileChangeRequest);
    }

    public yi4<Void> verifyBeforeUpdateEmail(String str) {
        return verifyBeforeUpdateEmail(str, null);
    }

    public abstract List<String> zza();

    public abstract FirebaseUser zzb(List<? extends UserInfo> list);

    public abstract FirebaseUser zzc();

    public abstract FirebaseApp zzd();

    public abstract zzwg zze();

    public abstract void zzf(zzwg zzwg);

    public abstract String zzg();

    public abstract String zzh();

    public abstract void zzi(List<MultiFactorInfo> list);

    public yi4<Void> verifyBeforeUpdateEmail(String str, ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzd()).zzh(this, false).j(new zzy(this, str, actionCodeSettings));
    }

    public yi4<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zzd()).zzh(this, false).j(new zzx(this, actionCodeSettings));
    }
}
