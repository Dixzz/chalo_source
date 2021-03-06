package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.api.Status;
import com.google.firebase.appindexing.FirebaseAppIndexingException;
import com.google.firebase.appindexing.FirebaseAppIndexingInvalidArgumentException;
import com.google.firebase.appindexing.FirebaseAppIndexingTooManyArgumentsException;
import com.google.firebase.appindexing.zza;
import com.google.firebase.appindexing.zzb;
import com.google.firebase.appindexing.zzc;
import com.google.firebase.appindexing.zzd;
import com.google.firebase.appindexing.zze;
import com.google.firebase.appindexing.zzf;
import com.google.firebase.appindexing.zzg;
import com.google.firebase.appindexing.zzh;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzaf {
    public static FirebaseAppIndexingException zza(Status status, String str) {
        Objects.requireNonNull(status, "null reference");
        String str2 = status.h;
        if (str2 != null && !str2.isEmpty()) {
            str = str2;
        }
        int i = status.g;
        if (i == 17510) {
            return new FirebaseAppIndexingInvalidArgumentException(str);
        }
        if (i == 17511) {
            return new FirebaseAppIndexingTooManyArgumentsException(str);
        }
        if (i == 17602) {
            return new zzh(str);
        }
        switch (i) {
            case 17513:
                return new zzb(str);
            case 17514:
                return new zza(str);
            case 17515:
                return new zzg(str);
            case 17516:
                return new zze(str);
            case 17517:
                return new zzf(str);
            case 17518:
                return new zzd(str);
            case 17519:
                return new zzc(str);
            default:
                return new FirebaseAppIndexingException(str);
        }
    }
}
