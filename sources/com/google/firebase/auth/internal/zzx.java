package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.p000firebaseauthapi.zzwg;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzx extends FirebaseUser {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    private zzwg zza;
    private zzt zzb;
    private final String zzc;
    private String zzd;
    private List<zzt> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private zzz zzi;
    private boolean zzj;
    private zze zzk;
    private zzbb zzl;

    public zzx(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        Objects.requireNonNull(firebaseApp, "null reference");
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zzb(list);
    }

    public static FirebaseUser zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzx zzx = new zzx(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzx) {
            zzx zzx2 = (zzx) firebaseUser;
            zzx.zzg = zzx2.zzg;
            zzx.zzd = zzx2.zzd;
            zzx.zzi = zzx2.zzi;
        } else {
            zzx.zzi = null;
        }
        if (firebaseUser.zze() != null) {
            zzx.zzf(firebaseUser.zze());
        }
        if (!firebaseUser.isAnonymous()) {
            zzx.zzj();
        }
        return zzx;
    }

    @Override // com.google.firebase.auth.UserInfo, com.google.firebase.auth.FirebaseUser
    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.UserInfo, com.google.firebase.auth.FirebaseUser
    public final String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ MultiFactor getMultiFactor() {
        return new zzac(this);
    }

    @Override // com.google.firebase.auth.UserInfo, com.google.firebase.auth.FirebaseUser
    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.UserInfo, com.google.firebase.auth.FirebaseUser
    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.UserInfo, com.google.firebase.auth.FirebaseUser
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getTenantId() {
        String str;
        Map map;
        zzwg zzwg = this.zza;
        if (zzwg == null || (str = zzwg.g) == null || (map = (Map) zzay.zza(str).getClaims().get("firebase")) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.UserInfo, com.google.firebase.auth.FirebaseUser
    public final String getUid() {
        return this.zzb.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isAnonymous() {
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzwg zzwg = this.zza;
            String signInProvider = zzwg != null ? zzay.zza(zzwg.g).getSignInProvider() : "";
            boolean z = false;
            if (this.zze.size() <= 1 && (signInProvider == null || !signInProvider.equals("custom"))) {
                z = true;
            }
            this.zzh = Boolean.valueOf(z);
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.A0(parcel, 1, this.zza, i, false);
        gj1.A0(parcel, 2, this.zzb, i, false);
        gj1.B0(parcel, 3, this.zzc, false);
        gj1.B0(parcel, 4, this.zzd, false);
        gj1.F0(parcel, 5, this.zze, false);
        gj1.D0(parcel, 6, this.zzf, false);
        gj1.B0(parcel, 7, this.zzg, false);
        gj1.s0(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        gj1.A0(parcel, 9, this.zzi, i, false);
        boolean z = this.zzj;
        parcel.writeInt(262154);
        parcel.writeInt(z ? 1 : 0);
        gj1.A0(parcel, 11, this.zzk, i, false);
        gj1.A0(parcel, 12, this.zzl, i, false);
        gj1.H1(parcel, o1);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<String> zza() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUser zzb(List<? extends UserInfo> list) {
        Objects.requireNonNull(list, "null reference");
        this.zze = new ArrayList(list.size());
        this.zzf = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals("firebase")) {
                this.zzb = (zzt) userInfo;
            } else {
                this.zzf.add(userInfo.getProviderId());
            }
            this.zze.add((zzt) userInfo);
        }
        if (this.zzb == null) {
            this.zzb = this.zze.get(0);
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* bridge */ /* synthetic */ FirebaseUser zzc() {
        zzj();
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp zzd() {
        return FirebaseApp.getInstance(this.zzc);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzwg zze() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzf(zzwg zzwg) {
        Objects.requireNonNull(zzwg, "null reference");
        this.zza = zzwg;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzg() {
        return this.zza.l1();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzh() {
        return this.zza.g;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzi(List<MultiFactorInfo> list) {
        Parcelable.Creator<zzbb> creator = zzbb.CREATOR;
        zzbb zzbb = null;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (MultiFactorInfo multiFactorInfo : list) {
                if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                    arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                }
            }
            zzbb = new zzbb(arrayList);
        }
        this.zzl = zzbb;
    }

    public final zzx zzj() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    public final zzx zzk(String str) {
        this.zzg = str;
        return this;
    }

    public final List<zzt> zzl() {
        return this.zze;
    }

    public final void zzm(zzz zzz) {
        this.zzi = zzz;
    }

    public final void zzn(boolean z) {
        this.zzj = z;
    }

    public final boolean zzo() {
        return this.zzj;
    }

    public final void zzp(zze zze2) {
        this.zzk = zze2;
    }

    public final zze zzq() {
        return this.zzk;
    }

    public final List<MultiFactorInfo> zzr() {
        zzbb zzbb = this.zzl;
        if (zzbb != null) {
            return zzbb.zza();
        }
        return new ArrayList();
    }

    public zzx(zzwg zzwg, zzt zzt, String str, String str2, List<zzt> list, List<String> list2, String str3, Boolean bool, zzz zzz, boolean z, zze zze2, zzbb zzbb) {
        this.zza = zzwg;
        this.zzb = zzt;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzz;
        this.zzj = z;
        this.zzk = zze2;
        this.zzl = zzbb;
    }
}
