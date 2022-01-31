package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzae extends MultiFactorResolver {
    public static final Parcelable.Creator<zzae> CREATOR = new zzaf();
    private final List<PhoneMultiFactorInfo> zza = new ArrayList();
    private final zzag zzb;
    private final String zzc;
    private final zze zzd;
    private final zzx zze;

    public zzae(List<PhoneMultiFactorInfo> list, zzag zzag, String str, zze zze2, zzx zzx) {
        for (PhoneMultiFactorInfo phoneMultiFactorInfo : list) {
            if (phoneMultiFactorInfo instanceof PhoneMultiFactorInfo) {
                this.zza.add(phoneMultiFactorInfo);
            }
        }
        Objects.requireNonNull(zzag, "null reference");
        this.zzb = zzag;
        gj1.j(str);
        this.zzc = str;
        this.zzd = zze2;
        this.zze = zzx;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final List<MultiFactorInfo> getHints() {
        ArrayList arrayList = new ArrayList();
        for (PhoneMultiFactorInfo phoneMultiFactorInfo : this.zza) {
            arrayList.add(phoneMultiFactorInfo);
        }
        return arrayList;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final yi4<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzv(multiFactorAssertion, this.zzb, this.zze).j(new zzad(this));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.F0(parcel, 1, this.zza, false);
        gj1.A0(parcel, 2, this.zzb, i, false);
        gj1.B0(parcel, 3, this.zzc, false);
        gj1.A0(parcel, 4, this.zzd, i, false);
        gj1.A0(parcel, 5, this.zze, i, false);
        gj1.H1(parcel, o1);
    }
}
