package com.google.firebase.auth.internal;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzac extends MultiFactor {
    private final zzx zza;

    public zzac(zzx zzx) {
        Objects.requireNonNull(zzx, "null reference");
        this.zza = zzx;
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final yi4<Void> enroll(MultiFactorAssertion multiFactorAssertion, String str) {
        Objects.requireNonNull(multiFactorAssertion, "null reference");
        zzx zzx = this.zza;
        return FirebaseAuth.getInstance(zzx.zzd()).zzA(zzx, multiFactorAssertion, str);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final List<MultiFactorInfo> getEnrolledFactors() {
        return this.zza.zzr();
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final yi4<MultiFactorSession> getSession() {
        return this.zza.getIdToken(false).j(new zzab(this));
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final yi4<Void> unenroll(MultiFactorInfo multiFactorInfo) {
        Objects.requireNonNull(multiFactorInfo, "null reference");
        String uid = multiFactorInfo.getUid();
        gj1.j(uid);
        zzx zzx = this.zza;
        return FirebaseAuth.getInstance(zzx.zzd()).zzu(zzx, uid);
    }

    @Override // com.google.firebase.auth.MultiFactor
    public final yi4<Void> unenroll(String str) {
        gj1.j(str);
        zzx zzx = this.zza;
        return FirebaseAuth.getInstance(zzx.zzd()).zzu(zzx, str);
    }
}
